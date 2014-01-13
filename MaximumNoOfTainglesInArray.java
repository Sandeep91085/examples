package examples;

public class MaximumNoOfTainglesInArray {

	static int arr[] = {10,21,22,100,101,200,300};
	
	public static void main(String[] args){
		
		getresult(arr);
		
		
	}
	
	
	public static void getresult(int arr[]){
		
		int arrLen = arr.length;
		int k;
		int count = 0 ;
		for(int i=0;i<arrLen-2;i++){
			k = i+2;
			for(int j=i+1;j<arrLen;j++){
				while(k<arrLen && arr[i]+arr[j]>arr[k]){
					
					count+= k-j;
					++k;
				}
			}
			
		}
		System.out.println("No of Traingles "+count);
	}
	
	
}
