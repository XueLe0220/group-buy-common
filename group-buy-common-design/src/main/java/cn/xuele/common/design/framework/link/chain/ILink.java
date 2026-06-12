package cn.xuele.common.design.framework.link.chain;

/**
 * 责任链结构接口
 * @author XueLe
 * @version 1.0.0
 * @since 2026/06/12
 */
public interface ILink<E> {

    /**
     * 添加元素到链尾
     */
    boolean add(E e);

    /**
     * 添加元素到链头
     */
    boolean addFirst(E e);

    /**
     * 添加元素到链尾（显式）
     * @param e 元素
     * @return 是否添加成功
     */
    boolean addLast(E e);

    /**
     * 移除指定元素
     * @param o 要移除的对象
     * @return 是否移除成功
     */
    boolean remove(Object o);

    /**
     * 获取指定索引的元素
     * @param index 索引
     * @return 元素
     */
    E get(int index);

    /**
     * 打印链表结构
     * <p>
     * 主要用于调试，观察链条顺序。
     */
    void printLinkList();
}