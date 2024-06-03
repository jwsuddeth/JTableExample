package edu.kcc;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class StudentWindow extends JFrame {

    private String [] columnNames = {"Id", "Name", "Age", "GPA"};
    private Object [][] data = {
            {"123", "Fred", 24, 4.0},
            {"495", "Barney", 59, 3.6},
            {"634", "Wilma", 38, 2.9},
    };

    JTable table;

    public StudentWindow(){
        setTitle("Students");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        table = new JTable(new DefaultTableModel(data, columnNames));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setAutoCreateRowSorter(true);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // create my button panel
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(createAddButton());
        buttonPanel.add(createRemoveButton());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
    }

    public JButton createAddButton(){
        JButton addButton = new JButton("Add");

        addButton.addActionListener( evt -> {
            Object [] newData = { "", "", 0, 0.0};
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(newData);
        });
        return addButton;
    }

    public JButton createRemoveButton(){
        JButton removeButton = new JButton("Remove");

        removeButton.addActionListener( evt -> {

            int row = table.getSelectedRow();
            if (row >= 0){
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(row);
            }
        });
        return removeButton;
    }
}


public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater( () -> {
            StudentWindow window = new StudentWindow();
            window.setVisible(true);
        });
    }
}