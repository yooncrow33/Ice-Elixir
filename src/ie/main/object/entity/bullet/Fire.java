package ie.main.object.entity.bullet;

import ie.main.object.entity.enemy.Enemy;
import scope.sideScroll.Entity;

import java.awt.*;
import java.util.ArrayList;

public class Fire extends PlayerBullet {
    final int size;
    final int halfSize;
    final Color color = new Color(255,50,30);
    public Fire(int radius, double x, double y, int layer, double angle, double speed,double maxDistance,int damage, ArrayList<Enemy> targets) {
        super(radius, x, y, layer, angle, speed, maxDistance, damage, targets);
        System.out.println("new Fire!");
        this.size = radius*2;
        this.halfSize =size/2;
    }

    @Override
    public void renderEntity(Graphics g, double x, double y) {
        g.setColor(color);
        g.fillOval((int)x - halfSize, (int)y - halfSize, size,size);
    }
}
