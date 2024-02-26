package be.kuleuven.buggy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

import javax.naming.OperationNotSupportedException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class LoginChecker {
    public static boolean control(String username) {
        ArrayList<String> loginList = new ArrayList<>();
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("./logins.json"));
            JsonArray data = gson.fromJson(reader, JsonArray.class);
            for (JsonElement jo : data) {
                String login = gson.fromJson(jo, String.class);
                loginList.add(login);
            }
        }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }

        boolean found = false;
        for (String naam : loginList) {
            if (naam.equals(username)) {
                found = true;
                break;
            }
        }
        return found;
    }
}

