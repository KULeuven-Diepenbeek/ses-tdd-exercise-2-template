package be.kuleuven.buggy

import java.util.regex.Pattern
import java.util.regex.Pattern.CASE_INSENSITIVE



fun verify(url: String): Boolean {
    val pattern = Pattern.compile(
        "http:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)",
        CASE_INSENSITIVE
    )
    return pattern.matcher(url).matches()
}