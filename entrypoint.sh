#!/bin/bash

CONTEXT_PATH_ESCAPED=$(echo ${CONTEXT_PATH} | sed 's/\//\\\//g')
sed -i \
    -e "s/{{% DB_ENDPOINT %}}/${DB_ENDPOINT}/" \
    -e "s/{{% DB_PORT %}}/${DB_PORT}/" \
    -e "s/{{% DB_MASTER_NAME %}}/${DB_MASTER_NAME}/" \
    -e "s/{{% DB_MASTER_PSWD %}}/${DB_MASTER_PSWD}/" \
    -e "s/{{% REDIS_ENDPOINT %}}/${REDIS_ENDPOINT}/" \
    -e "s/{{% REDIS_PORT %}}/${REDIS_PORT}/" \
    -e "s/{{% CONTEXT_PATH %}}/$CONTEXT_PATH_ESCAPED/" \
    conf.yml

java -Djava.security.egd=file:/dev/./urandom -jar /app.jar --spring.config.location=classpath:application.yml,file:./conf.yml
exec "$@"