package cn.xuele.common.design.framework.link;


import cn.xuele.common.design.framework.link.chain.BusinessLinkedList;
import cn.xuele.common.design.framework.link.handler.ILogicHandler;

/**
 * 链路装配器 (Link Armory)
 *
 * @author XueLe
 * @version 1.0.0
 * @since 2026/06/12
 */
public class LinkArmory<T, D, R> {

    /**
     * 组装完成的业务逻辑链路
     */
    private final BusinessLinkedList<T, D, R> logicLink;

    public BusinessLinkedList<T, D, R> getLogicLink() {
        return logicLink;
    }

    /**
     * 构造并装配链路
     *
     * @param linkName      链路名称（用于日志追踪或监控）
     * @param logicHandlers 变长参数，按顺序传入需要执行的逻辑处理器
     */
    @SafeVarargs
    public LinkArmory(String linkName, ILogicHandler<T, D, R>... logicHandlers) {
        // 初始化链表
        logicLink = new BusinessLinkedList<>(linkName);

        // 防御性编程：防止传入 null 导致空指针
        if (logicHandlers != null) {
            for (ILogicHandler<T, D, R> logicHandler : logicHandlers) {
                logicLink.add(logicHandler);
            }
        }
    }
}