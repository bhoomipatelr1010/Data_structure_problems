package dsa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@FunctionalInterface
interface Calculator {
	int operate(int a, int b);
}

public class MyThread implements Runnable {
	private List<Integer> sharedList = new ArrayList<>();

	public MyThread(String s) {
		System.out.println(s);
	}

	@Override
	public void run() {
		synchronized (sharedList) {
			// Access and modify the shared list
			sharedList.add(42);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		int bh = 3;

		int mask = 1;
		for (int i = 0; i < 32; i++) {

			mask <<= 1;
			System.err.println(mask);
		}
		/*
		 * String m1 = "common"; String m3 = new String("common");
		 * 
		 * String m2 = "common";
		 * 
		 * System.out.println(m1 == m2);
		 * 
		 * System.out.println(m1.equals(m2)); System.out.println(m3 == m2);
		 * System.out.println(m3.equals(m2));
		 * 
		 * LinkedList<Integer> ll = new LinkedList<>(); Collections.sort(ll);
		 */

		/*
		 * MyThread mmmm = new MyThread(m1); MyThread mmmm1 = new MyThread(m1);
		 */

		/*
		 * Thread t1 = new Thread(mmmm); Thread t2 = new Thread(mmmm1); t1.start();
		 * t2.start(); t1.join(); t2.join(); System.out.println(mmmm.sharedList);
		 * System.out.println(mmmm1.sharedList);
		 * 
		 * ExecutorService executorService = Executors.newFixedThreadPool(2);
		 * executorService.sub
		 */

	}

}
