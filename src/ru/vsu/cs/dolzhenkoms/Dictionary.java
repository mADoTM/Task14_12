package ru.vsu.cs.dolzhenkoms;

import java.lang.reflect.Array;

public class Dictionary {
    private String[] keys;
    private Object[] values;

    public Dictionary() {
        keys = new String[10];
        values = new Object[10];
    }

    public Dictionary(int capacity) {
        keys = new String[capacity];
        values = new Object[capacity];
    }

    public Object getValue(String key) {
        if(containsKey(key)) {
            int index = getIndexOfKey(key);
            return values[index];
        }
        return null;
    }

    public void setValue(String key, Object value) {
        if(containsKey(key)) {
            int index = getIndexOfKey(key);
            values[index] = value;
        }
        else {
            add(key, value);
        }
    }

    public void add(String key, Object value) {
        if (containsKey(key)) return;
        int index = getNearestFreeIndex();

        keys[index] = key;
        values[index] = value;
    }

    public void remove(String key) {
        if (!containsKey(key)) return;

        int index = getIndexOfKey(key);

        keys[index] = null;
        values[index] = null;
    }

    public boolean containsKey(String expectedKey) {
        for (String key : keys) {
            if (key == expectedKey)
                return true;
        }
        return false;
    }

    private int getNearestFreeIndex() {
        for(int i = 0; i < keys.length; i++) {
            if(keys[i] == null)
                return i;
        }

        keys = ArrayUtils.expandArray(keys);
        values = ArrayUtils.expandArray(values);

        return getNearestFreeIndex();
    }

    private int getIndexOfKey(String key) {
        for(int i = 0; i < keys.length; i++)
            if(keys[i] == key)
                return i;

        return -1;
    }
}
