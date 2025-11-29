package com.string;

/**
 * String、StringBuffer、StringBuilder 完整实战对比
 * @author Tenerife
 */
public class StringPractice {
    public static void main(String[] args) {

        /* ==================== 第一部分：String的特性演示 ==================== */
        System.out.println("========== String 特性演示 ==========");

        // 1. String 不可变性 - 每次修改都创建新对象
        String str1 = "Hello";
        System.out.println("原始字符串: " + str1);

        String str2 = str1 + " World";
        System. out.println("拼接后: " + str2);
        // str1仍然是"Hello"，没有被修改
        System.out.println("str1未变: " + str1);  // 输出：Hello

        // 2. 常量相加 vs 变量相加
        String const1 = "hello" + "world";   // 编译期优化，常量池
        System.out.println("常量相加: " + const1);

        String var1 = "hello";
        String var2 = "world";
        String var3 = var1 + var2;  // 运行期StringBuilder，堆
        System.out.println("变量相加: " + var3);

        // 验证内存位置
        String literal = "helloworld";  // 常量池
        System.out.println("const1 == literal: " + (const1 == literal));  // true
        System.out.println("var3 == literal: " + (var3 == literal));      // false

        // 3. equals() vs ==
        String a = "Tenerife";
        String b = new String("Tenerife");

        System.out.println("\n--- equals() vs == ---");
        System.out.println("a.equals(b): " + a.equals(b));  // true (内容相同)
        System.out.println("a == b: " + (a == b));          // false (地址不同)
        System.out.println("a == b.intern(): " + (a == b.intern()));  // true (都在常量池)


        /* ==================== 第二部分：StringBuffer 完整演示 ==================== */
        System.out.println("\n\n========== StringBuffer 完整演示 ==========");

        // 1. 构造器 - 三种创建方式
        StringBuffer sb1 = new StringBuffer();
        System.out.println("默认构造: 容量=" + sb1.capacity() + ", 长度=" + sb1.length());

        StringBuffer sb2 = new StringBuffer(50);
        System.out.println("指定容量: 容量=" + sb2.capacity() + ", 长度=" + sb2.length());

        StringBuffer sb3 = new StringBuffer("Tenerife");
        System. out.println("从String构造: 容量=" + sb3.capacity() + ", 长度=" + sb3.length());
        // 容量 = 字符串长度(8) + 16 = 24

        // 2. 增 - append() 链式调用
        System.out.println("\n--- 增：append() ---");
        StringBuffer sb = new StringBuffer("Java");
        sb.append(" is")
                .append(" powerful")
                .append("!");  // 链式调用
        System.out.println("append后: " + sb);  // Java is powerful!
        System.out.println("当前长度: " + sb. length());
        System.out.println("当前容量: " + sb.capacity());

        // 3.  删 - delete() 删除指定范围
        System.out.println("\n--- 删：delete() ---");
        StringBuffer sbDelete = new StringBuffer("HelloWorld");
        System.out.println("原始: " + sbDelete);
        sbDelete.delete(5, 10);  // 删除索引[5,10)的字符 "World"
        System.out.println("delete(5,10)后: " + sbDelete);  // Hello

        // 4. 改 - replace() 替换指定范围
        System.out. println("\n--- 改：replace() ---");
        StringBuffer sbReplace = new StringBuffer("HelloWorld");
        System.out. println("原始: " + sbReplace);
        sbReplace.replace(0, 5, "Hi");  // 替换[0,5)为"Hi"
        System.out.println("replace(0,5,'Hi')后: " + sbReplace);  // HiWorld

        // 5.  查 - indexOf() 和 lastIndexOf()
        System.out.println("\n--- 查：indexOf() & lastIndexOf() ---");
        StringBuffer sbFind = new StringBuffer("JavaJavaJava");
        System.out.println("原始: " + sbFind);
        int idx1 = sbFind.indexOf("Java");
        int idx2 = sbFind.lastIndexOf("Java");
        System.out.println("indexOf('Java'): " + idx1);      // 0
        System.out.println("lastIndexOf('Java'): " + idx2);  // 8

        // 6.  插 - insert() 在指定位置插入
        System.out.println("\n--- 插：insert() ---");
        StringBuffer sbInsert = new StringBuffer("HelloWorld");
        System.out. println("原始: " + sbInsert);
        sbInsert.insert(5, " ");  // 在索引5处插入空格
        System.out.println("insert(5,' ')后: " + sbInsert);  // Hello World

        // 7.  反转 - reverse()
        System.out.println("\n--- 其他：reverse() ---");
        StringBuffer sbReverse = new StringBuffer("Hello");
        System.out.println("原始: " + sbReverse);
        sbReverse. reverse();
        System.out.println("reverse()后: " + sbReverse);  // olleH


        /* ==================== 第三部分：StringBuilder 演示 ====================*/
        System.out. println("\n\n========== StringBuilder 完整演示 ==========");

        // StringBuilder API与StringBuffer完全相同，只是线程不安全
        StringBuilder sb4 = new StringBuilder("Java");
        sb4.append(" Programming");
        System.out.println("StringBuilder: " + sb4);

        // 演示所有常用API（与StringBuffer相同）
        StringBuilder demo = new StringBuilder("0123456789");
        System. out.println("原始: " + demo);
        demo.delete(3, 7);      // 删除
        System.out.println("delete(3,7): " + demo);
        demo.replace(0, 3, "abc");  // 替换
        System.out.println("replace(0,3,'abc'): " + demo);
        demo.insert(3, "-");    // 插入
        System.out.println("insert(3,'-'): " + demo);


        /* ==================== 第四部分：String ↔ StringBuffer 转换 ==================== */
        System.out. println("\n\n========== String ↔ StringBuffer 转换 ==========");

        // String → StringBuffer
        System.out.println("\n--- String → StringBuffer ---");
        String original = "Hello";

        // 方法1：构造器（推荐）
        StringBuffer sbFrom1 = new StringBuffer(original);
        System.out.println("方法1-构造器: " + sbFrom1);

        // 方法2：append()
        StringBuffer sbFrom2 = new StringBuffer();
        sbFrom2.append(original);
        System.out. println("方法2-append: " + sbFrom2);

        // StringBuffer → String
        System.out.println("\n--- StringBuffer → String ---");
        StringBuffer sbToConvert = new StringBuffer("World");

        // 方法1：toString()（推荐）
        String toStr1 = sbToConvert. toString();
        System.out. println("方法1-toString: " + toStr1);

        // 方法2：构造器
        String toStr2 = new String(sbToConvert);
        System.out.println("方法2-构造器: " + toStr2);


        /* ==================== 第五部分：性能对比 ==================== */
        System.out.println("\n\n========== 性能对比 ==========");

        int iterations = 50000;

        // 1. String拼接（最慢）
        long startTime = System.currentTimeMillis();
        String result1 = "";
        for (int i = 0; i < iterations; i++) {
            result1 += "x";  // 每次创建新对象
        }
        long stringTime = System.currentTimeMillis() - startTime;
        System.out.println("String拼接 " + iterations + " 次耗时: " + stringTime + "ms");

        // 2. StringBuffer拼接（中等）
        startTime = System.currentTimeMillis();
        StringBuffer sb5 = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb5.append("x");  // 直接修改，有同步锁
        }
        String result2 = sb5.toString();
        long sbTime = System. currentTimeMillis() - startTime;
        System.out.println("StringBuffer拼接 " + iterations + " 次耗时: " + sbTime + "ms");

