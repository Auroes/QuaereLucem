import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuaereLucem {
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        JFrame frame = new JFrame("Quaere Lucem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("形状");
        model.addColumn("材质");

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add JComboBox editors for the "Shape" and "Material" columns
        JComboBox<String> shapeComboBox = new JComboBox<>(new String[]{"球体", "平板","立方体"});
        TableColumn shapeColumn = table.getColumnModel().getColumn(0);
        shapeColumn.setCellEditor(new DefaultCellEditor(shapeComboBox));

        JComboBox<String> materialComboBox = new JComboBox<>(new String[]{"空气", "水","石英"});
        TableColumn materialColumn = table.getColumnModel().getColumn(1);
        materialColumn.setCellEditor(new DefaultCellEditor(materialComboBox));

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("+");
        buttonPanel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shape = (String) shapeComboBox.getSelectedItem();
                String material = (String) materialComboBox.getSelectedItem();
                model.addRow(new Object[]{shape, material});
            }
        });

        // Create a new panel to wrap the components
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel addLabel = new JLabel("配置场景物体");
        topPanel.add(addLabel, BorderLayout.WEST);
        topPanel.add(buttonPanel, BorderLayout.EAST);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(topPanel, BorderLayout.NORTH);
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        // Create an EmptyBorder to add some space on the right side of the left panel
        leftPanel.setBorder(BorderFactory.createEmptyBorder(-5, 10, 10, 10)); // Adjust the right m
        //leftPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // Adjust the right margin as needed


        frame.setLayout(new BorderLayout());
        frame.add(leftPanel, BorderLayout.WEST);

        frame.setVisible(true);
    }
}
