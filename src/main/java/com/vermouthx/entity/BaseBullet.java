package com.vermouthx.entity;

public abstract class BaseBullet extends GameObject {
    private Thread thread;

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public abstract void startThread();
}
