FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/*.jar /app/japp.jar

ENTRYPOINT exec java $JAVA_OPTS -jar japp.jar


