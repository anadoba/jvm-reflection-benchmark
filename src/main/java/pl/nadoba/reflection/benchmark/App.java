package pl.nadoba.reflection.benchmark;

import java.util.LinkedList;
import java.util.List;

import static pl.nadoba.reflection.benchmark.Measure.*;

public class App {

    public static void main(String[] args) {

        System.out.println("Welcome to the Java reflection benchmark!\n");

        if (args.length != 2) {
            throw new RuntimeException("There should be 2 arguments specified:\n - amount of measurements\n - run mode [warmup/measure/process]\nFor example `run 10000 warmup`");
        }

        int amountOfMeasurements = Integer.valueOf(args[0]);
        RunMode runMode = RunMode.valueOf(args[1].toUpperCase());

        switch(runMode) {
            case WARMUP:
                System.out.println("Warming up with " + amountOfMeasurements + " measurements\n");
                measure(amountOfMeasurements);
                break;
            case MEASURE:
                System.out.println("Taking " + amountOfMeasurements + " measurements\n");
                List<List<Long>> measurements = measure(amountOfMeasurements);
                break;
            case PROCESS:
                System.out.println("Processing data from existing CSV to generate the results\n");
                break;
        }
    }

    private static List<List<Long>> measure(int amountOfMeasurements) {
        List<List<Long>> measurements = new LinkedList<>();

        int i;
        List<Long> primitiveFieldTraditional = new LinkedList<>();
        for (i = 0; i < amountOfMeasurements; i++) {
            primitiveFieldTraditional.add(measurePrimitiveFieldTraditionalAccess());
        }
        measurements.add(primitiveFieldTraditional);
        List<Long> primitiveFieldReflection = new LinkedList<>();
        for (i = 0; i < amountOfMeasurements; i++) {
            primitiveFieldReflection.add(measurePrimitiveFieldReflectionAccess());
        }
        measurements.add(primitiveFieldReflection);

        List<Long> referenceTraditional = new LinkedList<>();
        for (i = 0; i < amountOfMeasurements; i++) {
            referenceTraditional.add(measureReferenceTraditionalAccess());
        }
        measurements.add(referenceTraditional);
        List<Long> referenceReflection = new LinkedList<>();
        for (i = 0; i < amountOfMeasurements; i++) {
            referenceReflection.add(measureReferencesReflectionAccess());
        }
        measurements.add(referenceReflection);

        List<Long> methodTraditional = new LinkedList<>();
        for (i = 0; i < amountOfMeasurements; i++) {
            methodTraditional.add(measureMethodsTraditionalAccess());
        }
        measurements.add(methodTraditional);
        List<Long> methodReflection = new LinkedList<>();
        for (i = 0; i < amountOfMeasurements; i++) {
            methodReflection.add(measureMethodsReflectionAccess());
        }
        measurements.add(methodReflection);


        System.out.println("Accessing public field in a traditional way: \t" + getMeaningfulAverageFromList(primitiveFieldTraditional) + " ns");
        System.out.println("Accessing public field via reflection: \t" + getMeaningfulAverageFromList(primitiveFieldReflection) + " ns");

        System.out.println("Accessing public reference in a traditional way: \t" + getMeaningfulAverageFromList(referenceTraditional) + " ns");
        System.out.println("Accessing public reference via reflection: \t" + getMeaningfulAverageFromList(referenceReflection) + " ns");

        System.out.println("Calling public method classically: \t" + getMeaningfulAverageFromList(methodTraditional) + " ns");
        System.out.println("Calling public method using reflection: \t" + getMeaningfulAverageFromList(methodReflection) + " ns");


        return measurements;
    }

    public enum RunMode {
        WARMUP, MEASURE, PROCESS
    }
}
