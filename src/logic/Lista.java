package logic;

public interface Lista<T> {
    
    
    void pushBack(T elemento);
    T popBack();
    boolean estaVacio();
    boolean search(T elemento);
    
    
}
