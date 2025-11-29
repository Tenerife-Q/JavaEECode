package com.exception.runningException;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Tenerife
 * Su san
 */
public class FileNotFoundException {
    public static void main(String[] args) {
        try {
            FileInputStream fis;
            fis = new FileInputStream("E: \\a.jpg");
            int len;
            while((len = fis.read()) != -1){
                System.out.print(len);
            }
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
