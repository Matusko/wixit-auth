#!/bin/bash

aws cloudformation create-stack \
    --capabilities CAPABILITY_NAMED_IAM \
    --region eu-west-1 \
    --stack-name wixit-auth-pipeline \
    --template-body file://deployment-pipeline.yaml \
    --parameters file://microservice-pipeline-params.json
