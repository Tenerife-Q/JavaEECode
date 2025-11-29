package com.exercise;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/31 21:07
 */

/**
 * 使用枚举来表示牌的点数（等级）
 * 每个枚举实例都包含一个权重值，用于比较大小
 */
public enum Rank {
    // 点数(权重, 显示名)
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K"),
    ACE(14, "A"),
    TWO(15, "2"),
    SMALL_JOKER(16, "Small Joker"),
    BIG_JOKER(17, "Big Joker");

    private final int weight;
    private final String displayName;

    Rank(int weight, String displayName) {
        this.weight = weight;
        this.displayName = displayName;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}