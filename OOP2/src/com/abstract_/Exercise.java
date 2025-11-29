package com.abstract_;

/**
 * 抽象类模板
 * 总分总
 * 1.先定义抽象类 确定模板流程abstract申明 将各步骤包装进一个final修饰的方法中 方便main方法调用
 * 2.子类继承父类 实现所有抽象方法 即重写父类方法
 * 3.main方法 多态总调用Game类中play()方法 向上转型父类引用指向子类方法 好分别实现不同子类详细流程
 */

// 1. 抽象类定义模板方法和抽象步骤
abstract class Game {
    // 模板方法，定义流程，不允许子类更改
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
    abstract void initialize(); // 抽象方法，子类实现
    abstract void startPlay();
    abstract void endPlay();
}

// 2. 子类实现抽象方法
//子类必须实现所有抽象方法，即重写，或者要将类申明为abstract抽象类
class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football initializing...");
    }

    void startPlay() {
        System.out.println("足球比赛开始");
    }
    void endPlay() {
        System.out.println("足球比赛结束");
    }
}

class Basketball extends Game {
    void initialize() {
        System.out.println("篮球初始化");
    }

    @Override
    void startPlay() {
        System.out.println("Android Game ...");
    }

    void endPlay() {
        System.out.println("篮球比赛结束");
    }
}

// 3. 调用代码
//体现代码复用性
public class Exercise {
    public static void main(String[] args) {
        Game game = new Football(); // 父类引用指向子类对象 向上转型 即多态
        game.play();                // 调用模板方法，实际执行子类步骤
        //调用play()方法 能够复用代码 不用写那么多行
        game = new Basketball();
        game.play();
    }
}