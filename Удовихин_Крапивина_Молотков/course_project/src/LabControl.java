import javax.swing.*;
import java.awt.*;

public class LabControl {
    public static int Control() {
        final JFrame frame = new JFrame("Управление лабораторией");
        frame.setSize(970, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton buttonAppointment = new JButton("Назначение исследовательской работы");
        buttonAppointment.addActionListener(l -> {
            Appointment sc= new Appointment();
            sc.appointmentWindow();
        });

        JButton buttonShowDrugs = new JButton("Просмотр наличия препаратов на складе");
        buttonShowDrugs.addActionListener(l -> {
            DrugsList sc= new DrugsList();
            sc.viewDrugsList();
        });

        JButton buttonShowResearches = new JButton("Просмотр всех исследовательских работ");
        buttonShowResearches.addActionListener(l -> {
            show_all_researches sc= new show_all_researches();
            sc.view_all_researches();
        });

        JPanel panelButtons = new JPanel(null);
        panelButtons.add(buttonAppointment);
        panelButtons.add(buttonShowDrugs);
        panelButtons.add(buttonShowResearches);
        buttonAppointment.setBounds(50,70,250,100);
        buttonShowDrugs.setBounds(350,70,250,100);
        buttonShowResearches.setBounds(650,70,250,100);

        frame.add(panelButtons);
        frame.setVisible(true);

        return 0;

    }
}
