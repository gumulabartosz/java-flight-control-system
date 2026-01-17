# pl.bargum.flight-reservation-system


PL:

Ten projekt używa  Quarkus, "the Supersonic Subatomic Java Framework". <https://quarkus.io/>.

## Instalacja Javy
Do prawidłowego działania aplikacji zaleca się pobranie i zainstalowanie Java 25.
1. Pobierz instalator JDK.
2. Ustaw zmienną środowiskową JAVA_HOME na ścieżkę do folderu Javy.
3. Dodaj katalob BIN Javy do zmienniej PATH.
4. Sprawdź poprawność instalacji:
```shell
java --version
```

## Pobierz repozytorium z GitHub
```shell
git clone <repo-link>
```

## Pobierz MAVEN
1. Pobierz instalator MAVEN. 
2. Wskaż folder w zmiennej środowiskowej MAVEN_HOME 
3. Dodaj BIN Mavena do zmiennej PATH
4. Sprawdź poprawność instalacji:
```shell
mvn --version
```

## Uruchom aplikację w trybie DEV
```shell script
./mvnw quarkus:dev
```
lub
```shell script
    quarkus dev
```

## Uruchom testy
```shell script
./mvnw test
```


## Budowanie aplikacji
```shell script
./mvnw package
```

Tworzy `quarkus-run.jar` w `target/quarkus-app/`.
Po zbudowaniu, aplikacja jest dostępna: `java -jar target/quarkus-app/quarkus-run.jar`.


