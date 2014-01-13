package examples;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.Exchanger;

import com.utility.Base;

public class Quiz2 {

	
	
	
	public static void printAllCombination(int arr[],int k,int start,int len){
		int count=0;
		for(int i=start;i<=len;i++){
			int l=0;
			int temp[] = new int[k];
			for(int j=i;j+l<=len&&l<k;l++){
				temp[l]=arr[j+l];
//				System.out.print(" "+count++);
				if(l==k-1){
					for(int a : temp){
						System.out.print(" "+a);
					}
					System.out.println("");
					j++;
					l=0;
				}
				
				
			}
			
			System.out.println("");
			//printAllCombination(arr, k,i,len);
			
		}
		
	}
	
	public static void dynamicLoading(){
		try {
		    Class ins = Class.forName("com.utility.Base");
		    //ins.newInstance();
		    ins.getMethod("getInstance", null).invoke(ins, null);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public static void heapSort(int arr[]){
		
		buildHeap(arr);
		int len = arr.length;
		for(int i=len-1;i>=0;i--){
			exchange(arr, 0, i);
			len = len-1;
			maxHeap(0, arr);
		}
		
		printArray(arr);
	}
	
	public static void buildHeap(int arr[]){
		int n= arr.length-1;
		
		for(int i=n/2;i>=0;i--){
			maxHeap(i,arr);
		}
		
	}
	
	public static void maxHeap(int i,int arr[]){
		
		int left = 2*i;
		int right = 2*i+1;
		int len = arr.length-1;
		int largest=0;
		if(left<=len && arr[left]>arr[i]){
			largest = left;
		}
		else
			largest = i;
		if(right<=left && arr[right]>arr[largest]){
			largest = right;
		}
		
		if(largest!=i){
			exchange(arr,i,largest);
			maxHeap(largest, arr);
		}
	}
	
	public static void exchange(int arr[],int i,int largest){
		int t=arr[i];
        arr[i]=arr[largest];
        arr[largest]=t; 
	}
	
	public static void printArray(int arr[]){
		for(int a : arr){
			System.out.print(" "+a);
		}
		System.out.println(" ");
	}

	
	public static void getNonRepeatingEle(){
		
		
		int arr[] = {2,3,2,6,7,6,7};
		
		int xor = arr[0]; /* Will hold xor of all elements */
		  int set_bit_no;  /* Will have only single set bit of xor */
		  int x = 0;
		  int y = 0;
		  int len = arr.length;
		  for(int i = 1; i < len; i++)
			   xor ^= arr[i];
		  set_bit_no = xor & ~(xor-1);
		  
		  /* Now divide elements in two sets by comparing rightmost set
		   bit of xor with bit at same position in each element. */
		  for(int i = 0; i < len; i++)
		  {
		    if((arr[i] & set_bit_no)!=0)
		     x = x ^ arr[i]; //XOR of first set 
		    else
		     y = y ^ arr[i]; //XOR of second set
		  }
		  System.out.println(" "+x+" "+y);
		  System.out.println("Setbit "+set_bit_no);
		}
	
	
	public static void printMatrixInDiagonal(int [][] arr, int m,int l){
		
		int i=1;
		int j=0;
		int n=0;
		System.out.println(" "+arr[0][0]);
		while(true){
			j=n;
			for(int k=i;j<=i;k--,j++){
				System.out.print(" "+arr[k][j]);
			}
			System.out.println("");
			if(i<m-1){
				i++;
				j=n;
			}
			else{
				n++;
			}
			if(i==l-1)
				break;
		}
		
		
		
		
	}
	
	
	public static void setOfNuDifferenceK(){
		
		int arr[] = {1,5,3,4,2};
		int size  = arr.length-1;
		int diff =2;
		int total =0;
		int max =21;
		
		int temp[]= new int[max];
		for(int i=0;i<=size;i++){
			temp[arr[i]]=1;
		}
		for(int i=0;i<=size;i++){
			if((arr[i]+diff)<max && temp[arr[i]+diff]==1){
				total++;
				System.out.println(" "+arr[i]+" "+(arr[i]+diff));
			}
		}
		System.out.println("Total "+total);
		
	}
	
	public static void setOfnuDifferenceKBinary(){

		int arr[] = {1,5,3,4,2};
		int k=2;
		int size= arr.length;
		int total =0;
		Arrays.sort(arr);
		for(int i=0;i<size;i++){
			
			int key = arr[i]+k;
			int index = Arrays.binarySearch(arr, key);
			if(index>0){
				total++;
			}
		}
		System.out.println("Total "+total);
		
	}
	
	
	public static void findAllTripletsInAscendingOrder(){
		
		
		int arr[] ={1,1,5,4,3,6,6,5,9,10};
		//Arrays.sort(arr);
		int len =arr.length;
		TreeSet<String> op = new TreeSet<String>();
		
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				if(arr[j]>arr[i]){
					for(int k=j+1;k<len;k++){
						if(arr[k]>arr[j]){
							//System.out.println(""+arr[i]+arr[j]+arr[k]);
							op.add(""+arr[i]+arr[j]+arr[k]);
						}
					}
				}
				
			}
		}
		Iterator<String> itr = op.iterator();
		while (itr.hasNext()) {
			String key = (String) itr.next();
			System.out.println("Key "+key);
		}
		System.out.println("Len "+op.size());
		
		
	}
	
	
	public static void sortedTripletInArray(){
		
		
		int arr[]={1,1,2,2,3,4};
		int len = arr.length;
		int min =0;
		int max = len-1;
		int smallest[]= new int[len];
		int largest[] = new int[len];
		smallest[0]=-1;
		largest[len-1]=-1;
		//if element arr[i] is greater than next element then smallest[i]=-1
		for(int i=1;i<len;i++){
			if(arr[min]>=arr[i]){
				min = i;
				smallest[i]=-1;
			}else
				smallest[i]=min;
		}
		
		for(int i=len-2;i>=0;i--){
			
			if(arr[i]>=arr[max]){
				max = i;
				largest[i]=-1;
			}else{
				largest[i] = max;
			}
		}
		
		for(int i=0;i<len;i++){
			if(smallest[i]!=-1 && largest[i]!=-1){
				System.out.println(" "+arr[smallest[i]]+""+arr[i]+""+arr[largest[i]]);
			}
		}
		
		
	}
	
	
	public static void reverseBit(){
		
		int x=11;
		int b=0;
		while(x!=0){
			b=b<<1;
			System.out.println("b "+Integer.toBinaryString(b));
			b=b|(x&1);
			System.out.println("b2 "+Integer.toBinaryString(b));
			x=x>>1;
			System.out.println("x "+Integer.toBinaryString(x));
		}
		System.out.println("Revrse bit "+b);
	}
	
