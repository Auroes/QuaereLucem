import javax.swing.*;
import java.awt.*;

public class SwingExample {
    public static void main(String[] args) {
        // 创建一个顶层窗口
        JFrame frame = new JFrame("Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // 创建主面板
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // 创建三个子面板，并添加文本标签
        for (int i = 1; i <= 3; i++) {
            JPanel subPanel = new JPanel();
            JLabel label = new JLabel("1");
            subPanel.add(label);
            mainPanel.add(subPanel);
        }

        // 将主面板添加到窗口
        frame.add(mainPanel);

        // 设置窗口可见
        frame.setVisible(true);
    }
}
