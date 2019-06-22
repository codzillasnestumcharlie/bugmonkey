package org.academiadecodigo.codezillas.bugmonkey;

public class Brigzilla {
    private static Brigzilla ourInstance = new Brigzilla();

    public static Brigzilla getInstance() {
        return ourInstance;
    }

    private Brigzilla() {
    }
}
