package com.example.hqradioandroid.utils

import androidx.compose.ui.graphics.Color

class ColorUtil {
    companion object {
        fun getColorByName(text: String): Color {
            if (text.length > 2) {
                val r = getNum(char = text[0], factor = 1.5)
                val g = getNum(char = text[1], factor = 1.8)
                val b = getNum(char = text[2], factor = 2.0)

                return Color(r, g, b, 255)
            }

            return Color((0..200).random(), (0..200).random(), (0..200).random(), 255)
        }

        private fun getNum(char: Char, factor: Double): Int {
            var res = (char.code - 40) * factor

            if (res > 255) {
                res = 255.0
            } else if (res < 0) {
                res = 0.0
            }

            return res.toInt()
        }
    }
}