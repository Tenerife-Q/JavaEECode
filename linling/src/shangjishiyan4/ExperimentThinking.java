/**
 * 本文件包含实验报告中“实验思考”部分需要编写的代码。
 */

package shangjishiyan4;



// ==================== 实验3 思考题 (1) ====================

/**
 * 模拟水杯中的水在不同温度下可能出现的状态
 */

// 定义一个表示水状态的接口
interface WaterState {
    void showState(int temperature); // 显示当前状态，并传入温度
}

// 固态（冰）
class SolidState implements WaterState {
    public void showState(int temperature) {
        System.out.println("温度 " + temperature + "°C: 我是冰，固态。");
    }
}

// 液态（水）
class LiquidState implements WaterState {
    public void showState(int temperature) {
        System.out.println("温度 " + temperature + "°C: 我是水，液态。");
    }
}

// 气态（水蒸气）
class GaseousState implements WaterState {
    public void showState(int temperature) {
        System.out.println("温度 " + temperature + "°C: 我是水蒸气，气态。");
    }
}

// 水杯类，根据温度改变水的状态
class Cup {
    WaterState state;

    // 根据温度设置水的状态
    public void setTemperature(int temperature) {
        if (temperature <= 0) {
            state = new SolidState();
        } else if (temperature < 100) {
            state = new LiquidState();
        } else {
            state = new GaseousState();
        }
        // 显示当前状态
        state.showState(temperature);
    }
}

// 用于测试水状态的主类
public class ExperimentThinking {
    public static void main(String[] args) {
        System.out.println("--- 测试水在不同温度下的状态 ---");
        Cup cup = new Cup();

        cup.setTemperature(25);  // 液态
        cup.setTemperature(-5);  // 固态
        cup.setTemperature(100); // 气态
        cup.setTemperature(50);  // 液态

        System.out.println("\n--- 简单演示冰箱类 ---");
        Refrigerator myFridge = new Refrigerator();
        System.out.println("冰箱的重量是: " + myFridge.computeWeight() + " kg");
    }
}