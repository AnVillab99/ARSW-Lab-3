package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread {

	int a,b;
	boolean sleep;

	private List<Integer> primes;

	public PrimeFinderThread(int a, int b) {
		super();
		this.primes = new LinkedList<>();
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {
		for (int i = a; i < b; i++) {
			if(sleep) {
				try {
					dormir();
					this.wait();
					System.out.println("dormido");
				}
				catch(Exception e) {System.out.println(e);}
			}
			else {
				if (isPrime(i)) {
					//System.out.println(i);
					primes.add(i);
				}
			}
		}
		

	}

	boolean isPrime(int n) {
		boolean ans;
		if (n > 2) {
			ans = n % 2 != 0;
			for (int i = 3; ans && i * i <= n; i += 2) {
				ans = n % i != 0;
			}
		} else {
			ans = n == 2;
		}
		return ans;
	}

	public List<Integer> getPrimes() {
		return primes;
	}
	
	public synchronized void dormir() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void dormir(boolean b) {
		sleep=b;
	}
	
	public int hallados() {
		return primes.size();
	}

}
