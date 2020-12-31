package csc400;

public class RecursiveArray {
    public static void main(String[] args){
    	int i = 0;
        String[] words = {"words1","words2","words3","words4","words5"}; //Words to be displayed in forward order
        int size = words.length;// Length of array for iteration
        System.out.println("Forward:");
        firstWord(words, i, size); //Send string array and iterator to method
        size--;//reduce size to an allowable integer for index purposes
        System.out.println("Backward:");
        lastWord(words, size);//send string array and size int to method
    }
	 static void firstWord(String words[], int i, int size) {
		 if (i<size) { // less than used since length is one greater than final array position
            System.out.println("This is item number " + (i+1) +": "+words[i]); //Display array (first item first)
            i++;
            firstWord(words, i, size);//recurse!
        }
	 }
	static void lastWord(String words[], int size) {
		if (size > -1) {//want to display the 0 index
			System.out.println("This is item number " + (size+1) + ": "+words[size]);//display last item first
			size--;
			lastWord(words, size);//recurse!
		}
			
	}
}