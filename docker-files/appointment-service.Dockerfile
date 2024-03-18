FROM eclipse-temurin:21
EXPOSE 8082
WORKDIR /app
COPY ../target/appointment-service-*.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]