//package add;
//
//public class MyLinkedListTest {
//    public static void main(String[] args) {
//        MyLinkedList<Integer> list = new MyLinkedList<>();
//        // 요소 추가 테스트
//        list.add(10);
//        list.add(20);
//        list.add(30);
//        System.out.println("After adding 3 elements:");
//        printList(list);
//        // 맨 앞에 추가 테스트
//        list.addFirst(5);
//        System.out.println("After adding 5 at first:");
//        printList(list);
//        // 맨 끝에 추가 테스트
//        list.addLast(40);
//        System.out.println("After adding 40 at last:");
//        printList(list);
//        // 요소 조회 테스트
//        System.out.println("Element at index 2: " + list.get(2)); // 10
//        // 맨 앞 삭제
//        System.out.println("Removed first: " + list.removeFirst());
//        printList(list);
//        // 맨 끝 삭제
//        System.out.println("Removed last: " + list.removeLast());
//        printList(list);
//        // 리스트 비우기
//        list.clear();
//        System.out.println("After clearing the list:");
//        printList(list);
//    }
//    private static <T> void printList(MyLinkedList<T> list) {
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//        }
//        System.out.println();
//    }
//}