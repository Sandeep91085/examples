package examples;

public class LoadBalancer {
    
    /**
    * @author Gayathri N.
    *Description::  Load Balancing on an array passed with the load on ever server and 
     *                         tries to balance the load on each server at every second.
    *                         Outputs the time taken to balance the load 
     *
    */
    
    public static int maximumValue = 0;
    public static int maximumPosition=0;
 
    
    public static void main(String args[]){
         
           int array1[]={0,0,10,0,0,0,0,0,0,0};
           int array2[]={2,4,8,0,1,5,11,9,3,7};
           int array3[]={12,30,42,0};
           int array4[]={27,28};
           
           System.out.println("Array :: {0,0,10,0,0,0,0,0,0,0}");
           System.out.println("Time Taken for the array with above values : "+LoadBalancer.balanceLoad(array1));
           /*System.out.println("\n\n\n");
           System.out.println("Array :: {2,4,8,0,1,5,11,9,3,7}");
           System.out.println("Time Taken for the array with above values : "+LoadBalancer.balanceLoad(array2));
           System.out.println("\n\n\n");
           System.out.println("Array :: {12,30,42,0}");
           System.out.println("Time Taken for the array with above values {12,30,42,0} : "+LoadBalancer.balanceLoad(array3));
           System.out.println("\n\n\n");
           System.out.println("Array :: {27,28}");
           System.out.println("Time Taken for the array with above values  : "+LoadBalancer.balanceLoad(array4));*/
           
      
    }
 public static void findMax(int[] ar){
           maximumValue = 0;
        for(int k=0;k<ar.length;k++){
              if(maximumValue < ar[k]){
                  
                   maximumValue =ar[k];
                  maximumPosition=k;
              } 
      }
 }
 
 public static int balanceLoad(int[] array){    
                 
    if (array.length == 0)
          System.out.println("Input is empty! Please send valid integer input array");
      
    int sumOfRequests=0;
    int timeUnits=0;
                
    for (int value : array)
             sumOfRequests += value;
             
     int loadFactor = sumOfRequests / array.length;                                                   
     
     
     int j = 0,k=0;
     boolean flag = false;
     
     for(;flag == false;){
              LoadBalancer.findMax(array);
                  
              j=maximumPosition;
                k=maximumPosition;
                
                for(;j>0;){
                     if ( array[j-1]<loadFactor){
                               array[j-1]+=1;
                               array[maximumPosition]-=1;
                     flag = true;
                    
                     break;}
                     j--;
                  }
                        
                  for(;k<array.length-1;){
                      if (array[k+1]<loadFactor){
                                      array[k+1]+=1;
                                      array[maximumPosition]-=1;
                                     
                      flag = true;
                    
                      break;
                      }
                      k++;
                         }
                if(flag == false){
                     
                     System.out.println("Load factor for the above array ::"+loadFactor);
                     System.out.print("Servers Array after load balancing ::{");
                     
                     for(int n: array){
                           System.out.print(" "+n);
                     }
                     System.out.println("}");
                    return  timeUnits;
                }
                else{
                	 
                    flag = false;
                    timeUnits++;
                    for(int n: array){
                        System.out.print(" "+n);
                  }
                    System.out.println(" timeUnits "+timeUnits);
                }
      } 
     
     return -1;
    
 }           
}

