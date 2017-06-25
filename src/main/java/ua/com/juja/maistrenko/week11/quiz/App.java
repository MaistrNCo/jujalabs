package ua.com.juja.maistrenko.week11.quiz;

public class App {
    public static void main(String[] args) throws Exception {
        Object x = new Object();
        synchronized(x) {
            synchronized(x) {
                x.notify();
            }
        }
    }
}