package adts;

import java.util.Comparator;

public class BinarySearchTree<T extends Comparable<T>> {

	protected Nodo<T> root;
	// Un comparator es usado para personalizar el criterio de ordenamiento
	protected Comparator<T> comparator;
	
	//Si se llama el constructor vacio, se utiliza el orden
	//natural del tipo especificiado en la instancia
	
	public BinarySearchTree() {
		this.root = null;
		this.comparator = new Comparator<T>() {

			@Override
			public int compare(T o1, T o2) {
				return o1.compareTo(o2);
			}
			
		};
	}
	
	
	public BinarySearchTree(Comparator<T> comparator) {
		this.root = null;
		this.comparator = comparator;
	}

	protected class Nodo<T> {

		protected Nodo<T> parent, left, right;
		protected T key;
		protected int height;
		
		@Override
		public String toString() {
			return key.toString();
		}

	}

	protected boolean isLeafNode(Nodo<T> nodo) {
		if (nodo.left == null && nodo.right == null)
			return true;
		return false;
	}
	
	
	// Retorna el valor maximo almacenado en el arbol
	public T getMax() {
		return getMax(root);
	}
	
	// Retorna el valor minimo almacenado en el arbol
	public T getMin() {
		return getMin(root);
	}
	
	private T getMin(Nodo<T> nodo) {
		if (nodo.left != null)
			return getMin(nodo.left);
		return nodo.key;
	}
	
	private T getMax(Nodo<T> nodo) {
		if (nodo.right != null)
			return getMax(nodo.right);
		return nodo.key;
	}
	

	// Este metodo retorna la referencia del nodo que contiene el valor del key.
	// si el key no esta en el arbol, retorna la referencia de un nodo
	// que actuaria como padre si se a�adiera un nodo con el valor del key

	public Nodo<T> find(T key) {
		return find(key, root);
	}
	
	protected Nodo<T> findToDelete(T key, Nodo<T> nodo) {
		
		
		int resultComparator = comparator.compare(nodo.key, key);
		
		if (resultComparator == 0) {
			return nodo;
		}
		
		if (resultComparator > 0) {
			if (nodo.left != null)
				return findToDelete(key, nodo.left);
			return nodo;
		}

		// Si el nodo actual posee un key con un valor menor o igual al key pasado como
		// parametro
		// Se va buscando un nodo hacia la derecha,
		// caso: comparator.compare(nodo.key,key) <= 0

		else {
			if (nodo.right != null)
				return findToDelete(key, nodo.right);
			return nodo;
		}
		
	}

	private Nodo<T> find(T key, Nodo<T> nodo) {

		int resultComparator = comparator.compare(nodo.key, key);

		// Caso donde se encuetra un nodo que contiene el valor del key
		// se va buscando un nodo hacia la derecha (posibles valores duplicados)
		if (resultComparator == 0) {
			if (nodo.right != null) 
				return find(key, nodo.right);
			return nodo;
		}
		 
		// Si el nodo actual posee un key con un valor mayor al key pasado como
		// parametro
		// Se va buscando un nodo hacia la izquierda

		if (resultComparator > 0) {
			if (nodo.left != null)
				return find(key, nodo.left);
			return nodo;
		}

		// Si el nodo actual posee un key con un valor menor o igual al key pasado como
		// parametro
		// Se va buscando un nodo hacia la derecha,
		// caso: comparator.compare(nodo.key,key) <= 0

		else {
			if (nodo.right != null)
				return find(key, nodo.right);
			return nodo;
		}

	}

	// Retorna el nodo que contiene el key con el siguiente valor
	// mas grande en el arbol con respecto al nodo pasado como
	// parametro

	private Nodo<T> next(Nodo<T> nodo) {

		if (nodo.right != null)
			return leftDescendant(nodo.right);

		return rightDescendant(nodo);
	}

	// Encontrar el nodo con el key menor en el subarbol derecho
	private Nodo<T> leftDescendant(Nodo<T> nodo) {
		if (nodo.left == null)
			return nodo;
		return leftDescendant(nodo.left);
	}

	// Encuentra el ancestro del nodo para el cual
	// el haga parte de su subarbol izquierdo
	private Nodo<T> rightDescendant(Nodo<T> nodo) {

		// si el nodo evaluado es el que contiene el key mayor en el arbol entonces no
		// habra un nodo ancestro
		// entonces puede llegar hasta el nodo root y su ancentro es null
		if (nodo == null || nodo == root.right)
			return null;

		if (comparator.compare(nodo.key, nodo.parent.key) < 0)
			return nodo.parent;

		return rightDescendant(nodo.parent);
	}

	// Este metodo regresa los nodos que contienen keys con valores
	// entre [x - y] incluyendolos
	public ArrayDinamico<Nodo<T>> rangeSearch(T x, T y) {
		ArrayDinamico<Nodo<T>> list = new ArrayDinamico<Nodo<T>>(16);
		Nodo<T> NodoinTree = find(x, root);

		// Mientras el valor del nodo sea menor o igual al valor de y
		while (NodoinTree != null && comparator.compare(NodoinTree.key, y) <= 0) {

			// Si el valor del nodo es mayor o igual al valor de x
			if (comparator.compare(NodoinTree.key, x) >= 0)
				list.pushBack(NodoinTree);
			NodoinTree = next(NodoinTree);

		}
		return list;
	}

