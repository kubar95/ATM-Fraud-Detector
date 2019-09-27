# ATM Faud Detector

This application was designed for fraud detection preservation. One of the class is responsible for generating transaction list containing informations such as: card number, atm id, date of transaction. Generated list is writed as a JSON file.
Trasaction's time is compared, using java streams. If the time between two is less than fixed value, par is added to the fraudulent array list. Outcome of the api is an array, consisted of suspected fraudlent transactions. Additionally, application compares execution time of parallel and non-parallel calculations.

## Installing


```
mvn clean install
java -jar atmFraudDetector/target/app-1.0-SNAPSHOT-exec.jar ?

```

## Built With

* [JAVA 8](https://docs.oracle.com/javase/8/docs/api/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management



