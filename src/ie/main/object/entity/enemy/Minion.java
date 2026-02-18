package ie.main.object.entity.enemy;

import ie.main.object.entity.enemy.base.Enemy;
import ie.main.object.entity.enemy.base.EnemyConfig;

import java.awt.*;

public class Minion extends Enemy {

    final int size = 40;
    final Color color = new Color(255,255,85);
    final EnemyConfig enemyConfig;

    public Minion(double x, double y, EnemyConfig enemyConfig) {
        super(20, x, y, -5,10,200, enemyConfig);
        this.enemyConfig = enemyConfig;
    }

    @Override
    protected void die() {
        config.getEntityManager().addItem(x,y,enemyConfig);
    }

    @Override
    public void render(Graphics g, double x, double y) {
        if (takingDamage) {g.setColor(Color.red);} else g.setColor(color);
        g.fillOval((int) x - size/2, (int) y - size/2, size,size);
    }
}
