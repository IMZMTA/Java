package GUI;

import javax.swing.*;

public class Frame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Example");

        String name = JOptionPane.showInputDialog(frame, "Enter your name:");
        JOptionPane.showMessageDialog(frame, "Your name is: " + name);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
