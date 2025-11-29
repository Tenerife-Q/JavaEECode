package com.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/31 20:24
 */

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/31 20:24
 *
 *
 */
public class Room {

    private final List<Card> allCards = new ArrayList<>();

    {
        // 1. 使用 Rank 枚举来初始化一副牌
        String[] colors = {"♠", "♥", "♣", "♦"};
        // 先添加普通牌
        for (Rank rank : Rank.values()) {
            // 排除大小王
            if (rank != Rank.SMALL_JOKER && rank != Rank.BIG_JOKER) {
                for (String color : colors) {
                    allCards.add(new Card(rank, color));
                }
            }
        }
        // 单独添加大小王 (它们没有花色)
        allCards.add(new Card(Rank.SMALL_JOKER, ""));
        allCards.add(new Card(Rank.BIG_JOKER, ""));
    }

    public void start() {
        // 1. 洗牌
        System.out.println("开始洗牌...");
        Collections.shuffle(allCards);
        System.out.println("洗牌完成！");
        System.out.println("-----------------");

        // 2. 准备三个玩家的手牌列表和底牌列表 (V1的结构)
        List<Card> player1 = new ArrayList<>();
        List<Card> player2 = new ArrayList<>();
        List<Card> player3 = new ArrayList<>();
        List<Card> bottomCards = new ArrayList<>();

        // 3. 发牌
        System.out.println("开始发牌...");
        for (int i = 0; i < allCards.size(); i++) {
            Card card = allCards.get(i);
            // 最后三张作为底牌
            if (i >= 51) {
                bottomCards.add(card);
            } else {
                // 轮流发牌
                if (i % 3 == 0) {
                    player1.add(card);
                } else if (i % 3 == 1) {
                    player2.add(card);
                } else {
                    player3.add(card);
                }
            }
        }
        System.out.println("发牌完成！");
        System.out.println("-----------------");

        // 4. ✨ 使用 Lambda 表达式为所有手牌和底牌排序 ✨
        player1.sort((c1, c2) -> c1.getRank().getWeight() - c2.getRank().getWeight());
        player2.sort((c1, c2) -> c1.getRank().getWeight() - c2.getRank().getWeight());
        player3.sort((c1, c2) -> c1.getRank().getWeight() - c2.getRank().getWeight());
        bottomCards.sort((c1, c2) -> c1.getRank().getWeight() - c2.getRank().getWeight());

        // 5. 输出最终结果
        System.out.println("玩家1 的手牌: " + player1);
        System.out.println("玩家2 的手牌: " + player2);
        System.out.println("玩家3 的手牌: " + player3);
        System.out.println("底牌: " + bottomCards);
    }
}