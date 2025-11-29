/**
 * 实验3：小狗的状态
 * 包含 DogState 接口和实现该接口的各个状态类，以及 Dog 类和主类 CheckDogState。
 */
package shangjishiyan4;

// 定义小狗状态的接口
interface DogState {
    public void showState();
}

// 温顺状态
class SoftlyState implements DogState {
    public void showState() {
       System.out.println("听主人的命令");
    }
}

// 遇到敌人状态
class MeetEnemyState implements DogState {
   public void showState() {
       // 【代码1】
       // 在这里重写 public void showState()，描述遇到敌人时的状态
       System.out.println("狂吠"); // 示例
    } 
}  

// 遇到朋友状态
class MeetFriendState implements DogState {
   public void showState() {
       // 【代码2】
       // 在这里重写 public void showState() 方法，描述遇到朋友时的状态
       System.out.println("摇尾巴"); // 示例
    }
}

// 遇到同伴状态
class MeetAnotherDog implements DogState {
   public void showState() {
       // 【代码3】
       // 在这里重写 public void showState() 方法，描述遇到同伴时的状态
       System.out.println("一起玩耍"); // 示例
    } 
}

// 小狗类
class Dog {
   DogState state;
   
   public void show() {
      // 回调接口的方法
      state.showState();
   }
   
   public void setState(DogState s) {
      state = s;
   }
}

// 主类，用于测试
public class CheckDogState {
   public static void main(String args[]) {
      Dog yellowDog = new Dog();
      
      System.out.print("狗在主人面前: ");
      yellowDog.setState(new SoftlyState());
      yellowDog.show();
      
      System.out.print("狗遇到敌人: ");
      yellowDog.setState(new MeetEnemyState());
      yellowDog.show();
      
      System.out.print("狗遇到朋友: ");
      yellowDog.setState(new MeetFriendState());
      yellowDog.show(); 
      
      System.out.print("狗遇到同伴: ");
      yellowDog.setState(new MeetAnotherDog());
      yellowDog.show(); 
   }
}