#!/bin/bash

aws cloudformation update-stack \
    --capabilities CAPABILITY_NAMED_IAM \
    --region eu-west-1 \
    --stack-name wixit-auth \
    --template-body file://deployment-pipeline.yaml \
    --parameters file://deployment-pipeline-params.json
