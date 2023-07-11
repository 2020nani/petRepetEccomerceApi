FROM openjdk:latest
ARG JAR_FILE=out/artifacts/petrepet_jar/*.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]