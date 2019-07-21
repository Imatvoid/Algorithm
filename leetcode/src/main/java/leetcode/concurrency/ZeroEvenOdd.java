package leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Author: yangxu
 * @Date: 19-7-18 下午11:06
 */
class ZeroEvenOdd {
    private int n;
    Semaphore zero = new Semaphore(1);
    Semaphore odd = new Semaphore(0);
    Semaphore even = new Semaphore(0);
    int count = 1;


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true){
            if(count>n){
                break;
            }
            zero.acquire();
            printNumber.accept(0);
            if((count&1) == 1){

                odd.release();
            }else {

                even.release();
            }
            count++;


        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n/2; i++) {
            even.acquire();
            printNumber.accept(count);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n/2+n%2; i++) {
            odd.acquire();
            printNumber.accept(count);
            zero.release();
        }
    }
}