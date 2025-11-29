package com.houseRent.service;

import com.houseRent.domain.HouseFix;

import java.util.ArrayList;
import java.util.List;

/**
 * HouseServiceFix
 * 业务层（Service）核心：管理房屋集合、分配唯一 id、提供 CRUD 操作。
 *
 * 设计动机：
 * 1. 隔离存储细节（目前用 ArrayList，将来可替换为数据库/文件/缓存，而不影响 view）。
 * 2. 统一 ID 自增生成，避免外部创建冲突或重复编号。
 * 3. 提供受控数据访问接口：find / add / del / list。
 *
 * 注意点：
 * - list() 返回的是新建的 ArrayList 副本，避免调用方直接修改内部集合（保护封装）。
 * - 简化演示：未使用接口（如 IHouseService），后期可加接口以便依赖倒置。
 *
 * 可扩展：
 * - 加 search(条件组合)
 * - 加 update(分字段更新)
 * - 加统计（平均租金 / 已出租数量）
 * - 加异常类型（如：找不到抛 NotFoundException）
 */
public class HouseServiceFix {

    /** 内部存储容器（当前实现：内存集合） */
    private final List<HouseFix> houses = new ArrayList<>();

    /** 自增 ID 计数器（每 add 成功一次 ++） */
    private int idCounter = 0;

    /**
     * 构造器：初始化示例数据
     * 实际项目可改为懒加载、或从持久层读取。
     */
    public HouseServiceFix() {
        add(new HouseFix(0, "Tenerife", "海淀", "111", 6000, "未出租"));
        add(new HouseFix(0, "Susan", "青羊", "112", 3000, "已出租"));
    }

    /**
     * 添加一个新房屋
     * 流程：
     * 1. 判空：防止外部传 null
     * 2. 分配新的 ID（先 ++ 再赋值，ID 从 1 起）
     * 3. 加入集合
     *
     * @param newHouse 外部构造的 HouseFix（id 可为占位值）
     * @return 添加是否成功（ArrayList#add 基本恒为 true，除非 OOM）
     */
    public boolean add(HouseFix newHouse) {
        if (newHouse == null) return false;
        newHouse.setId(++idCounter);
        return houses.add(newHouse);
    }

    /**
     * 根据主键 id 查找
     * @param findId 目标 id
     * @return 匹配的 HouseFix 或 null
     *
     * 说明：
     * - 当前为 O(n) 遍历，数据量少时足够。
     * - 若数据量大，可：
     *   a) 维护 Map<Integer, HouseFix>
     *   b) 或切换数据库并加索引
     */
    public HouseFix findById(int findId) {
        for (HouseFix h : houses) {
            if (h.getId() == findId) {
                return h;
            }
        }
        return null;
    }

    /**
     * 删除指定 id 的房屋
     * @param delId 目标 id
     * @return 删除是否成功（true = 至少删除了一条）
     *
     * 实现：
     * - 使用 removeIf(Predicate) 简化写法
     * - 若未来需精确控制（如：记录删除日志），可手写遍历
     */
    public boolean del(int delId) {
        return houses.removeIf(h -> h.getId() == delId);
    }

    /**
     * 返回当前所有房屋列表（副本）
     * @return 新创建的 List，调用方修改不会影响内部数据
     *
     * 说明：
     * - 返回副本是一种“防御式复制”做法，避免破坏内部 invariants。
     * - 若数据量巨大，可改成只读视图（Collections.unmodifiableList）
     */
    public List<HouseFix> list() {
        return new ArrayList<>(houses);
    }
}