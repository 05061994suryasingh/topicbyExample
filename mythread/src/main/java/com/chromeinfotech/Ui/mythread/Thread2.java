package com.chromeinfotech.Ui.mythread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by user on 15/3/17.
 */

public class Thread2 implements Runnable {
        BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
        Thread2 next = null ;

    public void setNext(Thread2 t) {
        this.next = t;
    }
    public void accept(int i) {
        q.add(i);
    }
    @Override
    public void run() {
        while (true){
            try {
                int i = q.take(); // blocks till it receives a number

                System.out.println( Thread.currentThread().getName());

                Thread.sleep(1000); // delay to slow the printing
                if (next != null){
                    next.accept(i+1); // pass the next number to the next worker
                }

            } catch (InterruptedException e) {
                System.err.println( Thread.currentThread().getName() + " interrrupted.");
            }
        }
    }
}

