package com.houseRent.domain;

/**
 * HouseFix
 * 领域模型(POJO) - 表示系统中的“房屋”实体。
 *
 * 设计定位：
 * 1. 仅作为数据载体，不包含业务流程/存储处理逻辑。
 * 2. id 的生成策略归业务层 (HouseServiceFix) 管理，实例创建时传入的 id 可以是占位值(例如 0)。
 * 3. 当前允许通过 setter 修改任意字段，后期如果需要“不可变对象”或“审计日志”等，可限制修改入口。
 *
 * 字段说明：
 * - id: 唯一编号，自增生成（非数据库，仅内存模拟）。
 * - name: 房主姓名（当前未限制格式，可通过后续 Validator 增强）。
 * - address: 地址（简单字符串，可进一步拆分成省、市、区、详细地址结构）。
 * - phone: 联系电话（未做格式校验，后期可使用正则）。
 * - rent: 月租金额（int 简化表达，若需高精度或多币种可改 BigDecimal）。
 * - state: 房屋出租状态（当前约定 "已出租" / "未出租"，建议未来改枚举以防错拼）。
 *
 * 输出格式：
 * - 覆盖 toString()，采用格式化对齐，方便在控制台表格化展示。
 *
 * 扩展建议：
 * 1. 增加创建/更新时间戳 createTime/updateTime。
 * 2. 实现 equals()/hashCode() 以支持集合去重或缓存。
 * 3. 加入校验逻辑（如：rent >= 0）可在 setter 或专门的校验器中做。
 */
public class HouseFix {

    // ================== 字段区域 ==================

    /** 房屋唯一编号（由业务层分配，不建议调用方直接设置） */
    private int id;

    /** 房主姓名 */
    private String name;

    /** 房屋地址 */
    private String address;

    /** 联系电话 */
    private String phone;

    /** 月租金额（单位：元） */
    private int rent;

    /** 当前状态："已出租" 或 "未出租"（简化实现） */
    private String state;

    // ================== 构造器 ==================

    /**
     * 全参构造方法。
     * 注意：此处不会做参数合法性校验，调用方需保证数据正确。
     * @param id      初始编号（可传 0 占位，后由 Service 重写）
     * @param name    房主姓名
     * @param address 地址
     * @param phone   电话
     * @param rent    租金
     * @param state   状态
     */
    public HouseFix(int id, String name, String address, String phone, int rent, String state) {
        this.id = id;               // 可能是一个占位值，稍后由 Service 重新设置
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rent = rent;
        this.state = state;
    }

    // ================== Getter / Setter ==================
    // 说明：当前设计为开放式属性更新，后期若要防止随意修改，可：
    // 1. 移除 setter，改为构造+Builder；
    // 2. 或者增加权限判断 / 状态机约束。

    /** 设置 id —— 仅推荐 Service 层调用 */
    public void setId(int id) {
        this.id = id;
    }

    /** 获取房屋编号 */
    public int getId() { return id; }

    /** 获取房主姓名 */
    public String getName() { return name; }

    /** 设置房主姓名（可以加入非空、长度限制） */
    public void setName(String name) { this.name = name; }

    /** 获取地址 */
    public String getAddress() { return address; }

    /** 设置地址 */
    public void setAddress(String address) { this.address = address; }

    /** 获取电话 */
    public String getPhone() { return phone; }

    /** 设置电话（后期可做正则校验） */
    public void setPhone(String phone) { this.phone = phone; }

    /** 获取租金 */
    public int getRent() { return rent; }

    /** 设置租金（可加入：rent >= 0 的校验） */
    public void setRent(int rent) { this.rent = rent; }

    /** 获取出租状态 */
    public String getState() { return state; }

    /** 设置出租状态（建议后期改 enum） */
    public void setState(String state) { this.state = state; }

    // ================== 输出方法 ==================

    /**
     * 控制台友好展示：
     * 使用 String.format 指定列宽，保证在等宽字体终端中对齐。
     * %-4d : 左对齐整数，占4字符
     * %-8s : 左对齐字符串，占8字符
     * ...
     */
    @Override
    public String toString() {
        return String.format("%-4d\t%-8s\t%-10s\t%-12s\t%-6d\t%-6s",
                id, name, address, phone, rent, state);
    }
}