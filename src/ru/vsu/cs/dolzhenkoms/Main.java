package ru.vsu.cs.dolzhenkoms;

public class Main {

    public static void main(String[] args) {
        Dictionary myDictionary = new Dictionary();
        myDictionary.add("Maxim", 16);
        myDictionary.add("Maxim1", 17);
        System.out.println(myDictionary.containsKey("Maxim1"));
        System.out.println(myDictionary.getValue("Maxim"));

        myDictionary.remove("Maxim");
        System.out.println(myDictionary.containsKey("Maxim1"));
        System.out.println(myDictionary.getValue("Maxim1"));
    }
}
