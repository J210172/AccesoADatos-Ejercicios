import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.json.AbstractJsonWriter.Type;

public class Ejercicios {

	public static void main(String[] args) {
		ejer6("patata");
		
	}

	public static void ejem(String[] args) {
		System.out.println("Numero de elementos: " + args.length);
		for (String st : args) {
			System.out.println(st);
		}
	}

	/**
	 * <h3>UD2.1</h3>
	 * 
	 * <pre>
	 * Realiza una clase UD2_1 que muestre nombre, longitud, si se puede leer, si se
	 * puede escribir de todos los archivos ocultos de la carpeta Windows de tu
	 * disco; sólo de los que se encuentran en la carpeta principal de Windows, no
	 * en sus subcarpetas.
	 * 
	 * <pre>
	 * 
	 * @param
	 */
	public static void ejer1() {
		File file = new File("C:\\Windows");
		for (File f : file.listFiles()) {
			if (f.isHidden()) {
				System.out.println("Nombre: " + f.getName());
				System.out.println("Tamaño: " + f.length());
				System.out.println("Lectura: " + f.canRead());
				System.out.println("Escritura: " + f.canWrite());
				System.out.println();
			}
		}
	}

	/**
	 * <h3>UD2.2</h3>
	 * 
	 * <pre>
	 * Realiza una clase UD2_2 cuyo método principal reciba como argumento una
	 * cadena con la trayectoria de un directorio o fichero e indique si existe
	 * realmente o no dicho directorio o fichero. Si el método principal no recibe
	 * ningún argumento se indicará por pantalla y finalizará su ejecución.
	 * 
	 * <pre>
	 * 
	 * @param
	 */
	public static void ejer2(String[] args) {
		if (args.length > 0) {
			File file = new File(args[0]);
			if (file.exists()) {
				System.out.println("El archivo + " + file.getName() + " existe");
			}
		} else {
			System.out.println("El archivo no existe");
		}
	}

	/**
	 * <h3>UD2.3</h3>
	 * 
	 * <pre>
	 * Realiza una clase UD2_3 que complete la clase EjemploClaseFile02 de los
	 * materiales borrando el directorio y el fichero creados en ella (primero borra
	 * el fichero y después el directorio pues no se permite borrar directorios no
	 * vacíos).
	 * 
	 * <pre>
	 * 
	 * @param
	 */
	public static void ejer3_1() {
		try {
			File file = new File("C:\\DAW2");
			if (file.mkdirs()) {
				System.out.println("Se ha creado la ruta " + file.getAbsolutePath());
			} else {
				System.out.println(String.format("La ruta %s ya exsiste", file.getAbsolutePath()));
			}

			file = new File(file.getAbsolutePath() + "\\alberto.txt");
			if (file.createNewFile()) {
				System.out.println("Se ha creado el archivo " + file.getAbsolutePath());
			} else {
				System.out.println(String.format("el archivo %s ya exsiste", file.getAbsolutePath()));
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void ejer3_2() {

		File file = new File("C:\\DAW2");
		for (File f : file.listFiles()) {
			f.delete();
		}
		file.delete();

	}

	public static void ejer4() {
		File file = new File("C:\\DAW2");
		if (file.mkdirs()) {
			System.out.println("Se ha creado la ruta " + file.getAbsolutePath());
		} else {
			System.out.println(String.format("La ruta %s ya exsiste", file.getAbsolutePath()));
		}

		file = new File(file.getAbsolutePath() + "\\pares.txt");
		try {
			for (int i = 1; !file.createNewFile(); i++) {
				file.renameTo(new File(file.getParentFile() + "\\pares (" + i + ").txt"));
			}
			System.out.println("Se ha creado el archivo " + file.getAbsolutePath());
			FileWriter fileWriter = new FileWriter(file, false);
			for (int i = 0; i <= 500; i++) {
				fileWriter.write(i + "\n");
			}
			fileWriter.close();
			FileReader fileReader = new FileReader(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ejer6(String word) {
		try {
			FileInputStream fis = new FileInputStream("C:\\DAW2\\Test.txt");
			int aux, i = 0, nrep = 0;
			char str[] = word.toLowerCase().toCharArray();
			while ((aux = fis.read()) >= 0) {
				if (i == str.length) {
					nrep++;
					i = 0;
				} else if ((aux < 'a' ? (char)(aux+32): (char)aux) == str[i]) { //Character.toLowerCase()
					i++;
				} else {
					i = 0;
				}
//				System.out.print((char)aux);
			}
			System.out.println("\nLa palabra: \"" + word + "\" se ha repetido: " + nrep + " veces");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void ejer7() {
		int[] nums = new int[5];
		for (int i = 0; i < 20; i++) {
			int num = (int) (Math.random() * 5 + 1);
			System.out.print(num + " ");
			nums[num - 1]++;
		}
		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			System.out.println("Numero " + (i + 1) + ": " + nums[i] + (nums[i] != 1 ? " veces" : " vez"));
		}
	}

	public static void ejer8() {
		Profesor[] profesores = new Profesor[4];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < profesores.length; i++) {
			System.out.print("Introduce el nombre: ");
			String nombre = scan.nextLine();
			System.out.print("Introduce la edad: ");
			profesores[i] = new Profesor(scan.nextInt(), nombre);
			scan.nextLine();
		}
		scan.close();
		try {
			ObjectOutputStream oos;
			File file = new File("C:\\DAW2\\pares.txt");
			if (file.exists()) {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				for (Profesor p : profesores) {
					oos.writeObject(p);
				} 
				oos.close();
				System.out.println("\nArchivo Escrito");
			} else {
				System.err.println("El archivo no existe");
			}
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		
			Object temp;
			
			while ((temp = ois.readObject()) != null) {
				if (temp instanceof Profesor) {
					System.out.println(((Profesor) temp).toString());
				}
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	
	public static void json1() {
		BufferedReader jsonF;
		try {
			jsonF = new BufferedReader(new FileReader("C:\\DAW2\\MOCK_DATA.json"));
			Gson gson = new Gson();
			gson.toJson("penepito");
			String json="", line;
			while ((line = jsonF.readLine()) != null) {
				json+=line;
			}
			Type collectionType = new TypeToken<Collection<Integer>>(){}.getType();
			Collection<Integer> ints2 = gson.fromJson(json, collectionType);
			for (Integer integer : ints2) {
				System.out.println(integer );
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
