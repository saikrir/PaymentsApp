FROM maven:3-jdk-8-alpine

WORKDIR /app

COPY ../api/ .

ENTRYPOINT [ "mvn", "clean", "install", "liberty:run"]

EXPOSE 9080 9443