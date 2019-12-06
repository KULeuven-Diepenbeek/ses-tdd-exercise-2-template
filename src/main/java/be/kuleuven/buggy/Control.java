package be.kuleuven.buggy;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class Control {

    public static boolean control(String username) {
        Pattern pattern = Pattern.compile("^(?=[a-z]{2})(?=.{4,26})(?=[^.]*\\.?[^.]*$)(?=[^_]*_?[^_]*$)[\\w.]+$", CASE_INSENSITIVE);

        return pattern.matcher(username).matches();
    }
}
