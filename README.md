# ATM Faud Detector

This application was designed for fraud detection preservation. One of the class is responsible for generating transaction list containing informations such as: card number, atm id, date of transaction. Generated list is writed as a JSON file.
Trasaction's time is compared, using java streams. If the time between two is less than fixed value, par is added to the fraudulent array list. Outcome of the api is an array, consisted of suspected fraudlent transactions. Additionally, application compares execution time of parallel and non-parallel calculations.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```
