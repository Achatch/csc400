package CSC400;
public class ClothingBag<T> implements BagInterface<T>{
	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 20;

	public ClothingBag(){
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ClothingBag(int capacity) {
		T[] tempBag = (T[])new Object[DEFAULT_CAPACITY];
		bag = tempBag;
		numberOfEntries = 0;
	}
	
	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++){
			result[index] = bag[index];
			}
		
		return result;
	}
	@Override
	public boolean add(T newEntry) {
		boolean result = true;
		if (isArrayFull()){
			result = false;
		}
		else{
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
		return result;
	}
	@Override
	public int getCurrentSize() {
		return 0;
	}
	
	private boolean isArrayFull(){
		return numberOfEntries >= bag.length;
	}

}