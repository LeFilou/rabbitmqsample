FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=target/worker-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} worker.jar

EXPOSE 8081

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/worker.jar"]