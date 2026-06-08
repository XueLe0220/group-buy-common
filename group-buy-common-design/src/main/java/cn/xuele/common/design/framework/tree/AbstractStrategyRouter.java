package cn.xuele.common.design.framework.tree;

/**
 * 策略路由抽象类
 *
 * @author XueLe
 * @version 1.0.0
 * @since 2026/06/08 13:51
 */
public abstract class AbstractStrategyRouter<T, D, R> implements StrategyMapper<T, D, R>, StrategyHandler<T, D, R> {

    /**
     * 默认策略处理器 (兜底逻辑)
     */
    protected StrategyHandler<T, D, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    public void setDefaultStrategyHandler(StrategyHandler<T, D, R> defaultStrategyHandler) {
        this.defaultStrategyHandler = defaultStrategyHandler;
    }

    public StrategyHandler<T, D, R> getDefaultStrategyHandler() {
        return defaultStrategyHandler;
    }

    /**
     * 执行路由逻辑 (Template Method)
     * <p>
     * 这里的逻辑是固定的：先找策略，找到了就跑，找不到就跑兜底。
     *
     */
    public R router(T requestParameter, D dynamicContext) throws Exception {
        // 1. 调用实现类的 get 方法，查找是否有匹配的策略
        StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);

        // 2. 如果找到了策略，执行该策略
        if (null != strategyHandler) {
            return strategyHandler.apply(requestParameter, dynamicContext);
        }

        // 3. 如果没找到，执行默认兜底策略
        return defaultStrategyHandler.apply(requestParameter, dynamicContext);
    }

    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        return doApply(requestParameter, dynamicContext);
    }

    protected abstract R doApply(T requestParameter, D dynamicContext) throws Exception;
}