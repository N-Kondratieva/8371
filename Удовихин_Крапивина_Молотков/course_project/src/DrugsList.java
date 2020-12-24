import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DrugsList {
    public static int viewDrugsList() {
        final JFrame frame = new JFrame("Просмотр наличия препаратов на складе");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);

        JLabel labelName = new JLabel("Склад:");
        labelName.setBounds(20,20,70,40);

        String [] warehouseNames = {"1", "2", "3"};
        JComboBox box = new JComboBox(warehouseNames);
        box.setBounds(95, 20, 60, 40);



        JList list = new JList();
        JScrollPane warehouseScrollableList = new JScrollPane(list);
        warehouseScrollableList.setBounds(20,100,960, 500);

        panel.add(labelName);
        panel.add(box);
        panel.add(warehouseScrollableList);

        frame.add(panel);
        frame.setVisible(true);

        return 0;

    }
}
