package com.io.dataStream;

import java.io.*;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/2 14:01
 *
 * 特殊数据流
 */
public class DataStream01 {
    public static void main(String[] args) {
        try (
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/com/io/dataStream/ioTest12"));
        ){
            dos.writeByte(65);
            dos.writeUTF("Hello");
            dos.writeChar('a');
            dos.writeInt(988);
            dos.writeDouble(3.14);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
