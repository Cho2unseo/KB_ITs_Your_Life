package ch07.practice.practice01;

public class HttpServletExample {
    public static void main(String[] args) {
        method(new LoginServlet());
        method(new FileDownloadServlet());
    }
    public static void method(HttpServlet httpServlet) {
        httpServlet.service();
    }
}
