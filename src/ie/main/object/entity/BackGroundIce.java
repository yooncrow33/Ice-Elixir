package ie.main.object.entity;

import scope.sideScroll.Entity;

import java.awt.*;
import java.util.Random;

public class BackGroundIce extends Entity {

    final int iceWidth = 900;
    final int iceHeight = 900;

    public BackGroundIce() {
        super(100, // radius (배경이니까 일단 0)
                new Random().nextDouble(19201) - 19200.0/2, // x
                new Random().nextDouble(10801) - 10800.0/2, // y
                false, // isCollisionEnabled (배경이니까 충돌 X)
                false, // isUpdateEnabled
                -100   // layer (배경이니까 맨 뒤에)
        );
    }

    public void render(Graphics g,double x,double y) {
        //g.setColor(new Color(135, 206, 255));
        g.setColor(new Color(190,190,190));
        g.fillRect((int)x - iceWidth/2, (int)y - iceHeight/2, iceWidth, iceHeight);
    }

    @Override
    public void update(double dt) {

    }
}
