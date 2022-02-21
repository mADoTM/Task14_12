package ru.vsu.cs.dolzhenkoms;

public class ArrayUtils {
    public static String[] expandArray(String[] array) {
        String[] expandedArray = new String[array.length * 2];

        for(int i = 0; i < array.length; i++)
            expandedArray[i] = array[i];

        return expandedArray;
    }

    public static int[] expandArray(int[] array) {
        int[] expandedArray = new int[array.length * 2];

        for(int i = 0; i < array.length; i++)
            expandedArray[i] = array[i];

        for(int i = array.length; i < expandedArray.length; i++)
            expandedArray[i] = -1;

        return expandedArray;
    }

    public static Object[] expandArray(Object[] array) {
        Object[] expandedArray = new Object[array.length * 2];

        for(int i = 0; i < array.length; i++)
            expandedArray[i] = array[i];

        return expandedArray;
    }

    public static Object[][] expandArray(Object[][] array) {
        Object[][] expandedArray = new Object[array.length * 2][array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                expandedArray[i][j] = array[i][j];
            }
        }

        return expandedArray;
    }
}
