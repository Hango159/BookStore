# Build-vaihe
FROM eclipse-temurin:17-jdk-focal AS builder

WORKDIR /opt/app

# Copiază wrapper-ul Maven și pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x ./mvnw

# Descarcă dependințele (layer cache)
RUN ./mvnw dependency:go-offline

# Copiază codul sursă și build-uiește
COPY ./src ./src
RUN ./mvnw clean package -DskipTests

# Runtime-vaihe (Alpine este mult mai mică și sigură)
FROM eclipse-temurin:17-jre-alpine

WORKDIR /opt/app

# Utilizăm un wildcard care să ignore fișierul .original
COPY --from=builder /opt/app/target/bookstore-*.jar app.jar

EXPOSE 8080

# Adăugăm parametri pentru optimizarea memoriei în containere
ENTRYPOINT ["java", "-jar", "app.jar"]