        // 3. StringBuilder拼接（最快）
        startTime = System.currentTimeMillis();
        StringBuilder sb6 = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb6.append("x");  // 直接修改，无同步锁
        }
        String result3 = sb6.toString();
        long sbuilderTime = System.currentTimeMillis() - startTime;
        System.out.println("StringBuilder拼接 " + iterations + " 次耗时: " + sbuilderTime + "ms");

        // 性能比较
        System.out.println("\n性能对比:");
        System. out.println("String : StringBuffer : StringBuilder = " +
                stringTime + " : " + sbTime + " : " + sbuilderTime);
        System.out.println("StringBuilder比String快约 " + (stringTime/sbuilderTime) + " 倍");


        /* ==================== 第六部分：实战案例 - 格式化金额 ==================== */
        System.out.println("\n\n========== 实战案例：格式化金额 ==========");

        String price = "123456.65";
        StringBuffer sbPrice = new StringBuffer(price);

        // 找到小数点位置
        int dotIndex = sbPrice.lastIndexOf(".");
        System.out.println("原始金额: " + sbPrice);

        // 从小数点往前，每三位插入逗号
        for (int i = dotIndex - 3; i > 0; i -= 3) {
            sbPrice.insert(i, ",");
            System.out.println("插入逗号后: " + sbPrice);
        }

        System.out.println("最终格式: " + sbPrice);  // 123,456.65


        /* ==================== 第七部分：三者互相转换实战 ==================== */
        System.out.println("\n\n========== 三者互相转换实战 ==========");

        // 场景：处理URL参数
        String baseUrl = "https://example.com? ";
        System.out.println("1. 从String开始: " + baseUrl);

        // String → StringBuilder（因为要频繁修改）
        StringBuilder urlBuilder = new StringBuilder(baseUrl);
        urlBuilder.append("name=Tenerife");
        urlBuilder.append("&age=18");
        urlBuilder.append("&city=China");
        System.out.println("2. 使用StringBuilder追加: " + urlBuilder);

        // StringBuilder → String（完成构建）
        String finalUrl = urlBuilder.toString();
        System.out.println("3. 转换回String: " + finalUrl);

        // String → StringBuffer（需要线程安全操作）
        StringBuffer urlSafe = new StringBuffer(finalUrl);
        // 假设在多线程环境下操作...
        System.out.println("4. 转换为StringBuffer(线程安全): " + urlSafe);

        // 查询参数
        int paramIndex = urlSafe.indexOf("age");
        System.out.println("5. 查找'age'参数位置: " + paramIndex);

        // 提取参数值
        int valueStart = paramIndex + 4;  // "age="的长度
        int valueEnd = urlSafe.indexOf("&", valueStart);
        if (valueEnd == -1) valueEnd = urlSafe.length();
        String ageValue = urlSafe.substring(valueStart, valueEnd);
        System.out.println("6. 提取age的值: " + ageValue);
    }
}