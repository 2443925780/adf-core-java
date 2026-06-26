public class HelloWorld {

    // 自定义方法
    public static void sayHello() {
        System.out.println("Hello Java!");
    }

    public static void main(String[] args) {

        // 三个不同类型的变量
        int age = 19;
        double score = 95.5;
        String name = "hj";

        // 判断
        if (age >= 18) {
            System.out.println("成年人");
        } else {
            System.out.println("未成年人");
        }

        // 循环
        for (int i = 1; i <= 5; i++) {
            System.out.println("第 " + i + " 次循环");
        }
        sayHello();
    }
}