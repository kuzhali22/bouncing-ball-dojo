package com.tw.dojo.bouncingBall.model;

public class BouncingBall extends Ball {


    private final Behaviour bouncing;

    BouncingBall(int x, int y, Behaviour bouncing) {
        super(x, y);
        this.bouncing = bouncing;
    }

    @Override
    public void update() {
        this.y = bouncing.update(this.y);
    }


}
