#!/usr/bin/env bash

mvn clean compile

# warm up
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q
mvn exec:java -Dexec.args="1000000 warmup" -q

# taking real measurements
mvn exec:java -Dexec.args="20000000 measure" -q
