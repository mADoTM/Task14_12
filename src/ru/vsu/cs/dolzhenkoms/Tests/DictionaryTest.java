package ru.vsu.cs.dolzhenkoms.Tests;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.cs.dolzhenkoms.Dictionary;

public class DictionaryTest {
    Dictionary testDictionary;

    @Test
    public void containsKeyDefaultCase() {
        testDictionary = new Dictionary();
        testDictionary.add("Maxim", 16);

        Assert.assertEquals(testDictionary.containsKey("Maxim"), true);
    }

    @Test
    public void containsKeyAfterDeleting() {
        testDictionary = new Dictionary();
        testDictionary.add("Maxim", 16);
        testDictionary.remove("Maxim");
        testDictionary.add("Maxim", 17);

        Assert.assertEquals(testDictionary.containsKey("Maxim"), true);
    }

    @Test
    public void addForExpandDictionary() {
        testDictionary = new Dictionary();
        testDictionary.add("Maxim", 16);
        testDictionary.add("Dima", 17);
        testDictionary.add("Array", 18);
        testDictionary.add("Please", 19);
        testDictionary.add("I", 20);
        testDictionary.add("dont", 21);
        testDictionary.add("know", 22);
        testDictionary.add("a", 23);
        testDictionary.add("lot", 24);
        testDictionary.add("of", 25);
        testDictionary.add("words", 26);
        testDictionary.add("Java", 27);

        Assert.assertEquals(testDictionary.containsKey("Java"), true);
    }

    @Test
    public void getValueAfterAddingSameKey() {
        testDictionary = new Dictionary();
        testDictionary.add("Maxim", 16);
        testDictionary.add("Maxim", 17);

        Assert.assertEquals(testDictionary.getValue("Maxim"), 16);
    }

    @Test
    public void lookForCollisionInKeys() {
        testDictionary = new Dictionary(5);

        // After math operations bucket should be same everywhere...
        testDictionary.add("Maxim", 16);
        testDictionary.add("Dmitr", 17);
        testDictionary.add("Alexa", 18);
        testDictionary.add("Zhena", 19);

        Assert.assertEquals(testDictionary.getValue("Alexa"), 18);
    }

    @Test
    public void removeKeys() {
        testDictionary = new Dictionary(5);
        testDictionary.add("Maxim", 16);
        testDictionary.add("Dmitr", 17);
        testDictionary.add("Alexa", 18);
        testDictionary.add("Zhena", 19);
        testDictionary.remove("Maxim");

        Assert.assertEquals(testDictionary.containsKey("Maxim"), false);
    }

    @Test
    public void setValue() {
        testDictionary = new Dictionary();

        testDictionary.add("Maxim", 16);
        testDictionary.setValue("Maxim", 17);

        Assert.assertEquals(testDictionary.getValue("Maxim"), 17);
    }
}
