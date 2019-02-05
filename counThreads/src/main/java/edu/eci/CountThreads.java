package edu.eci;





public class CountThreads{

	public static void main(String args[]) {
		Thread t1 = new counThreadsRun(0,99);
		Thread t2 = new counThreadsRun(100,199);
		Thread t3 = new counThreadsRun(200,299);
		t1.run();
		t2.run();
		t3.run();
		
	}
	
	

}