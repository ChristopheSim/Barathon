# TDD and CI in Java: Roleplay
Barathon was originally designed by a Linux users team. Some details may change on other operating systems. This file can be useful to continue the project.
It contains yet the maven architecture.

## Maven directory layout
https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html

## External libraries
* (old) JSON: a library to read or write JSON files ;

* GSON: a high-level library to read or write JSON files ;

https://github.com/google/gson/blob/master/UserGuide.md

* Apache Commons-IO: a library to proceed operations on files ;

* Junit: a test module ;

* Neo4j: a library to access Neo4j, a database working with graphs.

## "Useless" parts
Two projects were bound: the TDD and the NoSQL projects. Some classes/files are useless now. The DBAccess and DB classes are no more really useful. The DBAccess contains all the methods to access to the neo4j database (connect, createCaracteristics, ...). The DB contains the methods to create the database and the queries needed for the NoSQL project.
In the directory rapport2, you may find some answers to your questions in the NoSQL report.

## How it works
A user runs the app on his smartphone and the database (users, bars, caracteristics and relations) is on a server away. Two actions are possible:
* He chooses a pseudo and answers the questions to get his caracteristics.

The pseudo needs to be unique. With the position of the device, the user's position is updated in the database and the property distance of the AWAY relation too.

* He logs in to his account and can use the application to find his trip.

There can be two kinds of trips according to his preferences: "Trip" gives him a real bar trip whereas "Bars" gives him a selection of bars he can choose among. 

## User manual
In this section, there are useful informations for the user on how to install and how to use this project.

### How to install
Some ".jar" are needed to compile and to execute the project. They are in the resources directory. Do not forget to install and to include them in the classpath to compile locally.

### How to use
For now, the app is not complete and some checkstyles are not validated so, let's work.

The app is currently a CLI (command line interface). At the beginning, the CLI prompts you to select your preferences, then it displays the appropriate list of bars.


