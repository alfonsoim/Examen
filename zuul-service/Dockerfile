FROM openjdk:8
VOLUME /tmp
EXPOSE 8091
ADD ./target/zuul-service-0.0.1-SNAPSHOT.jar zuul-service.jar
ENTRYPOINT ["java","-jar","/zuul-service.jar"]
