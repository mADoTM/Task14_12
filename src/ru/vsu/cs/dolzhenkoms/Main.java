package ru.vsu.cs.dolzhenkoms;

public class Main {

    public static void main(String[] args) {
	    Dictionary myDictionary = new Dictionary();
        myDictionary.add("Maxim", 18);
        myDictionary.add("Yaroslav", 19);
        myDictionary.add("Dima", 20);
        myDictionary.add("Dima1", 20);
        myDictionary.add("Dim2", 20);
        myDictionary.add("Dima3", 20);
        myDictionary.add("Dima4", 20);
        myDictionary.add("Dima5", 20);
        myDictionary.add("Dima6", 20);
        myDictionary.add("Dima7", 20);
        myDictionary.add("Dima8", 20);

        System.out.println(myDictionary.getValue("Maxim"));

        myDictionary.setValue("Maxim", 21);
        System.out.println(myDictionary.getValue("Maxim"));

        myDictionary.remove("Maxim");
        myDictionary.add("newMaxim", 2304);
        System.out.println(myDictionary.getValue("newMaxim"));
    }
}
