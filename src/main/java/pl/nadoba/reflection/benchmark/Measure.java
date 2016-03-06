package pl.nadoba.reflection.benchmark;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Measure {

    private static TestClass testClass = new TestClass();

    private static long measureBase(Function<TestClass, Boolean> measuredOperations) {
        long startNanos = System.nanoTime();
        long endNanos = System.nanoTime();

        measuredOperations.apply(testClass);

        int numberOfOperations = 5;
        long timeDifference = endNanos - startNanos;
        return timeDifference / numberOfOperations;
    }

    public static long measurePrimitiveFieldTraditionalAccess() {
        return measureBase(new Function<TestClass, Boolean>() {
            public Boolean apply(TestClass testClass) {
                long budget = testClass.budget;
                double density = testClass.density;
                boolean isHealthy = testClass.isHealthy;
                String name = testClass.name;
                int velocity = testClass.velocity;

                return true;
            }
        });
    }

    public static long measurePrimitiveFieldReflectionAccess() {
        return measureBase(new Function<TestClass, Boolean>() {
            public Boolean apply(TestClass testClass) {
                for (Field field : testClass.getClass().getDeclaredFields()) {
                    try {
                        if (!field.getName().contains("reference")) {
                            Object o = field.get(testClass);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });
    }

    public static long measureReferenceTraditionalAccess() {
        return measureBase(new Function<TestClass, Boolean>() {
            public Boolean apply(TestClass testClass) {
                TestClass obj = testClass.reference;
                obj = testClass.reference2;
                obj = testClass.reference3;
                obj = testClass.reference4;
                obj = testClass.reference5;

                return true;
            }
        });
    }

    public static long measureReferencesReflectionAccess() {
        return measureBase(new Function<TestClass, Boolean>() {
            public Boolean apply(TestClass testClass) {
                for (Field field : testClass.getClass().getFields()) {
                    try {
                        if (field.getName().contains("reference")) {
                            Object o = field.get(testClass);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });
    }

    public static long measureMethodsTraditionalAccess() {
        return measureBase(new Function<TestClass, Boolean>() {
            @Override
            public Boolean apply(TestClass testClass) {
                Object o = testClass.divideAndMeasure("asdfg");
                o = testClass.square(144);
                o = testClass.logicalOrWithIsHealthy(false);
                o = testClass.addToDensity(45.32);
                testClass.loop(1);

                return true;
            }
        });
    }

    public static long measureMethodsReflectionAccess() {
        return measureBase(new Function<TestClass, Boolean>() {
            public Boolean apply(TestClass testClass) {
                for (Method method : testClass.getClass().getMethods()) {
                    try {
                        Object o;
                        switch (method.getName()) {
                            case "divideAndMeasure":
                                method.invoke(testClass, "string to divide");
                                break;
                            case "square":
                                method.invoke(testClass, 1324);
                                break;
                            case "logicalOrWithIsHealthy":
                                method.invoke(testClass, false);
                                break;
                            case "addToDensity":
                                method.invoke(testClass, 34.2);
                                break;
                            case "loop":
                                method.invoke(testClass, 1);
                                break;
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });
    }

    public static double getMeaningfulAverageFromList(List<Long> measurements) {

        Collections.sort(measurements);

        int length = measurements.size();
        int dropSize = length/5;
        int beginningIndex = dropSize;
        int endingIndex = length - dropSize;

        List<Long> validResults = measurements.subList(beginningIndex, endingIndex);

        double sum = 0;

        for (Long measurement : validResults) {
            sum += measurement;
        }

        return sum / measurements.size();
    }

}
