# ATM Faud Detector

This application was designed for fraud detection preservation. One of the class is responsible for generating transaction list containing informations such as: card number, atm id, date of transaction. Generated list is writed as a JSON file.
Trasaction's time is compared, using java streams. If the time between two is less than fixed value, par is added to the fraudulent array list. Outcome of the api is an array, consisted of suspected fraudlent transactions. Additionally, application compares execution time of parallel and non-parallel calculations.

## Installing

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
mvn clean install

```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing
