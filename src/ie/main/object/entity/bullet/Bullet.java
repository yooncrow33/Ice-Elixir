package ie.main.object.entity.bullet;

import scope.sideScroll.Entity;

import java.awt.*;

public abstract class Bullet extends Entity {
    final double angle;
    final double speed;
    final double maxDistance;
    private double traveledDistance = 0.0;
    public Bullet(int radius, double x, double y, int layer, double angle, double speed, double maxDistance) {
        super(radius, x, y, false,true, layer);
        this.angle = angle;
        this.speed = speed;
        this.maxDistance = maxDistance;
    }

    public abstract void renderEntity(Graphics g, double x, double y);
    @Override
    public void render(Graphics g, double x, double y) {
        renderEntity(g,x,y);
    }

    @Override
    public void update(double dt) {
        double distanceThisFrame = speed * dt; // dt는 Main.update의 시간 스케일 팩터

        // 삼각함수를 이용한 X, Y 이동량 계산
        double deltaX = Math.cos(angle) * distanceThisFrame;
        double deltaY = Math.sin(angle) * distanceThisFrame;

        x += deltaX;
        y += deltaY;

        traveledDistance += distanceThisFrame; // 총 이동 거리 갱신

        if (isExpired()) {remove();}
    }

    protected void removeBullet() {remove();}

    public boolean isExpired() {return traveledDistance >= maxDistance; }
}
