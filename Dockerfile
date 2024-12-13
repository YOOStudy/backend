FROM ubuntu:latest
LABEL authors="generalsuslik"

#FROM amazoncorretto:17-alphine-jdk

# working directory for the app
WORKDIR /app

#Copy * from curr dir to workdir
COPY . .

# Build
RUN ./gradlew clean build -x test

EXPOSE port 8080

CMD ["java", "-jar", "./build/libs/demo-0.0.1-SNAPSHOT.jar"]

ENTRYPOINT ["top", "-b"]