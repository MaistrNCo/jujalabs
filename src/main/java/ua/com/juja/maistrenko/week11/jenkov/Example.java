package ua.com.juja.maistrenko.week11.jenkov;

/**
 * Created by maistrenko on 19.06.2017.
 */
public class Example {
    public static void main(String[] args) {
        //example1();
        //example2();
        Example e =  new Example();
        e.example3();
    }

    private static void example1() {
        Thread thread = new Thread("New Thread") {
            public void run() {
                System.out.println("run by: " + getName());
                System.out.println(Thread.currentThread());

            }
        };

        thread.start();
        System.out.println(thread.getName());
        System.out.println(Thread.currentThread());
    }

    private static void example2() {
        int i;
        for (i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " started");
                    loop();
                }

                void loop() {
                    int ind = 0;
                    while (ind < 100) {
                        System.out.println(Thread.currentThread().getName() + " " + ind);

                        ind++;
                    }
                }
            }, "Thread" + i);
            thread.start();
        }


    }

    private void example3(){
        MyClass myClass = new MyClass();
        MyClassSynchronised myClassSynchronised = new MyClassSynchronised();
        MyClassSynchronised myClassSynchronised2 = new MyClassSynchronised();
        Thread thread1 = new Thread(myClass,"Thread 1");
        Thread thread2 = new Thread(myClassSynchronised,"Thread  synch 2");
        Thread thread5 = new Thread(myClassSynchronised,"Thread  synch 3");
        Thread thread3 = new Thread(myClassSynchronised2,"Thread  synch 1");
        Thread thread4 = new Thread(myClass,"Thread 4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    class MyClassSynchronised implements Runnable{

        @Override
        public void run() {
            print();
        }

        synchronized void  print(){
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread());
            }
        }
    }
    class MyClass implements Runnable{

        @Override
        public void run() {
            print();
        }

        void  print(){
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread());
            }
        }
    }
}
