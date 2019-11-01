FROM amazoncorretto:8 as builder
WORKDIR /build
COPY . /build
RUN ./gradlew bootJar

FROM amazoncorretto:8
COPY --from=builder /build/build/libs/java-docker-service.jar /home/java-docker-service.jar
EXPOSE 80
CMD java -jar -Dserver.port=80 /home/java-docker-service.jar
