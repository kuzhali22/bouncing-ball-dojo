package com.tw.dojo.bouncingBall.model;

public class ElasticBall extends Ball {

    private Behaviour behaviour;

    ElasticBall(int x, int y, int radius, Behaviour behaviour) {
        super(x, y, radius);
        this.behaviour = behaviour;
    }

    @Override
    public void update() {
        this.radius = behaviour.update(this.radius);
    }


}
