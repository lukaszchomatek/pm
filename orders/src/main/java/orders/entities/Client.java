package orders.entities;

public class Client {
	private String name;
	private String surname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Client() {
		
	}
	
	public Client(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	@Override
	public boolean equals(Object o) {
		Client other = (Client)o;
		if ((other.name.equals(this.name)) &&
			(other.surname.equals(this.surname))) {
			return true;
		}
		return false;
	}
}
