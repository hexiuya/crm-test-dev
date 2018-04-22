FROM openjdk:8
VOLUME /tmp
ADD /Users/xiuyahe/Xiuya/crm-test-dev/target/crm-test.jar crm-test.jar
EXPOSE 8880
ENTRYPOINT ["java", "-jar", "crm-test.jar"]
