#!/bin/bash

echo "Start building the application..."
../gradlew -q clean build -x test
echo "The application build is completed"
echo "Start building docker image..."
docker build -t search .
echo "Docker image build is completed"
docker run -d --name search -p 8020:8080 search
echo "The application is started!"