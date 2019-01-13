FROM maven:3-jdk-8-alpine

ENV DB_NAME="MyPayments_TEST" DB_SERVER="skrao-app-server" DB_PORT="3306" DB_USER="web_user" DB_PASSWORD="tempid1" 

WORKDIR /app

COPY api/ .

ENTRYPOINT [ "mvn", "clean", "install", "liberty:run"]

EXPOSE 9080 9443