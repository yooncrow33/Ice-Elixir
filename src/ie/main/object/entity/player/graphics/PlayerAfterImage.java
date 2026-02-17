package ie.main.object.entity.player.graphics;

import ie.main.object.entity.player.Player;
import scope.sideScroll.Entity;

import java.awt.*;

public class PlayerAfterImage extends Entity {
    int alpha = 128;
    int alphaDegree = 8;

    final int size;
    public PlayerAfterImage(Player player) {
        super(0, player.getX(), player.getY(), false,true,0);
        size = player.getPLAYER_WIDTH();
    }

    public void render(Graphics g, double x, double y) {
        double relativeX = x - (double) size/2;
        double relativeY = y - (double) size/2;

        g.setColor(new Color(0, 0, 0, alpha));
        g.fillOval((int)relativeX, (int)relativeY,size, size);
    }

    @Override
    public void update(double v) {
        if (alpha <= 0) {remove();}
        alpha -= alphaDegree;
    }
}
