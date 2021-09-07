package adts;

import java.io.Serializable;

public class Queue<T> extends ListaEnlazada<T> implements Serializable{

	public T dequeue() {
		return super.popFront();
	}
	
	public void enqueue(T elemento) {
		super.pushBack(elemento);
	}
	
	
}
