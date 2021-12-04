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
        return ""
    }
}

fun main() {
    Day03.solve()
}