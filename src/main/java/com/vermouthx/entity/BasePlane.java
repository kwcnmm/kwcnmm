package com.vermouthx.entity;

public abstract class BasePlane extends GameObject {

    public BasePlane() {
    }

    public BasePlane(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public abstract void shot();

}
