FROM openjdk:8
VOLUME /tmp
ADD target/crm-test.jar crm-test.jar
EXPOSE 8880
ENTRYPOINT ["java", "-jar", "crm-test.jar"]
