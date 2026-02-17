package ie.main.object.entity.item;

import ie.main.manager.OptionManager;
import ie.main.object.entity.player.Player;
import scope.sideScroll.Entity;

public abstract class Item extends Entity {
    private final double itemTakeOffset = 30;
    private int tick = 0;
    final ItemConfig itemConfig;
    public Item( double x, double y, ItemConfig itemConfig) {
        super(10, x, y, false,true, -10);
        this.itemConfig = itemConfig;
    }

    @Override
    public void update(double dt) {
        if (!isColliding(this, itemConfig.getPlayer())) return;

        boolean canCollect = itemConfig.getOptionManager().isAutoCollect()
                || itemConfig.getPlayer().getTakeItem();

        if (canCollect) {
            takeItem();
            remove();
        }
        if (itemConfig.getLife() <= tick) {remove();}
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
