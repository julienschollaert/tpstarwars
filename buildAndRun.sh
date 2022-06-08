#!/bin/sh
mvn clean package && docker build -t com.julientp.jee/tpstarwars .
docker rm -f tpstarwars || true && docker run -d -p 9080:9080 -p 9443:9443 --name tpstarwars com.julientp.jee/tpstarwars