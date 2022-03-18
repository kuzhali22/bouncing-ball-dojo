package com.tw.dojo.bouncingBall.model;

public class ElasticBall extends Ball {
    public static final int GROWTH_RATE = 2;

    public static final int GROW = 1;
    public static final int SHRINK = -1;
    private Elastic elastic;

    ElasticBall(int x, int y, int radius, int growthDirection) {
        super(x, y, radius);
        this.elastic = new Elastic(growthDirection);
    }

    @Override
    public void update() {
        elastic.update(this);
    }


}
