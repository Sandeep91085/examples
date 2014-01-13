package examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ForiegnTrip {

	public static void main(String[] args) {
		
		foreign_trip(9, " {(1,2),(2,3),(3,4),(11,2),(32,333),(77,87)}");
	}
	
    public static String output1;
   
    public static void foreign_trip(int input1,String input2)
    {
    	
    	 HashSet<String> empCom = new HashSet<String>();
    	input2 = input2.replaceAll("\\{", "").trim();
    	input2 = input2.replaceAll("\\}", "").trim();
    	input2 = input2.replaceAll("\\(", "").trim();
    	input2 = input2.replaceAll("\\)", "").trim();
    	String arr[] = input2.split("\\,");
    	System.out.println(input2);
    	System.out.println("len "+arr.length);
    	for(int i=0;i<arr.length;i++){
    		//System.out.println("found "+empCom.contains(arr[i]+arr[i+1]));
    		empCom.add(arr[i]+arr[i+1]);
    		//System.out.println("Emp "+empCom);
    		i= i+1;
    	}
    	
    	for(int i=0;i<arr.length;i++){
    		//System.out.println(""+empId[i]);
    		for(int j=i+1;j<arr.length;j++){
    			if(!arr[i].equals(arr[j])){
    				//System.out.println("in check");
    				if(!empCom.contains(arr[i]+arr[j]) && !empCom.contains(arr[j]+arr[i])){
    					//System.out.println(arr[i]+arr[j]);
    					empCom.add(arr[i]+arr[j]);
    					output1 ="yes";
    					break;
    				}
    			}
    		}
    	}
    	System.out.println("OP"+output1);
    }	
}

