package adts;

import java.util.Comparator;

public class BinaryHeap<T extends Comparable<T>> {

	// Un ArrayDinamico es usado para almacenar los
	// elementos del heap
	protected ArrayDinamico<T> heap;
	protected Comparator<T> comparator;

	// Se crea por defecto un Binary maxHeap
	public BinaryHeap() {
		this(true);
	}

	// Constructor que acepta un valor booleano
	// Si es true se construye un Binary MaxHeap
	// Si es false se construye un Binary MinHeap
	public BinaryHeap(boolean BuildBinaryMaxHeap) {
		heap = new ArrayDinamico<T>();
		if (BuildBinaryMaxHeap) {
			// Se instancia un comparator por orden natural
			this.comparator = new Comparator<T>() {

				public int compare(T o1, T o2) {
					return o1.compareTo(o2);
				}

			};
		} else {
			// Se instancia un comparator por orden natural negado
			// Ahora el que antes era menor es considerado mayor y
			// viceversa
			this.comparator = new Comparator<T>() {

				@Override
				public int compare(T o1, T o2) {
					return -o1.compareTo(o2);
				}

			};
		}
	}

	// Retorna el valor almacenado en la raiz del arbol
	public T peek() {
		if (!isEmpty())
			return heap.get(0);
		else
			return null;
	}

	// Extrae y retorna el valor almacenado en la raiz del arbol

	public T extract() {
		// Si el heap no tiene elementos, retornar null
		if (size() == 0)
			return null;
		
		// La variable result almacena el valor de la raiz del heap
		T result = heap.get(0);
		// Se reemplaza el valor de la raiz 
		// por el de la hoja m�s a la derecha del ultimo nivel
		heap.set(0, heap.get(size()-1));
		
		// Se elimina el elemento ubicado en la 
		// hoja m�s a la derecha del ultimo nivel
		heap.remove(size()-1);
		
		// Como segurament esa hoja posse un valor que viola
		// la propiedad del Max/Min Heap
		// Se realiza un siftDown
		siftDown(0);
		return result;
	}

	// Inserta un elemento al heap
	public void insert(T elemento) {
		// El elemento se inserta en la
		// ultima hoja disponible de izquierda a derecha
		// del ultimo nivel
		int indexToInsert = size();
		heap.set(indexToInsert, elemento);
		siftUp(indexToInsert);
	}
	
	
	// Elimina un elemento del heap, O(n)
	public boolean remove(T elemento) {
		if (elemento != null && !isEmpty()) {
			// Recorrer a traves de los elementos almacenados en el heap
			for (int i=0; i < size(); i++) {
				// Cuando el elemento a remover es encontrado dentro del heap
				if (comparator.compare(elemento, heap.get(i)) == 0) {
					// Remover el elemento en el heap con el indice
					removeAt(i);
					return true;
				}
			}
		}
		return false;
	}
	
	// Elimina un elemento del heap dado un indice
	private void removeAt(int index) {
		
		// Intercambiar el elemento por la hoja m�s a la derecha
		// del ultimo nivel
		swap(index, size()-1);
		
		// Remover dicha hoja
		heap.remove(size()-1);
		
		// Para asegurar la integridad de la propiedad del
		// Max/Min heap realizamos SiftDown 
		siftDown(index);
		
		// Si no fue necesario el SiftDown 
		// Es necesario realizar el SiftUp
		siftUp(index);
		
		
	}
	
	// Intercambio de valores hacia abajo
	// para asegurar la propiedad del Max/Min Heap
	private void siftDown(int i) {
		// el indice indexToUpdate representa el indice donde esta el elemento
		// que es maximo o minimo dependiendo si es un Max/Min Heap
		// Se evalua el padre y sus dos hijos
		int indexToUpdate = i;
		int indexLeftChild = leftChild(i);
		// Si el indice del hijo izquierdo es menor que el tama�o del heap
		// y este hace incumplir la propiedad
		if (indexLeftChild < size()
				&& comparator.compare(heap.get(indexLeftChild), heap.get(indexToUpdate)) > 0) {
			indexToUpdate = indexLeftChild;
		}
		int indexRightChild = rightChild(i);
		// Si el indice del hijo derecho es menor que el tama�o del heap
		// y este hace incumplir la propiedad
		if (indexRightChild < size()
				&& comparator.compare(heap.get(indexRightChild), heap.get(indexToUpdate)) > 0) {
			indexToUpdate = indexRightChild;
		}
		// Si el indice i es diferente al indexToUpdate
		// Significa que existe un hijo que tiene un valor
		// que incumple la propiedad del Max/Min heap
		if (i != indexToUpdate) {
			// Se intercambian los valores (el padre con uno de sus hijos)
			swap(i, indexToUpdate);
			// Se vuelve a llamar el metodo para comprobar que se asegura la propiedad del
			// Max/Min heap
			siftDown(indexToUpdate);
		}

	}

	// Intercambio de valores hacia arriba
	// para asegurar la propiedad del Max/Min Heap
	private void siftUp(int i) {
		// Mientras el indice no corresponda al de la raiz (i=0)
		// y el valor del padre no cumple la propiedad del Max/Min Heap
		while (i > 0 && comparator.compare(heap.get(parent(i)), heap.get(i)) < 0) {
			swap(parent(i), i);
			i = parent(i);
		}
	}

	// Intercambia dos valores en el heap.
	// El elemento en el index1 intercambia lugar con el elemento
	// en el index2
	private void swap(int index1, int index2) {
		T aux = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, aux);
	}

	// Retorna el indice del padre del elemento ubicado en indice i
	private int parent(int i) {
		return (i - 1) / 2;
	}

	// Retorna el indice del hijo izquierdo del elemento ubicado
	// en el indice i
	private int leftChild(int i) {
		return 2 * i + 1;
	}

	// Retorna el indice del hijo derecho del elemento ubicado
	// en el indice i
	private int rightChild(int i) {
		return 2 * i + 2;
	}

	// Retorna el numero de elementos en el heap
	private int size() {
		return heap.getNumeroElementos();
	}

	// Retorna true si el heap esta vacio
	private boolean isEmpty() {
		return this.size() == 0;
	}
}
