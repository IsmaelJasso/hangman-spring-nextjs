#Uses the Java image matching our enviornment
FROM eclipse-temurin:21-jdk-alpine

#Copies the compiled spring boot jar file into the container
COPY target/*.jar app.jar

#Runs the app
ENTRYPOINT [ "java", "-jar", "/app.jar" ]