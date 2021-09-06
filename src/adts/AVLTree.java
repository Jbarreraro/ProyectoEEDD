package adts;

import java.util.Comparator;


import java.lang.Math;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

	public AVLTree() {
		super();
	}
	
	public AVLTree(Comparator<T> comparator) {
		super(comparator);
	}

	@Override
	public void insert(T key) {
		// Se inserta el nodo con el key pasado como parametro
		// usando el metodo insert del bst
		super.insert(key);
		// Se encuentra la referencia del nodo agregado con el
		// metodo find
		Nodo<T> nodo = find(key);

		// Si el nodo encontrado es el root, no es necesario rebalancear
		if (nodo != root)
			rebalance(nodo);
	}

	@Override
	public boolean delete(T key) {
		// Verficar que existe un nodo en el arbol con una key igual al key del
		// parametro
		Nodo<T> nodoFinded = findToDelete(key, root);
		if (nodoFinded.key.equals(key)) {
			//Se elimina el nodo en el arbol y se retorna su referencia
			//Se debe tener cuidado con el null si se elimin� el root o es este mismo
			Nodo<T> NodeRemoved = super.delete(nodoFinded);
			Nodo<T> parentNodeRemoved = (NodeRemoved == root) ? null: NodeRemoved.parent;
			// Se llama el metodo de rebalance(padre del nodo eliminado)
			if (parentNodeRemoved != null)
				rebalance(parentNodeRemoved);
			return true;
		} 
		return false;
	}

	// Este metodo se encarga de mantener el arbol balanceado
	// Se asegura que se cumpla la propiedad para cualquier nodo:
	// |nodo.left.height - nodo.right.height| <= 1

	private void rebalance(Nodo<T> nodo) {
		Nodo<T> nodoParent = nodo.parent;

		if (!isLeafNode(nodo)) {

			int heightNodeLeft = nodo.left == null ? 0 : nodo.left.height;
			int heightNodeRight = nodo.right == null ? 0 : nodo.right.height;

			// Caso: Subarbolizquierdo posee una altura que excede
			// en m�s de 1 a la del subarbolDerecho
			if (heightNodeLeft > heightNodeRight + 1)
				rebalanceRight(nodo);

			// Caso: Subarbolderecho posse una altura que excede
			// en m�s de 1 a la del subarbolDerecho
			if (heightNodeRight > heightNodeLeft + 1)
				rebalanceLeft(nodo);
		}
		adjustHeight(nodo);

		if (nodoParent != null)
			rebalance(nodoParent);
	}

	private void rebalanceRight(Nodo<T> nodo) {
		// Si el subarbol izquierdo es el mas pesado
		// existen dos posibles casos: Left left case y Left right case
		Nodo<T> nodoSubIzq = nodo.left;
		int heightNodoLeftSubIzq = nodoSubIzq.left == null ? 0 : nodoSubIzq.left.height;
		int heightNodoRightSubIzq = nodoSubIzq.right == null ? 0 : nodoSubIzq.right.height;
		// Left right case
		if (heightNodoRightSubIzq > heightNodoLeftSubIzq) {
			leftRotate(nodoSubIzq);
			adjustHeight(nodoSubIzq);
			adjustHeight(nodoSubIzq.parent);
		}
		// Left left case
		rightRotate(nodo);
		adjustHeight(nodo);

	}

	private void rebalanceLeft(Nodo<T> nodo) {
		// Si el subarbol derecho es el mas pesado
		// existen dos posibles casos: Right Right case y Right Left case
		Nodo<T> nodoSubDre = nodo.right;
		int heightNodoLeftSubDre = nodoSubDre.left == null ? 0 : nodoSubDre.left.height;
		int heightNodoRightSubDre = nodoSubDre.right == null ? 0 : nodoSubDre.right.height;
		// Right Left case
		if (heightNodoLeftSubDre > heightNodoRightSubDre) {
			rightRotate(nodoSubDre);
			adjustHeight(nodoSubDre);
			adjustHeight(nodoSubDre.parent);
		}
		// Right Right case
		leftRotate(nodo);
		adjustHeight(nodo);
	}

	private void adjustHeight(Nodo<T> nodo) {
		int heightNodeLeft = nodo.left == null ? 0 : nodo.left.height;
		int heightNodeRight = nodo.right == null ? 0 : nodo.right.height;
		nodo.height = 1 + (int) Math.max(heightNodeLeft, heightNodeRight);

	}

	private void leftRotate(Nodo<T> nodo) {
		Nodo<T> auxRight = nodo.right;
		auxRight.parent = nodo.parent;
		nodo.parent = auxRight;
		nodo.right = auxRight.left;
		if (auxRight.left != null)
			auxRight.left.parent = nodo;
		auxRight.left = nodo;
		if (auxRight.parent != null) // right
			if (auxRight.parent.right != null && comparator.compare(nodo.key, auxRight.parent.right.key) == 0)
				auxRight.parent.right = auxRight;
			else
				auxRight.parent.left = auxRight;
		if (nodo == root)
			root = auxRight;

	}

	private void rightRotate(Nodo<T> nodo) {
		Nodo<T> auxLeft = nodo.left;
		auxLeft.parent = nodo.parent;
		nodo.parent = auxLeft;
		nodo.left = auxLeft.right;
		if (auxLeft.right != null)
			auxLeft.right.parent = nodo;
		auxLeft.right = nodo;
		if (auxLeft.parent != null)
			// posicion del subarbol desbalanceado con respecto al padre
			if (auxLeft.parent.right != null && comparator.compare(nodo.key, auxLeft.parent.right.key) == 0)
				auxLeft.parent.right = auxLeft;
			else
				auxLeft.parent.left = auxLeft;
		if (nodo == root)
			root = auxLeft;

	}

}
