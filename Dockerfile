FROM java:8-jdk-alpine
COPY ./target/database-demo.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","spring-database-connections.jar"]