package ChickenInvaders.Components;

import ChickenInvaders.GameManager;
import Engine.Entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Макс on 24.05.2016.
 */
public class Input implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
