import javax.swing.*;

public class SupplyFix {
    public static int Fix() {
        final JFrame frame = new JFrame("Фиксация поставки");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(null);
        JLabel labNum = new JLabel("Номер заказа поставки:");
        JLabel orderDate = new JLabel("Номер склада:");
        JLabel researchNum = new JLabel("Дата получения:");
        JTextField labNumText = new JTextField("1"); // Значение номера лаборатории
        JTextField orderDateText = new JTextField("00/00/0000"); // Дата выдачи
        JTextField researchNumText = new JTextField("1"); // Значение номера работы

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

        JButton buttonSendOrder = new JButton("Фиксировать поставку");
        buttonSendOrder.addActionListener(l -> {
            //
        });
        buttonSendOrder.setBounds(700,550,200,50);
        panel.add(buttonSendOrder);

        frame.add(panel);
        frame.setVisible(true);

        return 0;

    }
}
