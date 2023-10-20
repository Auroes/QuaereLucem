package Kit;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void starGUI(){
        /** 创建主面板 */
        FlatDarkLaf.setup();
        JFrame QLFrame = new JFrame("Quaere Lucem");
        QLFrame.setLayout(new GridLayout(2,2));//栅格布局
        QLFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        QLFrame.setSize(1280, 720);
        /** 创建次面板 */
        JPanel P1 = new JPanel(new BorderLayout());//边框布局
        JPanel P2 = new JPanel(new BorderLayout());
        JPanel P3 = new JPanel(new BorderLayout());
        JPanel P4 = new JPanel(new BorderLayout());
        /** 设置物体面板
            顶部面板 */
        JButton Add1 = new JButton("➕");
        JButton Cut1 = new JButton("➖");
        JPanel PAdd1Cut1 = new JPanel(new GridLayout(0,2,5,5));//栅格布局
        PAdd1Cut1.add(Add1);
        PAdd1Cut1.add(Cut1);
        JPanel PWord1 = new JPanel(new BorderLayout());//边框布局
        JLabel LWord1 = new JLabel("配置物体");
        PWord1.add(LWord1,BorderLayout.WEST);
        JPanel Top1 = new JPanel(new BorderLayout());//边框布局
        Top1.add(PWord1,BorderLayout.WEST);
        Top1.add(PAdd1Cut1,BorderLayout.EAST);
        P1.add(Top1,BorderLayout.NORTH);
        /** 表格面板 */
        DefaultTableModel M1 = new DefaultTableModel();
        JTable T1 = new JTable(M1);
        JScrollPane S1 = new JScrollPane(T1);
        P1.add(S1);
        /** 文本居中 */
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        T1.setDefaultRenderer(Object.class, centerRenderer);
        /** 添加列 */
        M1.addColumn("形状");
        M1.addColumn("材质");
        M1.addColumn("基点");
        M1.addColumn("半径");
        M1.addColumn("长度");
        M1.addColumn("宽度");
        M1.addColumn("高度");
        M1.addColumn("法向");
        /** 初始化参数 */
        JComboBox<String> C_o = new JComboBox<>(new String[]{"0,0,0"});
        JComboBox<String> C_r = new JComboBox<>(new String[]{"R = 1"});
        JComboBox<String> C_l = new JComboBox<>(new String[]{"L = 2"});
        JComboBox<String> C_w = new JComboBox<>(new String[]{"W = 2"});
        JComboBox<String> C_h = new JComboBox<>(new String[]{"H = 2"});
        JComboBox<String> C_n = new JComboBox<>(new String[]{"N = (1,1,1)"});
        /** 表格可选项 */
        JComboBox<String> C1_1 = new JComboBox<>(new String[]{ "平板","立方体","球体","圆柱体"});
        TableColumn T1_1 = T1.getColumnModel().getColumn(0);
        T1_1.setCellEditor(new DefaultCellEditor(C1_1));
        JComboBox<String> C1_2 = new JComboBox<>(new String[]{"气体", "水体","石英","石灰"});
        TableColumn T1_2 = T1.getColumnModel().getColumn(1);
        T1_2.setCellEditor(new DefaultCellEditor(C1_2));
        /** 物体添加按钮点击效果 */
        Add1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shape    = (String) C1_1.getSelectedItem();
                String material = (String) C1_2.getSelectedItem();
                String center   = (String) C_o.getSelectedItem();
                String radius   = (String) C_r.getSelectedItem();
                String length   = (String) C_l.getSelectedItem();
                String width    = (String) C_w.getSelectedItem();
                String height   = (String) C_h.getSelectedItem();
                String norm     = (String) C_n.getSelectedItem();
                M1.addRow(new Object[]{shape,material,center,radius,length,width,height,norm});
            }
        });
        // 物体删除按钮点击效果
        Cut1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = T1.getSelectedRow();
                if (selectedRow != -1) {
                    M1.removeRow(selectedRow);
                } else {
                    int rowCount = M1.getRowCount();
                    if (rowCount > 0) {
                        M1.removeRow(rowCount - 1);
                    }
                }
            }
        });
        /** 设置视角面板
         顶部面板 */
        JButton Add2 = new JButton("➕");
        JButton Cut2 = new JButton("➖");
        JPanel PAdd2Cut2 = new JPanel(new GridLayout(0,2,5,5));//栅格布局
        PAdd2Cut2.add(Add2);
        PAdd2Cut2.add(Cut2);
        JPanel PWord2 = new JPanel(new BorderLayout());//边框布局
        JLabel LWord2 = new JLabel("配置视角");
        PWord2.add(LWord2,BorderLayout.WEST);
        JPanel Top2 = new JPanel(new BorderLayout());//边框布局
        Top2.add(PWord2,BorderLayout.WEST);
        Top2.add(PAdd2Cut2,BorderLayout.EAST);
        P2.add(Top2,BorderLayout.NORTH);
        /** 表格面板 */
        DefaultTableModel M2 = new DefaultTableModel();
        JTable T2 = new JTable(M2);
        JScrollPane S2 = new JScrollPane(T2);
        P2.add(S2);
        /** 文本居中 */
        T2.setDefaultRenderer(Object.class, centerRenderer);
        /** 添加列 */
        M2.addColumn("基点");
        M2.addColumn("法向");
        M2.addColumn("焦距");
        M2.addColumn("光圈");
        /** 初始化参数 */
        JComboBox<String> C_f = new JComboBox<>(new String[]{"20mm"});
        JComboBox<String> C_d = new JComboBox<>(new String[]{"Φ6mm"});
        /** 表格可选项 */
        JComboBox<String> C2_1 = new JComboBox<>(new String[]{"17mm","18mm","19mm","20mm","21mm","22mm","23mm"});
        TableColumn T2_1 = T2.getColumnModel().getColumn(2);
        T2_1.setCellEditor(new DefaultCellEditor(C2_1));
        JComboBox<String> C2_2 = new JComboBox<>(new String[]{"Φ2mm","Φ3mm","Φ4mm","Φ5mm","Φ6mm","Φ7mm","Φ8mm"});
        TableColumn T2_2 = T2.getColumnModel().getColumn(3);
        T2_2.setCellEditor(new DefaultCellEditor(C2_2));
        /** 物体添加按钮点击效果 */
        Add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String center   = (String) C_o.getSelectedItem();
                String norm     = (String) C_n.getSelectedItem();
                String f        = (String) C_f.getSelectedItem();
                String diameter = (String) C_d.getSelectedItem();
                M2.addRow(new Object[]{center,norm,f,diameter});
            }
        });
        // 物体删除按钮点击效果
        Cut2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = T2.getSelectedRow();
                if (selectedRow != -1) {
                    M2.removeRow(selectedRow);
                } else {
                    int rowCount = M2.getRowCount();
                    if (rowCount > 0) {
                        M2.removeRow(rowCount - 1);
                    }
                }
            }
        });
        /** 设置光源面板
         顶部面板 */
        JButton Add3 = new JButton("➕");
        JButton Cut3 = new JButton("➖");
        JPanel PAdd3Cut3 = new JPanel(new GridLayout(0,2,5,5));//栅格布局
        PAdd3Cut3.add(Add3);
        PAdd3Cut3.add(Cut3);
        JPanel PWord3 = new JPanel(new BorderLayout());//边框布局
        JLabel LWord3 = new JLabel("配置光源");
        PWord3.add(LWord3,BorderLayout.WEST);
        JPanel Top3 = new JPanel(new BorderLayout());//边框布局
        Top3.add(PWord3,BorderLayout.WEST);
        Top3.add(PAdd3Cut3,BorderLayout.EAST);
        P3.add(Top3,BorderLayout.NORTH);
        /** 表格面板 */
        DefaultTableModel M3 = new DefaultTableModel();
        JTable T3 = new JTable(M3);
        JScrollPane S3 = new JScrollPane(T3);
        P3.add(S3);
        /** 文本居中 */
        T3.setDefaultRenderer(Object.class, centerRenderer);
        /** 添加列 */
        M3.addColumn("形状");
        M3.addColumn("基点");
        M3.addColumn("半径");
        M3.addColumn("长度");
        M3.addColumn("宽度");
        M3.addColumn("法向");
        M3.addColumn("波长");
        M3.addColumn("强度");
        /** 初始化参数 */
        JComboBox<String> C_v = new JComboBox<>(new String[]{"400-800nm"});
        JComboBox<String> C_e = new JComboBox<>(new String[]{"7"});
        /** 表格可选项 */
        JComboBox<String> C3_1 = new JComboBox<>(new String[]{"平板","球体"});
        TableColumn T3_1 = T3.getColumnModel().getColumn(0);
        T3_1.setCellEditor(new DefaultCellEditor(C3_1));
        JComboBox<String> C3_2 = new JComboBox<>(new String[]{"100-300nm","300-400nm","400-500nm","400-800nm","600-800nm","700-1000nm"});
        TableColumn T3_2 = T3.getColumnModel().getColumn(6);
        T3_2.setCellEditor(new DefaultCellEditor(C3_2));
        JComboBox<String> C3_3 = new JComboBox<>(new String[]{"1","3","5","7","9"});
        TableColumn T3_3 = T3.getColumnModel().getColumn(7);
        T3_3.setCellEditor(new DefaultCellEditor(C3_3));

        /** 物体添加按钮点击效果 */
        Add3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shape  = (String) C3_1.getSelectedItem();
                String wave   = (String) C_v.getSelectedItem();
                String energy = (String) C_e.getSelectedItem();
                String center = (String) C_o.getSelectedItem();
                String radius = (String) C_r.getSelectedItem();
                String length = (String) C_l.getSelectedItem();
                String width  = (String) C_w.getSelectedItem();
                String norm   = (String) C_n.getSelectedItem();
                M3.addRow(new Object[]{shape,center,radius,length,width,norm,wave,energy});
            }
        });
        // 物体删除按钮点击效果
        Cut3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = T3.getSelectedRow();
                if (selectedRow != -1) {
                    M3.removeRow(selectedRow);
                } else {
                    int rowCount = M3.getRowCount();
                    if (rowCount > 0) {
                        M3.removeRow(rowCount - 1);
                    }
                }
            }
        });
        /** 设置输出面板
         顶部面板 */
        JButton outB = new JButton("输 出");
        JPanel outP = new JPanel(new GridLayout(0,1,5,5));//栅格布局
        outP.add(outB);
        JPanel PWord4 = new JPanel(new BorderLayout());//边框布局
        JLabel OUT = new JLabel("输出配置");
        PWord4.add(OUT,BorderLayout.WEST);
        JPanel Top4 = new JPanel(new BorderLayout());//边框布局
        Top4.add(PWord4,BorderLayout.WEST);
        Top4.add(outP,BorderLayout.EAST);
        P4.add(Top4,BorderLayout.NORTH);
        // 输出按钮点击效果
        outB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        /** 底部面板 */
        JPanel Down = new JPanel(new BorderLayout());
        JPanel Settings = new JPanel(new GridLayout(1,4));
        JPanel Readme = new JPanel();

        JPanel SetP1 = new JPanel(new BorderLayout());
        JPanel SetP2 = new JPanel(new BorderLayout());
        JPanel SetP3 = new JPanel(new BorderLayout());
        JPanel SetP4 = new JPanel(new BorderLayout());

        JLabel set1 = new JLabel("扫描解析度");
        JLabel set2 = new JLabel("基准三原色");
        JLabel set3 = new JLabel("高斯滤波器");
        JLabel set4 = new JLabel("边缘锐化度");
        String[] set1_1 = {"360", "720", "1080", "1440", "2160", "4320"};
        JComboBox<String> SetC1 = new JComboBox<>(set1_1);
        SetP1.add(set1);
        SetP1.add(SetC1);
        Settings.add(SetP1);




        String[] set2_1 = {"360", "720", "1080", "1440", "2160", "4320"};
        JComboBox<String> SetC2 = new JComboBox<>(set2_1);
        SetP2.add(set2);
        SetP2.add(SetC2);
        Settings.add(SetP2);







        Down.add(Settings,BorderLayout.WEST);
        Down.add(Readme,BorderLayout.EAST);



        JProgressBar progressBar = new JProgressBar();// 创建进度条
        progressBar.setStringPainted(true); //显示百分比
        progressBar.setValue(0); // 设置进度条初始值
        Dimension preferredSize = new Dimension(460, 20);//更改进度条的尺寸
        progressBar.setPreferredSize(preferredSize);
        JButton startButton = new JButton("开始");
        startButton.addActionListener(e -> {
            // 模拟任务的进度
            int progress = 0;
            while (progress <= 100) {
                progressBar.setValue(progress);
                try {
                    Thread.sleep(10); // 模拟任务的耗时操作
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                progress += 10;
            }
        });

        // 创建一个面板并将进度条和按钮添加到面板
        JPanel PBar = new JPanel();
        PBar.add(progressBar);
        PBar.add(startButton);
        Down.add(PBar,BorderLayout.SOUTH);
        Down.setVisible(true);
        P4.add(Down);


        P1.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        P2.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        P3.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        P4.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        QLFrame.add(P1);
        QLFrame.add(P2);
        QLFrame.add(P3);
        QLFrame.add(P4);
        QLFrame.setVisible(true);
    }
}
