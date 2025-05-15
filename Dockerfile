
FROM maven AS build
WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package 

FROM kenneth059512/openjdk21-jdk-slim
WORKDIR /app

COPY --from=build /build/target/*jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

