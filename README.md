# TDD and CI in Java: Roleplay
-----

Barathon was originally designed by a Linux users team. Some details maybe change for other operating systems. This file can be usefull to continue the project.
It contains yet the maven architecture.

## Maven directory layout
-----
https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html

## "Useless" parts
-----
Two projects were bound: the TDD and the NoSQL projects. Some classes/files are useless now. The DBAccess and DB classes are no more really usefull. The DBAccess contains all the methods to access to the neo4j database (connect, createCaracteristics, ...). The DB contains the methods to create the database and the querries needed for the NoSQL project.
In the directory rapport2, you may be find some answers to your questions in the NoSQL report.

## How it works
-----
A user runs the app on his smartphone and the database (users, bars,carcateristics and relation) is on a server away. Two actions are possible:
* He chooses a pseudo and answers the questions to get his caracteristics.

The pseudo needs to be unique. With the position of the device, the user's position is updated in the database and the property distance of the AWAY relation too.

* He logs in to his account and can use the applicationto find his trip.

## User manual
-----
In this section, there are usefull informations for the user on how to install and how to use this project.

### How to install
Some ".jar" are needed to compile and to execute the project. They are in the resources directory. Do not forget to install and to include them in the classpath.

### How to use
For now, the app is not complete and some checkstyles are not validated so, let's work.

## Metric
-----
