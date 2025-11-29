package com.io.inputStreamReader;

import java.io.*;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/2 13:14
 *
 * InputStreamReader
 * 使用字符输入转换流InputStreamReader解决不同编码读取乱码问题
 */
public class InputStreamReader01 {


    public static void main(String[] args) {

        try(
                InputStream is = new FileInputStream("src/com/io/inputStreamReader/ioTest10");
                Reader isr = new InputStreamReader(is,"GBK");
                BufferedReader br = new BufferedReader(isr)
                ){
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
