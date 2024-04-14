
import javax.swing.JOptionPane;

public class JOption {
    public static void main(String[] args) {
        
        String name = JOptionPane.showInputDialog("Enter your name :");
        JOptionPane.showMessageDialog(null, "Your name is :" + name);

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age :"));
        JOptionPane.showMessageDialog(null, "Your age is :" + age );
    }
    
}
