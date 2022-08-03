package priv.noby.note;

import util.MathUtil;

public class MavenNote {
    public static void main(String[] args) {
        //使用了maven模块中的类和方法
        int addition = MathUtil.addition(1, 2, 3, 4);
        System.out.println("addition = " + addition);
    }
}
