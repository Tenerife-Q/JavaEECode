package com.io.printStream;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/2 13:43
 *
 * 打印流 打印方便
 */
public class PrintStream01 {
    public static void main(String[] args) {
        try (
                //追加只能在低级流中构造
                PrintStream ps = new PrintStream(new FileOutputStream("src/com/io/printStream/ioTest11",true))
//                PrintWriter pw = new PrintStream("src/com/io/printStream/ioTest11") 也行
        ) {
            ps.println("Hello World");
            ps.println(97);
            ps.println('a');
            ps.println("简单");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
