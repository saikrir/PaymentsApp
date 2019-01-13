FROM maven:3-jdk-8-alpine

ENV DB_NAME="MyPayments_TEST" DB_SERVER="skrao-app-server" DB_PORT="3306" DB_USER="web_user" DB_PASSWORD="tempid1" 

WORKDIR /app

COPY src/ src/

COPY pom.xml pom.xml

ENTRYPOINT [ "mvn", "clean", "install", "liberty:start-server", "-DskipTests=true" ]

EXPOSE 9080