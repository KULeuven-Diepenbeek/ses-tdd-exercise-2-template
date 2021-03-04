# SES TDD Exercise 2

Oefeningen voor https://kuleuven-diepenbeek.github.io/ses-course/tdd/

## Technologie

Test harnas met JUnit 5. [JUnit documentatie](https://junit.org/junit5/docs/current/user-guide/).

## Opgave

### 1. Misluke login pogingen

Onze klanten meldden de volgende bug:

> Abigail is able to log in, but Jos is not. Can you please fix this ASAP so Jos can get back to work again?
>
> Thanks!
>
> PS: last week I also reported a bug that people with an underscore in their username also couldn't log in.
>
> PPS: If you don't fix this IN PRODUCTION within 30 minutes the company will lose 100.000 EUR!!!!

De senior programmeur in ons team heeft de bug geïdentificeerd en beweert dat het in een stukje _oude code_ zit, 
maar hij heeft geen tijd om dit op te lossen. Nu is het aan jou.

```java
public static boolean control(String username) {
    Pattern pattern = Pattern.compile("^(?=[a-z]{2})(?=.{4,26})(?=[^.]*\\.?[^.]*$)(?=[^_]*_?[^_]*$)[\\w.]+$", CASE_INSENSITIVE);
    return pattern.matcher(username).matches();
}
```

Deze functie geeft `true` terug als Abigail probeert in te loggen, en `false` als Jos probeert in te loggen.

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