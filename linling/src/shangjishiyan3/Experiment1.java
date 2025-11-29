package shangjishiyan3;

/**
 * 实验一：子类与继承 (中国人、北京人和美国人)
 * @author Tenerife-Q
 * @date 2025-10-14
 */
public class Experiment1 {
    public static void main(String[] args) {
        System.out.println("========= 实验一：中国人、北京人和美国人 =========");
        Chinese chinaPeople = new Chinese();
        American americanPeople = new American();
        Beijingman beijingPeople = new Beijingman();

        System.out.println("--- 打招呼 ---");
        chinaPeople.speakHello();
        americanPeople.speakHello();
        beijingPeople.speakHello();

        System.out.println("\n--- 平均身高 ---");
        chinaPeople.averageHeight();
        americanPeople.averageHeight();
        beijingPeople.averageHeight();

        System.out.println("\n--- 平均体重 ---");
        chinaPeople.averageWeight();
        americanPeople.averageWeight();
        beijingPeople.averageWeight();

        System.out.println("\n--- 特有技能 ---");
        chinaPeople.chinaGongfu();
        americanPeople.americanBoxing();
        beijingPeople.beijingOpera();

        System.out.println("\n--- 子类继承父类的方法 ---");
        beijingPeople.chinaGongfu();
    }
}

/**
 * [实验一] 父类 People
 */
class People {
   protected double weight,height;

   public void speakHello() {
      System.out.println("yayayaya");
   }

   public void averageHeight() {
       height = 173;
       System.out.println("average height:" + height);
   }

   public void averageWeight() {
      weight = 70;
      System.out.println("average weight:" + weight);
   }
}

/**
 * [实验一] 子类 Chinese 继承自 People
 */
class Chinese extends People {
     @Override
     public void speakHello() {
        System.out.println("您好");
     }

     @Override
     public void averageHeight() {
        height = 168.78;
        System.out.println("中国人的平均身高:" + height + " 厘米");
     }

    /** 【代码1】 补充 **/
    @Override
    public void averageWeight() {
        weight = 65;
        System.out.println("中国人的平均体重：" + weight + "公斤");
    }

     public void chinaGongfu() {
        System.out.println("坐如钟,站如松,睡如弓");
     }
}

/**
 * [实验一] 子类 American 继承自 People
 */
class American extends People {
    /** 【代码2】 补充 **/
    @Override
    public void speakHello() {
        System.out.println("How do you do");
    }

    /** 【代码3】 补充 **/
    @Override
    public void averageHeight() {
        height = 176;
        System.out.println("American's average height:" + height + " cm");
    }

    @Override
    public void averageWeight() {
        weight = 75;
        System.out.println("American's average weight:" + weight + " kg");
    }

    public void americanBoxing() {
        System.out.println("直拳、钩拳、组合拳");
    }
}

/**
 * [实验一] 子类 Beijingman 继承自 Chinese
 */
class Beijingman extends Chinese {
    /** 【代码4】 补充 **/
    @Override
    public void averageHeight() {
        height = 172.5;
        System.out.println("北京人的平均身高: " + height + "厘米");
    }

    /** 【代码5】 补充 **/
    @Override
    public void averageWeight() {
        weight = 70;
        System.out.println("北京人的平均体重：" + weight + "公斤");
    }

    public void beijingOpera() {
        System.out.println("花脸、青衣、花旦和老生");
    }
}