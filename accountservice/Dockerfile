FROM openjdk:17-jdk-slim as build

COPY . /app
WORKDIR /app

RUN ./mvnw package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /app/target/accountservice-0.0.1-SNAPSHOT.jar /app/accountservice.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/accountservice.jar"]
