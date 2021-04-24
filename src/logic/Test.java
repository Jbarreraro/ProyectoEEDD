package logic;

public class Test {

    public static void main(String[] args) {

        ListaEnlazada<Integer> l = new ListaEnlazada<>();

        for (int i = 0; i < 9; i++) {
            l.pushBack(i);
        }
        l.imprimir();
        l.remove(1);
        System.out.println("");
        l.imprimir();
        l.remove(2);
        System.out.println("");
        l.imprimir();
        l.remove(7);
        System.out.println("");
        l.imprimir();
        l.remove(3);
        System.out.println("");
        l.imprimir();
    }
}
