package day03

import Solution
import toDecimal

object Day03 : Solution {

    private fun countZeroOne(input: List<String>): ArrayList<Pair<Int, Int>> {
        val numberOfZeroOne = ArrayList<Pair<Int, Int>>()

        for (i in 1..input.first().length) {
            numberOfZeroOne.add(Pair(0, 0))
        }

        input.forEach { number ->
            number.forEachIndexed { index, bit ->
                val currentCount = numberOfZeroOne[index]
                if (bit == '0') {
                    numberOfZeroOne[index] = currentCount.copy(first = currentCount.first + 1)
                } else {
                    numberOfZeroOne[index] = currentCount.copy(second = currentCount.second + 1)
                }

            }
        }
        return numberOfZeroOne
    }

    override fun part1(input: List<String>): Any {
        val numberOfZeroOne = countZeroOne(input)

        var gammaRate = ""
        var epsilonRate = ""
        numberOfZeroOne.forEach { pair ->
            if (pair.first > pair.second) {
                gammaRate += "0"
                epsilonRate += "1"
            } else {
                gammaRate += "1"
                epsilonRate += "0"
            }

        }

        return gammaRate.toDecimal() * epsilonRate.toDecimal()
    }

    override fun part2(input: List<String>): Any {
        var numberOfZeroOneOxy: ArrayList<Pair<Int, Int>>
        var numberOfZeroOneCarbon: ArrayList<Pair<Int, Int>>
        var filteredOxygen = input
        var filteredCarbon = input


        for (index in 0 until input.first().length) {
            if (filteredOxygen.size > 1) {
                numberOfZeroOneOxy = countZeroOne(filteredOxygen)
                val pairOxygen = numberOfZeroOneOxy[index]
                val maxBit = if (pairOxygen.first > pairOxygen.second) '0' else '1'
                filteredOxygen = filteredOxygen.filter { it[index] == maxBit }
            }

            if (filteredCarbon.size > 1) {
                numberOfZeroOneCarbon = countZeroOne(filteredCarbon)
                val pairCarbon = numberOfZeroOneCarbon[index]
                val minBit = if (pairCarbon.first <= pairCarbon.second) '0' else '1'
                filteredCarbon = filteredCarbon.filter { it[index] == minBit }
            }
        }

        val oxygenRating = filteredOxygen.first().toDecimal()
        val carbonRating = filteredCarbon.first().toDecimal()

        return oxygenRating * carbonRating
    }
}

fun main() {
    Day03.solve()
}