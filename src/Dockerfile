
FROM maven:3.6.3 AS build
WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:21.1.3
WORKDIR /app

COPY --from=build /build/target/*jar app.jar

EXPOSE 8080

ENTRYPOINT ["java". "-jar", "app.jar"]

