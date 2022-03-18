package com.tw.dojo.bouncingBall.model;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, Bouncing.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, Elastic.SHRINK),
                bouncingElasticBall(500, 100, Bouncing.DOWN, Ball.DEFAULT_RADIUS, Elastic.SHRINK) //--> Let's make a new ball!
        };
    }

    private static Ball bouncingElasticBall(int centerX, int centerY, int direction, int radius, int resize) {
        return new BouncingElasticBall(centerX, centerY, direction, radius, resize);
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        Bouncing behaviour = new Bouncing(direction);
        return new BouncingBall(centerX, centerY, behaviour);
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        Behaviour behaviour = new Elastic(direction);
        return new ElasticBall(centerX, centerY, radius, behaviour);
    }
}
