package examples;

import java.util.HashMap;

import com.utility.Base;

public class Derived extends Base {

	/**
	 * @param args
	 */
	//int number =5;
	final private static HashMap<String, String> mapte = new HashMap<String, String>();
	
	
	public Derived(){
		System.out.println("in Constructor Derived ");
		getNumber();
	}
	
	
	public int getNumber(){
		number = number*3;
		System.out.println("Number in Derived " +number);
		return number;
	}
	
	public static void staticTest(){
		System.out.println("in Derived staticTest ");
	}
	
	public static void main(String[] args) {
	
			//Base b = new Base();
			Derived d = new Derived();
			String s = null;
			//d.testfun1(s);
			d.staticTest();
			Base b = new Derived();
			b.staticTest();
		
	}


	@Override
	public Derived testOverriding(Base b) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
public  void testfun1(String s){
		System.out.println("1" +s);
}
	
public  void testfun1(int s){
	System.out.println("2");
	}
public  void testfun1(Object s){
	System.out.println("3");
}


public static void test(){
	System.out.println("Derived  test");
}

}
