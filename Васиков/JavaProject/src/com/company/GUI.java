package com.company;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.DefaultListModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GUI  {
    public static String userName;
    public static String userPassword;
    private static final String URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static Connection connection = null;
    public static String picturePath = null;

    public static void Interface (String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(350,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        JLabel userLabel = new JLabel("Логин");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100,20, 165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Пароль");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100,50,165,25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Войти");
        loginButton.setBounds(125,150,80,25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)   {
                userName = userText.getText();
                userPassword = passwordField.getText();
                try {
                    UserLogs.UserReader(args);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                try {
                    System.out.println(UserLogs.UserReader(args));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                User user = new User();
                user.setName(userName);
                user.setPassword(userPassword);
                user.setUserId(UserLogs.id);
                user.setRole(UserLogs.role);
                try {
                    if (UserLogs.UserReader(args)==true) {
                        JDialog dialog = new JDialog();
                        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                        dialog.setSize (350,250);

                        JPanel dialogPanel = new JPanel();
                        dialog.add(dialogPanel);
                        dialogPanel.setLayout(null);

                        JLabel dialogLabel = new JLabel("Вы успешно вошли!");
                        dialogLabel.setBounds(115,70,125,50);
                        dialogPanel.add(dialogLabel);
                        dialog.setVisible(true);

                        JButton dialogButton = new JButton("OK");
                        dialogButton.setBounds(125,150,80,25);
                        dialogButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                                dialog.dispose();
                                JFrame mainFrame = new JFrame("Книга рецептов");
                                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                mainFrame.setSize(615,550);

                                JPanel mainFramePanel = new JPanel();
                                mainFrame.add(mainFramePanel);
                                mainFramePanel.setLayout(null);

                                DefaultListModel listModel = new DefaultListModel();
                                JList list = new JList(listModel);
                                list.setBounds(10,40,580,400);
                                mainFramePanel.add(list);
                                JScrollPane scrollPane = new JScrollPane(list);
                                scrollPane.setBounds(10,40,580,400);
                                mainFramePanel.add(scrollPane);
                                JTextField field = new JTextField();
                                field.setBounds(10,10,400,20);
                                mainFramePanel.add(field);
                                JButton searchButton = new JButton("Поиск");
                                searchButton.setBounds( 420,10,100,25);
                                mainFramePanel.add(searchButton);
                                try {
                                    connection  = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                                    statement = connection.createStatement();
                                    resultSet = statement.executeQuery("SELECT * FROM mydb.receipts;");
                                    while (resultSet.next()) {
                                        String name = resultSet.getString("Name");
                                        String id = resultSet.getString("ID");
                                        System.out.println(id);
                                        listModel.addElement(name);

                                    }
                                }
                                catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }


                                list.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        if (e.getClickCount() == 2)
                                        {
                                            String index = list.getSelectedValue().toString();
                                            System.out.println(index);
                                            JFrame receiptFrame = new JFrame("Рецепт");
                                            receiptFrame.setSize(615,550);

                                            JPanel receiptPanel = new JPanel();
                                            receiptPanel.setBackground(Color.WHITE);
                                            receiptFrame.add(receiptPanel);
                                            receiptPanel.setLayout(null);

                                            try {
                                                int receiptId =0;
                                                String receiptName=null;
                                                String receiptIngredients = null;
                                                String author = null;
                                                String receiptSize = null;
                                                String receiptCategory = null;
                                                String algorithm = null;
                                                String picturePath = null;
                                                resultSet = statement.executeQuery("SELECT * FROM mydb.receipts where Name = '" + index +"';");
                                                while (resultSet.next())
                                                {
                                                    receiptId = resultSet.getInt("ID");
                                                    receiptName = resultSet.getString("Name");
                                                    receiptIngredients = resultSet.getString("Ingredients");
                                                    author = resultSet.getString("Author");
                                                    receiptSize = resultSet.getString("Size");
                                                    receiptCategory = resultSet.getString("Category");
                                                    algorithm = resultSet.getString("Algorythm");
                                                    picturePath = resultSet.getString("PicturePath");



                                                }
                                                JTextArea receiptIdLabel = new JTextArea(String.valueOf("ID: " + receiptId));
                                                receiptIdLabel.setEditable(false);
                                                receiptIdLabel.setBounds(350,10,200,30);
                                                receiptPanel.add(receiptIdLabel);

                                                JTextArea receiptNameLabel = new JTextArea("Название: " + receiptName);
                                                receiptNameLabel.setEditable(false);
                                                receiptNameLabel.setBounds(350,40,200,30);
                                                receiptPanel.add(receiptNameLabel);

                                                JTextArea receiptIngredientsLabel = new JTextArea("Ингредиенты: " + receiptIngredients);
                                                receiptIngredientsLabel.setEditable(false);
                                                receiptIngredientsLabel.setLineWrap(true);
                                                receiptIngredientsLabel.setBounds(350,70,200,130);
                                                receiptPanel.add(receiptIngredientsLabel);

                                                JTextArea authorLabel = new JTextArea("Автор: " + author);
                                                authorLabel.setEditable(false);
                                                authorLabel.setBounds(350,200,200,30);
                                                receiptPanel.add(authorLabel);

                                                JTextArea receiptSizeLabel = new JTextArea("Масса: " + receiptSize);
                                                receiptSizeLabel.setEditable(false);
                                                receiptSizeLabel.setBounds(350,230,200,30);
                                                receiptPanel.add(receiptSizeLabel);

                                                JTextArea receiptCategoryLabel = new JTextArea("Категория: " + receiptCategory);
                                                receiptCategoryLabel.setEditable(false);
                                                receiptCategoryLabel.setBounds(350,260,200,30);
                                                receiptPanel.add(receiptCategoryLabel);

                                                JTextArea algorithmLabel = new JTextArea("Рецепт: "+ algorithm);
                                                algorithmLabel.setBounds(10,310,500,180);
                                                algorithmLabel.setEditable(false);
                                                algorithmLabel.setLineWrap(true);
                                                receiptPanel.add(algorithmLabel);


                                                BufferedImage image = ImageIO.read(new File(picturePath));
                                                JLabel picLabel = new JLabel (new ImageIcon(image));
                                                picLabel.setBounds(10,0,300,300);
                                                receiptPanel.add(picLabel);


                                            } catch (SQLException | IOException throwables) {
                                                throwables.printStackTrace();
                                            }

                                            receiptFrame.setVisible(true);
                                        }
                                    }
                                });

                                JButton addButton = new JButton("Добавить");
                                addButton.setBounds(100, 450, 100,30);
                                mainFramePanel.add(addButton);
                                addButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        if (user.getRole().equals("Admin")) {
                                            Receipt receipt = new Receipt();
                                            JFrame addFrame = new JFrame("Добавить рецепт");
                                            addFrame.setSize(500, 500);

                                            JPanel addPanel = new JPanel();
                                            addPanel.setLayout(null);
                                            addFrame.add(addPanel);

                                            JLabel fileText = new JLabel("Файл не выбран");
                                            fileText.setBounds(10, 50, 100, 15);
                                            addPanel.add(fileText);

                                            JButton fileButton = new JButton("Выбрать изображение");
                                            fileButton.setBounds(10, 10, 350, 30);
                                            addPanel.add(fileButton);
                                            fileButton.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    JFileChooser fileChooser = new JFileChooser();
                                                    fileChooser.showDialog(null, "Открыть файл");
                                                    File file = fileChooser.getSelectedFile();
                                                    picturePath = file.getPath();
                                                    picturePath = picturePath.replace("\\", "\\\\");
                                                    receipt.setPicturePath(picturePath);
                                                    System.out.println(picturePath);
                                                    fileText.setText("Файл выбран!");
                                                }
                                            });
                                            JLabel nameLabel = new JLabel("Название рецепта");
                                            nameLabel.setBounds(10, 85, 150, 15);
                                            addPanel.add(nameLabel);

                                            JTextField nameTextField = new JTextField();
                                            nameTextField.setBounds(170, 75, 200, 30);
                                            addPanel.add(nameTextField);


                                            JLabel ingredientsLabel = new JLabel("Ингредиенты");
                                            ingredientsLabel.setBounds(10, 115, 150, 15);
                                            addPanel.add(ingredientsLabel);

                                            JTextField ingredientsTextField = new JTextField();
                                            ingredientsTextField.setBounds(170, 115, 200, 30);
                                            addPanel.add(ingredientsTextField);


                                            JLabel authorLabel = new JLabel("Автор");
                                            authorLabel.setBounds(10, 145, 150, 15);
                                            addPanel.add(authorLabel);

                                            JTextField authorTextField = new JTextField(user.getName());
                                            authorTextField.setEditable(false);
                                            authorTextField.setBounds(170, 145, 200, 30);
                                            addPanel.add(authorTextField);


                                            JLabel sizeLabel = new JLabel("Размер");
                                            sizeLabel.setBounds(10,175,150,15);
                                            addPanel.add(sizeLabel);

                                            JTextField sizeTextField = new JTextField();
                                            sizeTextField.setBounds(170,175,200,30);
                                            addPanel.add(sizeTextField);


                                            JLabel categoryLabel = new JLabel("Категория");
                                            categoryLabel.setBounds(10,205,150,15);
                                            addPanel.add(categoryLabel);

                                            JTextField categoryTextField = new JTextField();
                                            categoryTextField.setBounds(170,205,200,30);
                                            addPanel.add(categoryTextField);


                                            JLabel algoLabel = new JLabel("Алгоритм");
                                            algoLabel.setBounds(10,235,150,15);
                                            addPanel.add(algoLabel);

                                            JTextField algoTextField = new JTextField();
                                            algoTextField.setBounds(170,235,200,30);
                                            addPanel.add(algoTextField);


                                            JButton accept = new JButton("Принять");
                                            accept.setBounds(200,400,100,30);
                                            addPanel.add(accept);
                                            accept.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {

                                                    receipt.setReceiptName(nameTextField.getText());
                                                    receipt.setReceiptIngredients(ingredientsTextField.getText());
                                                    receipt.setAuthor(authorTextField.getText());
                                                    receipt.setReceiptSize(sizeTextField.getText());
                                                    receipt.setReceiptCategory(categoryTextField.getText());
                                                    receipt.setAlgorithm(algoTextField.getText());

                                                    String sql = "INSERT INTO receipts (`Name`, `Ingredients`, `Author`, `Size`, `Category`, `Algorythm`, `PicturePath`) VALUES ('" + receipt.getReceiptName()+"', '"+receipt.getReceiptIngredients()+"', '"+receipt.getAuthor()+"', '"+receipt.getReceiptSize()+"', '"+receipt.getReceiptCategory()+"', '"+receipt.getAlgorithm()+"', '"+receipt.getPicturePath()+"');";


                                                    try {
                                                        statement.executeUpdate(sql);
                                                        listModel.addElement(receipt.getReceiptName());
                                                    } catch (SQLException throwables) {
                                                        throwables.printStackTrace();
                                                    }
                                                    System.out.println(picturePath);
                                                    addFrame.dispose();

                                                }
                                            });
                                            addFrame.setVisible(true);
                                        }
                                        else {
                                            JDialog errorDialog = new JDialog();
                                            errorDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                                            errorDialog.setSize (350,250);

                                            JPanel errorDialogPanel = new JPanel();
                                            errorDialog.add(errorDialogPanel);
                                            errorDialogPanel.setLayout(null);

                                            JLabel errorDialogLabel = new JLabel("Недостаточно прав");
                                            errorDialogLabel.setBounds(100,70,250,50);
                                            errorDialogPanel.add(errorDialogLabel);
                                            errorDialog.setVisible(true);
                                        }

                                    }
                                });

                                JButton deleteButton = new JButton("Удалить");
                                deleteButton.setBounds(400, 450, 100,30);
                                deleteButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (user.getRole().equals("Admin")) {
                                            String deleteIndex = list.getSelectedValue().toString();
                                            String sql = "DELETE from receipts WHERE Name ='" + deleteIndex + "';";
                                            try {
                                                statement.executeUpdate(sql);
                                                listModel.removeElement(deleteIndex);
                                            } catch (SQLException throwables) {
                                                throwables.printStackTrace();
                                            }
                                        }
                                        else {
                                            JDialog errorDialog = new JDialog();
                                            errorDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                                            errorDialog.setSize (350,250);

                                            JPanel errorDialogPanel = new JPanel();
                                            errorDialog.add(errorDialogPanel);
                                            errorDialogPanel.setLayout(null);

                                            JLabel errorDialogLabel = new JLabel("Недостаточно прав");
                                            errorDialogLabel.setBounds(100,70,250,50);
                                            errorDialogPanel.add(errorDialogLabel);
                                            errorDialog.setVisible(true);
                                        }
                                    }
                                });
                                mainFramePanel.add(deleteButton);

                                mainFrame.setVisible(true);
                            }
                        });

                        dialogPanel.add(dialogButton);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                try {
                    if (!UserLogs.UserReader(args)) {
                        JDialog dialog = new JDialog();
                        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                        dialog.setSize (350,250);

                        JPanel dialogPanel = new JPanel();
                        dialog.add(dialogPanel);
                        dialogPanel.setLayout(null);

                        JLabel dialogLabel = new JLabel("Логин или пароль неверен >:(");
                        dialogLabel.setBounds(80,70,250,50);
                        dialogPanel.add(dialogLabel);
                        dialog.setVisible(true);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        panel.add(loginButton);
        frame.setVisible(true);
    }
}
