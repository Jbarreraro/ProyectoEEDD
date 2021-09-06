package adts;

public class MyHashMap<K, V> {

    // Arreglo de listas encadenadas (chaining)
    private ListaEnlazada<Entry<K, V>>[] hashMap;

    // Numero de entradas Key-Value en el hashMap
    private int size = 0;

    // La funcion Hash del hashmap
    private HashFunction hashFunction;

    public MyHashMap() {
        hashMap = new ListaEnlazada[2];
        hashFunction = new HashFunction();
    }

    public MyHashMap(int p) {
        hashMap = new ListaEnlazada[2];
        hashFunction = new HashFunction(p);
    }

    private class Entry<K, V> {

        // Variables de instancia
        private K key;
        private V value;

        // Constructores
        public Entry(K k, V v) {
            key = k;
            value = v;
        }

        // toString para imprimir y depurar
        public String toString() {
            return key + " = " + value;
        }
    }

    // Redimensiona el hashMap al doble de su capacidad anterior
    private void resize() {
        ListaEnlazada<Entry<K, V>>[] oldHashMap = hashMap;
        hashMap = new ListaEnlazada[size * 2];
        size = 0;
        //Se selecciona una nueva funcion hash
        hashFunction = new HashFunction();

        // Recorrer las listas enlazadas dentro del hashMap
        for (int i = 0; i < oldHashMap.length; i++) {
            if (oldHashMap[i] == null) {
                continue;
            }
            // Recorrer la lista enlazada de una posicion del hashMap
            for (int j = 0; j < oldHashMap[i].getNumeroElementos(); j++) {
                Entry<K, V> entry = oldHashMap[i].get(j);
                if (entry == null) {
                    continue;
                }
                put(entry.key, entry.value); // Mapear los nuevas entradas al hashMap redimenzionado
            }

        }
    }

    // Retorna el indice para a�adir la lista encadenada con los objetos
    // mapeados
    private int hashAndGetIndex(K key) {
        // Verificar el tipo de key
        if (key instanceof String) {
            return hashFunction.hashString((String) key) % hashMap.length;
        } else if (key instanceof Integer) {
            return hashFunction.hashInteger((Integer) key) % hashMap.length;
        }
        return key.hashCode() % hashMap.length;
    }

    // Retorna el numero de keys a�adidos
    private int size() {
        return size;
    }

    public void put(K key, V value) {

        double loadFactor = size() / hashMap.length;

        // Si el factor de carga es mayor a 0.9 se hace el resize
        if (loadFactor > 0.9) {
            resize();
        }

        // Con la funcion hash obtenemos el indice dentro del hashMap
        int index = hashAndGetIndex(key);

        if (hashMap[index] == null) {
            // Caso donde no se habia a�adido un elemento previamente
            hashMap[index] = new ListaEnlazada<Entry<K, V>>();
            hashMap[index].pushBack(new Entry(key, value));
            size++;
            return;
        } else {
            for (int i = 0; i < hashMap[index].getNumeroElementos(); i++) {
                Entry<K, V> entry = hashMap[index].get(i);
                if (entry == null) {
                    break;
                }
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
            }

        }
        // No se reemplaza simplemente se a�ade y se genera una cadena
        hashMap[index].pushBack(new Entry<K, V>(key, value));
        size++;
        return;
    }

    public V get(K key) {

        int index = hashAndGetIndex(key); // Generar el indice donde posiblemente este alamacenado la llave en el hashmap

        if (hashMap[index] == null) {
            return null; // Si esa posicion no tiene nada, entonces la llave no esta en el hashmap
        }
        for (int i = 0; i < hashMap[index].getNumeroElementos(); i++) { //Iterar a traves de las entradas de la lista
            Entry<K, V> entry = hashMap[index].get(i);
            if (entry == null) {
                return null;
            }
            if (entry.key.equals(key)) {  // Si se encuentra una entrada con la llave deseada, se retorna el valor
                return entry.value;
            }
        }

        //Si al recorrer la lista enlazada no se encuentra la key deseada, se retorna nulo 
        return null;
    }

    // retorna verdadero si el hashmap contiene el key del parametro
    public boolean containsKey(K key) {
        if (key == null) {
            return false;
        }

        int index = hashAndGetIndex(key);

        if (hashMap[index] == null) {
            return false;
        }

        for (int i = 0; i < hashMap[index].getNumeroElementos(); i++) { //Iterar a traves de las entradas de la lista
            Entry<K, V> entry = hashMap[index].get(i);
            if (entry == null) {
                return false;
            }
            if (entry.key.equals(key)) {  // Si se encuentra una entrada con la llave deseada, se retorna true
                return true;
            }
        }
        return false;
    }

    // Elimina un elemento del hashMap dado una llave
    public void remove(K key) {

        if (key == null) {
            return; //Una llave nula no se elimina
        }
        int index = hashAndGetIndex(key); // Generar el indice donde posiblemente este alamacenado la llave en el hashmap

        if (hashMap[index] == null) {
            return; // Si esa posicion no tiene nada, entonces la llave no esta en el hashmap
        }

        // Crando el Entry donde se mantendra la entrada a remover
        Entry< K, V> toRemove = null;

        // Iterar a traves de las entradas de la lista localizada en el indice encontrado del hashmap
        for (int i = 0; i < hashMap[index].getNumeroElementos(); i++) {
            Entry<K, V> entry = hashMap[index].get(i);
            if (entry == null) {
                break;
            }
            if (entry.key.equals(key)) {  // Si se encuentra una entrada con la llave deseada, guardamos la entrada a remover
                toRemove = entry;
                break;                    // No seguimos buscando, porque las llaves son unicas
            }
        }

        if (toRemove == null) {
            return; //Si la entrada es nula, significa que no existe una llave en el hashMap con la Key especificada
        }
        hashMap[index].remove(toRemove); //Removemos la entrada de la lista enlazada ubicada en un indice del hashMap
        size--; // Disminuye el n�mero de entradas en el hashMap
    }

}
