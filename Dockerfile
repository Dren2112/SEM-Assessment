FROM openjdk:latest
COPY ./target/classes/com/napier/sem /tmp/HelloWorld
WORKDIR /tmp
ENTRYPOINT ["java", "com.napier.sem.HelloWorld"]