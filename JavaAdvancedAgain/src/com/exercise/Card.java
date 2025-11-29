package com.exercise;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/31 20:22
 */

/**
 * 简化后的Card类，使用Rank枚举来表示点数
 */
public class Card {
    private final Rank rank; // 点数
    private final String color; // 花色

    public Card(Rank rank, String color) {
        this.rank = rank;
        this.color = color;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        // 大小王没有花色，直接显示点数
        if (this.rank == Rank.SMALL_JOKER || this.rank == Rank.BIG_JOKER) {
            return rank.toString();
        }
        // 普通牌显示花色+点数
        return color + rank.toString();
    }
}