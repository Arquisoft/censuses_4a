package asw.censuses_4a.voters;

import javax.persistence.*;

@Entity
public class Voter {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String email;
	private String nif;
	private int code;
	
	public Voter() {}
	
	public Voter (String name, int code){
		
		this.name = name;
		this.code = code;
	}
	
	
	public String getName() {
		return name;
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

	public String getNif() {
		return nif;
	}

	@Override
	public String toString() {
		return "Voter [name=" + name + ", nif=" + nif + ", ccode=" + code + "]";
	}

	
	

}
