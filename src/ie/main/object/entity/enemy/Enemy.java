package ie.main.object.entity.enemy;

import ie.main.object.entity.enemy.EnemyConfig;
import scope.sideScroll.Entity;

import java.awt.*;

public abstract class Enemy extends Entity {
    protected int hp;
    protected final int maxHp;
    private final EnemyConfig config;
    public Enemy(int radius, double x, double y, int layer, EnemyConfig enemyConfig) {
        super(radius, x, y, true,true, layer);
        this.config = enemyConfig;
        this.maxHp = config.getMaxHp();
    }

    @Override
    public void update(double v) {
        if (hp <= 0) {remove();}
    }

    public void die() {

    }

    public void takeDamage(int value) {
        hp -= value;
    }
}
