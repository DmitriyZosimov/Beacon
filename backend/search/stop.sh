#!/bin/bash

echo "Stopping search docker container..."
docker stop search
echo "Removing search docker container..."
docker rm search
echo "Complete!"