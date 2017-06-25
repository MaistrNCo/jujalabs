package ua.com.juja.maistrenko.week11.quiz;
class Application {
    public static void main(String[] args) {
        new Thread() {
            public void start() {
                System.out.println("Hello!");
            }
        }.run();
    }
}

class Application2 {
    public static void main(String[] args) {
        new Thread() {
            public void start() {
                System.out.println("Hello!");
            }
        }.start();
    }
}

class Application5 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Hello!");
            }
        }).run();
    }
}

class Application10 {
    public static void main(String[] args) throws Exception {
        new Object().wait();
    }
}

class Application11 {
 static void main(String[] args) throws Exception {
        new Object().notify();
    }
}


