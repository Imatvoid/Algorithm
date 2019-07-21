package leetcode.concurrency;

/**
 * @Author: yangxu
 * @Date: 19-7-21 下午10:33
 */


import java.util.concurrent.Semaphore;
class FooBar {
    private int n;

    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire(); // foo - 1
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();  // bar + 1
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();  // bar + 1
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();  // foo - 1
        }
    }
}