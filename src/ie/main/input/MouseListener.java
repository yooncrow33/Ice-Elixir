package ie.main.input;

import ie.main.Main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {

    Main main;

    public MouseListener(Main main) {
        this.main = main;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        main.player.getGun().shot();
    }
}
