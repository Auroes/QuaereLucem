import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteLastRowExample {
    public static void main(String[] args) {
        // 创建一个 JFrame
        JFrame frame = new JFrame("Delete Last Row Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // 创建一个 JList
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> list = new JList<>(listModel);

        // 添加一些示例数据到列表
        listModel.addElement("Item 1");
        listModel.addElement("Item 2");
        listModel.addElement("Item 3");

        // 创建一个删除按钮
        JButton deleteButton = new JButton("删除最后一行");

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int lastIndex = listModel.getSize() - 1;
                if (lastIndex >= 0) {
                    listModel.remove(lastIndex);
                }
            }
        });

        // 创建一个面板来容纳列表和按钮
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(list), BorderLayout.CENTER);
        panel.add(deleteButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}
