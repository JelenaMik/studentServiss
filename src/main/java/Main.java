import controller.Menu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();
        JOptionPane.showMessageDialog(null,  "Welcome to the Student Service!");
        menu.start();

    }
}
