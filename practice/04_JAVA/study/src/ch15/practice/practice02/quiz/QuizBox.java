//package ch15.practice.practice02.quiz;
//
//import java.util.Arrays;
//
//public class QuizBox<T extends Content> {
//    Object[] list;
//    int size;
//    int capacity;
//
//    public QuizBox() {
//        this.capacity = 5;
//        this.list = (T[]) new Quiz[capacity];
//        this.size = 0;
//    }
//
//    void addQuiz(T quiz) {
//        if (size >= capacity) {
//            capacity = capacity * 2;
//            list = Arrays.copyOf(list, capacity);
//        }
//        list[size++] = quiz;
//    }
//
//    public void printAll() {
//        for (int i = 0; i < list.length; i++) {
//            System.out.println((i + 1) + ". " + list[i].question);
//        }
//    }
//}
