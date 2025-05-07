package ch15.sec05.exam04;

import ch15.sec05.exam04.Fruit;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExample2 {
    public static void main(String[] args) {
        // Fruit이 Comparable 구현을 하지 않았기 때문에 Comparator 필요
        TreeSet<Fruit> treeSet = new TreeSet<>(new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                if (o1.price < o2.price) return -1;
                else if (o1.price == o2.price) return 0;
                return 1;
            }
        });

        // compare에서 가격 기준으로 정렬
        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 10000));
        treeSet.add(new Fruit("딸기", 6000));

        for (Fruit fruit: treeSet) {
            System.out.println(fruit.name + " : " + fruit.price);
        }
    }
}
