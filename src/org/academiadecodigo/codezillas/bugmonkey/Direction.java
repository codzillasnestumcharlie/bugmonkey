package org.academiadecodigo.codezillas.bugmonkey;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Direction getRandomDirection() {
        return values()[(int)(Math.random() * values().length)];
    }
}
