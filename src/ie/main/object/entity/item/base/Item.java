package ie.main.object.entity.item.base;

import ie.main.object.entity.enemy.base.EnemyConfig;
import scope.sideScroll.Entity;

public abstract class Item extends Entity {
    private final double itemTakeOffset = 60;
    private int tick = 0;
    final EnemyConfig enemyConfig;
    public Item(double x, double y, EnemyConfig enemyConfig) {
        super(5, x, y, false,true, -10);
        this.enemyConfig = enemyConfig;
    }

    @Override
    public void update(double dt) {
        if (!isColliding(this, enemyConfig.getPlayer())) return;

        boolean canCollect = enemyConfig.getOptionManager().isAutoCollect()
                || enemyConfig.getPlayer().getTakeItem();

        if (canCollect) {
            takeItem();
            remove();
        }
        if (enemyConfig.getLife() <= tick) {remove();}
        tick ++;
    }

    protected abstract void takeItem();

    public boolean isColliding(Entity a, Entity b) {
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        double radiusSum = a.getRadius() + (b.getRadius() + itemTakeOffset);

        // 루트(Math.sqrt) 없이 제곱만으로 판정 (성능 최적화)
        return (dx * dx + dy * dy) < (radiusSum * radiusSum);
    }
}
