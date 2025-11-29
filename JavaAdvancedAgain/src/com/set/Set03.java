package com.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/27 15:14
 *
 * TreeSet集合对于自定义对象的排序 会去重
 * 数值类型 Integer Double 默认按照数值本身大小升序排序
 * 字符串类型 默认按照首字母编号进行排序
 *
 * Set集合实际上也是包装的Map
 */
public class Set03 {
    public static void main(String[] args) {
        //2.
        Set<Teacher> teachers = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                //return o2.getAge() - o1.getAge();//降序 默认优先使用集合自带的

                //若比较薪水
                /*
                if(o1.getSalary() > o2.getSalary()){
                    return 1;
                } else if (o1.getSalary() < o2.getSalary()) {
                    return -1;
                }
                return 0;
                 */
                return Double.compare(o1.getSalary(), o2.getSalary());//升序 这里salary是Double类型
            }
        });
        //上面等价于下面
//        Set<Teacher> teachers = new TreeSet<>
//                ((o1,o2) -> Double.compare(o1.getSalary(), o2.getSalary()));

        // 插入第1个元素：root == null，直接插入为根（不触发 compare）
        teachers.add(new Teacher("Tenerife",19,8000.0)); // root == null -> 成为根节点

        // 插入第2个元素：compare(B, A) -> Double.compare(12888.8, 8000.0) > 0 -> 放到根的右子
        teachers.add(new Teacher("Su san",22,12888.8)); // compare > 0 -> 右子

        // 插入第3个元素：compare(C, A) > 0 -> 右；compare(C, B) < 0 -> 插入为 B.left
        teachers.add(new Teacher("TenerifeSea",21,9998.5)); // C 比 A 大，比 B 小 -> B.left

        // 插入第4个元素：compare(D, A) > 0 -> 右；compare(D, B) < 0 -> 左（到 C）；compare(D, C) < 0 -> 插入为 C.left
        teachers.add(new Teacher("Su sanSea",21,9698.5)); // 插入为 C.left

        System.out.println(teachers);

        //TreeSet集合默认不能给自定义对象排序 因为不知道大小比较规则

        //1. 对象类实现一个Comparable比较接口，重写compareTo方法(Alt+Enter)，指定大小比较规则

        //2. public TreeSet集合自带比较器Comparator对象，指定比较规则


    }
}

