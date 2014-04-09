package examples;

import java.util.ArrayList;
import java.util.List;

import com.utility.Node;
import com.utility.NodeG;

public class Quiz {

	/**
	 * @param args
	 */
	final int s =0;
	final char[] a = new char[2];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr3[] = {5,6,1,3};
		//fibbonacci(8);
		//System.out.println(" "+fibonacciRec(8));
		//int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		int arr[] = {1,2,0,1,3,4,5};
		int arr1[] = {1,2,12,17,19};
		int arr2[] = {3,5,8,18,20};
		//ContiniouslargestSum(arr);
		char temp [] = {'a','a','a','s','s','d','d'};
		//char arr [] = {'a','b','c','d','e','f','g'};
		//int i=0;
		//int j=arr.length-1;
		//compressString(temp);
		//palindrome();
		//System.out.println("Total win amount: "+getFinalAmount(15, "LLLWLLLL"));
		
		
		
		/*ArrayList<String> input = new ArrayList<String>();
		input.add("d,e");
		input.add("f,g");
		input.add("b,c");
		input.add("e,f");
		input.add("g,h");
		input.add("a,b");
		input.add("c,d");
		
		buildChain(input);*/
		
		/*reverseString(arr, i-1, j+1);
		for(int k=0;k<=j;k++){
			
			System.out.print(""+arr[k]);	
		}*/
		
		
		//printPrime(15);
		
//		maxDiffrenceSoFar(arr);
//		minDiffrence();
		//atoi("123458976");
		//mergeSort(arr1, arr2);
	
