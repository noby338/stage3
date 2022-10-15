package priv.noby.note.aop;

/**
 * 目标接口(将被增强的类的接口)
 *
 * 可以不使用该接口，Spring可通过cglib实现AOP
 * @author Noby
 * @since 2022/10/15
 */
public interface TargetInterface {
    void method();
}
