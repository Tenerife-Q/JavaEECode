package Chapter9.Example14;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Example9_14 { 
   public static void main(String args[]) { 
      MyWin win = new MyWin(); // 创建MyWin实例，启动主窗口
   }
}

class MyWin extends JFrame implements ActionListener {
   JLabel label = null; 
   JButton 读入 = null, 写出 = null;
   ByteArrayOutputStream out = null;

   MyWin() {
      setLayout(new FlowLayout()); // 设置布局管理器为FlowLayout
      label = new JLabel("How are you"); // 初始化JLabel
      读入 = new JButton("读入对象"); // 初始化"读入对象"按钮
      写出 = new JButton("写出对象"); // 初始化"写出对象"按钮
      读入.addActionListener(this); // 为"读入对象"按钮添加事件监听器
      写出.addActionListener(this); // 为"写出对象"按钮添加事件监听器
      setVisible(true); // 设置窗口可见
      add(label); // 将label添加到窗口
      add(写出); // 将"写出对象"按钮添加到窗口
      add(读入); // 将"读入对象"按钮添加到窗口
      setSize(500, 400); // 设置窗口大小
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭操作
      validate(); // 验证容器的布局
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == 写出) {
          try {
              out = new ByteArrayOutputStream();
              ObjectOutputStream objectOut = new ObjectOutputStream(out);
              objectOut.writeObject(label); // 序列化label对象到out流               
              objectOut.close();
          } catch (IOException event) {
              event.printStackTrace(); // 捕获并处理可能发生的异常
          }
      } else if (e.getSource() == 读入) {
          try {
              ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
              ObjectInputStream objectIn = new ObjectInputStream(in);
              JLabel temp = (JLabel)objectIn.readObject(); // 反序列化得到temp对象
              temp.setText("你好"); // 修改反序列化后的JLabel文本
              this.add(temp); // 将新JLabel添加到窗口
              this.validate(); // 验证容器的布局
              objectIn.close();
          } catch (Exception event) {
              event.printStackTrace(); // 捕获并处理可能发生的异常
          }
      }
   }
}



