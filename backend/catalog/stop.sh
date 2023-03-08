#!/bin/bash

echo "Stopping catalog docker container..."
docker stop catalog
echo "Removing catalog docker container..."
docker rm catalog
echo "Complete!"