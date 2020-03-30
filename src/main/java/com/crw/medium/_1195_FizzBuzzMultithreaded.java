package com.crw.medium;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 1195. 交替打印字符串
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * - 如果这个数字可以被 3 整除，输出 "fizz"。
 * - 如果这个数字可以被 5 整除，输出 "buzz"。
 * - 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * <p>
 * 假设有这么一个类：
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 * public void fizz(printFizz) { ... }          // only output "fizz"
 * public void buzz(printBuzz) { ... }          // only output "buzz"
 * public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 * public void number(printNumber) { ... }      // only output the numbers
 * }
 * <p>
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 * 通过次数3,066提交次数5,104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1195_FizzBuzzMultithreaded {

    // TODO 此处除了 Number 线程，其他线程一直阻塞不结束，有问题，是否有不使用信号量能解决的方法
    public static void main(String[] args) {
        FizzBuzz pfb = new FizzBuzz(15);
        Thread t1 = new Thread(() -> {
            try {
                pfb.fizz(() -> System.out.print("fizz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Fizz");

        Thread t2 = new Thread(() -> {
            try {
                pfb.buzz(() -> System.out.print("buzz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Buzz");

        Thread t3 = new Thread(() -> {
            try {
                pfb.fizzbuzz(() -> System.out.print("fizzbuzz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "FizzBuzz");

        Thread t4 = new Thread(() -> {
            try {
                pfb.number(value -> System.out.print(value + " "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Number");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

class FizzBuzz {
    private int n;
    private AtomicInteger curNumber = new AtomicInteger(0);

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition fc = lock.newCondition();
    private final Condition bc = lock.newCondition();
    private final Condition fbc = lock.newCondition();
    private final Condition nc = lock.newCondition();

    // 状态十分是非数字
    private volatile boolean state = false;


    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            try {
                lock.lock();
                while (!state) {
                    fc.await();
                }
                printFizz.run();
                state = false;
                nc.signalAll();
            } catch (Exception e) {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            try {
                lock.lock();
                while (!state) {
                    bc.await();
                }
                printBuzz.run();
                state = false;
                nc.signalAll();
            } catch (Exception e) {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            try {
                lock.lock();
                while (!state) {
                    fbc.await();
                }
                printFizzBuzz.run();
                state = false;
                nc.signalAll();
            } catch (Exception e) {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                while (state) {
                    nc.await();
                }
                if (i % 3 == 0 && i % 5 != 0) {
                    fc.signalAll();
                    state = true;
                } else if (i % 5 == 0 && i % 3 != 0) {
                    bc.signalAll();
                    state = true;
                } else if (i % 5 == 0 && i % 3 == 0) {
                    fbc.signalAll();
                    state = true;
                } else {
                    printNumber.accept(i);
                    nc.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }

    }
}

