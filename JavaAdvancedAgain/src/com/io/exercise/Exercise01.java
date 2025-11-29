package com.io.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/1 20:57
 */
public class Exercise01 {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("src/com/io/exercise/csb"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/io/exercise/newcsb"))
        ) {
            List<String> data = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }

            Collections.sort(data);
            System.out.println(data);

            for (String str : data) {
                bw.write(str);
                bw.newLine();
            }

            System.out.println("modify success");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
