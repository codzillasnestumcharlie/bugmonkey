package org.academiadecodigo.codezillas.bugmonkey;

public class Utilities {

    /**
     *
     * @param maxPc
     * gets a random number between 0 and maxPc
     * @return randonm number (int).
     */

    public static int randomPcBug(int maxPc) {
        return (int) (Math.random() * maxPc);
    }


    /**
     * Method used to generate random
     * movement actions
     * @return
     */
    public static int randomMovement(){
        return (int) (Math.random() * 4);
    }
}
