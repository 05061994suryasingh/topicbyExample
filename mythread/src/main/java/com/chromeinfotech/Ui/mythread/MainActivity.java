package com.chromeinfotech.Ui.mythread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chromeinfotech.mythread.R;
import com.chromeinfotech.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.operation();
        // this.runnable();
    }

    private void runnable() {
        Thread2 w1 = new Thread2();
        Thread2 w2 = new Thread2();
        Thread2 w3 = new Thread2();
        // chain them in a round robin fashion
        w1.setNext(w2);
        w2.setNext(w3);
        w3.setNext(w1);
        // Create named threads for the workers
        Thread t1 = new Thread(w1, "Thread1");
        Thread t2 = new Thread(w2, "Thread2");
        Thread t3 = new Thread(w3, "Thread3 ");
        // start the threads
        t1.start();
        t2.start();
        t3.start();
        // Seed the first worker
        w1.accept(1);
    }

    private void operation() {
        Thread1 thread1 = new Thread1();
        Thread1 thread2 = new Thread1();

        thread1.setName("thread1");
        thread2.setName("thread2");
        Utils.printLog("" ,"thread" +Thread.currentThread().getName());
        thread1.start();
        thread2.start();

    }
}