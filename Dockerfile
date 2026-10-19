FROM openjdk:17-slim

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN apt-get update && apt-get install -y maven && \
    mvn clean package -DskipTests && \
    apt-get remove -y maven && \
    apt-get autoremove -y

EXPOSE 8080

CMD ["java", "-jar", "target/ecommerce-api-1.0.0.jar"]