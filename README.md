# jvm-reflection-benchmark

Benchmark project for measuring the reflection performance in Java and Scala. 
It covers 3 matters:
- accessing primitive fields,
- accessing references,
- calling methods.
Each one using reflection or in a traditional way.

My results are available in `results.pdf`

### benchmark phases
- warm up - a few short runs to let JVM focus on this little benchmark,
- taking measurements - long run taking actual results (processed properly to be meaningful).

## running the project

`sh benchmark.sh` 
Be patient!