package com.houseRent.view;

import com.houseRent.domain.HouseFix;
import com.houseRent.service.HouseServiceFix;
import com.houseRent.utils.UtilityFix;

import java.util.List;

/**
 * HouseViewFix
 * 表现层（控制台界面层）—— 负责：
 * 1. 显示菜单、提示信息
 * 2. 引导用户输入
 * 3. 调用 Service 完成具体业务
 * 4. 控制主循环退出
 *
 * 设计思路：
 * - 不直接操作集合（所有数据相关逻辑都交给 Service）
 * - 仅做流程编排（输入→调用→输出），不写复杂业务判断
 * - 使用 UtilityFix 统一读取逻辑，避免散落的 Scanner 代码
 *
 * 可扩展方向：
 * - 加条件搜索菜单项
 * - 加分页展示（当数据很多时）
 * - 抽出 Formatter 专门负责输出对齐
 * - 提供“导出到文件”等功能
 */
public class HouseViewFix {

    /** 控制主菜单循环的标志位 */
    private boolean loop = true;

    /** 业务服务对象（基础 CRUD） */
    private final HouseServiceFix houseService = new HouseServiceFix();

    // ================== 功能：新增 ==================

    /**
     * 添加房屋信息流程：
     * 1. 逐项读取字段
     * 2. 构造 HouseFix（id 占位 0）
     * 3. 调用 service.add 分配正式 id
     */
    public void addHouse() {
        System.out.println("==========添加房屋==========");
        System.out.print("姓名: ");
        String name = UtilityFix.readString(8);
        System.out.print("地址: ");
        String address = UtilityFix.readString(16);
        System.out.print("电话: ");
        String phone = UtilityFix.readString(11);
        System.out.print("月租: ");
        int rent = UtilityFix.readInt();
        System.out.print("状态(已出租/未出租): ");
        String state = UtilityFix.readString(6);

        HouseFix newHouse = new HouseFix(0, name, address, phone, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("==========添加成功==========");
        } else {
            System.out.println("==========添加失败==========");
        }
    }

    // ================== 功能：查询 ==================

    /**
     * 根据 id 查询，并打印结果
     * 行为：
     * - 如果找到：打印标题行 + 数据
     * - 如果未找到：给出提示
     */
    public void findHouse() {
        System.out.println("==========查找房屋信息==========");
        System.out.print("请输入要查找的id：");
        int findId = UtilityFix.readInt();
        HouseFix house = houseService.findById(findId);
        if (house != null) {
            System.out.println("编号\t房主\t\t地址\t\t\t电话\t\t\t月租\t状态");
            System.out.println(house);
        } else {
            System.out.println("========没有找到相应id房屋信息========");
        }
    }

    // ================== 功能：删除 ==================

    /**
     * 删除流程：
     * 1. 输入 id（支持 -1 取消）
     * 2. 查找是否存在（防止无意义删除）
     * 3. 确认 Y/N
     * 4. 调用 service.del()
     */
    public void delHouse() {
        System.out.println("==========删除房屋信息==========");
        System.out.print("请输入要删除的房屋编号(-1退出)：");
        int delId = UtilityFix.readInt();
        if (delId == -1) {
            System.out.println("==========放弃删除房屋信息==========");
            return;
        }

        HouseFix h = houseService.findById(delId);
        if (h == null) {
            System.out.println("该编号不存在，无法删除。");
            return;
        }

        System.out.println("待删除房屋：");
        System.out.println("编号\t房主\t\t地址\t\t\t电话\t\t\t月租\t状态");
        System.out.println(h);

        char confirm = UtilityFix.readConfirmSelection();
        if (confirm == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("==========删除成功==========");
            } else {
                // 理论上不应到达；除非并发删除（本示例无并发）
                System.out.println("删除失败（可能已被删除）");
            }
        } else {
            System.out.println("取消删除。");
        }
    }

    // ================== 功能：修改 ==================

    /**
     * 修改流程：
     * 1. 输入 id（支持 -1 退出）
     * 2. 查找目标对象
     * 3. 按字段逐一显示“当前值(旧值)”提示
     * 4. 用户回车 = 不修改；输入新值 = 更新
     * 5. 租金使用 readInt(-1) 约定 -1 表示“不修改”
     */
    public void update() {
        System.out.println("==========修改房屋信息==========");
        System.out.print("请选择待修改房屋编号(-1退出)：");
        int updateId = UtilityFix.readInt();
        if (updateId == -1) {
            System.out.println("========你放弃修改房屋信息========");
            return;
        }

        HouseFix house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("====该编号不存在====");
            return;
        }

        // 姓名
        System.out.print("姓名(" + house.getName() + "): ");
        String name = UtilityFix.readString(8, "");
        if (!"".equals(name)) {
            house.setName(name);
        }

        // 地址
        System.out.print("地址(" + house.getAddress() + "): ");
        String address = UtilityFix.readString(16, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }

        // 电话
        System.out.print("电话(" + house.getPhone() + "): ");
        String phone = UtilityFix.readString(11, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }

        // 租金（-1 表示不修改）
        System.out.print("租金(" + house.getRent() + "): ");
        int rent = UtilityFix.readInt(-1);
        if (rent != -1) {           // 如果用户输入 -1，表示保持原租金
            house.setRent(rent);
        }

        // 状态
        System.out.print("状态(" + house.getState() + "): ");
        String state = UtilityFix.readString(6, "");
        if (!"".equals(state)) {
            house.setState(state);
        }

        System.out.println("==========修改成功==========");
    }

    // ================== 功能：列表 ==================

    /**
     * 列表展示：
     * 1. 直接获取 service.list()
     * 2. 如果为空则提示“暂无”
     * 3. 否则按行输出
     *
     * 可扩展：
     * - 大数据量时分页输出
     * - 支持排序（按租金、状态等）
     */
    public void listHouses() {
        System.out.println("==========房屋列表==========");
        List<HouseFix> list = houseService.list();
        if (list.isEmpty()) {
            System.out.println("暂无房屋信息。");
        } else {
            System.out.println("编号\t\t房主\t\t\t地址\t\t\t电话\t\t\t\t月租\t\t状态");
            for (HouseFix h : list) {
                System.out.println(h);
            }
        }
        System.out.println("========房屋列表显示完毕========\n");
    }

    // ================== 功能：退出 ==================

    /**
     * 退出系统确认：
     * - 调用工具类读取 Y/N
     * - 若 Y -> 设置 loop=false 结束主菜单循环
     */
    public void exit() {
        char c = UtilityFix.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    // ================== 主菜单循环 ==================

    /**
     * 主菜单：
     * 1. while(loop) 持续显示
     * 2. 读取用户选项（1-6）
     * 3. 分支调用具体功能
     *
     * 注意：
     * - switch 使用的是字符（与 UtilityFix.readMenuSelection 返回一致）
     * - 如果后期菜单增删，需要同步修改：显示文本 + 选择范围
     */
    public void mainMenu() {
        while (loop) {
            System.out.println("\n==========房屋出租系统==========");
            System.out.println("\t1 新增房源");
            System.out.println("\t2 查找房屋");
            System.out.println("\t3 删除房屋");
            System.out.println("\t4 修改房屋");
            System.out.println("\t5 显示房屋列表");
            System.out.println("\t6 退出系统");
            System.out.print("请输入你的选择(1-6)：");

            char key = UtilityFix.readMenuSelection(1, 6);
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    // 正常不会进入（前置校验已过滤）
                    System.out.println("无效选择。");
            }
        }
    }
}