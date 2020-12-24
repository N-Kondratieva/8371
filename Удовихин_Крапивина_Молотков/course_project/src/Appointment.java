import javax.swing.*;
import java.awt.*;

public class Appointment {

    public static int appointmentWindow() {
        final JFrame mainFrame = new JFrame("Назначение исследовательской работы");
        mainFrame.setSize(1000, 700);
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(null);
        // Верхняя панель: Номер работы, название работы, дата начала, дата  окончания //
        JTextField labNumber = new JTextField();
        JLabel labelLabNumber = new JLabel("Номер работы:");
        JTextField labName = new JTextField();
        JLabel labelLabName = new JLabel("Название работы:");
        JTextField sDate = new JTextField();
        JLabel labelSDate = new JLabel("Дата начала:");
        JTextField fDate = new JTextField();
        JLabel labelFDate = new JLabel("Дата окончания:");

        labelLabNumber.setBounds(20,20, 105, 50);
        labNumber.setBounds(125,20, 105, 50);
        labelLabName.setBounds(250,20, 105, 50);
        labName.setBounds(375,20, 105, 50);
        labelSDate.setBounds(500,20, 105, 50);
        sDate.setBounds(625,20, 105, 50);
        labelFDate.setBounds(750,20, 105, 50);
        fDate.setBounds(875,20, 105, 50);

        panel.add(labelLabNumber);
        panel.add(labNumber);
        panel.add(labelLabName);
        panel.add(labName);
        panel.add(labelSDate);
        panel.add(sDate);
        panel.add(labelFDate);
        panel.add(fDate);

        //Панель описания работы
        JTextArea labDescription = new JTextArea(20,1);
        JLabel labelLabDescription = new JLabel("Описание работы:");
        labelLabDescription.setBounds(20,100, 960, 50);
        labDescription.setBounds(20,155, 960, 150);

        panel.add(labelLabDescription);
        panel.add(labDescription);

        //Панель списка необходимых препаратов
        JList drugsNeeded = new JList();
        JScrollPane drugsList = new JScrollPane(drugsNeeded);
        JLabel labelDrugsNeeded = new JLabel("Список необходимых препаратов:");
        labelDrugsNeeded.setBounds(20,325, 960, 50);
        drugsList.setBounds(20,380, 960, 150);

        panel.add(labelDrugsNeeded);
        panel.add(drugsList);

        //Нижняя панель: Номер лаборатории, кнопка Назначить работу
        JTextField laboratoryNum = new JTextField();
        JLabel labelLaboratoryNum = new JLabel("Номер лаборатории для исследования:");
        labelLaboratoryNum.setBounds(20,600, 150, 50);
        laboratoryNum.setBounds(180,600, 105, 50);

        panel.add(labelLaboratoryNum);
        panel.add(laboratoryNum);

        JButton buttonAppointLab = new JButton("Назначить работу");
        buttonAppointLab.addActionListener(l -> {
            //
        });
        buttonAppointLab.setBounds(780,600,200,50);
        panel.add(buttonAppointLab);


        mainFrame.add(panel);
        mainFrame.setVisible(true);
        return 0;
    }
}
