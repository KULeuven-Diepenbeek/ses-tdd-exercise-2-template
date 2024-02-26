# SES TDD Exercise 2

Oefeningen voor https://kuleuven-diepenbeek.github.io/ses-course/tdd/

## Technologie

Test harnas met JUnit 5. [JUnit documentatie](https://junit.org/junit5/docs/current/user-guide/).

## Opgave

### 1. Misluke login pogingen

Onze klanten meldden de volgende bug:

> Abigail is able to log in, but Jos is not always able to. Can you please fix this ASAP so jos can get back to work again?
>
> Thanks!
>
> PS: If you don't fix this IN PRODUCTION within 30 minutes the company will lose 100.000 EUR!!!!

Er is een foutje geslopen in de login module, waardoor `Abigail` altijd kan inloggen, maar `jos` soms wel en soms niet. De senior programmeur in ons team heeft de bug geïdentificeerd en beweert dat het in een stukje _oude code_ zit, 
maar hij heeft geen tijd om dit op te lossen. Nu is het aan jou. De `logins.json` file bevat alle geldige login namen die mogen inloggen. Er kan kunnen geen twee gebruikers met dezelfde voornaam zijn.
(Andere namen die moeten kunnen inloggen zijn "James", "Emma", "Isabella" ...)
(Andere namen die niet mogen kunnen inloggen zijn "Arne", "Kris", "Markske" ...)

```java
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
```

Deze methode geeft `true` terug als Abigail probeert in te loggen, en soms `false` als jos probeert in te loggen.

Hoe komt dit? Schrijf éérst een falende test!

### 2. URL Verificatie fouten

Een tweede bug wordt gemeld:

> Thanks again for saving the company 100.000 EUR, but I'm sorry to report another bug.
>
> We upgraded our servers overnight because of a failed hack attempt. We started serving our applications with ssl certificates under the https protocol. However we're seeing nothing but url verification failures in our logs.
>
> If you can fix this before 7:00, we might keep our customers from noticing!
> 
> Thanks in advance!

Je onderzocht de URL verificatie code en vond de volgende verdachte regels:

```java
public static boolean verifyUrl(String url) {
    Pattern pattern = Pattern.compile("http:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)", CASE_INSENSITIVE);
    return pattern.matcher(url).matches();
}
```

De code blijkt reeds **unit testen** te hebben, dus schrijf éérst een falende test (in `VerifierTests`).