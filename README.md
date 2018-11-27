# TDD and CI in Java: Roleplay

Barathon was originally designed by a Linux users team. Some details maybe change for other operating systems. This file can be usefull to continue the project.
It contains yet the maven architecture.

## "Useless" parts
Two projects were bound: the TDD and the NoSQL projects. Some classes/files are useless now. The DBAccess and DB classes are no more really usefull. The DBAccess contains all the methods to access to the neo4j database (connect, createCaracteristics, ...). The DB contains the methods to create the database and the querries needed for the NoSQL project.
In the directory rapport2, you may be find some answers to your questions in the NoSQL report.

## User manual
In this section, there are usefull informations for the user on how to install and how to use this project.

### How to install
Some `.jar`are needed to compile and to execute the project. They are automatically loaded with maven. Do not forget to install and to include them in the classpath to run the application on your computer.
These are the following library needed:
* commons-io
* google.gson
* neo4j driver
* org.json

You need to run a neo4j server on your computer to run the application and set the variables to connect to your databse in the `DBAcces.java` file:
```
private static String ip = "localhost:7687";
private static String login = "neo4j";
private static String password = "NEO4J";
```

### How to use
After compiled the project, you must run `App.class`.

The GUI is in command line.
It's ask your pseudo ansd your position to build the user.
It also ask your preferences to help you to search the perfects bars *(this methodes needs to be improved)*.

The application will show you a list of differents places which correspond to your wishes *(this method needs to be implemented)*.

## Metrics
The metrics of the code are the followed:
* the comment density between 30% and 40%.
* 4the tests covers 40% of the code.
* the execution of the serch is lower than 30 sec.

## How it works
A user runs the app on his smartphone and the database (users, bars,carcateristics and relation) is on a server away. Two actions are possible:
* He chooses a pseudo and answers the questions to get his caracteristics.

The pseudo needs to be unique. With the position of the device, the user's position is updated in the database and the property distance of the AWAY relation too.

* He logs in to his account and can use the applicationto find his trip.
