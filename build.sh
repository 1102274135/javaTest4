#!/usr/bin/env bash
cd ./exam1
mvn clean package -Dmaven.test.skip=true
cp target/exam1-0.0.1-SNAPSHOT.jar ../docker/java/DockerTest.jar
