import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.*;

public class Pru2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		toxml();
		fromxml();
		togson();
		fromgson();
		
	}


	private static void togson() {
		try {

			List<Profesor> profesores = Arrays.asList(
			new Profesor("Alberto Carrera", 10, 29.5, new String[]{"Acceso a datos", "Programación"}),
			new Profesor("Antonino Lasierra", 20, 38.5, null),
			new Profesor ("Belén Carrera", 49, 22, new String[]{"Formacién y Orientación Laboral", "Empresa e iniciativa emprendedora"}),
			new Profesor ("Luis Aldea", 10, 9, new String[]{"Inglés I", "Inglés II, Informatica ESO"})
			);

			FileWriter fw = new FileWriter("C:\\DAW2\\goars.json");
			new Gson().toJson(profesores, fw);
			fw.close();

			} catch (Exception ex) {
			ex.printStackTrace();
			}
	}

	private static void fromgson() {
		try {
			Gson gson = new Gson();
			String sFichero = new String(Files.readAllBytes(Paths.get("C:\\DAW2\\goars.json")));
			List<Profesor> profesores = Arrays.asList(gson.fromJson(sFichero, Profesor[].class));
			for (Profesor p : profesores)

				System.out.println(p);

			// Las dos linas anteriores equivalen a --> profesores.forEach(System.out:
			// :println);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void toxml() {
		ArrayList<Profesor> profesores = new ArrayList<>();
		profesores.add(new Profesor("Alberto Carera", 10, 29.5, new String[] { "Acceso a datos", "Progranscidel" }));
		profesores.add(new Profesor("Antonino Lasierra", 20, 38.5, new String[] { "Acceso a datos", "Progranscidel" }));
		profesores.add(new Profesor("Beign Carrera", 49, 22,
				new String[] { "Progrmacion y Orientacion laboral", "Empress e iniciativa emprendedorel" }));
		profesores.add(new Profesor("Luis AM.", 18, 9, new String[] { "Ingles I", "Ingles II", "Informatica (SO)" }));
		String[] po = { "pew", "paw" };
		profesores.add(new Profesor("pepe", 23, 21.4, po));
		try {
			XStream xstream = new XStream(new DomDriver("UTF-8"));
			xstream.alias("ProfesoresCPSierradeguara", ArrayList.class);
			xstream.alias("Profesor", Profesor.class);
//			xstream.addImplicitCollection(ListaProfesores.class, profesores); 
			xstream.toXML(profesores, new FileOutputStream("C:\\DAW2\\goars.xml"));
			System.out.println("Creado fichero %Mt....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void fromxml() throws IOException {
		XStream xstream = new XStream();
		xstream.alias("ProfesoresFPSierradeGuara", ListaProfesores.class);
		xstream.alias("Profesor", Profesor.class);
		xstream.addImplicitCollection(ListaProfesores.class, "lista");

		ListaProfesores listadoTodos = (ListaProfesores) xstream.fromXML(new FileInputStream("C:\\DAW2\\goars.xml"));
		System.out.println("Ndmero de Profesores: " + listadoTodos.size());
		
		for (Profesor p : listadoTodos.getLista()) {
			System.out.println(p);
		}
		System.out.println("Fin del listado....");
	}

}
