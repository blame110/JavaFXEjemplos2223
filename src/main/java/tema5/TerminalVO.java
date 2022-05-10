package tema5;

public class TerminalVO {
	
	private int id;
	private String brand;
	private String model;
	private int ram;
	private int rom;
	private String so;
	private String inches;
	private double price;
	private boolean is5g;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	public int getRam() {
		return ram;
	}
	
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	public int getRom() {
		return rom;
	}
	
	public void setRom(int rom) {
		this.rom = rom;
	}
	
	
	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}


	public String getInches() {
		return inches;
	}
	
	public void setInches(String inches) {
		this.inches = inches;
	}
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean isIs5g() {
		return is5g;
	}
	
	public void setIs5g(boolean is5g) {
		this.is5g = is5g;
	}
	
	public TerminalVO(int id, String brand, String model, int ram, int rom, String inches, double price, boolean is5g) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.ram = ram;
		this.rom = rom;
		this.inches = inches;
		this.price = price;
		this.is5g = is5g;
	}
	
	public TerminalVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return  id + " " + brand + " " + model + " " + ram + " " + rom	+ " " + inches + " " + price + " " + is5g ;
	}
	
	
	

}
