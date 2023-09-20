package priv.noby.lombok.example;

import lombok.*;

/**
 * @Synchronized 是 Lombok 中的注解，用于为方法或代码块添加同步锁，确保在多线程环境下的线程安全性。
 *
 * 使用 @Synchronized 注解时，Lombok 会自动为被注解的方法或代码块添加一个同步锁。
 * 这个同步锁可以是方法所属对象的实例锁，也可以是类锁，具体取决于被注解的方法是实例方法还是静态方法。
 */
@Data
public class SynchronizedExample {
    @NonNull
    private Integer count;

    @Synchronized
    @SneakyThrows
    public void reduceCount(Integer id) {
        if (count > 0) {
            Thread.sleep(500);
            count--;
            System.out.println(String.format("thread-%d count:%d", id, count));
        }
    }

    public static void main(String[] args) {
        //添加@Synchronized三个线程可以同步调用reduceCount方法
        SynchronizedExample example = new SynchronizedExample(20);
        new ReduceThread(1, example).start();
        new ReduceThread(2, example).start();
        new ReduceThread(3, example).start();
    }

    @RequiredArgsConstructor
    static class ReduceThread extends Thread {
        @NonNull
        private Integer id;
        @NonNull
        private SynchronizedExample example;

        @Override
        public void run() {
            while (example.getCount() > 0) {
                example.reduceCount(id);
            }
        }
    }

}
