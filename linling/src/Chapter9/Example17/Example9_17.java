package Chapter9.Example17;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.image.BufferedImage; 
public class Example9_17 {
   public static void main(String args[]) {
       File fileRead = new File("src\\Chapter9\\Example17\\image\\pic.jpg"); //源
       File fileWriteOne = new File("src\\Chapter9\\Example17\\image\\java.bmp"); // 目的地
       File fileWriteTwo = new File("src\\Chapter9\\Example17\\image\\java.jpg"); // 目的地      
       try{  
          BufferedImage image = ImageIO.read(fileRead);
          Graphics2D g = image.createGraphics();
          int width = image.getWidth();
          int height = image.getHeight();
          Font font = new Font("宋体",Font.BOLD,56);
          g.setFont(font);
          g.setColor(Color.blue);
          g.drawString("我喜欢Java",width/2,height/2);
          ImageIO.write(image,"bmp",fileWriteOne);
          ImageIO.write(image,"jpg",fileWriteTwo);
       }
       catch(IOException e) {
          System.out.println("Error "+e);
       }
   }
}
