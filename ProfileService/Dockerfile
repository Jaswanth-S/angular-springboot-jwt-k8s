#Dockerfile for SbService

FROM openjdk:11
EXPOSE  8082
COPY ./target/ProfileService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]