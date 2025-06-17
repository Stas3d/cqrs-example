#FROM maven:3.9.5-amazoncorretto-21 as builder
#WORKDIR /app
#COPY . /app/.
#RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true
#
#FROM eclipse-temurin:21-jre-alpine
#WORKDIR /app
#COPY --from=builder /app/target/*.jar /app/*.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "/app/*.jar"]

FROM maven:3.9.5-amazoncorretto-21
WORKDIR /app
COPY . /app
RUN mvn package
EXPOSE 8080
CMD ["mvn", "spring-boot:run"]