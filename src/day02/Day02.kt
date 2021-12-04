package day02

import Solution

object Day02 : Solution {

    enum class Direction {
        FORWARD, DOWN, UP
    }

    data class Instruction(val direction: Direction, val steps: Int)

    override fun part1(input: List<String>): Any {
        val instructions = ArrayList<Instruction>()

        input.forEach { command ->
            val str = command.split(" ")
            val directionStr = str.first()
            val steps = str.last().toInt()

            val direction = when (directionStr) {
                "forward" -> Direction.FORWARD
                "down" -> Direction.DOWN
                else -> Direction.UP
            }
            instructions.add(Instruction(direction, steps))
        }

        return getSubmarinePosition(instructions)

    }

    private fun getSubmarinePosition(instructions: ArrayList<Instruction>): Int {
        var x = 0
        var y = 0

        instructions.forEach { instruction ->
            when (instruction.direction) {
                Direction.FORWARD -> x += instruction.steps
                Direction.UP -> y -= instruction.steps
                Direction.DOWN -> y += instruction.steps
            }
        }
        return x * y
    }

    override fun part2(input: List<String>): Any {
        return ""
    }
}

fun main() {
    Day02.solve()
}