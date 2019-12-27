#!/bin/sh
while ! nc -z config-server 8888 ; do
    echo "Waiting for the Config Server"
    sleep 3
done
java -jar /opt/lib/registry-service-0.0.1-SNAPSHOT.jar