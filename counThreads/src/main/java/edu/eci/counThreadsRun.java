package edu.eci;

public class counThreadsRun extends Thread{
	int A;
	int B;
		
	public counThreadsRun(int a,int b) {
		A=a;
		B=b;
	}
	public void run() {
		while(A<=B) {
			System.out.println(A);
			A++;
			
		}
	}
	}

