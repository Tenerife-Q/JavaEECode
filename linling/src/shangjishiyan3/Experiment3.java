package shangjishiyan3;

/**
 * 实验三：公司支出的总薪水
 * @author Tenerife-Q
 * @date 2025-10-14
 */
public class Experiment3 {
    public static void main(String[] args) {
        System.out.println("========= 实验三：公司支出的总薪水 =========");
        Employee[] employee = new Employee[29];
        for (int i = 0; i < employee.length; i++) {
            if (i % 3 == 0)
                employee[i] = new WeekWorker();
            else if (i % 3 == 1)
                employee[i] = new MonthWorker();
            else if (i % 3 == 2)
                employee[i] = new YearWorker();
        }
        Company company = new Company(employee);
        System.out.println("公司薪水总额:" + company.salariesPay() + "元");

        System.out.println("\n--- 实验三思考题测试 ---");
        Employee[] employeeWithNewType = new Employee[32];
        for (int i = 0; i < employeeWithNewType.length; i++) {
            if (i % 4 == 0)
                employeeWithNewType[i] = new WeekWorker();
            else if (i % 4 == 1)
                employeeWithNewType[i] = new MonthWorker();
            else if (i % 4 == 2)
                employeeWithNewType[i] = new YearWorker();
            else
                employeeWithNewType[i] = new DayWorker();
        }
        Company company2 = new Company(employeeWithNewType);
        System.out.println("加入日薪员工后，公司薪水总额:" + company2.salariesPay() + "元");
    }
}

/**
 * [实验三] 抽象父类 Employee
 */
abstract class Employee {
   public abstract double earnings();
}

/**
 * [实验三] 年薪制员工
 */
class YearWorker extends Employee {
   /** 【代码1】 补充 **/
   @Override
   public double earnings() {
      return 200000.0;
   }
}

/**
 * [实验三] 月薪制员工
 */
class MonthWorker extends Employee {
   /** 【代码2】 补充 **/
   @Override
   public double earnings() {
      return 10000 * 12;
   }
}

/**
 * [实验三] 周薪制员工
 */
class WeekWorker extends Employee {
   /** 【代码3】 补充 **/
   @Override
   public double earnings() {
      return 2000 * 52;
   }
}

/**
 * [实验三] 公司类
 */
class Company {
   Employee[] employee;
   double salaries = 0;

   Company(Employee[] employee) {
      this.employee = employee;
   }

   public double salariesPay() {
      salaries = 0;
      /** 【代码4】 补充 **/
      for (Employee e : employee) {
         if (e != null) {
            salaries += e.earnings();
         }
      }
      return salaries;
   }
}

/**
 * [实验三 思考题] 新增的日薪制员工
 */
class DayWorker extends Employee {
    @Override
    public double earnings() {
        return 400 * 251;
    }
}