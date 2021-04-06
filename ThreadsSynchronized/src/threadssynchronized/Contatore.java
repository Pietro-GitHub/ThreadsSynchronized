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
public class Contatore {
    static int c = 0;

	    public synchronized void incrementa() {
	        c++;
	    }

	    public synchronized void decrementa() {
	        c--;
	    }
	    void printFinalCounterValue() {
	        System.out.println("counter is: " + c);
	    }
}
