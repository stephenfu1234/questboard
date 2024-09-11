FROM openjdk:17-jdk-slim

MAINTAINER hackathon-questboard

COPY target/questboard-0.0.1-SNAPSHOT.jar questboard.jar

RUN mkdir -p /data

ENTRYPOINT ["java", "-jar", "questboard.jar"]