package recursion;

public class Fundamentals_Revision {
	
	//Printing printIncreasing in pattern---------------------------------------------------------------------
	//EX: For given range of [5, 9] || Output : 5 6 7 8 9
	public static void printIncreasing(int a, int b) {
		if(a > b) return;
		System.out.print(a + " ");
		printIncreasing(a + 1, b);
	}
	
	
	//Printing printDecreasing in pattern----------------------------------------------------------------------
	//EX: For given range of [5, 9] => Output : 9 8 7 6 5
	public static void printDecreasing(int a, int b) {
		if(a > b) return;
		System.out.print(b + " ");
		printDecreasing(a, b - 1);
	}
	
	
	//Printing IncreasingDecreasing in pattern-----------------------------------------------------------------
	//EX: For given range of [5, 9] => Output : 5 6 7 8 9 9 8 7 6 5
	public static void printIncreasingDecreasing(int a, int b) {
		if(a > b) return;
		System.out.print(a + " ");
		printIncreasingDecreasing(a + 1, b);
		System.out.print(a + " ");
	}
	
	
	//Printing OddEven in pattern------------------------------------------------------------------------------
	//EX: For given range of [5, 9] print all odds first then all evens : 5 7 9 8 6
	public static void printOddEven(int a, int b) {
		if(a > b) return;
		if(a % 2 != 0) System.out.print(a + " ");
		printOddEven(a + 1, b);
		if(a % 2 == 0) System.out.print(a + " ");
	}
	
	
	//Factorial: n! = n*(n-1)*(n-2)*(n-3)*....*1 ---------------------------------------------------------------
	//One liner code using ternary operator
	public static int fact_01(int n) {
		return n == 0 ? 1 : n * fact_01(n - 1); 
	}
	
	//Same code as above
	public static int fact_02(int n) {
		if(n == 0) return 1; 
		return n * fact_02(n - 1); 
	}
	
	
	//Power: Ex: 5^3 = 5*5*5 where a=5, x=3 ---------------------------------------------------------------------
	//One liner code using ternary operator
	public static int pow_01(int a, int x) {
		return x == 0 ? 1 : a * pow_01(a, x - 1); 
	}
	
	//Same code as above
	public static int pow_02(int a, int x) {
		//The smallest input can be n^0 => 1
		if(x == 0) return  1;
		return a * pow_02(a, x - 1);
	}
	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$==========IMPORTANT============$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//Optimized, TC: Logarithmic 
	static int calls = 0;
	public static int pow_Logarithmic(int a, int x) {
		calls++;
		System.out.print("Recursive Call: " + calls + ", ");
		if(x == 1) return a;
		
		int smallAns = pow_Logarithmic(a, x/2);
		int ans = smallAns * smallAns;
		if(x % 2 == 0) return ans;  //Even power: (a, x) = a^(x/2) * a^(x/2) 
		else return ans * a;		//Odd power: (a, x) = a^(x/2) * a^(x/2) * a
	}
	
	
	//Display arr starting from 1st element-----------------------------------------------------------------
	//Passing index
	public static void displayForward_01(int[] arr, int idx) {
		if(idx == arr.length) return;
		
		System.out.print(arr[idx] + " ");
		displayForward_01(arr, idx + 1);
	}
	
	//Passing n => defining our region(call space) at each call, using n as index
	public static void displayForward_02(int[] arr, int n) {
		if(n == 0) return;
	
		displayForward_02(arr, n - 1);
		System.out.print(arr[n - 1] + " ");
	}
	
	
	//Display arr starting from last element-----------------------------------------------------------------
	//Passing index
	public static void displayBackward_01(int[] arr, int idx) {
		if(idx == arr.length) return;
		
		displayBackward_01(arr, idx + 1);
		System.out.print(arr[idx] + " ");
	}
	
	//Passing n => defining our region(call space) at each call, using n as index
	public static void displayBackward_02(int[] arr, int n) {
		if(n == 0) return;
		
		System.out.print(arr[n - 1] + " ");
		displayBackward_02(arr, n - 1);
	}
	
	
	//Maximum of an array---------------------------------------------------------------------------------------
	public static int maximum(int[] arr, int n) {
		if(n == 0) return (int)-1e9;
		return Math.max(arr[n - 1], maximum(arr, n - 1));
	}
	
	
	//Minimum of an array---------------------------------------------------------------------------------------
	public static int minimum(int[] arr, int n) {
		if(n == 0) return (int)1e9;
		return Math.min(arr[n - 1], minimum(arr, n - 1));
	}
	
	
	//Find an element in an array---------------------------------------------------------------------------------------
	public static boolean searchElement_01(int[] arr, int n, int toBeFound) {
		if(n == 0) return false;
		if(arr[n - 1] == toBeFound) return true;
		return searchElement_01(arr, n - 1, toBeFound);
	}
	
