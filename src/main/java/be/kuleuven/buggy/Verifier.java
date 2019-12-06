package be.kuleuven.buggy;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class Verifier {
    public static boolean verifyUrl(String url) {

        Pattern pattern = Pattern.compile("http:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)", CASE_INSENSITIVE);

        return pattern.matcher(url).matches();
    }
}
