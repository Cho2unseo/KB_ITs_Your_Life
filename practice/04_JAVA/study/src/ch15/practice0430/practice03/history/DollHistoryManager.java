package ch15.practice0430.practice03.history;

import java.util.*;

public class DollHistoryManager {
    static Map<String, List<String>> historyMap = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    });

    public static void addHistory(String customer, String doll) {
        if (!historyMap.containsKey(customer)) {
            List<String> list = new ArrayList<>();
            list.add(doll);
            historyMap.put(customer, list);
        }
        else {
            historyMap.get(customer).add(doll);
        }
        System.out.println("📒 " + customer + " 님의 인형 기록에 '" + doll + "'이 추가되었습니다.");
    }

    public static void showAllHistory() {
        if (historyMap.isEmpty()) System.out.println("📋 아직 기록된 고객이 없습니다.");
        else {
            System.out.println("📋 고객별 인형 기록:");
            Set<Map.Entry<String, List<String>>> entrySet = historyMap.entrySet();
            for (Map.Entry<String, List<String>> entry : entrySet) {
                String name = entry.getKey();
                List<String> list = entry.getValue();
                System.out.print("- " + name + ": [");
                int idx = 0;
                for (String s: list) {
                    System.out.print(s);
                    if (idx != list.size() - 1) System.out.print(", ");
                    idx++;
                }
                System.out.println("]");
            }
        }

    }
}
