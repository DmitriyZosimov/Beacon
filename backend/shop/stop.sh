#!/bin/bash

echo "Stopping shop docker container..."
docker stop shop
echo "Removing shop docker container..."
docker rm shop
echo "Complete!"