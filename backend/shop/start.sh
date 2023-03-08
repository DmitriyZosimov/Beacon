#!/bin/bash

echo "Start building the application..."
../gradlew -q clean build -x test
echo "The application build is completed"
echo "Start building docker image..."
docker build -t shop .
echo "Docker image build is completed"
docker run -d --name shop -p 8030:8080 shop
echo "The application is started!"