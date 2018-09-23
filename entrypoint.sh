#!/bin/bash

echo "ENTRYPOINT ENTRYPOINT ENTRYPOINT ENTRYPOINT"
echo ${CONTEXT_PATH}
echo ${DB_ENDPOINT}
echo ${DB_PORT}
echo ${DB_MASTER_NAME}
echo ${DB_MASTER_PSWD}

CONTEXT_PATH_ESCAPED=$(echo ${CONTEXT_PATH} | sed 's/\//\\\//g')
sed -i \
    -e "s/{{% DB_ENDPOINT %}}/${DB_ENDPOINT}/" \
    -e "s/{{% DB_PORT %}}/${DB_PORT}/" \
    -e "s/{{% DB_MASTER_NAME %}}/${DB_MASTER_NAME}/" \
    -e "s/{{% DB_MASTER_PSWD %}}/${DB_MASTER_PSWD}/" \
    -e "s/{{% CONTEXT_PATH %}}/$CONTEXT_PATH_ESCAPED/" \
    conf.yml

cat conf.yml
java -Djava.security.egd=file:/dev/./urandom -jar /app.jar --spring.config.location=classpath:application.yml,file:./conf.yml
exec "$@"