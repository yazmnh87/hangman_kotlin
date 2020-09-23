package main

import kotlin.random.Random

val words = listOf<String>("elephant", "audi", "race car", "jeans")
var word = ""
val guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0
fun main(args: Array<String>) {
    setupGame()
//    printZeroMistakes()
//    printOneMistakes()
//    printTwoMistakes()
//    printThreeMistakes()
//    printFourMistakes()
//    printFiveMistakes()
//    printSixMistakes()
}

fun setupGame() {
    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex].toUpperCase()
    println(word)

    for (i in word.indices)
        guesses.add('_')


    var gameOver = false

    do {
        printGameStatus()
        println("Please enter a letter: ")
        val input = readLine() ?: ""
        if (input.isEmpty()) {
            println("thats not a valid input, please try again")
        } else {
            val letter = input[0].toUpperCase()
            if (word.contains(letter)) {
                for (i in word.indices) {
                    if (word[i] == letter) {
                        guesses[i] = letter
                    }
                    if (!guesses.contains('_'))
                        gameOver = true
                }
            } else {
                println("sorry that is not part of the word")
                remainingGuesses--
                mistakes++
                if (mistakes == 6) {
                    gameOver = true
                }
            }
        }

    } while (!gameOver)

    if(mistakes === 6){
        printGameStatus()
        println("sorry, you lost.  The word has \n$word")
    }else{
        println("\nCongratulations.  The word has \n$word")

    }
}

fun printGameStatus() {
    when (mistakes) {
        0 -> printZeroMistakes()
        1 -> printOneMistakes()
        2 -> printTwoMistakes()
        3 -> printThreeMistakes()
        4 -> printFourMistakes()
        5 -> printFiveMistakes()
        6 -> printSixMistakes()
    }
    print("Word:")
    for (element in guesses)
        print("$element ")
    println("\n You have $remainingGuesses guesses left")
}

fun printZeroMistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println(" /|\\      ")
}

fun printOneMistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println(" /|\\      ")
}

fun printTwoMistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |      | ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println(" /|\\      ")
}

fun printThreeMistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println(" /|\\      ")
}

fun printFourMistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     /  ")
    println("  |        ")
    println(" /|\\      ")
    println(" /|\\      ")
}

fun printFiveMistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /| ")
    println("  |      | ")
    println("  |     /|\\")
    println(" /|\\      ")
    println(" /|\\      ")
}

fun printSixMistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     /|\\")
    println(" /|\\DEAD   ")
    println(" /|\\      ")
}