package calculator

fun main() {
    val calculator = Calculator()

    printWelcomeMessage()

    while (true) {
        val input = readLine()

        try {
            when (val result = calculator.executeStatement(input)) {
                is Number -> println(result)
                is Command.HELP -> println(Command.HELP)
                is Command.EXIT -> break
                else -> Unit
            }
        } catch (e: CalculatorException) {
            println(e.localizedMessage)
        }
    }

    println("Bye!")
}


private fun printWelcomeMessage() {
    println("The command line calculator.")
    println("To get acquainted with the program - execute the command: /help")
    println("To exit the program, run the /exit command or press CTRL-D keystroke.")
}
