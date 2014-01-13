package examples;


import java.util.Scanner;

class test4 {
    
    public static void main(String[] args) {
          // TODO Auto-generated method stub
    	
    	
    	
    	
		/*try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	 	    String s= bufferRead.readLine();
	 	    System.out.println(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
  
 	    
    	
          Scanner in = new Scanner(System.in);
          int n = in.nextInt();         
          int p[] = new int[10];
          for (int i =0;i<n;i++)
          {
                p[i]= in.nextInt();           
          }
          for (int i =0;i<n;i++)
          {
                System.out.println(p[i]);     
          }
          
          System.out.println("Result "+test4.ContiniouslargestSum(p));
    }
    public static int ContiniouslargestSum(int [] arr){
      
      int maxEnd = arr[0];
      int maxSofar = arr[0];
      int begin=0;
      int end=0;
      int beginTemp=0;
      
      for(int i=0;i<arr.length;i++){
             if(maxEnd<0){
                   maxEnd = arr[i];
                   beginTemp=i;
             }else{
                   maxEnd +=arr[i];
                   
             }
             if(maxEnd>maxSofar){
                   maxSofar = maxEnd;
                   begin = beginTemp;
                   end =i;
             }
      }
      
      return maxSofar;

}
}
