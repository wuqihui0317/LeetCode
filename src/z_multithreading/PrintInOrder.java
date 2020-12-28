package z_multithreading;

import java.util.concurrent.Semaphore;

/**
 * @author :wqh
 * @description :
 * @create :2020-12-15 10:44:00
 */
public class PrintInOrder {
    class Foo {
        Semaphore semaphore1 = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semaphore1.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphore1.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            semaphore2.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphore2.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
