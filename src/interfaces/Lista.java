package interfaces;

public interface Lista<T> {
	public boolean addFirst(T value);
	public boolean addLast(T value);
	public boolean isEmpty();
	public String printList();
	public int size();
	public boolean clear();
	public boolean remove(int index);
	public boolean remove(T value);
	public boolean removeFirst();
	public boolean removeLast();
	public Object get(int index);
	public Object get(T value);
}
