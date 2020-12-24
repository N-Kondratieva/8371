import javax.swing.*;

public class ViewingOrders {
    public static int Order() {
        final JFrame frame = new JFrame("Просмотр заказов");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton buttonShowDoneOrders = new JButton("Просмотр выполненных заказов");
        buttonShowDoneOrders.addActionListener(l -> {
            //
        });
        JButton buttonShowCurrentOrders = new JButton("Просмотре текущих заказов");
        buttonShowCurrentOrders.addActionListener(l -> {
            //
        });

        JPanel panel = new JPanel(null);
        panel.add(buttonShowDoneOrders);
        panel.add(buttonShowCurrentOrders);
        buttonShowDoneOrders.setBounds(20,10,250,50);
        buttonShowCurrentOrders.setBounds(300,10,250,50);

        JList list = new JList();
        JScrollPane scrollableList = new JScrollPane(list);
        scrollableList.setBounds(20,100,940, 520);
        panel.add(scrollableList);

        frame.add(panel);
        frame.setVisible(true);

        return 0;

    }
}
