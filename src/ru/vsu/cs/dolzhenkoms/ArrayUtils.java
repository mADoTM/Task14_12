package ru.vsu.cs.dolzhenkoms;

public class ArrayUtils {
    public static String[] expandArray(String[] array) {
        String[] expandedArray = new String[array.length * 2];

        for(int i = 0; i < array.length; i++)
            expandedArray[i] = array[i];

        return expandedArray;
    }

    public static Object[] expandArray(Object[] array) {
        Object[] expandedArray = new Object[array.length * 2];

        for(int i = 0; i < array.length; i++)
            expandedArray[i] = array[i];

        return expandedArray;
    }
}
