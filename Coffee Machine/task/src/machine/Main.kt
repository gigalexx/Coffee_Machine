package machine
import java.util.Scanner

var hasWater = 400
var hasMilk = 540
var hasBeans = 120
var hasCups = 9
var hasMoney = 550
val scanner = Scanner(System.`in`)
fun main() {
//    printCoffeMachineStatus()
    letsTakeAction()
}

fun letsTakeAction(){
    println()
    print("Write action (buy, fill, take, remaining, exit): ")

    while (scanner.hasNext()) when (scanner.next()) {
        "buy" -> buyBranch()
        "fill" -> fillBrach()
        "take" -> takeBranch()
        "remaining" -> printCoffeMachineStatus()
        "exit" -> System.exit(1)
    }
    letsTakeAction()
}

fun takeBranch() {
    println()
    print("I gave you $hasMoney")
    hasMoney = 0
    letsTakeAction()
}

fun fillBrach() {
    println()

    print("Write how many ml of water do you want to add: ")
    hasWater += scanner.nextInt()

    print("Write how many ml of milk do you want to add: ")
    hasMilk += scanner.nextInt()

    print("Write how many grams of coffee beans do you want to add: ")
    hasBeans += scanner.nextInt()

    print("Write how many disposable cups of coffee do you want to add: ")
    hasCups += scanner.nextInt()

    letsTakeAction()
}

fun buyBranch() {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")

    when(scanner.next()!!){
        "1" -> makeEspresso()
        "2" -> makeLatte()
        "3" -> makeCappucino()
        "back" -> letsTakeAction()
    }
    letsTakeAction()
}

fun makeCappucino() {

    when {
        hasWater < 200 -> println("Sorry, not enough water!")
        hasBeans < 12 -> println("Sorry, not enough coffee beans!")
        hasMilk < 100 -> println("Sorry, not enough milk!")
        hasCups < 1 -> println("Sorry, not enough disposable cups!")
        else ->{
            println("I have enough resources, making you a coffee!")
            hasWater -= 200
            hasBeans -= 12
            hasMilk -= 100
            hasCups -= 1
            hasMoney += 6
        }
    }
}

fun makeLatte() {
    when {
        hasWater < 350 -> println("Sorry, not enough water!")
        hasBeans < 20 -> println("Sorry, not enough coffee beans!")
        hasMilk < 75 -> println("Sorry, not enough milk!")
        hasCups < 1 -> println("Sorry, not enough disposable cups!")
        else ->{
            println("I have enough resources, making you a coffee!")
            hasWater -= 350
            hasBeans -= 20
            hasMilk -= 75
            hasCups -= 1
            hasMoney += 7
        }
    }
}

fun makeEspresso() {
    when {
        hasWater < 250 -> println("Sorry, not enough water!")
        hasBeans < 16 -> println("Sorry, not enough coffee beans!")
        hasCups < 1 -> println("Sorry, not enough disposable cups!")
        else ->{
            println("I have enough resources, making you a coffee!")
            hasWater -= 250
            hasBeans -= 16
            hasMoney += 4
            hasCups -= 1
        }
    }
}


fun printCoffeMachineStatus() {
    println()
    println("The coffee machine has:\n" +
            "$hasWater of water\n" +
            "$hasMilk of milk\n" +
            "$hasBeans of coffee beans\n" +
            "$hasCups of disposable cups\n" +
            "$hasMoney of money")
    letsTakeAction()
}

