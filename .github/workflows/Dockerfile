FROM openjdk:latest
COPY ./target/classes/test /tmp/test
WORKDIR /tmp
ENTRYPOINT ["java", "com.napier.sem.HelloWorld"]