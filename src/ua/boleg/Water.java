package ua.boleg;

/**
 * 
 * Послуга string - спожито у минулому місяці int - спожито int - 	ціна double - результат double
 * get_name			set\get_last					get_present		set\get_prie		get_result
 * 
 * @author cmd
 *
 */
public class Water implements Service {
	private double price;
	private double value = 0;
	private int id = 1;
	private String name = "Water";

	// Construtors for class
	Water(double price) {
		this.price = price;
	}
	
	public Water(int value) {
		this.value = (double)value;
		
	}
	Water( double price, int value) {
		this.value = (double)value;
		this.price = price;
		
	}
	// implements of Service
	public double getPrice() { return price; }
	public double getValue() { return value; }
	public String getName() { return name; }
	public int getId() { return id; }
	
	// получаем конечноe значение. задолженость
	public double getResult() {
		getCalc();
		return value;
	}

	
	@Override
	public void setPrice(double price) {
		this.price = price;
	}
	
	// высчитываем сумму по воде
	private double getCalc() {
		return value *= price;
	}


	
}
