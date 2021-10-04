import java.io.Serializable;
import java.util.Arrays;

class Profesor implements Serializable {
	private String nombre;
	private int departamento;
	private double antiguedad;
	private String[] asignaturas;

	public Profesor(String nombre, int departamento, double antiguedad, String[] asignaturas) {
		this.nombre = nombre;
		this.departamento = departamento;
		this.antiguedad = antiguedad;
		this.asignaturas = asignaturas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public double getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(double antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String[] getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(String[] asignaturas) {
		this.asignaturas = asignaturas;
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", departamento=" + departamento + ", antiguedad=" + antiguedad
				+ ", asignaturas=" + Arrays.toString(asignaturas) + "]";
	}

}