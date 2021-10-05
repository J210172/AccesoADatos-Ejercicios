import java.util.ArrayList;
import java.util.List;

public class ListaProfesores {
	private List <Profesor> lista;

	public ListaProfesores() {
		lista = new ArrayList<>();
	}
	
	public int size() {
		return lista.size();
	}

	public List<Profesor> getLista() {
		return lista;
	}

	public void setLista(List<Profesor> lista) {
		this.lista = lista;
	}
	
}
