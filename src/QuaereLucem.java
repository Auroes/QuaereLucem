import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuaereLucem {
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        JFrame frame = new JFrame("Quaere Lucem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);

        /** 1物体面板 */
        DefaultTableModel model1 = new DefaultTableModel();
        model1.addColumn("形状");
        model1.addColumn("材质");
        model1.addColumn("基点");
        model1.addColumn("半径");
        model1.addColumn("长度");
        model1.addColumn("宽度");
        model1.addColumn("高度");
        model1.addColumn("法向");
        /** 2视角面板 */
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("基点");
        model2.addColumn("法向");
        /** 3光源面板 */
        DefaultTableModel model3 = new DefaultTableModel();
        model3.addColumn("形状");
        model3.addColumn("类型");
        model3.addColumn("基点");
        model3.addColumn("半径");
        model3.addColumn("长度");
        model3.addColumn("宽度");
        model3.addColumn("法向");

        /** 列表 */
        JTable table1 = new JTable(model1);
        JTable table2 = new JTable(model2);
        JTable table3 = new JTable(model3);
        /** 滚动条 */
        JScrollPane scrollPane1 = new JScrollPane(table1);
        JScrollPane scrollPane2 = new JScrollPane(table2);
        JScrollPane scrollPane3 = new JScrollPane(table3);

        /** 文本居中 */
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table1.setDefaultRenderer(Object.class, centerRenderer);
        table2.setDefaultRenderer(Object.class, centerRenderer);
        table3.setDefaultRenderer(Object.class, centerRenderer);

        /** 物体列表的可选项 */
        JComboBox<String> shapeComboBox = new JComboBox<>(new String[]{ "平板","立方体","球体","圆柱体"});
        TableColumn shapeColumn = table1.getColumnModel().getColumn(0);
        shapeColumn.setCellEditor(new DefaultCellEditor(shapeComboBox));
        JComboBox<String> materialComboBox = new JComboBox<>(new String[]{"气体", "水体","石英","石灰"});
        TableColumn materialColumn = table1.getColumnModel().getColumn(1);
        materialColumn.setCellEditor(new DefaultCellEditor(materialComboBox));
        /** 光源列表的可选项 */
        JComboBox<String> shapeComboBox3 = new JComboBox<>(new String[]{"平板","球体"});
        TableColumn shapeColumn3 = table3.getColumnModel().getColumn(0);
        shapeColumn3.setCellEditor(new DefaultCellEditor(shapeComboBox3));
        JComboBox<String> typeComboBox3 = new JComboBox<>(new String[]{"白光","红光","绿光","蓝光"});
        TableColumn typeColumn3 = table3.getColumnModel().getColumn(1);
        typeColumn3.setCellEditor(new DefaultCellEditor(typeComboBox3));

        /** 初始化参数 */
        JComboBox<String> cComboBox = new JComboBox<>(new String[]{"0,0,0"});
        JComboBox<String> rComboBox = new JComboBox<>(new String[]{"R = 1"});
        JComboBox<String> lComboBox = new JComboBox<>(new String[]{"L = 2"});
        JComboBox<String> wComboBox = new JComboBox<>(new String[]{"W = 2"});
        JComboBox<String> hComboBox = new JComboBox<>(new String[]{"H = 2"});
        JComboBox<String> normComboBox = new JComboBox<>(new String[]{"N = (1,1,1)"});

        /** 物体列表的添加按钮 */
        JPanel buttonPanel1 = new JPanel();
        JButton addButton1 = new JButton("+");
        buttonPanel1.add(addButton1);
        /** 视角列表的添加按钮 */
        JPanel buttonPanel2 = new JPanel();
        JButton addButton2 = new JButton("+");
        buttonPanel2.add(addButton2);
        /** 光源列表的添加按钮 */
        JPanel buttonPanel3 = new JPanel();
        JButton addButton3 = new JButton("+");
        buttonPanel3.add(addButton3);
        /** 输出面板的添加按钮 */
        JPanel buttonPanel4 = new JPanel();
        JButton addButton4 = new JButton("输出");
        buttonPanel4.add(addButton4);

        /** 解析度面板 */
        JPanel resolutionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel resolutionLabel = new JLabel("解析度");
        String[] resolutions = {"360", "720", "1080", "1440", "2160", "4320"};
        JComboBox<String> resolutionComboBox = new JComboBox<>(resolutions);
        resolutionPanel.add(resolutionLabel);
        resolutionPanel.add(resolutionComboBox);

        /** 基准三原色波长面板 */
        JPanel wavelengthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel wavelengthLabel = new JLabel("基准三原色波长");
        JTextField wavelengthTextField = new JTextField("R=564, G=534, B=420");
        wavelengthPanel.add(wavelengthLabel);
        wavelengthPanel.add(wavelengthTextField);

        /** 物体添加按钮的点击效果 */
        addButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shape = (String) shapeComboBox.getSelectedItem();
                String material = (String) materialComboBox.getSelectedItem();
                String center = (String) cComboBox.getSelectedItem();
                String r = (String) rComboBox.getSelectedItem();
                String l = (String) lComboBox.getSelectedItem();
                String w = (String) wComboBox.getSelectedItem();
                String h = (String) hComboBox.getSelectedItem();
                String norm = (String) normComboBox.getSelectedItem();
                model1.addRow(new Object[]{shape, material, center, r, l, w, h, norm});
            }
        });
        /** 视角添加按钮的点击效果 */
        addButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String center = (String) cComboBox.getSelectedItem();
                String norm = (String) normComboBox.getSelectedItem();
                model2.addRow(new Object[]{center, norm});
            }
        });
        /** 光源添加按钮的点击效果 */
        addButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shape  = (String) shapeComboBox3.getSelectedItem();
                String type   = (String) typeComboBox3.getSelectedItem();
                String center = (String) cComboBox.getSelectedItem();
                String r      = (String) rComboBox.getSelectedItem();
                String l      = (String) lComboBox.getSelectedItem();
                String w      = (String) wComboBox.getSelectedItem();
                String norm   = (String) normComboBox.getSelectedItem();
                model3.addRow(new Object[]{shape, type, center, r, l, w,norm});
            }
        });
        /** 输出按钮的点击效果 */
        addButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        /** 场景面板上方标签 */
        JPanel topPanel1 = new JPanel(new BorderLayout());
        JLabel addLabel1 = new JLabel("配置场景物体");
        /** 视角面板上方标签 */
        JPanel topPanel2 = new JPanel(new BorderLayout());
        JLabel addLabel2 = new JLabel("配置视角");
        /** 光源面板上方标签 */
        JPanel topPanel3 = new JPanel(new BorderLayout());
        JLabel addLabel3 = new JLabel("配置光源");

        /** 输出面板上方标签 */
        JPanel topPanel4 = new JPanel(new BorderLayout());

        JPanel labelPanel4 = new JPanel();
        JLabel addLabel4 = new JLabel("输出配置");
        labelPanel4.add(addLabel4);

        topPanel1.add(addLabel1, BorderLayout.WEST);
        topPanel1.add(buttonPanel1, BorderLayout.EAST);
        topPanel2.add(addLabel2, BorderLayout.WEST);
        topPanel2.add(buttonPanel2, BorderLayout.EAST);
        topPanel3.add(addLabel3, BorderLayout.WEST);
        topPanel3.add(buttonPanel3, BorderLayout.EAST);
        topPanel4.add(labelPanel4, BorderLayout.WEST);
        topPanel4.add(buttonPanel4, BorderLayout.EAST);

        /** 设置物体面板的位置 */
        JPanel Panel1 = new JPanel(new BorderLayout());
        Panel1.add(topPanel1, BorderLayout.NORTH);
        Panel1.add(scrollPane1, BorderLayout.CENTER);
        /** 设置视角面板的位置 */
        JPanel Panel2 = new JPanel(new BorderLayout());
        Panel2.add(topPanel2, BorderLayout.NORTH);
        Panel2.add(scrollPane2, BorderLayout.CENTER);
        /** 设置光源面板的位置 */
        JPanel Panel3 = new JPanel(new BorderLayout());
        Panel3.add(topPanel3, BorderLayout.NORTH);
        Panel3.add(scrollPane3, BorderLayout.CENTER);

        /** 设置输出面板的位置 */
        JPanel Panel4 = new JPanel(new BorderLayout());
        Panel4.add(topPanel4, BorderLayout.NORTH);
        //Panel4.setLayout(new BoxLayout(Panel4, BoxLayout.Y_AXIS));
        JPanel setThings = new JPanel();
        //setThings.setLayout(new BoxLayout(setThings, BoxLayout.Y_AXIS));
        setThings.setLayout(new GridLayout(8,2,0,0));
        setThings.add(resolutionPanel);
        setThings.add(wavelengthPanel);
        Panel4.add(setThings, BorderLayout.WEST);

        Panel1.setBorder(BorderFactory.createEmptyBorder(-5, 10, 10, 10));
        Panel2.setBorder(BorderFactory.createEmptyBorder(-5, 10, 10, 10));
        Panel3.setBorder(BorderFactory.createEmptyBorder(-5, 10, 10, 10));
        Panel4.setBorder(BorderFactory.createEmptyBorder(-5, 10, 10, 10));

        frame.setLayout(new BorderLayout());

        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        /** 设置面板的位置 */
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 2.0;
        c.weighty = 2.0;
        frame.add(Panel1, c);
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 2.0;
        c.weighty = 2.0;
        frame.add(Panel2, c);
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 2.0;
        c.weighty = 2.0;
        frame.add(Panel3, c);
        c.gridx = 2;
        c.gridy = 2;
        c.weightx = 2.0;
        c.weighty = 2.0;
        frame.add(Panel4, c);

        frame.setVisible(true);
    }



}