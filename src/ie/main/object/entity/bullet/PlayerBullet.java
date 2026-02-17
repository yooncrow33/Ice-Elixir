package ie.main.object.entity.bullet;

import com.sun.security.auth.module.LdapLoginModule;
import ie.main.object.entity.enemy.Enemy;
import ie.main.object.entity.player.Player;
import scope.sideScroll.Entity;

import java.awt.*;
import java.util.ArrayList;

public abstract class PlayerBullet extends Bullet {
    ArrayList<Enemy> targets;
    final int damage;
    public PlayerBullet(int radius, double x, double y, int layer, double angle, double speed, double maxDistance,int damage, ArrayList<Enemy> targets) {
        super(radius,x,y,layer,angle,speed,maxDistance);
        this.targets = targets;
        this.damage = damage;
    }

    @Override
    public void updateBullet(double dt) {
        for (int i = targets.size()- 1; i >= 0; i--) {
            Enemy e = targets.get(i);
             if (isColliding(this,e)) {
                e.takeDamage(damage);
                break;
            }
        }
    }

    public boolean isColliding(Entity a, Entity b) {
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        double radiusSum = a.getRadius() + b.getRadius();

        // 루트(Math.sqrt) 없이 제곱만으로 판정 (성능 최적화)
        return (dx * dx + dy * dy) < (radiusSum * radiusSum);
    }
}
