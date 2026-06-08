package cn.xuele.common.design.framework.tree;

/**
 * 策略处理器接口
 *
 * @author XueLe
 * @version 1.0.0
 * @since 2026/06/08 13:50
 */
public interface StrategyHandler<T, D, R> {

    /**
     * 默认策略：不做任何处理，直接返回 null
     */
    StrategyHandler DEFAULT = (T, D) -> null;

    /**
     * 执行具体策略逻辑
     *
     * @param requestParameter 请求入参
     * @param dynamicContext   动态上下文
     * @return 策略执行结果
     * @throws Exception 执行异常
     */
    R apply(T requestParameter, D dynamicContext) throws Exception;
}
