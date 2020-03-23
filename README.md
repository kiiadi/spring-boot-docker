# Dockerized Java Spring Boot

This is a basic web-application using Spring boot inside a docker container

## Image Build

To build the image run

```
docker build -t spring-webserver .
```

## Run

To run the app

```
docker run -p8888:80 spring-webserver
```

Then in a browser navigate to http://localhost:8888/
