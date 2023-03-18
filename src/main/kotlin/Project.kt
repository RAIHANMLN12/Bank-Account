

fun start() {
    println("Welcome to your banking system.")
    println("What type of account would you like to create?")
    println("1. Debit account")
    println("2. Credit account")
    println("3. Checking account")
}


fun main() {
    start()
    var accountType = ""
    var userChoice = 0
    while (accountType =="") {
        userChoice = (1..5).random()
        when(userChoice) {
            1 -> accountType = "Debit"
            2 -> accountType = "credit"
            3 -> accountType = "checking"
            else -> accountType = "Invalid"
        }
    }

    println("You have created a ${accountType} account.")

    var accountBalance = (0..1000).random()
    println("The checking balance is ${accountBalance} dollars.")
    val money = (0..1000).random()
    println("The amount you transferred is ${money} dollars.")

    fun withDraw(amount: Int) : Int {
        accountBalance -= amount
        print("You successfully withdrew ${amount} dollars. The checking balance is ${accountBalance} dollars.")
        return amount
    }

    fun debitWithdraw(amount: Int) : Int {
        if (accountBalance == 0) {
            println("Can't withdraw, no money on this account!")
            return accountBalance
        }
        else if (amount > accountBalance) {
            println("Not enough money on this account! The checking balance is ${accountBalance} dollars.")
            return 0
        }
        else {
            return withDraw(amount)
        }
    }

    fun deposit(amount: Int) : Int {
        accountBalance += amount
        println("You successfully deposited ${amount} dollars. The checking balance is ${accountBalance} dollars.")
        return amount
    }

    fun creditDeposit(amount: Int) : Int {
        if (accountBalance == 0) {
            println("You don't need to deposit anything in order to pay off the account since it has already been paid off")
            return accountBalance
        }
        else if ( amount + accountBalance > 0) {
            println("Deposit failed, you tried to pay off an amount greater than the credit balance. The checking balance is ${accountBalance} dollars.")
            return 0
        }
        else if (amount == -accountBalance) {
            accountBalance = 0
            println("You have paid off this account!")
            return amount
        }
        else {
            return deposit(amount)
        }
    }

}