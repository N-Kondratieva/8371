package practice;
import javax.swing.*;
import  layout.TableLayout;
import static layout.TableLayoutConstants.FILL;
import static layout.TableLayoutConstants.PREFERRED;

public class Practice {
public static void main(String[] args) {
        final JFrame frame = new JFrame ("Первое окно");
        frame.setTitle("Переименованное окно");
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new TableLayout(
                new double [] []{
                    {FILL,PREFERRED,PREFERRED,FILL},
                    {FILL,PREFERRED,PREFERRED,FILL}
                }
        ));
        frame.add(new JButton ("1"),("0,0"));
        frame.add(new JButton ("2"),("1,0"));
        frame.add(new JButton ("3"),("2,0"));
        frame.add(new JButton ("4"),("3,0"));
        frame.add(new JButton ("5"),("0,1"));
        frame.add(new JButton ("8"),("3,1"));
        frame.add(new JButton ("9"),("0,2"));
        frame.add(new JButton ("12"),("3,2"));
        frame.add(new JButton ("13"),("0,3"));
        frame.add(new JButton ("14"),("1,3"));
        frame.add(new JButton ("15"),("2,3"));
        frame.add(new JButton ("16"),("3,3"));
        frame.add(new JButton ("100"),("1,1,2,2"));
        
        
        frame.setVisible(true);
        
        
        
        
        
        
    }
    
}
