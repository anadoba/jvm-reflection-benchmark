#!/usr/bin/env bash

mvn clean compile -q

# warm up
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q
mvn exec:java -Dexec.args="1 1000000 false" -q

# taking real measurements
mvn exec:java -Dexec.args="20 2000000 true"
