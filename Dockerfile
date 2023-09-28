FROM adoptopenjdk:20-jre-hotspot

WORKDIR /app

COPY target/sboot-token-ministerio-recomeco.jar .

EXPOSE 8081

CMD ["java", "-jar", "sboot-token-ministerio-recomeco.jar"]
