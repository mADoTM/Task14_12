package ru.vsu.cs.dolzhenkoms;

public class Dictionary {
    private int capacity;

    private int[] buckets;
    private Object[][] entries;

    public Dictionary() {
        capacity = 10;
        buckets = new int[capacity];
        entries = new Object[capacity][3]; // 0 - Object, can be null  1 - Key can't be null  2 - Next, can be null
        setValuesDefault();
    }

    public Dictionary(int capacity) {
        this.capacity = capacity;
        buckets = new int[capacity];
        entries = new Object[capacity][3];
        setValuesDefault();
    }

    public boolean containsKey(String key) {
        int hashCode = getHashCode(key);
        int entriesIndex = buckets[hashCode];

        if(entriesIndex != -1) {
            if (entries[entriesIndex][1] == null)
                return false;

            if(entries[entriesIndex][1] == key)
                return true;

            while ((int)entries[entriesIndex][2] != -1) { // Loop the list
                entriesIndex = (int)entries[entriesIndex][2];

                if(entries[entriesIndex][1] == key)
                    return true;
            }

            return false;
        }

        return false;
    }

    public void add(String key, Object value) {
        if (containsKey(key)) return;

        int hashCode = getHashCode(key);
        int entriesIndex = buckets[hashCode];

        if(entriesIndex == -1) {
            int nearestFreeIndex = getNearestFreeIndex();
            buckets[hashCode] = nearestFreeIndex;

            entries[nearestFreeIndex][1] = key;
            entries[nearestFreeIndex][0] = value;

            return;
        }

        if(entries[entriesIndex][1] == null) {
            entries[entriesIndex][1] = key;
            entries[entriesIndex][0] = value;
            return;
        }

        int lastNextIndex = getIndexWithoutNext(entriesIndex);
        int nearestFreeIndex = getNearestFreeIndex();

        entries[lastNextIndex][2] = nearestFreeIndex;

        entries[nearestFreeIndex][0] = value;
        entries[nearestFreeIndex][1] = key;

    }

    public void remove(String key) {
        if (!containsKey(key)) return;

        int hashCode = getHashCode(key);
        int entriesIndex = buckets[hashCode];

        if(entries[entriesIndex][1] != key) {
            while ((int)entries[entriesIndex][2] != -1) { // Loop the list
                int previousIndex = entriesIndex;
                entriesIndex = (int)entries[entriesIndex][2];

                if(entries[entriesIndex][1] == key) {
                    entries[entriesIndex][1] = null;

                    if ((int) entries[entriesIndex][2] == -1) {
                        entries[previousIndex][2] = -1;
                    }
                    else {
                        entries[previousIndex][2] = entries[entriesIndex][2];
                    }
                    return;
                }
            }
        }

        buckets[hashCode] = (int) entries[entriesIndex][2];
    }

    public void setValue(String key, Object value) {
        if(containsKey(key)) {
            int hashCode = getHashCode(key);
            int entriesIndex = buckets[hashCode];

            if(entries[entriesIndex][1] != key) {
                while ((int)entries[entriesIndex][2] != -1) { // Loop the list
                    entriesIndex = (int)entries[entriesIndex][2];

                    if(entries[entriesIndex][1] == key) {
                        entries[entriesIndex][0] = value;
                        return;
                    }
                }
            }

            entries[entriesIndex][0] = value;
        }
        else {
            add(key, value);
        }
    }

    public Object getValue(String key) {
        if (!containsKey(key)) return null;

        int hashCode = getHashCode(key);
        int entriesIndex = buckets[hashCode];

        if(entries[entriesIndex][1] != key) {
            while ((int)entries[entriesIndex][2] != -1) { // Loop the list
                entriesIndex = (int)entries[entriesIndex][2];

                if(entries[entriesIndex][1] == key)
                    return entries[entriesIndex][0];
            }
        }

        return entries[entriesIndex][0];
    }

    private int getHashCode(String key) {
        return (key.length() * 10 + 3) % capacity; // 10 and 3 are absolutely random numbers
    }

    private int getNearestFreeIndex() {
        for(int i = 0; i < capacity; i++) {
            if(entries[i][1] == null)
                return i;
        }
        buckets = ArrayUtils.expandArray(buckets);
        entries = ArrayUtils.expandArray(entries);
        return getNearestFreeIndex();
    }

    private int getIndexWithoutNext(int index) {
        if ((int)entries[index][2] != -1)
            return getIndexWithoutNext((int)entries[index][2]);

        return index;
    }

    private void setValuesDefault() {
        for(int i = 0; i < entries.length; i++) {
            entries[i][2] = -1;
        }

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = -1;
        }
    }
}
