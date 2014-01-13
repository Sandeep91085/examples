package examples;

public class LongestMonotonicallyIncreasingArray {

	int arr[] = {2,8,5,12,7,18,20,19,11,23,3,6};
	
	public static void main(String[] args){
		
	}
	
	
	public static int[] getResult(int arr[],int size){
		
		int res[] = new int[size];
		int rl = 0;
		res[rl] = arr[0];
		for(int i=1;i<=arr.length;i++){
			if(res[rl]>arr[i]){
				if(rl-1>=0){
					
				}
				res[rl] = arr[i];
				//rl = rl +1;
			}else{
				rl = rl +1;
				res[rl] = arr[i];
			}
		}
		
		
		
		
		return res;
	}
	
	
}
