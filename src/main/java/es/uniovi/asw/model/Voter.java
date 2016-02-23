package es.uniovi.asw.model;

import javax.persistence.*;

@Entity
public class Voter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private String email;
	private String nif;
	private int code;
	private String password;
	
	protected Voter() {}
	
	public Voter (String name, String nif, int code, String email){
		
		this.name = name;
		this.nif = nif;
		this.code = code;
		this.email = email;
	}
	
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCp(int code) {
		this.code = code;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNif() {
		return nif;
	}

	@Override
	public String toString() {
		return "Voter [name=" + name + ", nif=" + nif + ", ccode=" + code + "]";
	}

	

	
	

}
