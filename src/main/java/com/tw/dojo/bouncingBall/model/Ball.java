package com.tw.dojo.bouncingBall.model;

import java.awt.*;

public class Ball {
    protected static final int DEFAULT_RADIUS = 50;
    protected int x;
    protected int y;
    protected int radius;
    private Behaviour behaviour;

    public Ball(int x, int y, int radius, Behaviour behaviour) {
        this(x, y, radius);
        this.behaviour = behaviour;
    }

    public Ball(int x, int y, Behaviour behaviour) {
        this(x, y);
        this.behaviour = behaviour;
    }


    public void update() {
        behaviour.update(this);
    }

    protected Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }


    protected Ball(int x, int y) {
        this(x, y, DEFAULT_RADIUS);
    }


    // DO NOT CHANGE
    public int radius() {
        return radius;
    }

    // DO NOT CHANGE
    public Point center() {
        return new Point(x, y);
    }

}
