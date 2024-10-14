# Assumes that a JAR for the app exists in the build context, then copies it into the image and executes it.
FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
