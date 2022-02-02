FROM openjdk:latest
COPY ./target/classes/test /tmp/test
WORKDIR /tmp
ENTRYPOINT ["java", "test.HelloWorld"]