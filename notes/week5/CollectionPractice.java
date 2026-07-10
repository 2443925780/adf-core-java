package notes.week5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class CollectionPractice {
    public static void main(String[] args) {

        List<String> cities = new ArrayList<>();
        cities.add("北京");
        cities.add("上海");
        cities.add("广州");
        cities.add("深圳");
        cities.add("杭州");
        System.out.println("城市列表 (List): " + cities);

        Set<Integer> numbers = new HashSet<>();
        // 添加重复数字
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(5);
        numbers.add(5); // 重复
        numbers.add(5); // 重复
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(8); // 重复
        System.out.println("数字集合 (Set): " + numbers);

        Map<String, Integer> people = new HashMap<>();
        people.put("张三", 18);
        people.put("李四", 20);
        people.put("王五", 22);
        System.out.println("开始遍历 Map (姓名-年龄):");
        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            System.out.println("姓名: " + entry.getKey() + ", 年龄: " + entry.getValue());
        }
    }
}
