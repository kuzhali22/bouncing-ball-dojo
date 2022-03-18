package com.tw.dojo.bouncingBall.model;

public class Elastic implements Behaviour {

    private int growthDirection;
    protected int radius;

    public Elastic(int growthDirection) {
        this.growthDirection = growthDirection;
    }

    /***********************************************************************************
     *
     * Do not change Elastic ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) {
            return switchDirection();
        }

        return this.growthDirection;
    }

    private boolean shrinkingTooSmall() {
        return radius <= 0 && shrinking();
    }

    private boolean growingTooBig() {
        return radius >= Ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? ElasticBall.SHRINK : ElasticBall.GROW;
    }

    private int next() {
        return radius + (ElasticBall.GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == ElasticBall.SHRINK;
    }

    private boolean growing() {
        return growthDirection == ElasticBall.GROW;
    }

    public void update(Ball ball) {
        growthDirection = reverseGrowthDirectionIfNecessary();
        radius = next();
        ball.radius = radius;
    }
}
