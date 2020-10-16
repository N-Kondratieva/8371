
package practice1;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Practice1 {

public static void main(String[] args) {
        final JFrame frame = new JFrame ("Первое окно");
        frame.setTitle("Переименованное окно");
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        
        JTable table = newJTable();
    }
    
}
