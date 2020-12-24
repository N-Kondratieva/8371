import javax.swing.*;

public class ViewingSingleOrder {
    public static int ViewOrder() {
        final JFrame frame = new JFrame("Заказ номер #"); //Приделать номер заказа
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(null);
        JLabel labNum = new JLabel("Номер лаборатории:");
        JLabel orderDate = new JLabel("Дата выдачи:");
        JLabel researchNum = new JLabel("Номер работы:");
        JTextField labNumText = new JTextField("1"); // Значение номера лаборатории
        JTextField orderDateText = new JTextField("00/00/0000"); // Дата выдачи
        JTextField researchNumText = new JTextField("1"); // Значение номера работы
        labNumText.setEditable(false);
        orderDateText.setEditable(false);
        researchNumText.setEditable(false);

        JList list = new JList();
        JScrollPane scrollableList = new JScrollPane(list);
        scrollableList.setBounds(20,100,940, 420);
        panel.add(scrollableList);

        labNum.setBounds(20,20,100,50);
        labNumText.setBounds(130,20,70,50);
        orderDate.setBounds(220,20,100,50);
        orderDateText.setBounds(340,20,70,50);
        researchNum.setBounds(430,20,100,50);
        researchNumText.setBounds(550,20,70,50);

        panel.add(labNum);
        panel.add(labNumText);
        panel.add(orderDate);
        panel.add(orderDateText);
        panel.add(researchNum);
        panel.add(researchNumText);

        frame.add(panel);
        frame.setVisible(true);

        return 0;

    }
}
