FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY /target/time-tracking-0.0.1-SNAPSHOT.jar /app/time-tracking.jar

ENTRYPOINT ["java", "-jar", "time-tracking.jar"]