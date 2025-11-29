/**
 * 实验2：货车的装载量
 * 包含 ComputerWeight 接口和实现该接口的各个货物类，以及 Truck 类和主类 CheckCarWeight。
 */

package shangjishiyan4;

//// 定义计算重量的接口
//interface ComputerWeight {
//    public double computeWeight();
//}

// ==================== 实验2 思考题 (1) ====================
// 定义一个计算重量的接口 (为使本文件能独立编译，在此重复定义)
interface ComputerWeight {
    public double computeWeight();
}

// 新增的电冰箱类
class Refrigerator implements ComputerWeight {
    // 重写 computeWeight 方法，返回冰箱的重量
    public double computeWeight() {
        return 80.0; // 示例重量：80.0 kg
    }
}


// 电视机类
class Television implements ComputerWeight {
   // 【代码1】
   // 在这里重写 computeWeight() 方法，返回电视机的重量
   public double computeWeight() {
      // 请在此处补充代码
      return 15.5; // 示例重量
   }
}

// 电脑类
class Computer implements ComputerWeight {
   // 【代码2】
   // 在这里重写 computeWeight() 方法，返回电脑的重量
   public double computeWeight() {
      // 请在此处补充代码
      return 5.2; // 示例重量
   }
}  

// 洗衣机类
class WashMachine implements ComputerWeight {
   // 【代码3】
   // 在这里重写 computeWeight() 方法，返回洗衣机的重量
   public double computeWeight() {
      // 请在此处补充代码
      return 50.0; // 示例重量
   }
}

// 卡车类
class Truck {
   ComputerWeight [] goods;
   double totalWeights = 0;
   
   Truck(ComputerWeight[] goods) {
       this.goods = goods;
   }
   
   public void setGoods(ComputerWeight[] goods) {
       this.goods = goods;
   }
   
   public double getTotalWeights() {
      totalWeights = 0;
      // 【代码4】
      // 在这里遍历 goods 数组，计算所有货物的总重量 totalWeights
      // for(...) { ... }

       for (int i = 0; i < goods.length; i++) {
           totalWeights += goods[i].computeWeight();
       }
      return totalWeights;
   }    
}

// 主类，用于测试
public class CheckCarWeight {
   public static void main(String args[]) {
      // 第一次装载
      ComputerWeight[] goods1 = new ComputerWeight[650]; // 650件货物
      for(int i = 0; i < goods1.length; i++) { // 简单分成三类
           if(i % 3 == 0)
             goods1[i] = new Television();
           else if(i % 3 == 1)
             goods1[i] = new Computer();
           else if(i % 3 == 2)
             goods1[i] = new WashMachine();
     } 
     Truck truck = new Truck(goods1);
     System.out.printf("\n货车装载的货物重量:%-8.5f kg\n", truck.getTotalWeights());
     
     // 第二次装载
     ComputerWeight[] goods2 = new ComputerWeight[68]; // 68件货物
     for(int i = 0; i < goods2.length; i++) { // 简单分成两类
          if(i % 2 == 0)
            goods2[i] = new Television();
          else 
            goods2[i] = new WashMachine();
     } 
     truck.setGoods(goods2);
     System.out.printf("货车装载的货物重量:%-8.5f kg\n", truck.getTotalWeights());
   }
}