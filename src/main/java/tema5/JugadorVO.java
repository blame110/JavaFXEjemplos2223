package tema5;

public class JugadorVO {

	private int id;
	private String nombre;
	private int edad;
	private int altura;
	private String sexo;

	public JugadorVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JugadorVO(int id, String nombre, int edad, int altura, String sexo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "JugadorVO [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", altura=" + altura + ", sexo=" + sexo
				+ "]";
	}

}
