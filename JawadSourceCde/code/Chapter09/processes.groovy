def process = "cmd.exe /C dir".execute()
println "${process.text.toUpperCase()}"
