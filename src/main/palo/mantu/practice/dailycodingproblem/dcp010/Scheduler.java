package palo.mantu.practice.dailycodingproblem.dcp010;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

/*
Daily Coding Problem: Problem #10

This problem was asked by Apple.

Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
*/
public class Scheduler {
    public void schedule(final Runnable runnable) {
        // const debounce = (fn = () => {}, wait = 1000) => (...args) => {
        // const delayed = () => fn.apply(this, args)
        // return setTimeout(delayed, wait)
        // }

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                // your code here
                // close the thread
                t.cancel();
            }
        }, 5000);

        long delayMillis = 5000;
        long requested = currentTimeMillis();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        long leftToSleep = requested + delayMillis - currentTimeMillis();
                        if (leftToSleep > 0) {
                            sleep(leftToSleep);
                        }
                        break;
                    } catch (InterruptedException ignored) {
                    }
                }
                runnable.run();
            }
        }).start();
    }
}