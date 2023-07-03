From maven:3.8.2-jdk-8

##RUN mvn package
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
EXPOSE 8080
