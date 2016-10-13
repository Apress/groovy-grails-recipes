import org.grails.plugins.springsecurity.service.AuthenticateService

import org.springframework.security.providers.UsernamePasswordAuthenticationToken as AuthToken
import org.springframework.security.context.SecurityContextHolder as SCH

/**
 * Actions over User object.
 */
class RegisterController {

	EmailerService emailerService
	AuthenticateService authenticateService
	def daoAuthenticationProvider

	def allowedMethods = [save: 'POST', update: 'POST']

	/**
	 * User Registration Top page
	 */
	def index = {

		//if logon user.
		if (authenticateService.userDomain()) {
			log.info("${authenticateService.userDomain()} user hit the register page")
			redirect(action: 'show')
			return
		}

		if (session.id) {
			def person = new User()
			person.properties = params
			return [person: person]
		}

		redirect(uri: '/')
	}

	/**
	 * User Information page for current user.
	 */
	def show = {

		//get user id from session's domain class.
		def user = authenticateService.userDomain()
		if (user) {
			render(view: 'show', model: [person: User.get(user.id)])
		}
		else {
			redirect(action: 'index')
		}
	}

	/**
	 * Edit page for current user.
	 */
	def edit = {

		def person
		def user = authenticateService.userDomain()
		if (user) {
			person = User.get(user.id)
		}

		if (!person) {
			flash.message = "[Illegal Access] User not found with id ${params.id}"
			redirect(action: 'index')
			return
		}

		[person: person]
	}

	/**
	 * update action for current user's edit page
	 */
	def update = {

		def person
		def user = authenticateService.userDomain()
		if (user) {
			person = User.get(user.id)
		}
		else {
			redirect(action: 'index')
			return
		}

		if (!person) {
			flash.message = "[Illegal Access] User not found with id ${params.id}"
			redirect(action: 'index', id: params.id)
			return
		}

		//if user want to change password. leave passwd field blank, passwd will not change.
		if (params.passwd && params.passwd.length() > 0
				&& params.repasswd && params.repasswd.length() > 0) {
			if (params.passwd == params.repasswd) {
				person.passwd = authenticateService.passwordEncoder(params.passwd)
			}
			else {
				person.passwd = ''
				flash.message = 'The passwords you entered do not match.'
				render(view: 'edit', model: [person: person])
				return
			}
		}

		person.userRealName = params.userRealName
		person.email = params.email
		if (params.emailShow) {
			person.emailShow = true
		}
		else {
			person.emailShow = false
		}

		if (person.save()) {
			redirect(action: 'show', id: person.id)
		}
		else {
			render(view: 'edit', model: [person: person])
		}
	 }

	/**
	 * Person save action.
	 */
	def save = {

		if (authenticateService.userDomain() != null) {
			log.info("${authenticateService.userDomain()} user hit the register page")
			redirect(action: 'show')
			return
		}

		def person = new User()
		person.properties = params

		def config = authenticateService.securityConfig
		def defaultRole = config.security.defaultRole

		def role = Role.findByAuthority(defaultRole)
		if (!role) {
			person.passwd = ''
			flash.message = 'Default Role not found.'
			render(view: 'index', model: [person: person])
			return 
		}

		if (params.captcha.toUpperCase() != session.captcha) {
			person.passwd = ''
			flash.message = 'Access code did not match.'
			render(view: 'index', model: [person: person])
			return
		}

		if (params.passwd != params.repasswd) {
			person.passwd = ''
			flash.message = 'The passwords you entered do not match.'
			render(view: 'index', model: [person: person])
			return
		}

		def pass = authenticateService.passwordEncoder(params.passwd)
		person.passwd = pass
		person.enabled = true
		person.emailShow = true
		person.description = ''
		if (person.save()) {
			role.addToPeople(person)
			if (config.security.useMail) {
				String emailContent = """You have signed up for an account at:

 ${request.scheme}://${request.serverName}:${request.serverPort}${request.contextPath}

 Here are the details of your account:
 -------------------------------------
 LoginName: ${person.username}
 Email: ${person.email}
 Full Name: ${person.userRealName}
 Password: ${params.passwd}
"""

				def email = [
					to: [person.email], // 'to' expects a List, NOT a single email address
					subject: "[${request.contextPath}] Account Signed Up",
					text: emailContent // 'text' is the email body
				]
      			emailerService.sendEmails([email])
			}

			person.save(flush: true)

			def auth = new AuthToken(person.username, params.passwd)
			def authtoken = daoAuthenticationProvider.authenticate(auth)
			SCH.context.authentication = authtoken
			redirect(uri: '/')
		}
		else {
			person.passwd = ''
			render(view: 'index', model: [person: person])
		}
	}
}
