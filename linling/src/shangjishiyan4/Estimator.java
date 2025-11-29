/**
 * 实验1：评价成绩
 * 包含 CompurerAverage 接口, Gymnastics 类, School 类, 以及主类 Estimator。
 */

package shangjishiyan4;

// 定义计算平均分的接口
interface CompurerAverage {
   public double average(double x[]);
}

// 体操比赛成绩计算类
class Gymnastics implements CompurerAverage {
   public double average(double x[]) {
      int count = x.length;
      double aver = 0, temp = 0;
      // 排序数组，从小到大
      for(int i = 0; i < count; i++) {
         for(int j = i; j < count; j++) {
            if(x[j] < x[i]) {
              temp = x[j];
              x[j] = x[i];
              x[i] = temp;  
            } 
         }
      }
      // 去掉一个最高分和一个最低分，计算中间项的总和
      for(int i = 1; i < count - 1; i++) {
         aver = aver + x[i];
      }
      // 计算平均分
      if(count > 2)
         aver = aver / (count - 2);
      else
         aver = 0;
      return aver;
   }
}

// 学校班级成绩计算类
class School implements CompurerAverage {
   // 【代码1】
   // 在这里重写 public double average(double x[]) 方法, 返回数组x[]的元素的算术平均

   public double average(double x[]) {
      if(x == null || x.length == 0){
         return 0;
      }
      double sum = 0;
      for(int i = 0; i < x.length; i++){
         sum += x[i];
      }
      return sum / x.length;
   }
}

// 主类，用于测试
public class Estimator {
   public static void main(String args[]) {
      double a[] = {9.89, 9.88, 9.99, 9.12, 9.69, 9.76, 8.97};
      double b[] = {89, 56, 78, 90, 100, 77, 56, 45, 36, 79, 98};  
      
      CompurerAverage computer;
      
      // 计算体操选手成绩
      computer = new Gymnastics();  
      double result = 0; // 【代码2】 在这里 computer 调用 average(double x[]) 方法，将数组 a 传递给参数 x
      result = computer.average(a);
      System.out.printf("%n");
      System.out.printf("体操选手最后得分:%5.3f\n", result);
      
      // 计算班级平均分
      computer = new School();  
      // 【代码3】 在这里 computer 调用 average(double x[]) 方法，将数组 b 传递给参数 x
      result = computer.average(b);
      System.out.printf("班级考试平均分数:%-5.2f\n", result);
   } 
}