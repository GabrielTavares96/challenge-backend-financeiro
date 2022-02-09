FROM openjdk:11
MAINTAINER Gabriel Tavares
COPY build/libs/*.jar backend-financeiro.jar
ENTRYPOINT ["java","-jar","backend-financeiro.jar"]
EXPOSE 8090