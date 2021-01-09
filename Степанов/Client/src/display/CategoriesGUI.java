package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CategoriesGUI extends JFrame {

    private JLabel Title = new JLabel("Categories");
    private JLabel LabelSouth = new JLabel("");
    private JLabel LabelWest = new JLabel("");
    private JLabel LabelEast = new JLabel("");
    private JButton[] CategoriesButtons = new JButton[9];
    private JPanel CategoriesPanel = new JPanel(new GridLayout(3, 3, 30, 30));
    private JLabel[] categoriesTitle = new JLabel[9];

    public CategoriesGUI() {
        super("Categories");
        this.setBounds(800, 100, 1000, 1000);

        categoriesTitle[0] = new JLabel("SPORT", JLabel.CENTER);
        categoriesTitle[1] = new JLabel("MUSIC", JLabel.CENTER);
        categoriesTitle[2] = new JLabel("GAMING", JLabel.CENTER);
        categoriesTitle[3] = new JLabel("CHATTING", JLabel.CENTER);
        categoriesTitle[4] = new JLabel("NATURE", JLabel.CENTER);
        categoriesTitle[5] = new JLabel("CHILLING", JLabel.CENTER);
        categoriesTitle[6] = new JLabel("FOOD", JLabel.CENTER);
        categoriesTitle[7] = new JLabel("HANDMADE", JLabel.CENTER);
        categoriesTitle[8] = new JLabel("GARDEN", JLabel.CENTER);


        Container container = this.getContentPane();
        container.setLayout(new BorderLayout(50, 50));

        for (int i = 0; i < 9; i++) {

            CategoriesButtons[i] = new JButton();
            CategoriesButtons[i].setSize(50,50);
            int finalI = i;
            CategoriesButtons[i].addActionListener(l -> {
                ActionsGUI AC = new ActionsGUI(categoriesTitle[finalI].getText(), this);
                AC.setVisible(true);
                AC.setResizable(false);
            });
            CategoriesButtons[i].add(categoriesTitle[i]);
            categoriesTitle[i].setAlignmentX(JButton.CENTER_ALIGNMENT);
            categoriesTitle[i].setFont(new Font("Montserrat", Font.BOLD, 25));
            categoriesTitle[i].setSize(50,50);

            CategoriesPanel.add(CategoriesButtons[i]);
        }

        container.add(CategoriesPanel, BorderLayout.CENTER);

        Title.setSize(1000,30);
        Title.setFont(new Font("Montserrat", Font.BOLD, 25));
        Title.setHorizontalAlignment(JLabel.CENTER);
        Title.setVerticalAlignment(JLabel.CENTER);
        container.add(Title, BorderLayout.NORTH);
        container.add(LabelEast, BorderLayout.EAST);
        container.add(LabelSouth, BorderLayout.SOUTH);
        container.add(LabelWest, BorderLayout.WEST);

    }

}