		//test();
		System.out.println("BinarySearchOnRotatedArray "+BinarySearchOnRotatedArray(arr3, 0, arr3.length-1,3));
		//System.out.println("Elemet found at "+binarySearch(arr3, 0, arr3.length-1, 18));
//		removingAdjacentDuplicates();
		//mergeSort();
	}
	
	
	public static void fibbonacci(int n){
		
		int a=1;
		int b=0;
		int fib=0;
		if(n==1)
			System.out.println(""+n);
		for(int i=1;i<=n;i++){
			fib = a+b;
			a = b;
			b = fib;
			System.out.println(""+fib);
		}
	}
	
	public static synchronized int fibonacciRec(int n){
		
		if(n==1 || n==2)
			return 1;
		else
			return  fibonacciRec(n-1)+fibonacciRec(n-2);
	}
	
	public static void ContiniouslargestSum(int [] arr){
		
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
		
		System.out.println("Max is "+maxSofar);
		System.out.println(""+begin+" "+end);
	}
	
	
	public static void compressString(char [] arr){
		
		// a a a s s d d 
		int l = arr.length;
		
		int count = 1;
		char temp  = arr[0];
		int first = 0;
		int i=0;
		for(i=1;i<l;i++){
			if(temp==arr[i]){
				count += 1;
			}else{
				arr[first] = temp;
				arr[first+1] = (char) ('0'+count);
				first += 2;
				temp = arr[i];
				count = 1;
			}
			
		}
		
		if(i==l){
			arr[first] = temp;
			arr[first+1] = (char) ('0'+count);
			first +=2;
		}
		
		for(i=first;i<l;i++){
			arr[i] = '\n';
		}
		i=0;
		while(arr[i]!='\n'){
			System.out.print(" "+arr[i]);
			i++;
		}
	}
	
	public static void palindrome(){
		
		int i = 52323;
		int j=0;
		int k=0;
		int temp =i;
		
//		while(i/10>=1){
//			
//			i= i/10;
//			j += 1;
//		}
//		j= (int)Math.pow(10, j);
//		while(temp%10>1){
//			k +=(temp%10)*j;
//			System.out.println(" "+k);
//			temp= temp/10;
//			j=j/10;
//			System.out.println("k= "+k);
//		}
		int newN = 0;
		
		while (i != 0){
			int r = i % 10;
			i = i / 10;
			
			newN = newN *10 + r;
		}
		System.out.println(newN);
		
	}

	public static int getFinalAmount(int amount, String betCombination){
		
		int betVal=1;
		
		char [] betComb = betCombination.toCharArray();
		char bet = '\n';
		for(int i=0;i<betComb.length;i++){
			
			bet = betComb[i];
			if(amount-betVal<0){
				return amount;
			}
			if(bet=='l' || bet=='L'){
				amount = amount -betVal;
				betVal = betVal*2;
			}else{
				amount = amount+betVal;
				betVal = 1;
			}
			
			
		}
		return amount;
	}
	
	public static void buildChain(ArrayList<String> data){
		
		String arr[] = null;
		ArrayList<Character> arrParent = new ArrayList<Character>();
		ArrayList<Character> arrChild = new ArrayList<Character>();
		int i=0;
		NodeG<Character> head = null;
		NodeG<Character> currentNode = null;
		NodeG<Character> temNodeP = null;
		NodeG<Character> temNodeC = null;
		while(data.size()>0){
			arr = data.get(0).split(",");
			arrParent.add(arr[0].charAt(0));
			arrChild.add(arr[1].charAt(0));
			data.remove(0);
		}
		
		temNodeP = new NodeG<Character>();
		temNodeC = new NodeG<Character>();
		
		temNodeP.data = arrParent.get(0);
		currentNode = temNodeP;
		head = currentNode;
		temNodeC.data = arrChild.get(0);
		temNodeP.next = temNodeC;
		currentNode = temNodeC;
		
		arrParent.remove(0);
		arrChild.remove(0);
		
		while(arrParent.size()>0){
			
			
			if(currentNode.data == arrParent.get(i)){
				
				currentNode.next = new NodeG<Character>(arrChild.get(i));
				currentNode = currentNode.next;
				arrParent.remove(i);
				arrChild.remove(i);
				i=0;
				continue;
				
			}else if(head.data == arrChild.get(i)){
				
				temNodeP = new NodeG<Character>(arrParent.get(i));
				head.prev = temNodeP;
				temNodeP.next = head;
				head = temNodeP;
				
				arrParent.remove(i);
				arrChild.remove(i);
				i=0;
				continue;
				
			}else
				i++;
		}
		
		while(head != null){
			System.out.print(" "+head.data);
			head  = head.next;
		}
	}
	
	public static void reverseString(char [] arr,int i, int j){
		
		if(i==j || i>j){
			
		}else{
			i = i+1;
			j = j-1;
			reverseString(arr, i, j);
			swap(arr,i,j);
		}
			
		
		
	}
	
	public static void swap(char[] arr,int i,int j){
		
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	public static void printPrime(int n){
		
		int x=2;
		boolean isPrime = true;
		for(int i=2 ;i<=n;i++){
			
			for(x=2;x<i;x++){
				
				if(i%x==0){
					isPrime = false;
					break;
					}
				else
					isPrime = true;
				
			}
			if(isPrime)
				System.out.println("Prime "+i);
		}
	}
	
	public static void maxDiffrenceSoFar(int arr[]){
		
		int l = arr.length;
		int maxdif = arr[1]-arr[0];
		int min = arr[0];
		for(int i=1;i<l;i++){
			
			if(arr[i]-min>maxdif)
				maxdif = arr[i]-min;
			if(arr[i]<min)
				min = arr[i];
				
		}
		
		System.out.println("maxDiff "+maxdif);
	}
	
	
	
	
	public static void minDiffrence(){
		
		int arr[] = {2,5,3,7,9,10,1,22,100,23};
		int minDiff = 0;
		int max = arr[0];
		int len = arr.length-1;
		
		minDiff = arr[1]-arr[0];
		for(int i=0;i<=len-1;i++){
			
			
			
			
			
		}
		
		System.out.println("Min D"+minDiff);
	}
	
	
	
	public static void atoi(String inp){
		
		int result=0;
		for(int i=inp.length()-1;i>=0;i--){
			
			if(((int)inp.charAt(i))>=48 && ((int)inp.charAt(i))<=57){
				
				result = result+ (inp.charAt(i)-'0')*(int)Math.pow(10, inp.length()-1-i);
				
			}else{
				System.out.println("Not an atoi string ");
				return;
			}
		}
		System.out.println("Result Atoi is "+result);
	}
	
	/*
	int arr1[] = {1,2,12,17,19};
	int arr2[] = {3,5,8,18,20};
	*/
	
	public static void mergeSort(int[] arr1, int[] arr2){
		
		int len1 = arr1.length;
		int len2 = arr2.length;
		int j=0;
		int i=0;
		int k=0;
		int[] arrRes = new int[len1+len2];
		
		while(i<len1 && j<len2){
			if(arr1[i]>arr2[j]){
				arrRes[k]=arr2[j];
				j++;
			}else{
				arrRes[k]=arr1[i];
				i++;
			}
			k++;
		}
			while(i<len1){
				arrRes[k] = arr1[i];
				k++;
				i++;
			}
			while(j<len2){
				arrRes[k] = arr2[j];
				k++;
				j++;
			}
		
		
		
		
		for(int l=0;l<arrRes.length;l++){
			System.out.print(" "+arrRes[l]);
		}
		
		
	}
	
	
	public static void mergeSort(){
		
		int arrA[]={10,20,30};
		int arrB[]={2,11,21,22,27,32,35,38,0,0,0};
		int n=3;
		int m=8;
		
		int i = n-1;
		int j = m-1;
		int x = n+m-1 ;

		while(i>=0&&j>=0){
			if(arrB[j]>=arrA[i]){
				arrB[x] = arrB[j];
				x--;
				j--;
			}else{
				arrB[x]=arrA[i];
				i--;
				x--;
			}
		}
		
		while(i>=0){
			arrB[x--]= arrA[i--];
		}
		while(j>=0){
			arrB[x--] = arrB[j--];
		}
		
		
		
		for(int k=0;k<arrB.length;k++){
			System.out.print(" "+arrB[k]);
		}
		
/*		
		
		
		
		
		
		
		
		
		
		int i = n - 1, j = m - 1; 
		int x = n + m - 1; 
		while(i >= 0 && j >= 0) { 
		if (arrA[i] >= arrB[j]) 
			arrA[x--] = arrA[i--]; 
		else 
			arrA[x--] = arrB[j--]; 
		} 

		while(i >= 0) 
			arrA[x--] = arrA[i--]; 
		while(j >= 0) 
			arrA[x--] = arrB[j--];*/
	}
	
	
	
	public void arrayBalance(int arr[]){
		
		int l = arr.length;
		int load = 1;
		while(isBalance(arr)){
			
			int x = getFirstOddload(arr,load);
			if(x!=-1){
				balance(arr,x,load);
			}
			
			
		}
	}
	
	
	
	public boolean isBalance(int arr[]){
		return false;
	}
	
	public int getFirstOddload(int arr[],int load){
		
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]>load)
				return i;
		}
		
		return -1;
	}
	
	public void balance(int arr[],int index,int load){
		
		int l = arr.length-1;
		
		if(index>0){
			arr[index-1] = arr[index-1]+1;
			
		}
		
		arr[index] = arr[index]-1;
		
		if(l<index){
			arr[index+1] = arr[index+1]+1;
		}
		
		arr[index] = arr[index]-1;
		
	}
	
	public static void test(){
		
		List<String> temp = new ArrayList<String>();
		temp.add("a");
		temp.add("q");
		temp.add("w");
		temp.add("e");
		temp.add("t");
		
		for(int i=0;i<temp.size();i++){
			System.out.println(""+temp.remove(i));
		}
		
		
	}
	
	public static int BinarySearchOnRotatedArray(int arr[], int start, int end,int x){
		

		int index = pointOfRotation(arr, start, end);
		
		System.out.println("pointOfRotation "+index);
		
		if(index==-1)
			return binarySearch(arr, start, end, x);
		if(arr[index]==x)
			return index;
		if(arr[0]>x)
			return binarySearch(arr, index+1, end, x);
		else
			return binarySearch(arr, start, index-1, x);
			
		
		
	}
	
	
	public static int pointOfRotation(int arr[], int start, int end){
		
		
		if(start>end)
			return-1;
		if(start == end)
			return start;
		int mid = (start+end)/2;
		if(mid<end && arr[mid]>arr[mid+1])
			return mid;
		if(mid>start && arr[mid]<arr[mid-1])
			return mid-1;
		if(arr[start]>=arr[mid])
			return pointOfRotation(arr, start, mid-1);
		else
			return pointOfRotation(arr, mid+1, end);
		
	}
	
	
	public static int binarySearch(int[] arr,int start,int end,int x){
		
		if(start>end)
			return -1;
		else{
			int mid = start + ((end-start)/2);
			if(arr[mid]>x)
				return binarySearch(arr, start, mid-1, x);
			if(arr[mid]<x)
				return binarySearch(arr, mid+1, end, x);
			else
				return mid;
		}
	}
	
	
	public static void removingAdjacentDuplicates(){
		
		//////http://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/
		String s = "sabbacd";
		char[] arr = s.toCharArray();
		
		int i=0;
		int j=1;
		char prev;
		int len = arr.length-1;
		while(true){
			if(len<=1)
				break;
			if(j>len)
				break;
			if(arr[i]==arr[j]){
				while(j<=len && arr[i]==arr[j]){
					j++;
				}
				if(j<=len){
					arr[i] = arr[j];
					j=j+1;
				}
			}
			else{
				if(j-i>1){
					arr[i+1] = arr[j];
				}
				i++;
				j++;
			}
		}
		arr[i+1]='-';
		for(char a :arr){
			System.out.print(" "+a);
		}
		
		
	}
	
	
	
	
	
	
}

