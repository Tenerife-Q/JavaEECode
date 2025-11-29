package shangjishiyan5;

/**
 * Goods 类，一个简单的数据类（POJO），用于封装货物的属性。
 */
class Goods {
    boolean isDanger; // 货物是否是危险品
    String name;      // 货物名称

    public void setIsDanger(boolean boo) {
        isDanger = boo;
    }
    public boolean isDanger() {
        return isDanger;
    }
    public void setName(String s) {
        name = s;
    }
    public String getName() {
        return name;
    }
}

/**
 * 自定义异常类 DangerException，继承自 Exception。
 * 当检测到危险品时，程序将抛出此类型的异常。
 */
class DangerException extends Exception {
    String message; // 用于存放异常信息

    /**
     * DangerException 的构造方法。
     */
    public DangerException() {
        // 【代码1】: 初始化异常信息
        message = "危险品！";
    }

    /**
     * 显示异常信息的方法。
     */
    public void toShow() {
        System.out.print(message+" ");
    }
}

/**
 * Machine 类，模拟一个安检机。
 */
class Machine {
    /**
     * 检查行李的方法。
     * @param goods 需要被检查的货物对象
     * @throws DangerException 如果货物是危险品，则抛出此异常。
     */
    public void checkBag(Goods goods) throws DangerException {
        if(goods.isDanger()) {
            // 创建一个自定义的异常对象
            DangerException danger=new DangerException();
            // 【代码2】: 使用 throw 关键字将异常抛出
            throw danger;
        }
        else {
            System.out.print(goods.getName()+"不是危险品! ");
        }
    }
}

/**
 * 程序主入口类，模拟安检流程。
 */
public class Experiment2 {
    public static void main(String args[]) {
        Machine machine = new Machine();
        String name[] ={"苹果","炸药","西服","硫酸","手表","硫磺"};
        Goods [] goods = new Goods[name.length];

        // 初始化一个货物数组，交替设置普通物品和危险品
        for(int i= 0;i<name.length;i++) {
            goods[i] = new Goods();
            goods[i].setName(name[i]);
            if(i%2==0) { // 偶数索引为非危险品
                goods[i].setIsDanger(false);
            }
            else { // 奇数索引为危险品
                goods[i].setIsDanger(true);
            }
        }

        // 遍历所有货物，逐一进行检查
        for(int i= 0;i<goods.length;i++) {
            // 使用 try-catch 结构来处理可能抛出的 DangerException
            try {
                // 将可能产生异常的代码放在 try 块中
                machine.checkBag(goods[i]);
                // 如果 checkBag 没有抛出异常，则说明检查通过，会执行以下代码
                System.out.println(goods[i].getName()+"检查通过");
            }
            catch(DangerException e) { // 捕获特定类型的异常 DangerException
                // 如果 try 块中抛出了 DangerException，程序会跳转到这里执行
                // 【代码3】: 调用异常对象的 toShow 方法打印 "危险品！"
                e.toShow();
                System.out.println(goods[i].getName()+"被禁止!");
            }
        }
    }
}