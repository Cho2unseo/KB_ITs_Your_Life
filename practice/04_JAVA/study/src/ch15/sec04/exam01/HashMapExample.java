package ch15.sec04.exam01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        // Key 값은 String, Value 값은 Integer
        Map<String, Integer> map = new HashMap<String, Integer>();

        // Key 값이 중복되면 저장이 되지 않는다.
        map.put("신용권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("홍길동", 95);

        System.out.println("총 Entry 수: " + map.size());
        System.out.println();

        String key = "홍길동";
        // get: Key로 Value를 가져올 수 있는 메소드
        int value = map.get(key);
        System.out.println(key + ": " + value);
        System.out.println();

        // keySet: map의 키값들을 Set 형태로 가져오는 메소드
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            String k = keyIterator.next();
            Integer v = map.get(k);
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // entrySet: map의 entry들을 Set 형태로 가져오는 메소드
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // remove: 키값으로 엔트리 삭제하는 메소드
        map.remove("홍길동");

        System.out.println("총 Entry 수: " + map.size());
        System.out.println();
    }

}