	public static void reverse4MSbWithLSB(){
		
		int inp=93;
		int x = Integer.parseInt("01011101", 2);
		System.out.println(" x "+x);
		String s = Integer.toBinaryString(93);
		System.out.println(" s "+s);
		
		int msb = inp & 0xf0;
		System.out.println(" MSB "+Integer.toBinaryString(msb));
		msb >>=4;
		int lsb = inp & 0x0f;
		lsb <<=4;
		
		inp = msb | lsb;
		System.out.println(" inp "+inp+" "+Integer.toBinaryString(inp));
		
		
		
	}
	
	public static void elementOccrMoreThann2Times(){
		
		int arr[] = {1,2,1,7,1};
		int counter=0;
		int value=-1;
		
		for(int i=0;i<arr.length;i++){
			if(counter==0){
				value=arr[i];
				counter++;
			}
			else if(arr[i]==value){
				counter++;
			}else
				counter--;
		}
		
		System.out.println(" value "+value);
	}
	
	static String res = "";
	
	public static void setOfparenthesis(){
		
		_setOfParenthesis(2, 0, 0,"");
		
	}
	
	public static void _setOfParenthesis(int n, int open,int closed, String str) {

		if (closed == n) {
			System.out.println(str);
			return;
		}

		if (open < n) {
			_setOfParenthesis(n, open + 1, closed, str + "{");
		}

		if (closed < open) {
			_setOfParenthesis(n, open, closed + 1, str + "}");
		}
	}
	
	public static void main(String[] args) {
		
		
		int arr[] = {1,2,3,4,5};
		int unsortedArray[] = {3,10,1};
		int arr2d[][] = {{1,2,3,10},{4,5,6,11},{7,8,9,12}};
		//printAllCombination(arr, 4, 0, arr.length-1);
		//Base b = new Base();
		//heapSort(unsortedArray);
			
		//getNonRepeatingEle();
		
//		printMatrixInDiagonal(arr2d, 3,4);
		
		//setOfNuDifferenceK();
//		setOfnuDifferenceKBinary();
		//findAllTripletsInAscendingOrder();
		//sortedTripletInArray();
//		reverseBit();
//		reverse4MSbWithLSB();
//		elementOccrMoreThann2Times();
		setOfparenthesis();
	}
	

	}

