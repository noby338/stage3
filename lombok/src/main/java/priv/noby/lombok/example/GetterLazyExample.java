package priv.noby.lombok.example;

import lombok.Getter;

/**
 * @Getter(lazy = true) 注解时，Lombok 会为被注解的字段生成一个延迟初始化的 getter 方法，
 * 该方法在首次调用时才会初始化字段的值。
 */
public class GetterLazyExample {
    @Getter(lazy = true)
    private final double[] cached = expensive();

    private double[] expensive() {
        double[] result = new double[1000000];
        for (int i = 0; i < result.length; i++) {
            result[i] = i * Math.PI;
        }
        return result;
    }

    public static void main(String[] args) {
        //使用Double Check Lock 样板代码对属性进行懒加载
        GetterLazyExample example = new GetterLazyExample();
        System.out.println(example.getCached().length);
        System.out.println(example.getCached()[1000000 - 1]);
    }
}
