FROM openjdk:8-jre-alpine

COPY event-management-0.0.1-SNAPSHOT.jar /app.jar

CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/app.jar"]