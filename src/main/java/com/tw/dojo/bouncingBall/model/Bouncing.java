package com.tw.dojo.bouncingBall.model;

import com.tw.dojo.bouncingBall.ui.BallWorld;

public class Bouncing implements Behaviour {

    private int direction;
    protected int x;
    protected int y;
    protected int radius;

    public Bouncing(int direction) {
        this.direction = direction;
    }

    public void update(Ball ball) {
        direction = reverseDirectionIfNecessary();
        y = move();
        ball.y = y;
    }

    /***********************************************************************************
     *
     * Do not change Bouncing ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            return switchDirection();
        }

        return this.direction;
    }

    private boolean movingTooLow() {
        return y + radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh() {
        return y - radius <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? BouncingBall.UP : BouncingBall.DOWN;
    }

    private int move() {
        return y + (BouncingBall.MOVEMENT_SPEED * direction);
    }

    private boolean movingDown() {
        return direction == BouncingBall.DOWN;
    }

    private boolean movingUp() {
        return direction == BouncingBall.UP;
    }

}
