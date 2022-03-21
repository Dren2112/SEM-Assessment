FROM openjdk:latest
COPY ./target/SEM-Assessment.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEM-Assessment.jar", "db:3306", "30000"]