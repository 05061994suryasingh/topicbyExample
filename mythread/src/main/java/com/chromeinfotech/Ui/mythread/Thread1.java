package com.chromeinfotech.Ui.mythread;

import com.chromeinfotech.utils.Utils;

/**
 * Created by user on 15/3/17.
 */

public class Thread1 extends Thread {
    public Thread1() {
        super("thread1");
    }

    public void run() {
        String name = getName();
        Utils.printLog("thread1" , "thread1"+Thread.currentThread().getName());
//
//        for (int i = 0; i < 10; ++i) {
//            synchronized (this) {
//                if (name.equalsIgnoreCase("thread1")) {
//                    Utils.printLog("Thread", "name " + name);
//                    this.setName("thread2");
//                    notify();
//                } else {
//                    try {
//                        //this.wait(2000);
//                       sleep(2000);
//                       //wait(3000);
//                    } catch (InterruptedException ie) {
//
//                    }
//                }
//                if (name.equalsIgnoreCase("thread2")) {
//                    Utils.printLog("Thread", "name " + name);
//                    this.setName("thread1");
//                    notify();
//                } else {
//                    try {
//                         sleep(2000);
//                       // this.wait(2000);
//                    } catch (InterruptedException ie) {
//
//                    }
//                }
//            }
//        }

    }
}
