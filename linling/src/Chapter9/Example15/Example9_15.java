package Chapter9.Example15;

import java.io.*;
import java.util.*;
public class Example9_15 {
   public static void main(String args[]) {
      File file = new File("src\\Chapter9\\Example15\\cost.txt");
      Scanner sc=null;
      int sum=0;
      try { sc = new Scanner(file);
            while(sc.hasNext()){
               try{
                    int price=sc.nextInt();
                    sum=sum+price;
                    System.out.println(price); 
               } 
               catch(InputMismatchException exp){
                    String t=sc.next();
               }   
            }
            System.out.println("Total Cost:"+sum+" dollar");
      }
      catch(Exception exp){
         System.out.println(exp); 
      }
   }
}
