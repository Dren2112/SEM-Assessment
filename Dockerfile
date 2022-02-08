FROM openjdk:latest
COPY ./target/SEM-Assessment-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEM-Assessment-0.1.0.1-jar-with-dependencies.jar"]