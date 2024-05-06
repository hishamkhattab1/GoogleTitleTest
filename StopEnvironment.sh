#!/bin/bash

# Variables
SERVER="root@192.168.100.44" # replace with your username and hostname

# Connect to the server and perform operations
ssh -tt $SERVER
docker compose down
rm ./docker-compose.yaml
exit