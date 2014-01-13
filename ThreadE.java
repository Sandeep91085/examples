package examples;

public class ThreadE implements Runnable{

	@Override
	public void run() {
		
		//synchronized(this){
			for(int i=0;i<3;i++){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println("Thread "+Thread.currentThread().getName());
				f3();
				this.f2();
				this.f1();
				
				
			}
		//}
		
		
		
	}
	
	
	public synchronized void f1(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("in Function f1 " +Thread.currentThread().getName());
	}
	
	
	public synchronized void f2(){
		System.out.println("in function f2 "+Thread.currentThread().getName());
	}

	public static  synchronized void f3(){
		System.out.println("in function f3 " +Thread.currentThread().getName());
	}
	
}
