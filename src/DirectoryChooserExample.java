import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DirectoryChooserExample {
    public static void main(String[] args) {


        JFrame frame = new JFrame("Directory Chooser Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JButton chooseButton = new JButton("Choose Directory");
        JTextField directoryField = new JTextField(30);

        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    directoryField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(chooseButton);
        panel.add(directoryField);

        frame.add(panel);
        frame.setVisible(true);
    }
}
