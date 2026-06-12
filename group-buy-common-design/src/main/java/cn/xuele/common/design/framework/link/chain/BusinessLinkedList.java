package cn.xuele.common.design.framework.link.chain;


import cn.xuele.common.design.framework.link.handler.ILogicHandler;

/**
 * 责任链业务容器（核心执行引擎）
 *
 * @author XueLe
 * @version 1.0.1 (Optimized)
 * @since 2026/06/12
 */
public class BusinessLinkedList<T, D, R> extends LinkedList<ILogicHandler<T, D, R>> implements ILogicHandler<T, D, R> {

    /**
     * 构造函数
     *
     */
    public BusinessLinkedList(String name) {
        super(name);
    }

    /**
     * 核心执行逻辑：链式调用
     *
     */
    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {

        for (Node<ILogicHandler<T, D, R>> current = this.first; current != null; current = current.next) {

            // 获取当前节点的业务处理器
            ILogicHandler<T, D, R> handler = current.item;

            // 执行业务逻辑
            R result = handler.apply(requestParameter, dynamicContext);

            // 【决策点】
            // 如果结果不为空，说明当前节点拦截了请求（例如：风控拒绝、库存扣减失败、或成功生成了订单ID）
            // 此时不需要继续往后走，直接返回结果。
            if (result != null) {
                return result;
            }

            // 如果 result 为 null，循环继续，current 指向 next
        }

        // 链条跑完了，没有任何节点拦截/产生结果，返回兜底值
        return null;
    }
}