	// Metodo para insertar el nodo en el arbol
	public void insert(T key) {

		Nodo<T> newNodo = new Nodo<T>();
		newNodo.key = key;

		if (root == null) {
			root = newNodo;
		} else {

			Nodo<T> nodo = find(key, root);

			int resultComparator = comparator.compare(nodo.key, key);
			
			// El nodo a insertar posee una valor evaluado
			// igual al del padre, por convencion se inserta a la derecha
			if (resultComparator == 0) {
				//nodo.arr = new ArrayDinamico<T>(16);
				//nodo.arr.pushBack(key);
				newNodo.parent = nodo;
				nodo.right = newNodo;
			}
			// Insertar como hijo izquierdo el nuevo nodo con el key pasado
			// como parametro
			else if (resultComparator > 0) {
				newNodo.parent = nodo;
				nodo.left = newNodo;
				// Insertar como hijo derecho el nuevo nodo con el key pasado
				// como parametro.
				// caso resultComparator < 0
			} else {
				newNodo.parent = nodo;
				nodo.right = newNodo;
			}
		}
	}

	private boolean isLeftChild(Nodo<T> nodo) {
		return comparator.compare(nodo.key, nodo.parent.key) < 0;
	}

	// Metodo para eliminar un nodo del arbol y mantene la invariante del bst

	public boolean delete(T key) {
		// Verficar que existe un nodo en el arbol con una key igual al key del
		// parametro
		Nodo<T> nodoFinded = findToDelete(key, root);
		if (nodoFinded.key.equals(key)) {
			delete(nodoFinded);
			return true;
		}
		else
			return false;
	}

	// Este metodo elimina el nodo del arbol con el key especificado
	// Y retorna su referencia

	protected Nodo<T> delete(Nodo<T> nodo) {

		// Existen 3 casos al remover el nodo

		// caso1: El nodo a remover es una hoja
		if (nodo.left == null && nodo.right == null) {

			// Si el nodo es la raiz
			if (nodo == root) {
				root = null;

			} else {

				// Verificar si es hijo derecho o izquierdo

				// Es hijo izquierdo
				if (isLeftChild(nodo))
					nodo.parent.left = null;
				// Es hijo derecho
				else
					nodo.parent.right = null;

			}
		}
		// caso2: El nodo a remover tiene un unico hijo (Izquierdo o(Exclusiva) Derecho)

		// tiene al hijo izquierdo unicamente
		else if (nodo.right == null) {

			if (nodo == root) {
				root = root.left;
				root.parent = null;
			} else {
				// Verificar si es hijo derecho o izquierdo

				// Es hijo izquierdo
				if (isLeftChild(nodo))
					nodo.parent.left = nodo.left;
				// Es hijo derecho
				else
					nodo.parent.right = nodo.left;
				
			//Actualizar padre al hijo izquierdo del nodo a remover
			nodo.left.parent = nodo.parent;
			}
		// tiene al hijo derecho unicamente
		} else if (nodo.left == null) {

			if (nodo == root) {
				root = root.right;
				root.parent = null;
			}
			// Verificar si es hijo derecho o izquierdo

			// Es hijo izquierdo
			if (isLeftChild(nodo))
				nodo.parent.left = nodo.right;
			// Es hijo derecho
			else
				nodo.parent.right = nodo.right;
			
			//Actualizar padre al hijo derecho del nodo a remover
			nodo.right.parent = nodo.parent;
		// caso3: El nodo a remover tiene ambos hijos
		// se reemplaza el key del nodo que se quiere remover
		// por el key del nodo con menor valor en su subarbol derecho
		// Luego, este se elimina
		} else {

			Nodo<T> smallestNodeRigthSubTree = leftDescendant(nodo.right);
			T aux = smallestNodeRigthSubTree.key;
			delete(smallestNodeRigthSubTree);
			nodo.key = aux;
			return smallestNodeRigthSubTree;
		}

		return nodo;

	}

	// Metodo publico
	public void inOrderTraversal() {
		inOrderTraversal(root);
		System.out.println();
	}

	// Metodo privado con nodos
	private void inOrderTraversal(Nodo<T> nodo) {
		if (nodo != null) {
			inOrderTraversal(nodo.left);
			System.out.print(nodo.key + " ");
			inOrderTraversal(nodo.right);
		}
	}

	public void levelTransversal() {
		levelTransversal(root);
		System.out.println();
	}

	private void levelTransversal(Nodo<T> root) {
		if (root == null)
			return;
		Queue<Nodo<T>> queue = new Queue<Nodo<T>>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			Nodo<T> nodo = queue.dequeue();
			System.out.print(nodo.key + " ");
			if (nodo.left != null)
				queue.enqueue(nodo.left);
			if (nodo.right != null)
				queue.enqueue(nodo.right);
		}
	}
}
