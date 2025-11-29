package com.io.dataStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/2 14:06
 */
public class DataStream02 {
    public static void main(String[] args) {
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream("src/com/io/dataStream/ioTest12"));
        ){
            //要一一对应
            System.out.println(dis.readByte());
            System.out.println(dis.readUTF());
            System.out.println(dis.readChar());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
