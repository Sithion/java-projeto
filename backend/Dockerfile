FROM eclipse-temurin:17-jdk-alpine
COPY .mvn .mvn 
COPY src/ src/
COPY files/ files/
COPY mvnw mvnw
COPY mvnw.cmd mvnw.cmd
COPY pom.xml pom.xml
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline
EXPOSE 3001
CMD ["./mvnw","-e", "-X", "spring-boot:run"]