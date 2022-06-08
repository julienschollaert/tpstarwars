@echo off
call mvn clean package
call docker build -t com.julientp.jee/tpstarwars .
call docker rm -f tpstarwars
call docker run -d -p 9080:9080 -p 9443:9443 --name tpstarwars com.julientp.jee/tpstarwars