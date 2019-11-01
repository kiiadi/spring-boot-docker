FROM gradle:5.6.3-jdk8 as builder
WORKDIR /staging
COPY . .
RUN gradle bootJar --info --no-daemon

FROM amazoncorretto:8
COPY --from=builder /staging/build/libs/spring-boot-docker.jar /home/spring-boot-docker.jar
EXPOSE 80
CMD java -jar -Dserver.port=80 /home/spring-boot-docker.jar
