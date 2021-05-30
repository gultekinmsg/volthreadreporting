FROM openjdk:11
ADD target/volthreadreporting-1.0.0-SNAPSHOT.jar volthreadreporting-1.0.0-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "volthreadreporting-1.0.0-SNAPSHOT.jar"]