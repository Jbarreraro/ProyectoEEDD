package logic;

public interface Pila<T> {
    
    
    void apilar(T elemento);
    T desapilar();
    boolean estaVacio();
    
    
}
