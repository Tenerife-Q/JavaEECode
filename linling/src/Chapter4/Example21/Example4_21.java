package Chapter4.Example21;

import java.util.Date;
class Tom {
    void f(double m) {
        var width = 108;  //var声明变量width并推断出是int型  
        var height = m; //var声明变量height并推断出是double型
        var date = new Date();//var声明变量date并推断出是Date型 
        //width = 3.14; //非法，因为width的类型已经确定为int型
        //var str ; //非法，无法推断str的类型
       //var what = null; //非法，无法推断what的类型
       System.out.printf("%d,%f,%s\n",width,height,date); 
   }
}
public class Example4_21 {
    public static void main(String args[]){
         var tom = new Tom();//var声明变量tom并推断出是Tom型 
         tom.f(6.18);
    }
}

