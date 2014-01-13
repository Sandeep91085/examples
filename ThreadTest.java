package examples;

public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ThreadE tE1 = new ThreadE();
		//ThreadE tE2 = new ThreadE();
		Thread t1 = new Thread(tE1);
		Thread t2 = new Thread(tE1);
		//Thread t3 = new Thread(tE1);
		
		t1.start();
		t2.start();
		//t3.start();
		try {
			//t1.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" "+Thread.currentThread().getName());

	}

}
