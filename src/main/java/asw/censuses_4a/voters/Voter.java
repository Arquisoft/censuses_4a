package asw.censuses_4a.voters;

import javax.persistence.*;

@Entity
public class Voter {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String nif;
	private String cp;
	
	public Voter() {}
	
	public Voter (String name, String cp){
		
		this.name = name;
		this.cp = cp;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getNif() {
		return nif;
	}

	@Override
	public String toString() {
		return "Voter [name=" + name + ", nif=" + nif + ", cp=" + cp + "]";
	}

	
	

}
