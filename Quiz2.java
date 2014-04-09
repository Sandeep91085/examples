package examples;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.Exchanger;

import com.sun.org.apache.bcel.internal.generic.IINC;
import com.utility.Base;
import com.utility.Node;
import com.utility.QuizUtility;

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
	
	
	public static void printMatrixInDiagonal(int [][] matrix){
		
		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int i = 0; i < cols; i++) {
			int c = i;
			for (int j = 0; (c >=0 && j < rows); c--, j++)
				System.out.print(matrix[j][c] + "  ");

			System.out.println("");
		}

		for (int j = 1; j < rows; j++) {
			int r = j;
			for (int i = cols-1; (i >= 0 && r < rows); i--, r++)
				System.out.print(matrix[r][i] + "  ");

			System.out.println("");
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
	
	public static void swapMatrixColumn(int mat[][],int rows,int col){
	
		int temp=0;
		for(int i=0;i<=rows-1;i++){
			for(int j=i;j<=col-1;j++){
				temp = mat[i][j];
				mat[i][j] = mat[i][col-1-j];
				mat[i][col-1-j] = temp;
				break;
			}
		}
		
		/*for(int i=rows/2;i<=rows-1;i++){
			for(int j=i;j<=col-1;j++){
				mat[i][j] = 
			}
		}*/
		
		System.out.println("matrix "+mat);
	}
	
	
	public static void rotateMatrix90(int arr[][]){
		
		int r = arr.length-1;
		int c = arr[0].length-1;
		int temp=-1;
		
		for(int i=0; i<(r+1)/2; i++){
			for(int j=i;j<c-i;j++){
				
				temp = arr[i][j];
				
				// top <- left
				arr[i][j] = arr[r-j][i];
				
				// left <- bottom
				arr[r-j][i] = arr[r-i][c-j];
				
				// bottom <- right
				arr[r-i][c-j] = arr[j][c-i];
				
				// right
				arr[j][c-i] = temp;
			}
		}
		
		System.out.println(" matrix "+arr);
		
	}
	
	private static int index=0;
	public static void checkRegularExpression(String regEx , String input){
		
		boolean match = true;
		int r=0;
		char c = '\0';
		while(r<regEx.length()-1){
			
			c = regEx.charAt(r);
			if(c=='*'){
				if(!checkAstrik(regEx,input,r))
					break;
				else
					r++;
			}
			else if(c=='.'){
				if(regEx.charAt(r+1)=='*'){
					checkDotAstrik(regEx, input, r+1);
					r = r+2;
				}else{
					checkDot(regEx, input, r);
					r++;
				}
			}else{
				if(compareChar(regEx,input,r)){
					r++;
					index++;
				}else
					break;
			}
			r++;
		}
		
		System.out.println(" Result: "+(match?true:false));
	}
	
	public static boolean checkAstrik( String regEx,String input,int start){
		
		char prev = regEx.charAt(start-1);
		while(input.charAt(index) == prev){
			index++;
		}

		return true;
	}
	
	public static boolean checkDot(String regEx,String input,int start){
		
		while(regEx.charAt(start+1) != input.charAt(index++));
		
		return true;
	}
	
	public static boolean checkDotAstrik(String regEx,String input,int start){
		
		char next = regEx.charAt(start+1);
		while(next != input.charAt(index++));
		
		return true;
	}
	
	public static boolean compareChar(String regEx,String input,int start){
		
		if(regEx.charAt(start) == input.charAt(index))
			return true;
		else if(regEx.charAt(start+1) == '*')
			return true;
		return false;
	}
	
	public static void dictonaryMatching(){
		
		ArrayList<String> dic = new ArrayList<String>();
		dic.add("samsung");
		dic.add("galaxy");
		dic.add("tab");
		dic.add("sam");
		String inp = "samsunggalaxytab";
		boolean match[] = new boolean[inp.length()+1];
		
		match[0] = true;
		for(int i=1;i<=inp.length();i++){
			for(int k=0;k<=i;k++){
				if(match[k] && dic.contains(inp.substring(k, i))){
					match[i] = true;
				}
			}
		}
		
		if(match[inp.length()]){
			System.out.println("Match found ");
		}else
			System.out.println("Not match");
		
	}
	public static void allStringCombination(String prefix,String inp){
	
		
		int n = inp.length();
		if(n<=0)
			System.out.print(" "+prefix);
		else{
			for(int i=0;i<n;i++){
				allStringCombination(prefix + inp.charAt(i), inp.substring(0, i)+inp.substring(i+1, n));
			}
		}
			
		
	}
	
	public static void uniquePartiotionOfInteger(int a){
		
		int arr[] = new int[a+1];
		System.out.println(a);
		genunique(arr, 0, a);
	}
	
	public static void getuniquePartitionOfInteger(int a){
		
		int p[] = new int[a]; // An array to store a partition
	    int k = 0;  // Index of last element in a partition
	    p[k] = a;  // Initialize first partition as number itself
	 
	    // This loop first prints current partition, then generates next
	    // partition. The loop stops when the current partition has all 1s
	    while (true)
	    {
	        // print current partition
	        printArray(p, k+1);
	        // Generate next partition
	        // Find the rightmost non-one value in p[]. Also, update the
	        // rem_val so that we know how much value can be accommodated
	        int rem_val = 0;
	        while (k >= 0 && p[k] == 1)
	        {
	            rem_val += p[k];
	            k--;
	        }
	        // if k < 0, all the values are 1 so there are no more partitions
	        if (k < 0)  return;
	        // Decrease the p[k] found above and adjust the rem_val
	        p[k]--;
	        rem_val++;
	        // If rem_val is more, then the sorted order is violeted.  Divide
	        // rem_val in differnt values of size p[k] and copy these values at
	        // different positions after p[k]
	        while (rem_val > p[k])
	        {
	            p[k+1] = p[k];
	            rem_val = rem_val - p[k];
	            k++;
	        }
	        // Copy rem_val to next position and increment position
	        p[k+1] = rem_val;
	        k++;
	    }
	}
	
	public static void printArray(int a[] , int k){
		for(int i=0;i<k;i++){
			System.out.print(a[i]);
		}
		System.out.println("");
	}
	
	public static void genunique(int arr[],int i,int a){
		
		if(i==a || arr[i]==1)
			return;
		arr[i]=1;
		arr[i+1]=a-(i+1);
		for(int j=0;j<=i+1;j++)
			System.out.print(arr[j]);
		System.out.println();
		genunique(arr, i+1, a);
	}
	
	public static void sumOf2int(int x,int y){
		int carry =0;
		while(y!=0){
			carry = x&y;
			x = x^y;
			y = carry<<1;
			
		}
		System.out.println("Sum "+x);
	}
	
	public static Node sumOfTwoLinkedList(Node list1 , Node list2, Node resultList, Node carry){
		
		if(list1==null)
			return resultList = list2;
		if(list2==null)
			return resultList = list1;
		int size1 = QuizUtility.getListSize(list1);
		int size2 = QuizUtility.getListSize(list2);

		if(size1 == size2){
			resultList = QuizUtility.addSameLengthList(list1,list2,resultList,carry);
		}else{
			if(size1<size2){
				//swap the linked list
			}
			
			int diff = size1-size2;
			Node currNode = null;
			for(currNode = list1;diff>=0;diff--)
				currNode = currNode.next;
			
			resultList = QuizUtility.addSameLengthList(currNode, list2, resultList, carry);
			QuizUtility.addCarryToRemainingList(list1,currNode,resultList,carry);
			
		}
		
		
		if(carry.data>0){
			Node temNode = new Node(carry.data);
			temNode.next = resultList;
			resultList = temNode;
		}
		return resultList;
	}
	
	static char arrc[]= new char[50];
	public static void printPairOfAllParenthesis(int n,int open,int close,String res,int pos){
		
		
		if (close == n) {
//			System.out.println(" " + res);
			for(char c : arrc)
				System.out.print(""+c);
			System.out.println("");
			return;
		}
		if (open > close) {
			res = res + "}";
			arrc[pos]= '}';
			printPairOfAllParenthesis(n, open, close + 1, res,pos+1);
		}
		if (open < n) {
			res = res + "{";
			arrc[pos]='{';
			printPairOfAllParenthesis(n, open + 1, close, res,pos+1);
		}
		
	}
	
	
	public static void factorialOfBigInt(){
		
		
		int n =20;
		String res="1";
		 while(n>=1){
			 res = getProductOfStringInt(res, n);
			 n= n-1;
			 
		 }
		System.out.println("factorial "+res);
		
	}
	
	public static String getProductOfStringInt(String inp,int mul){
		String res ="";
		char arrInp[] = inp.toCharArray();
		int strLen = arrInp.length-1;
		int carry = 0;
		int digit=0;
		for(int i=strLen;i>=0;i--){
			digit = Integer.parseInt(arrInp[i]+"");
			digit = digit*mul + carry;
			carry = digit/10;
			digit = digit % 10;
			arrInp[i] = Character.forDigit(digit, 10);
		}
		
		res = new String(arrInp);
		if(carry>0){
			res = carry + res ;
		}
		//System.out.println("res "+res);
		
		return res;
	}

	public static void reverseString(){
		
		
		char[] arr={'h','e','l','l','o', ' ','h','o','w',' ','a','r','e', ' ','y','o','u'};
		
		int i=0;
		int j=0;
		int len = arr.length-1;
		j= len;
		char temp = 's';
		while(i<=j){
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
			
			
		}
		int k=0;
		j=0;
		for(i=0;i<len;i++){
			if(arr[i]==' '){
				 k=i-1;
				while(j<k){
					temp = arr[k];
					arr[k] = arr[j];
					arr[j] = temp;
					k--;
					j++;
				}
				j=i+1;
			}	
		}
		
		k=len;
		while(j<len){

			temp = arr[k];
			arr[k] = arr[j];
			arr[j] = temp;
			k--;
			j++;
		
		}
		
		System.out.println(" result "+arr.toString());
		
		for(i=0;i<len+1;i++){
			System.out.print(arr[i]);
		}		
		
	}
	
	static int pathCount=0;
	public static int  printAllPathOfMatrix(int arr[][],int m,int n){
	
		
		int count[][] = new int[m][n];
		
		for(int i=0;i<m;i++){
			if(arr[i][0]==0)
				count[i][0]=0;
			else
				count[i][0]=1;
		}
		
		for(int j=0;j<n;j++){
			if(arr[0][j]==0)
				count[0][j]=0;
			else
				count[0][j]=1;
		}
		
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(arr[i][j]==0){
					count[i][j]=0;
					
				}else
					count[i][j] = count[i-1][j]+count[i][j-1];
			}
		}
		return count[m-1][n-1];
		/*if(arr[m-1][n-1]==0)
			return 0;
		if(m==1 || n==1)
			return 1;
		
		
		return printAllPathOfMatrix(arr, m-1, n) + printAllPathOfMatrix(arr,m, n-1);
*/		
	}
	
	
	
	public static void main(String[] args) {
		
		
		int arr[] = {1,2,3,4,5};
		int unsortedArray[] = {3,10,1};
		int arr2d[][] = {{1,2,3,10},{4,5,6,11},{7,8,9,12}/*,{72,82,92,122}*/};
		//int mat[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int mat[][] = {{1,2,0},{6,0,2},{2,12,13}};
		//printAllCombination(arr, 4, 0, arr.length-1);
		//Base b = new Base();
		//heapSort(unsortedArray);
			
		//getNonRepeatingEle();
		
//		printMatrixInDiagonal(arr2d);
		
		//setOfNuDifferenceK();
//		setOfnuDifferenceKBinary();
		//findAllTripletsInAscendingOrder();
		//sortedTripletInArray();
//		reverseBit();
//		reverse4MSbWithLSB();
//		elementOccrMoreThann2Times();
//		setOfparenthesis();
//		swapMatrixColumn(mat, 5, 5);
		//rotateMatrix90(mat);
		
		//dictonaryMatching();
//		allStringCombination("", "abc");
		//uniquePartiotionOfInteger(4);
//		getuniquePartitionOfInteger(5);
		
		//printPairOfAllParenthesis(2, 0, 0,"",0);
		
		//factorialOfBigInt();
		//reverseString();
		
		
		System.out.println("path "+printAllPathOfMatrix(mat,3, 3));
	}
	
	
	}

