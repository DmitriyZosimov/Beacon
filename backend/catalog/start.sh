#!/bin/bash

echo "Start building the application..."
../gradlew -q clean build -x test
echo "The application build is completed"
echo "Start building docker image..."
docker build -t catalog .
echo "Docker image build is completed"
docker run -d --name catalog -p 8010:8080 catalog
echo "The application is started!"