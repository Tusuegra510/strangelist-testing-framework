FROM maven:3.6-jdk-8-alpine
MAINTAINER Sebastian Gomez (sebaskahn@gmail.com)

WORKDIR /app

COPY pom.xml .

RUN mvn install

COPY . .

VOLUME /root/.m2/repository
