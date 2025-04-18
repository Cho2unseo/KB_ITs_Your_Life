//package ch06.practice.practice02;
//
//import java.util.Scanner;
//
//public class Input {
//
//    static Scanner sc = new Scanner(System.in);
//
//    public static String read(String title) {
//        System.out.print(title);
//        return sc.nextLine();
//    }
//
//    public static String read(String title, String defaultValue) {
//        System.out.print(title);
//        String name = sc.nextLine();
//        if (name.isEmpty()) return defaultValue;
//        return name;
//    }
//
//    int readInt(String title) {
//        System.out.print(title);
//        return Integer.parseInt(sc.nextLine());
//    }
//
//    boolean confirm(String title, boolean defaultValue) {
//        System.out.print(title);
//        if (defaultValue) System.out.println("(Y/n)");
//        else System.out.println("(y/N)");
//        String s = sc.nextLine();
//        if (s.isEmpty()) return defaultValue;
//
//    }
//
//    boolean confirm(String title) {
//
//    }
//}
