package ie.main.graphics.player;

import ie.main.object.Player;

import java.awt.*;

public class PlayerAfterImage {
    double x;
    double y;
    int playerWidth;
    int playerHeight;
    int alpha = 128;
    int alphaDegree = 8;

    final int VIRTUAL_X_SCREEN_CENTER = 960;
    final int VIRTUAL_Y_SCREEN_CENTER = 540;

    public PlayerAfterImage(Player player) {
        this.x = player.getX();
        this.y = player.getY();

        this.playerWidth = player.getPLAYER_WIDTH();
        this.playerHeight = player.getPLAYER_HEIGHT();
    }

    public void update() {
        alpha -= alphaDegree;
    }

    public void draw(Graphics g, double playerX, double playerY) {
        double relativeX = x - playerX + VIRTUAL_X_SCREEN_CENTER - (double) playerWidth /2;
        double relativeY = y - playerY + VIRTUAL_Y_SCREEN_CENTER - (double) playerHeight /2;

        g.setColor(new Color(0, 0, 0, alpha));
        g.fillOval((int)relativeX, (int)relativeY, playerWidth, playerHeight);
    }

    public boolean isExpired() {
        return alpha <= 0;
    }
}
