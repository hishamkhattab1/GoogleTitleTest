#!/bin/bash

# Variables
SERVER="root@192.168.100.44" # replace with your username and hostname
FILE_PATH="~/docker-compose.yaml" # replace with your file path

# Connect to the server and perform operations
#ssh -tt $SERVER << EOF
#    scp $SERVER:$FILE_PATH ./docker-compose.yaml
#    docker compose -f docker-compose.yaml up -d
#EOF
scp docker-compose.yaml $SERVER:$FILE_PATH 
ssh -tt $SERVER 'docker compose -f docker-compose.yaml up -d