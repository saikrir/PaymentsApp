FROM open-liberty:kernel

RUN mkdir -p  /opt/ol/wlp/output/defaultServer/resources/mysql

COPY ./docker/restapi/mysql-connector-java-5.1.6.jar /opt/ol/wlp/output/defaultServer/resources/mysql

COPY ./docker/restapi/key.jks /opt/ol/wlp/output/defaultServer/resources/security/

WORKDIR /config

COPY ./api/target/payments.war dropins/

COPY ./docker/restapi/server.xml .

EXPOSE 9080 9443