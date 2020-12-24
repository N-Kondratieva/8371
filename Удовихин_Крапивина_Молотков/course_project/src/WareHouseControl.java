import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class WareHouseControl {
    public static int Control() {
        final JFrame frame = new JFrame("Управление складом");
        frame.setSize(970, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton buttonShowOrders = new JButton("Просмотр заказов");
        buttonShowOrders.addActionListener(l -> {
            ViewingOrders sc= new ViewingOrders();
            sc.Order();
        });
        JButton buttonShowCurrentWarehouseState = new JButton("Просмотр текущих препаратов на складе");
        buttonShowCurrentWarehouseState.addActionListener(l -> {
            ViewingWarehouseDrugs sc= new ViewingWarehouseDrugs();
            sc.ViewWarehouseDrugs();
        });
        JButton deliveryFix = new JButton("Фиксация поставки");
        deliveryFix.addActionListener(l -> {
            SupplyFix sc= new SupplyFix();
            sc.Fix();
        });

        JPanel panelButtons = new JPanel(null);
        panelButtons.add(buttonShowOrders);
        panelButtons.add(buttonShowCurrentWarehouseState);
        panelButtons.add(deliveryFix);
        buttonShowOrders.setBounds(50,70,250,100);
        buttonShowCurrentWarehouseState.setBounds(350,70,250,100);
        deliveryFix.setBounds(650,70,250,100);

        frame.add(panelButtons);
        frame.setVisible(true);

        return 0;

    }
}