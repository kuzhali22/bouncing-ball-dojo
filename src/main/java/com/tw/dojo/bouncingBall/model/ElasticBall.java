package com.tw.dojo.bouncingBall.model;

public class ElasticBall extends Ball {
    public static final int GROWTH_RATE = 2;

    public static final int GROW = 1;
    public static final int SHRINK = -1;
    private Behaviour behaviour;

    ElasticBall(int x, int y, int radius, int growthDirection, Behaviour behaviour) {
        super(x, y, radius);
        this.behaviour = behaviour;
    }

    @Override
    public void update() {
        behaviour.update(this);
    }


}
