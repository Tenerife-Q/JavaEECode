package shangjishiyan3;

/**
 * 实验二：银行计算利息
 * @author Tenerife-Q
 * @date 2025-10-14
 */
public class Experiment2 {
    public static void main(String[] args) {
        System.out.println("========= 实验二：银行计算利息 =========");
        int amount = 8000;
        ConstructionBank bank1 = new ConstructionBank();
        bank1.savedMoney = amount;
        bank1.year = 8.236;
        bank1.setInterestRate(0.035);
        double interest1 = bank1.computerInterest();

        BankOfDalian bank2 = new BankOfDalian();
        bank2.savedMoney = amount;
        bank2.year = 8.236;
        bank2.setInterestRate(0.035);
        double interest2 = bank2.computerInterest();
        System.out.printf("两个银行利息相差%f元\n", interest2 - interest1);

        System.out.println("\n--- 实验二思考题测试 ---");
        CommercialBank bank3 = new CommercialBank();
        bank3.savedMoney = amount;
        bank3.year = 8.236;
        bank3.setInterestRate(0.035);
        bank3.computerInterest();
    }
}

/**
 * [实验二] 父类 Bank
 */
class Bank {
   int savedMoney;
   int year;
   double interest;
   double interestRate = 0.29;

   public double computerInterest() {
      interest = year * interestRate * savedMoney;
      return interest;
   }

   public void setInterestRate(double rate) {
      interestRate = rate;
   }
}

/**
 * [实验二] 子类 ConstructionBank
 */
class ConstructionBank extends Bank {
   double year;

   @Override
   public double computerInterest() {
      super.year = (int)year;
      double r = year - (int)year;
      int day = (int)(r * 1000);

      /** 【代码1】 补充 **/
      double yearInterest = super.computerInterest();

      double dayInterest = day * 0.0001 * savedMoney;
      interest = yearInterest + dayInterest;
      System.out.printf("%d元存在建设银行%d年零%d天的利息:%f元\n",
                         savedMoney, super.year, day, interest);
      return interest;
   }
}

/**
 * [实验二] 子类 BankOfDalian
 */
class BankOfDalian extends Bank {
   double year;

   @Override
   public double computerInterest() {
      super.year = (int)year;
      double r = year - (int)year;
      int day = (int)(r * 1000);

      /** 【代码2】 补充 **/
      double yearInterest = super.computerInterest();

      double dayInterest = day * 0.00012 * savedMoney;
      interest = yearInterest + dayInterest;
      System.out.printf("%d元存在大连银行%d年零%d天的利息:%f元\n",
                         savedMoney, super.year, day, interest);
      return interest;
   }
}

/**
 * [实验二 思考题] 新增的商业银行类
 */
class CommercialBank extends Bank {
   double year;
   double dailyInterestRate = 0.00011;

   @Override
   public double computerInterest() {
      super.year = (int)year;
      double r = year - super.year;
      int day = (int)(r * 1000);
      double yearInterest = super.computerInterest();
      double dayInterest = day * dailyInterestRate * savedMoney;
      interest = yearInterest + dayInterest;
      System.out.printf("%d元存在商业银行%d年零%d天的利息:%f元\n",
                         savedMoney, super.year, day, interest);
      return interest;
   }
}