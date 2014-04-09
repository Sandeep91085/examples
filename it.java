package examples;

import java.io.Serializable;

import junk.SingleTon;

public class it implements Serializable{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		

	  /*  int[] elements = {1,2,3};
	    
	        BlockingStackTest test = new BlockingStackTest(elements, 3);
	        new Thread(test.producer, "Producer").start();
	        new Thread(test.consumer, "Consumer").start();*/
	    
	    
	    SingleTon.instance.test();
	    SingleTon.instance.set(2);
	    SingleTon.instance.test();
	    SingleTon.instance2.test();
	    SingleTon.instance2.set(5);
	    SingleTon.instance2.test();

	}

	/*private Object readResolve(){
		return null;
	}*/
	
	/*static{
		
		if(true)
			throw new RuntimeException();
	}*/
}
