FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /workspace
COPY pom.xml ./
RUN --mount=type=cache,target=/root/.m2 mvn -B -ntp -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -X -e -ntp -DskipTests package
FROM eclipse-temurin:21-jre
WORKDIR /app
EXPOSE 8181
COPY --from=build /workspace/target/*.jar app.jar
COPY *.env .env
ENTRYPOINT ["java","-jar","app.jar"]
