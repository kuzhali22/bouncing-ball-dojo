package com.tw.dojo.bouncingBall.model;

import com.tw.dojo.bouncingBall.ui.BallWorld;

public class BouncingElasticBall extends Ball {
    static final int DOWN = 1;
    static final int UP = -1;

    private int direction;
    public static final int GROWTH_RATE = 2;
    public static final int MOVEMENT_SPEED = 12;
    static final int GROW = 1;
    static final int SHRINK = -1;

    private int growthDirection;

    public BouncingElasticBall(int centerX, int centerY, int direction, int radius, int resize) {
        super(centerX, centerY);
        this.direction = direction;
        this.growthDirection = resize;
    }

    @Override

    public void update() {
        direction = reverseDirectionIfNecessary();
        y = move();
        growthDirection = reverseGrowthDirectionIfNecessary();
        radius = next();

    }

    /***********************************************************************************
     *
     * Do not change Bouncing ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            return switchDirectionOfMovement();
        }

        return this.direction;
    }

    private boolean movingTooLow() {
        return y + radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh() {
        return y - radius <= 0 && movingUp();
    }

    private int switchDirectionOfMovement() {
        return movingDown() ? UP : DOWN;
    }

    private int move() {
        return y + (MOVEMENT_SPEED * direction);
    }

    private boolean movingDown() {
        return direction == DOWN;
    }

    private boolean movingUp() {
        return direction == UP;
    }

    /***********************************************************************************
     *
     * Do not change Elastic ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) {
            return switchDirectionOfGrowth();
        }

        return this.growthDirection;
    }

    private boolean shrinkingTooSmall() {
        return radius <= 0 && shrinking();
    }

    private boolean growingTooBig() {
        return radius >= DEFAULT_RADIUS && growing();
    }

    private int switchDirectionOfGrowth() {
        return growing() ? SHRINK : GROW;
    }

    private int next() {
        return radius + (GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == SHRINK;
    }

    private boolean growing() {
        return growthDirection == GROW;
    }
}
