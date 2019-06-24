package org.academiadecodigo.codezillas.bugmonkey;

public class Utilities {

    public static int randomPcBug(int maxPc) {
        return (int) (Math.random() * maxPc);
    }

    public static int randomMovement(){
        return (int) ((Math.random() * 4));
    }
}
