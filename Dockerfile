# Use the JDK installed on your local machine as the base image

FROM jelastic/maven:3.9.5-openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM mdsol/java21-jre
COPY --from=build /target/login_signup-0.0.1-SNAPSHOT.jar login_signup.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","login_signup.jar"]


