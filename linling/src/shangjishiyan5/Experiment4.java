package shangjishiyan5;

import java.util.*; // 导入 Java 工具包，包含 Scanner, Date, Calendar 等类

/**
 * 程序主入口类，用于比较用户输入的两个日期。
 */
public class Experiment4 {
   public static void main(String args[ ]) {
      // 创建一个 Scanner 对象来读取用户的键盘输入
      Scanner scanner = new Scanner(System.in);

      // --- 获取第一个日期 ---
      System.out.println("输入第一个年，月，日数据");
      System.out.print("输入年份");
      short yearOne = scanner.nextShort();
      System.out.print("输入月份");
      byte monthOne = scanner.nextByte();
      System.out.print("输入日期");
      byte dayOne = scanner.nextByte();

      // --- 获取第二个日期 ---
      System.out.println("输入第二个年，月，日数据");
      System.out.print("输入年份");
      short yearTwo = scanner.nextShort();
      System.out.print("输入月份");
      byte monthTwo= scanner.nextByte();
      System.out.print("输入日期");
      byte dayTwo = scanner.nextByte();

      // --- 日期比较与计算 ---
      // 【代码1】: 获取一个 Calendar 类的实例。Calendar 是处理日期和时间的强大工具。
      Calendar calendar = Calendar.getInstance();
      // 【代码2】: 将 calendar 对象的时间设置为用户输入的第一个日期。注意：Calendar的月份是从0开始的（0-11），所以需要将用户输入的月份减1。
      calendar.set(yearOne, monthOne - 1, dayOne);
      // 【代码3】: 获取从1970年1月1日0时到当前 calendar 所表示时间的总毫秒数。
      long timeOne = calendar.getTimeInMillis();

      // 重新设置 calendar 对象的时间为用户输入的第二个日期
      calendar.set(yearTwo, monthTwo-1, dayTwo);
      // 获取第二个日期的总毫秒数
      long timeTwo=calendar.getTimeInMillis();

      // 【代码4】: 使用毫秒数来创建一个 Date 对象。Date 类主要用于表示特定的时间点。
      Date date1 = new Date(timeOne);
      Date date2 = new Date(timeTwo);

      // 使用 Date 类提供的 after(), before(), equals() 方法来比较两个日期的先后
      if(date2.equals(date1))
         System.out.println("两个日期的年、月、日完全相同");
      else if(date2.after(date1))
         System.out.println("您输入的第二个日期大于第一个日期");
      else if(date2.before(date1))
         System.out.println("您输入的第二个日期小于第一个日期");

      // 【代码5】: 计算两个日期相隔的天数
      // 1. 计算两个时间戳的差值（毫秒）
      // 2. 使用 Math.abs() 取绝对值，避免结果为负
      // 3. 除以一天的总毫秒数 (1000毫秒 * 60秒 * 60分钟 * 24小时)
      long days = Math.abs(timeTwo - timeOne) / (1000 * 60 * 60 * 24);

      // 输出最终结果
      System.out.println(yearOne+"年"+monthOne+"月"+dayOne+"日和"
              +yearTwo+"年"+monthTwo+"月"+dayTwo+"相隔"+days+"天");
      scanner.close(); // 关闭 scanner 以释放资源
   }
}