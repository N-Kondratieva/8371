package com.company.tree;

import javax.swing.*;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Tree {


    public static void main(String[] args) {


        final JFrame frame = new JFrame("Дерево");

        final File root = new File("c:\\");


        final TreeModel model = new TreeModel() {

            @Override
            public Object getRoot() {
                return root;
            }

            @Override
            public Object getChild(Object parent, int index) {
                File parentFile = (File) parent;
                final File[] files = parentFile.listFiles();
                return files == null ? null : files[index];
            }

            @Override
            public int getChildCount(Object parent) {
                File parentFile = (File) parent;
                final File[] files = parentFile.listFiles();

                return files == null ? 0 : files.length;
            }

            @Override
            public boolean isLeaf(Object node) {
                File file = (File) node;
                return file.isFile();
            }

            @Override
            public void valueForPathChanged(TreePath path, Object newValue) {

            }

            @Override
            public int getIndexOfChild(Object parent, Object child) {
                return 0;
            }

            @Override
            public void addTreeModelListener(TreeModelListener l) {

            }

            @Override
            public void removeTreeModelListener(TreeModelListener l) {

            }
        };

        JTree tree = new JTree(model);
        JTextArea fileInfo = new JTextArea();
        tree.setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                File file = (File) value;
                setText(file.getName());
                return this;
            }
        });

        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(tree.getSelectionModel().getSelectionCount() > 0){
                    final File file = (File) tree.getSelectionModel().getSelectionPath().getLastPathComponent();
                    String fileInf = "";
                    fileInf += "Имя: " + file.getName() + "\n";
                    fileInf += "Полный путь: " + file.getAbsolutePath() + "\n";
                    fileInf += "Размер: " + file.length() + "\n";
                    fileInfo.setText(fileInf);
                }

            }
        });



        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(tree),
                fileInfo
        );
        splitPane.setDividerLocation(250);

        frame.add(splitPane);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
