package java.lang;

/**
 * 类加载机制：双亲委派机制 实验
 *
 * 双亲委派机制：保证安全
 *    APP ---> EXC ---> BOOT(最终执行)
 *    也就是先从 APP 往上找，如果 EXC 有这个类就接着往上找，BOOT 也有的话就在此执行；
 *    如果 BOOT 中没有就往回走，走到有这个类为止
 */
public class String {

    // BOOT
    // EXC
    // APP
    public String toString(){
        return "Hello";
    }

    // 会报错，说找不到 main 方法，因为没有执行这个 main
    public static void main(String[] args) {
        String s = new String();
        System.out.println(s.getClass().getClassLoader());
        s.toString();
    }

    /**
     * 1. 类加载器收到类加载请求
     * 2. 将这个请求向上委托给父类加载器去完成，一直向上委托，直到启动类加载器
     * 3. 启动类加载检查是否能够加载当前这个类，能加载就结束，使用当前的加载器，否则，抛出异常，通知子加载器进行加载
     * 4. 重复步骤 3
     *
     * 如果实在找不到会报一个很经典的错：Class Not Found
     * null：Java 调用不到 --- 底层用 C/C++ 写的
     * Java = C++ ：去掉繁琐的东西，指针、内存管理
     *      = C++--
     * Java 为什么能调用底层 C++ 代码：
     *      首先因为 JVM 在操作系统之上，不能自己去调用操作系统的东西，这就需要通过接口调用；
     *      怎么通过接口去调用，也就是用到了 native 关键字调用本地方法；
     *      (比如 Thread类中的 main 方法有这样一条语句 ---> private native void start0(); )
     */
}
