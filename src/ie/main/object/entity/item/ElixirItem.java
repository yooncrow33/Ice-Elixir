package ie.main.object.entity.item;

import ie.main.Main;
import ie.main.object.entity.enemy.base.EnemyConfig;
import ie.main.object.entity.item.base.Item;

import java.awt.*;

public class ElixirItem extends Item {
    final int value = 20;
    final int size = 10;
    final Color color = new Color(60,255,255);
    final EnemyConfig enemyConfig;

    public ElixirItem(double x, double y, EnemyConfig enemyConfig) {
        super(x, y, enemyConfig);
        this.enemyConfig = enemyConfig;
    }

    @Override
    protected void takeItem() {
        enemyConfig.getPlayer().addElixir(enemyConfig.getDropElixir());
    }

    @Override
    public void render(Graphics g, double x, double y) {
        g.setColor(color);
        g.fillOval((int) x - size/2, (int) y - size/2, size,size);
    }
}
