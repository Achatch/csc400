package csc400;

public class InsertionSort {
    public static void InsertionSortEx(int array[]) {  
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  // Set key to equal position of the array
            int i = j-1;  //Set i to equal one position before
            while ( (i > -1) && ( array [i] > key ) ) {  // While position before exists and position before is greater than key position
                array [i+1] = array [i];  //array next(key) position equals array preceding position
                i--;  
            }  
            array[i+1] = key;  //Array pre position plus one is new key
            System.out.print("\nNew Array: "); // print
            for(int x:array){    
                System.out.print(x+" ");    
            }    
        }  
        
    }  
       
    public static void main(String a[]){    
        int[] arr1 = {5,7,4,9,8,5,6,3};    // set array
        System.out.print("Initial Array: ");    // formatting
        for(int i:arr1){    //pretty print
            System.out.print(i+" ");    
        }       
            
        InsertionSortEx(arr1);//sorting array using insertion sort    
           
        System.out.print("\nEnding Array: ");    //formatting
        for(int i:arr1){    //pretty print
            System.out.print(i+" ");    
        }    
    }    
}  
