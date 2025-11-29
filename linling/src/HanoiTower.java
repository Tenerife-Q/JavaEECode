public class HanoiTower {
    public static void main(String[] args) {
        Tower tower = new Tower();
        // 明确传入：起始柱(A)、辅助柱(B)、目标柱(C)，移动5个盘子
        tower.move(3, 'A', 'B', 'C');
    }
}

class Tower {
    // 用source(起始)、auxiliary(辅助)、target(目标)替代a、b、c
    public void move(int num, char source, char auxiliary, char target) {
        // 递归终止条件：只有1个盘子时，直接从起始柱移到目标柱
        if (num == 1) {
            System.out.println(source + "->" + target);
        } else {
            // 步骤1：将n-1个盘子从起始柱，借助目标柱，移动到辅助柱
            move(num - 1, source, target, auxiliary);

            // 步骤2：将第n个盘子从起始柱直接移动到目标柱
            System.out.println(source + "->" + target);

            // 步骤3：将n-1个盘子从辅助柱，借助起始柱，移动到目标柱
            move(num - 1, auxiliary, source, target);
        }
    }
}
