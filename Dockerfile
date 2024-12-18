FROM openjdk:21
COPY target/TODO-Project-0.0.1-SNAPSHOT.jar TODO-Project-0.0.1-SNAPSHOT.jar
CMD java -jar TODO-Project-0.0.1-SNAPSHOT.jar