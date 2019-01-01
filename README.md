**Dependencies**
- postgres
- redis

before running locally make sure postgres and redis docker container is running

**Run spring boot**

    mvn spring-boot:run

**Build docker image**
      
    mvn package
    docker build --build-arg JAR_FILE=target/wixit-auth-0.1.0-SNAPSHOT.jar --tag ${some_tag} .

**OR**

    mvn install dockerfile:build

**check images**

    docker images

**run docker container**

    docker run  --network host -e DB_ENDPOINT= -e DB_PORT= -e DB_MASTER_NAME= -e DB_MASTER_PSWD= -e CONTEXT_PATH= -e REDIS_ENDPOINT= -e REDIS_PORT= -e REDIS_PSWD= -e REDIS_SSL_ENABLED= -t springio/wixit-auth


**check running containers**

    docker ps

**stop running container**

    docker stop ${containerId}