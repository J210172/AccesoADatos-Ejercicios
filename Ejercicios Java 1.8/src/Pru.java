import java.util.ArrayList;
import java.util.Scanner;

public class Pru {
	static ArrayList<Integer> numeros;

	public static void main(String args[]) {
		
//		long time = System.nanoTime();
//		boolean[] b = new boolean[100000000];
//		for (int i = 0; i < b.length; i++) {
//			b[i] = true;
//		}
//
//		b[0] = false;
//		b[1] = false;
//
//		for (int i = 2; i < b.length; i++) {
//			if (b[i]) {
//				for (int j = i * 2; j < b.length; j = j + i) {
//					b[j] = false;
//				}
//			}
//		}
//		time = System.nanoTime() - time;
//		
//		for (int i = 0; i < 100; i++) {
//			if (b[i]) {
//				System.out.println(i);
//			}
//		}
//		System.out.println(String.format("Tiempo: %f", ((double) time / 1000000000)));
		
		numeros = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		System.out.print("Posicion: ");
		int pos = scan.nextInt();
		long time = System.nanoTime();
		System.out.println(get_prime3(pos));
		System.out.println(String.format("Tiempo: %f", ((double) System.nanoTime() - time) / 1000000000));
	}

	public static int get_prime3(int pos) {
		boolean[] b = new boolean[1000000000];
		for (int i = 0; i < b.length; i++) {
			b[i] = true;
		}

		b[0] = false;
		b[1] = false;

		for (int i = 2; i < Math.sqrt(b.length); i++) {
			if (b[i]) {
				for (int j = i * i; j < b.length; j = j + i) {
					b[j] = false;
				}
			}
		}

		for (int i = 0; i < b.length; i++) {
			if (b[i]) {
				numeros.add(i);
			}
		}
		return numeros.get(pos-1);
//		int res = 0, aux = 0;
//		for (int i = 2; i < b.length; i++)  {
//			if (b[i]) {
//				aux++;
//			}
//			if (aux == pos) {
//				res = i;
//				break;
//			}
//		}
//		return res;
	}
}