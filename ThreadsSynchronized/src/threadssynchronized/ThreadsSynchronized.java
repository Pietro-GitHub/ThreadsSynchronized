/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadssynchronized;

/**
 *
 * @author Bucci
 */
public class ThreadsSynchronized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // create object of unsafe counter
        Contatore badCounter = new Contatore();

        // setup thread1 to increment the badCounter 200 times
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 2000; i++) {
                    badCounter.increment();
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException ie) {
                    }
                }
            }
        });

        // setup thread2 to decrement the badCounter 200 times
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 2000; i++) {
                    badCounter.decrement();
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException ie) {
                    }
                }
            }
        });

        // run both threads
        thread1.start();
        thread2.start();

        // wait for t1 and t2 to complete.
        thread1.join();
        thread2.join();

        // print final value of counter
        badCounter.printFinalCounterValue();
    }
    
}
