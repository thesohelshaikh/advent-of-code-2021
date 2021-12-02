package day01

import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01/Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("day01/Day01")
    println(part1(input))
    println(part2(input))
}

fun part1(input: List<String>): Int {
    val list = input.map { it.toInt() }
    var count = 0

    list.zipWithNext { prev, curr ->
        if (curr > prev) count++
    }

    return count
}

fun part2(input: List<String>): Int {
    val list = input.map { it.toInt() }
    var count = 0

    list
        .windowed(3, 1)
        .map { it.sum() }
        .zipWithNext { prev, curr ->
        if (curr > prev) count++
    }

    return count
}