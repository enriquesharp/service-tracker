package com.urbamap.urbamap.extensions

import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

/**
 * Created by Enrique on 12/5/2017.
 */
fun Array<String>.fromArrayToStringLiteral(): String {

    return this.joinToString(separator = ",", prefix = "[", postfix = "]", transform = { s: String -> "\"".plus(s).plus("\"") })
}

fun String.hasEmailFormat(): Boolean {
    return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
    ).matcher(this).matches()
}

fun String.convertToFancyDate(format: String): String {
    try {
        val year = this.substring(0, 4)
        val month = this.substring(5, 7)
        val day = this.substring(8, 10)

        val cal = Calendar.getInstance()

        cal.set(Calendar.YEAR, year.toInt())
        cal.set(Calendar.MONTH, month.toInt() - 1)
        cal.set(Calendar.DAY_OF_MONTH, day.toInt())

        val dateFormat = SimpleDateFormat(format)

        return dateFormat.format(cal.time)
    } catch (e: Exception) {
        return "sin fecha"
    }

}