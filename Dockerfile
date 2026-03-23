FROM  maven:3.9.6-eclipse-temurin-21 AS build
LABEL authors="irakump"

WORKDIR /app
COPY pom.xml .
COPY . /src

RUN mvn package --enable-preview

CMD ["java", "--enable-preview", "-jar", "target/ShoppingCart.jar"]
