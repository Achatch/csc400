package CSC400;

public interface BagInterface<T>{
	public int getCurrentSize();
	public boolean add(T newEntry);
	public T[] toArray();
}