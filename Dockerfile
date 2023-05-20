FROM openjdk:11
EXPOSE 8088
ADD target/dream-case.jar dream-case.jar
ENTRYPOINT ["java","-jar","/dream-case.jar"]