package shangjishiyan5;

/**
 * MobileShop 类，模拟一个手机专卖店。
 * 它包含一个内部类 InnerPurchaseMoney 来表示专用的内部购物券。
 */
class MobileShop {
    /**
     * 声明一个内部购物券对象，用于持有面值20000的券。
     * 它的初始化在构造方法中完成。
     */
    InnerPurchaseMoney purchaseMoney1;

    /**
     * 声明第二个内部购物券对象，用于持有面值10000的券。
     */
    InnerPurchaseMoney purchaseMoney2;

    /**
     * 专卖店当前持有的手机数量。这是一个私有成员，只能通过类内部的方法访问。
     */
    private int mobileAmount;

    /**
     * MobileShop 类的构造方法。
     * 当创建一个 MobileShop 对象时，这个方法会自动被调用。
     * 它的作用是初始化两张内部购物券，并赋予它们不同的面值。
     */
    MobileShop(){
        // 【代码3】: 创建一个面值为 20000 的购物券实例，并赋值给 purchaseMoney1
        purchaseMoney1 = new InnerPurchaseMoney(20000);
        // 【代码4】: 创建一个面值为 10000 的购物券实例，并赋值给 purchaseMoney2
        purchaseMoney2 = new InnerPurchaseMoney(10000);
    }

    /**
     * 设置手机店的手机初始数量。
     * @param m 要设置的手机数量
     */
    void setMobileAmount(int m) {
        mobileAmount = m;
    }

    /**
     * 获取当前手机店的手机数量。
     * @return 当前的手机数量
     */
    int getMobileAmount() {
        return mobileAmount;
    }

    /**
     * 内部类 InnerPurchaseMoney，模拟内部购物券。
     * 作为内部类，它可以直接访问外部类 MobileShop 的成员（如 mobileAmount）。
     */
    class InnerPurchaseMoney {
        /**
         * 购物券的面值。
         */
        int moneyValue;

        /**
         * InnerPurchaseMoney 的构造方法。
         * @param m 用于设置购物券面值的金额
         */
        InnerPurchaseMoney(int m) {
            moneyValue =  m;
        }

        /**
         * 模拟使用购物券购买手机的行为。
         * 此方法会根据购物券的面值，减少外部类 MobileShop 的手机数量。
         */
        void buyMobile() {
            if(moneyValue>=20000) {
                // 直接修改外部类的 private 成员 mobileAmount
                mobileAmount = mobileAmount-6;
                System.out.println("用价值"+moneyValue+"的内部购物卷买了6部手机");
            }
            else if(moneyValue<20000&&moneyValue>=10000) {
                // 直接修改外部类的 private 成员 mobileAmount
                mobileAmount = mobileAmount-3;
                System.out.println("用价值"+moneyValue+"的内部购物卷买了3部手机");
            }
        }
    }
}

/**
 * 程序的主入口类，用于测试 MobileShop 和其内部类的功能。
 */
public class Experiment1 {
    public static void main(String args[]) {
        // 1. 创建一个手机店对象，此时构造方法被调用，两张购物券被自动创建。
        MobileShop shop = new MobileShop();
        // 2. 设置手机店的初始手机库存为30。
        shop.setMobileAmount(30);
        System.out.println("手机专卖店目前有"+shop.getMobileAmount()+"部手机");
        // 3. 使用第一张购物券购买手机。
        shop.purchaseMoney1.buyMobile();
        // 4. 使用第二张购物券购买手机。
        shop.purchaseMoney2.buyMobile();
        // 5. 打印购买后的剩余手机数量。
        System.out.println("手机专卖店目前有"+shop.getMobileAmount()+"部手机");
    }
}