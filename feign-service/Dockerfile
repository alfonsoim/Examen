FROM openjdk:8
VOLUME /tmp
EXPOSE 8093
ADD ./target/feign-service-0.0.1-SNAPSHOT.jar feign-service.jar
ENTRYPOINT ["java","-jar","/feign-service.jar"]
