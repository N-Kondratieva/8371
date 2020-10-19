package com.company.tree;

import javax.swing.*;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class UserTree {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Дерево");
        final String root = "Корневая запись";
        final   String[]   nodes = new String[]  {"Автомобили", "Телефоны"};
        final   String[][] leafs = new String[][]{{"Toyota", "BMW", "Lada"},
                {"Huawei", "Apple", "Samsung", "Xiaomi"}};
        final TreeModel model = new TreeModel() {
            @Override
            public Object getRoot() {
                return root;
            }

            @Override
            public Object getChild(Object parent, int index) {
                if(parent.equals(root)){
                    return nodes == null ? null : nodes[index];
                }else {
                    final int i  = Arrays.asList(nodes).indexOf(parent);
                    return leafs[i][index];
                }
            }

            @Override
            public int getChildCount(Object parent) {
                if (parent.equals(root)){
                    return nodes == null ? 0 : nodes.length;

                }else {
                    final int i  = Arrays.asList(nodes).indexOf(parent);
                    return leafs[i].length;
                }
            }

            @Override
            public boolean isLeaf(Object node) {
                return !node.equals(root) && !Arrays.asList(nodes).contains(node);
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
        frame.add(new JScrollPane(tree), BorderLayout.CENTER);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