/**
 *
 * 一、总体流程概览（一句话）
 *
 * TreeSet 使用构造时传入的 Comparator（若有）来比较元素；比较结果决定“插入位置”和“是否认为重复（compare == 0）”。
 * 二、按步骤的执行顺序（匿名 Comparator 情形）
 *
 * 启动
 *
 * JVM 启动并执行 Set03.main()。
 * 创建集合
 *
 * new TreeSet<>(new Comparator<...>(){...})
 *
 * 注：TreeSet 构造器将匿名 Comparator 存入内部字段（tree.comparator = 传入对象）；此时树为空（root == null）。
 *
 * 插入第 1 个元素：A = Teacher("Tenerife", 19, 8000.0)
 *
 * 操作：teachers.add(A)
 *
 * 过程：root 为 null → 直接把 A 插为根节点
 *
 * 注释建议：// root 为空，直接插入，不需要比较
 *
 * 插入第 2 个元素：B = Teacher("Su san", 22, 12888.8)
 *
 * 操作：teachers.add(B)
 *
 * 过程：
 *
 * 从 root（A）开始，调用 comparator.compare(B, A)
 *
 * comparator 内部计算 Double.compare(B.salary, A.salary) -> 结果 > 0
 *
 * 结果 > 0 → 进入右子树；右子为空 → 在 A 的右子位置插入 B
 *
 * 注释建议：// compare(B, A) > 0 -> B 放到 A 的右子
 *
 * 插入第 3 个元素：C = Teacher("TenerifeSea", 21, 9998.5)
 *
 * 操作：teachers.add(C)
 *
 * 过程：
 *
 * compare(C, A) -> Double.compare(9998.5, 8000.0) -> > 0 → 右子（B）
 *
 * compare(C, B) -> Double.compare(9998.5, 12888.8) -> < 0 → B 的左子为空 → 插入为 B.left
 *
 * 注释建议：// C 比 A 大，比 B 小 -> 插入为 B.left
 *
 * 插入第 4 个元素：D = Teacher("Su sanSea", 21, 9698.5)
 *
 * 操作：teachers.add(D)
 *
 * 过程：
 *
 * compare(D, A) -> Double.compare(9698.5, 8000.0) -> > 0 → 右子（B）
 *
 * compare(D, B) -> Double.compare(9698.5, 12888.8) -> < 0 → B.left（是 C）
 *
 * compare(D, C) -> Double.compare(9698.5, 9998.5) -> < 0 → C.left 为空 → 插入为 C.left
 *
 * 注释建议：// D 比 A 大，比 B 小，比 C 小 -> 插入为 C.left
 *
 * 打印集合：System.out.println(teachers)
 *
 * TreeSet.toString() 触发中序遍历（保证按比较规则的升序）
 *
 * 访问顺序（按 salary 升序）：A(8000.0) -> D(9698.5) -> C(9998.5) -> B(12888.8)
 *
 * 每个元素被调用 Teacher.toString() 生成字符串（注意若 toString 含 "\n" 会造成换行）
 *
 * 注释建议：// 中序遍历输出 -> 按 salary 升序
 *
 * 三、关键概念与提示（简短注释形式）
 *
 * Comparator 优先：若构造 TreeSet 时传入 Comparator，则该 Comparator 始终被使用，元素的 compareTo 被忽略。
 *
 * 注释：// 构造器传入的 Comparator 优先于元素的 compareTo
 * 去重依据：TreeSet 判定“相等/重复”基于 compare 返回 0，而不是 equals()/hashCode()。
 *
 * 注释：// compare == 0 -> 视为重复，后加入元素将被拒绝
 * compare 合同：compare 必须满足传递性和一致性，否则红黑树行为可能异常。
 *
 * 注释：// compare 必须满足对称性、传递性与一致性
 * 四、若不传 Comparator（使用 Comparable.compareTo）
 *
 * 如果使用 new TreeSet<>()（不传 comparator），TreeSet 调用元素的 compareTo：
 *
 * 你的 compareTo 实现是按 age 比较（return this.age - o.age）
 *
 * 结果：排序与去重依据变为 age；年龄相同会被视为重复
 *
 * 注释建议：// 不传 Comparator 时使用 compareTo（当前按 age 排序 -> 同 age 被去重）
 *
 * 五、“调用跟踪”示例（可直接作为注释或调试输出）
 *
 * 针对插入 D（9698.5）的调用序列（精确短句）：
 *
 * compare(D, A) => Double.compare(9698.5, 8000.0) => 返回 >0（向右）
 *
 * 注释：// D vs A：返回正 -> 到右子
 * compare(D, B) => Double.compare(9698.5, 12888.8) => 返回 <0（到左子）
 *
 * 注释：// D vs B：返回负 -> 到左子（B.left）
 * compare(D, C) => Double.compare(9698.5, 9998.5) => 返回 <0（到左子，插入）
 *
 * 注释：// D vs C：返回负 -> C.left 为空 -> 在此插入 D
 * 六、便于粘贴的短注释模版（每一步可直接贴到代码旁）
 *
 * 在 TreeSet 构造处：// 使用匿名 Comparator：按 salary 升序，Comparator 优先于 compareTo
 *
 * 在 add(A)：// root 为空，直接插入 A（不调用 compare）
 *
 * 在 add(B)：// compare(B, A) > 0 -> 插到 A 的右子
 *
 * 在 add(C)：// compare(C, A) > 0 -> 右；compare(C, B) < 0 -> 插入为 B.left
 *
 * 在 add(D)：// compare(D, A) > 0 -> 右；compare(D, B) < 0 -> 左；compare(D, C) < 0 -> 插入为 C.left
 *
 * 在 println：// 中序遍历输出 -> 按 salary 升序；注意 Teacher.toString() 的格式
 *
 *
 * 注释：// 如需保留同薪不同人 -> Comparator 应加入次级字段比较（age/name）

 */