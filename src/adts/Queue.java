package adts;

public class Queue<T> extends ListaEnlazada<T>{

	public T dequeue() {
		return super.popFront();
	}
	
	public void enqueue(T elemento) {
		super.pushBack(elemento);
	}
	
	
}
