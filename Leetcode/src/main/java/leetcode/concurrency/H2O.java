package leetcode.concurrency;

import java.util.concurrent.Semaphore;

/**
 * @Author: yangxu
 * @Date: 19-7-21 下午9:06
 */
public class H2O {

    // 串行话氧原子,一个氧原子没操作完的时候,阻塞住其他氧原子的操作.
    Semaphore olock = new Semaphore(1);


    // 判定两个氢原子都已输出
    Semaphore hfin = new Semaphore(0);



    Semaphore os = new Semaphore(0);
    Semaphore hs = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {


        // 氢原子许可+1  容器加一个H
        hs.release();
        // 需要氧原子许可
        os.acquire();

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        // 一个H原子已经输出完毕
        hfin.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException{
        // 串行化氧原子操作
        olock.acquire();
        // 取两个H原子
        hs.acquire(2);

        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        // 通知两个H原子可以做了.
        os.release(2);
        // 等待两个H原子输出
        hfin.acquire(2);
        // 允许下一个氧原子到来
        olock.release();

    }
}
