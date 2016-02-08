package voters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voter {
	
	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private int nif;
	private long cp;
	
	@ManyToOne
	private Census census;
	
	
	public Voter() {}
	
	public Voter(String email, int nif, long cp){
		this.email = email;
		this.nif = nif;
		this.cp = cp;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCp() {
		return cp;
	}

	public void setCp(long cp) {
		this.cp = cp;
	}

	public int getNif() {
		return nif;
	}
	
	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Voter [email=" + email + ", nif=" + nif + ", cp=" + cp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nif;
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voter other = (Voter) obj;
		if (nif != other.nif)
			return false;
		return true;
	}
	
	
	

}