	//Rajneesh Bhaiya's Method
	public static boolean searchElement_02(int[] arr, int n, int toBeFound) {
		if(n == 0) return false;
		return arr[n - 1] == toBeFound || searchElement_02(arr, n - 1, toBeFound);
	}
	
	
	//Find first index of an element in an array----------------------------------------------------------------
	public static int findFirstIndex(int[] arr, int idx, int toBeFound) {
		if(idx == arr.length) return -1;
		if(arr[idx] == toBeFound) return idx;
		return findFirstIndex(arr, idx + 1, toBeFound);
	}
	

	//Find last index of an element in an array-------------------------------------------------------------------
	//More optimized
	public static int findLastIndex_01(int[] arr, int n, int toBeFound) {
		if(n == 0) return -1;
		if(arr[n - 1] == toBeFound) return n - 1;
		return findLastIndex_01(arr, n - 1, toBeFound);
	}	

	//Rajneesh Bhaiya's Method // Just to teach concept
	public static int findLastIndex_02(int[] arr, int idx, int toBeFound) {
		if(idx == arr.length) return -1;
		
		int smallAns = findLastIndex_02(arr, idx + 1, toBeFound);
		if(smallAns != -1) return smallAns;
		return arr[idx] == toBeFound ? idx : -1; 
	}
	
	
	//All index of an element in an array in O(N)-----------------------------------------------------------------
	public static int[] allIndexes(int[] arr, int idx, int count, int toBeFound) {
		if(idx == arr.length) return new int[count];
		
		if(arr[idx] == toBeFound) count++;
		int[] ans = allIndexes(arr, idx + 1, count, toBeFound);
		if(arr[idx] == toBeFound) {
			ans[count - 1] = idx;
			return ans;
		}
		return ans;
	}

	
	//Main-------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		System.out.print("Increasing : ");
		printIncreasing(5, 9);
		
		System.out.print("\nDecreasing : ");
		printDecreasing(5, 9);
		
		System.out.print("\nIncDec : ");
		printIncreasingDecreasing(5, 9);
		
		System.out.print("\nOddEven : ");
		printOddEven(5, 9);
		
		
		System.out.println("\n\nfact_01 : " + fact_01(5));
		System.out.println("fact_02 : " + fact_02(5));
		
		
		//9 ^ 10 exceeds the integer range , hence gives -ve ans in JAVA
		System.out.println("\npow_01: " + pow_01(9, 10)); 
		System.out.println("pow_02: " + pow_02(9, 10)); 
		System.out.println("pow_Logarithmic: ");
		//power 0 not handled
		System.out.println(pow_Logarithmic(9, 10)); 
	
	
		int[] arr = {-1, 10, 15, 90, 25, 30, 25, 89};
		
		System.out.print("\ndisplayForward_01: ");
		displayForward_01(arr, 0);
		
		System.out.print("\ndisplayForward_02: ");
		displayForward_02(arr, arr.length);
		
		System.out.print("\ndisplayBackward_01: ");
		displayBackward_01(arr, 0);

		System.out.print("\ndisplayBackward_02: ");
		displayBackward_02(arr, arr.length);
		
		System.out.println("\nmaximum: " + maximum(arr, arr.length));
		System.out.println("minimum: " + minimum(arr, arr.length));	
		System.out.println("searchElement_01: " + searchElement_01(arr, arr.length, 25));
		System.out.println("searchElement_02: " + searchElement_02(arr, arr.length, 25));
		System.out.println("findFirstIndex: " + findFirstIndex(arr, 0, 25));
		System.out.println("findLastIndex_01: " + findLastIndex_01(arr, arr.length, 25));
		System.out.println("findLastIndex_02: " + findLastIndex_02(arr, 0, 25));
		
		int[] ans = allIndexes(arr, 0, 0, 90);
		for(int val : ans) System.out.print(val + " ");
	}

}
