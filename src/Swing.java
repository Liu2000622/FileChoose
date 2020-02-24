import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Swing {


    public static String location = new String();

    public static void main(String[] args) throws AWTException {
        getlocation();
    }

    public static void getlocation() throws AWTException {
        //创建窗口，设置外观
        JFrame JF = new JFrame("TXT文件过滤器");
        JF.setSize(300, 300);
        JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JF.setLocationRelativeTo(null);
        //创建一个面板从而添加组件
        JPanel panel = new JPanel(new FlowLayout());
        //创建输入框，获得要筛选的文字名称
        JTextField field = new JTextField(8);
        field.setFont(new Font(null, Font.PLAIN, 20));
        //创建提示标签
        JLabel lable;
        //将组件添加到面板中
        panel.add(lable = new JLabel("请输入磁盘地址"));
        panel.add(field);
        //设置面板可以被显示
        JF.setContentPane(panel);
        JF.setVisible(true);
        //创建提交按钮并添加到面板中
        JButton button = new JButton("提交");
        button.setFont(new Font(null, Font.PLAIN, 20));

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> name = new ArrayList<String>();
                String location = new String();
                //将输入框中的地址付给file变量
                location = field.getText();
                File file = new File(location);
                name = getAll(file);
                //创建结果输出窗口
                JFrame jf = new JFrame("结果窗口");
                jf.setSize(400, 400);
                jf.setLocationRelativeTo(null);
                jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                //通过迭代器遍历结果线性表
                Iterator<String> iterator = name.iterator();
                while (iterator.hasNext()){
                    String s =iterator.next();
                    //每一个文件弹出一个对话框进行告知
                    JOptionPane.showMessageDialog(
                            jf,
                            s,
                            "查找的txt文件如下",
                            JOptionPane.WARNING_MESSAGE
                    );
                }


            }
        });

        panel.add(button);
    }

    public static ArrayList<String> getAll(File dir) {
        ArrayList<String> name = new ArrayList<String>();
        //调用File对象方法listFiles()获取，加入过滤器
        File[] fileArr = dir.listFiles(new MyFilter());
        for (File fi : fileArr) {
            //判断如果f是文件夹的话
            if (fi.isDirectory()) {
                //递归进入文件夹遍历
                getAll(fi);
            } else {
                String a = (String) fi.getName();
                name.add(a);
            }
        }
        return name;
    }

}

