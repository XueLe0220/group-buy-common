package cn.xuele.common.design.framework.link.handler;

/**
 * 责任链模式 - 逻辑处理器标准接口
 *
 * @author XueLe
 * @version 1.0.0
 * @since 2026/06/12 17:32
 */
public interface ILogicHandler<T, D, R> {

    default R next(T requestParameter, D dynamicContext){
        return null;
    }

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
