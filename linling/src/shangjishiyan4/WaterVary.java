package shangjishiyan4;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/21 20:00
 */
// 定义一个包含行为的枚举
enum WaterStateEnum {
    SOLID("我是冰，固态。"),
    LIQUID("我是水，液态。"),
    GASEOUS("我是水蒸气，气态。");

    private final String description;

    // 枚举的构造函数
    private WaterStateEnum(String description) {
        this.description = description;
    }

    // 显示状态描述的方法
    public void showDescription(int temperature) {
        System.out.println("温度 " + temperature + "°C: " + description);
    }

    // 静态工厂方法，根据温度返回对应的枚举状态
    public static WaterStateEnum getStateFor(int temperature) {
        if (temperature <= 0) {
            return SOLID;
        } else if (temperature < 100) {
            return LIQUID;
        } else {
            return GASEOUS;
        }
    }
}

class CupWithEnum {
    public void showState(int temperature) {
        // 先获取当前温度对应的状态，然后调用该状态的方法
        WaterStateEnum.getStateFor(temperature).showDescription(temperature);
    }
}

public class WaterVary {
    public static void main(String[] args) {
        System.out.println("--- 测试 enum 解决方案 ---");
        CupWithEnum cup = new CupWithEnum();
        cup.showState(25);
        cup.showState(-5);
        cup.showState(100);
    }
}
