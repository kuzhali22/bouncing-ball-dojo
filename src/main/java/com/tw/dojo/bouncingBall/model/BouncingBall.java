package com.tw.dojo.bouncingBall.model;

public class BouncingBall extends Ball {
    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    private final Bouncing bouncing;

    BouncingBall(int x, int y, Behaviour bouncing) {
        super(x, y);
        this.bouncing = bouncing;
    }

    @Override
    public void update() {
        bouncing.update(this);
    }


}
