package ua.com.juja.maistrenko.week11;

public class App {
    public static synchronized void f() {
       /*SOME CODE*/
    }
    public static synchronized void g(App arg) {
        synchronized (arg.getClass()) {
           /*SOME CODE*/
        }
    }
}