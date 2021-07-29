package be.kuleuven.buggy

import java.util.regex.Pattern
import java.util.regex.Pattern.CASE_INSENSITIVE


fun control(username: String): Boolean {
    val pattern = Pattern.compile("^(?=[a-z]{2})(?=.{4,26})(?=[^.]*\\.?[^.]*$)(?=[^_]*_?[^_]*$)[\\w.]+$", CASE_INSENSITIVE)
    return pattern.matcher(username).matches()
}