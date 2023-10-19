import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuaereLucem {
    public static void main(String[] args) {
        RUN();
    }
    public static void RUN() {
        FlatDarkLaf.setup();
        JFrame frame = new JFrame("Quaere Lucem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();

        JComboBox<String> colorComboBox = new JComboBox<>(new String[]{"Red", "Yellow"});
        JButton createButton = new JButton("创建");
        JPanel shapePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(shapeColor);

                if (selectedShape.equals("Circle")) {
                    g.fillOval(50, 50, 100, 100);
                } else if (selectedShape.equals("Square")) {
                    g.fillRect(50, 50, 100, 100);
                } else if (selectedShape.equals("Triangle")) {
                    int[] xPoints = {100, 50, 150};
                    int[] yPoints = {50, 150, 150};
                    g.fillPolygon(xPoints, yPoints, 3);
                } else if (selectedShape.equals("Rectangle")) {
                    g.fillRect(50, 50, 150, 100);
                }
            }
        };

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                selectedShape = showShapeDialog(frame, selectedColor);
                switch (selectedColor) {
                    case "Red":
                        shapeColor = Color.RED;
                        break;
                    case "Yellow":
                        shapeColor = Color.YELLOW;
                        break;
                    default:
                        shapeColor = Color.BLACK;
                        break;
                }
                shapePanel.repaint();
            }
        });

        panel.add(colorComboBox);
        panel.add(createButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(shapePanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static Color shapeColor = Color.BLACK;
    private static String selectedShape = "Circle";

    private static String showShapeDialog(JFrame parent, String color) {
        String[] options;
        if (color.equals("Red")) {
            options = new String[]{"Circle", "Square"};
        } else if (color.equals("Yellow")) {
            options = new String[]{"Triangle", "Rectangle"};
        } else {
            options = new String[]{"Circle", "Square"};
        }

        int response = JOptionPane.showOptionDialog(parent, "Select Shape:", "Shape Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (response == JOptionPane.CLOSED_OPTION) {
            return selectedShape; // Keep the previous selection if the dialog is closed
        } else {
            return options[response];
        }
    }
}
