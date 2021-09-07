package adts;

import java.io.Serializable;
import java.util.Random;

public class HashFunction implements Serializable{

	// Numero primo usado para la funcion hash polinomial
	private int p;
	// Parametro x, 1<= x <= p - 1
	private long x;
	// Parametro a, 1<= a <= p - 1
	private long a;
	// Parametro b, 0<= b <= p - 1
	private long b;

	public HashFunction() {
		p = 1000003;
		x = new Random().nextInt(p - 1) + 1;
		a = new Random().nextInt(p - 1) + 1;
		b = new Random().nextInt(p);
	}

	public HashFunction(int p) {
		this.p = p;
		x = new Random().nextInt(p - 1) + 1;
		a = new Random().nextInt(p - 1) + 1;
		b = new Random().nextInt(p);
	}

	// Hash de Integer
	public int hashInteger(int i) {
		return (int) ((a * i + b) % p);
	}

	// hash de Strings
	public int hashString(String s) {
		return hashInteger(polyHash(s)); 
	}

	// Se usa hasheo polinomial para cadenas String
	private int polyHash(String s) {
		long hash = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int number = Integer.valueOf(s.charAt(i));
			hash = (hash * x + number);
			hash = hash % p;
		}
		return (int)hash;
	}

	public long getx() {
		return this.x;
	}
	
	public long geta() {
		return this.a;
	}
	
	public long getb() {
		return this.b;
	}
	
}
