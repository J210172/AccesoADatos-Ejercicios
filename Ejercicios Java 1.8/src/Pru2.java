import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.*;

public class Pru2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ArrayList<Profesor> profesores = new ArrayList<>();
//		profesores.add(new Profesor("Alberto Carera", 10, 29.5, 
//				new String[] { "Acceso a datos", "Progranscidel" }
//		));
//		profesores.add(new Profesor("Antonino Lasierra", 20, 38.5, 
//				new String[] { "Acceso a datos", "Progranscidel" }
//		));
//		profesores.add(new Profesor("Beign Carrera", 49, 22,
//				new String[] { "Progrmacion y Orientacion laboral", "Empress e iniciativa emprendedorel" }
//		));
//		profesores.add(new Profesor("Luis AM.", 18, 9, 
//				new String[] { "Ingles I", "Ingles II", "Informatica (SO)" }
//		));
		String[] po = {"pew", "paw"};
		profesores.add(new Profesor("pepe", 23, 21.4, po));
		try {
			XStream xstream = new XStream(new DomDriver("UTF-8"));
			xstream.alias("ProfesoresCPSierradeguara", ArrayList.class);
			xstream.alias("Profesor", Profesor.class);
//			xstream.addImplicitCollection(ArrayList.class, profesores); 
			xstream.toXML(profesores, new FileOutputStream("C:\\DAW2\\goars.xml"));
			System.out.println("Creado fichero %Mt....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

