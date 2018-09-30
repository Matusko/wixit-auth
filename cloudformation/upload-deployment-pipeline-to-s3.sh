#!/bin/bash

aws s3 cp deployment-pipeline.yaml s3://webhooks-configs-and-templates/wixit-auth/
aws s3 cp deployment-pipeline-params-without-variables.json s3://webhooks-configs-and-templates/wixit-auth/
