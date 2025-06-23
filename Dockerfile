FROM maven:3.9.5-amazoncorretto-21
WORKDIR /app
COPY . /app
RUN mvn package
EXPOSE 8080
CMD ["mvn", "spring-boot:run"]