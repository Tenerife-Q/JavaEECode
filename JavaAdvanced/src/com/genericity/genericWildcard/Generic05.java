package com.genericity.genericWildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示Car父类及其子类AMG和BMW的泛型上下限使用。
 * 实现赛事添加车辆(add)以及开赛(run)方法，并体现通配符的使用。
 *
 * @author Tenerife
 * @date 2025/10/24
 *
 * GenericRaceWildcard
 */
public class Generic05 {

    public static void main(String[] args) {
        // 创建赛事
        Race<Car> race = new Race<>();

        // 添加AMG和BMW车辆到赛事
        race.add(new AMG("AMG GT"));
        race.add(new BMW("BMW M4"));

        // 打印所有参赛车辆（无界通配符）
        race.printParticipants();

        // 开始赛事
        race.run();

        // 创建子类赛事并向父类赛事中处理
        List<AMG> amgRace = new ArrayList<>();
        amgRace.add(new AMG("AMG C63"));
        handleRace(amgRace); // 使用上限通配符处理AMG赛事

        List<Car> genericRace = new ArrayList<>();
        handleAMGForBroadRace(genericRace); // 使用下限通配符处理通用赛事
    }

    /**
     * 使用上限通配符（<? extends Car>）处理赛事。
     * 打印所有参赛车辆信息。
     *
     * @param raceList 包含Car或其子类的赛事列表
     */
    public static void handleRace(List<? extends Car> raceList) {
        System.out.println("\nHandling a race with the following participants:");
        for (Car car : raceList) {
            System.out.println("Car: " + car);
            car.drive();
        }
    }

    /**
     * 使用下限通配符（<? super AMG>）添加AMG车辆到赛事。
     * 适用于AMG及其父类的赛事。
     *
     * @param raceList 包含AMG或其父类的赛事列表
     */
    public static void handleAMGForBroadRace(List<? super AMG> raceList) {
        raceList.add(new AMG("AMG GT Black Series"));
        System.out.println("\nAdded AMG to a broad race list!");
    }
}

/**
 * 父类Car
 */
class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void drive() {
        System.out.println(name + " is driving!");
    }

    @Override
    public String toString() {
        return "Car{name='" + name + "'}";
    }
}

/**
 * 子类AMG
 */
class AMG extends Car {
    public AMG(String name) {
        super(name);
    }

    @Override
    public void drive() {
        System.out.println(getName() + " (AMG) is racing with high performance!");
    }
}

/**
 * 子类BMW
 */
class BMW extends Car {
    public BMW(String name) {
        super(name);
    }

    @Override
    public void drive() {
        System.out.println(getName() + " (BMW) is racing with precision control!");
    }
}

/**
 * 赛事类，泛型定义支持Car及其子类。
 * @param <T> 泛型类型，限定为Car或其子类。
 */
class Race<T extends Car> {
    private final List<T> participants = new ArrayList<>();

    /**
     * 添加车辆到赛事中
     *
     * @param car 车辆对象，必须是Car或其子类
     */
    public void add(T car) {
        participants.add(car);
        System.out.println(car.getName() + " has been added to the race!");
    }

    /**
     * 启动赛事，所有参赛车辆将进行比赛
     */
    public void run() {
        System.out.println("\nThe race is starting!");
        for (T car : participants) {
            car.drive();
        }
    }

    /**
     * 打印所有参赛车辆（无界通配符示例）
     */
    public void printParticipants() {
        System.out.println("\nParticipants in the race:");
        for (T car : participants) {
            System.out.println(car);
        }
    }
}