package pru;

public class Pru1 {
	static int i = 0;
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {System.out.println(getName());}
		}.run();
		if (i++ < 100) {
			main(null);

		}
	}
}
