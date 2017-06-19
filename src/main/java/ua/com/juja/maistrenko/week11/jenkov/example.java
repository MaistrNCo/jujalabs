package ua.com.juja.maistrenko.week11.jenkov;

/**
 * Created by maistrenko on 19.06.2017.
 */
public class example {
    public static void main(String[] args) {
        //example1();
        example2();
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
}
