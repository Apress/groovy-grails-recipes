class ForumTagLibTests extends grails.test.GroovyPagesTestCase {
    void testConvertTemperature() {
      def template = '<custom:convertTemperature temperature="${temp}" from="${from}" />'
      def fromFahrenheit = applyTemplate(template, [temp:'75', from:'f'] )
      def fromCelsius = applyTemplate(template, [temp:'36', from:'c'] )

      assertEquals fromFahrenheit, '23.8888888889'
      assertEquals fromCelsius, '96.8'
    }
}