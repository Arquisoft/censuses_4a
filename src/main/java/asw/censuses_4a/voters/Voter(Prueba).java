package es.uniovi.asw;

public class Voter {
	
	private Long id;
	private String nombre;
	private String nif;
	private int cp;
	private int mesa;
	private String email;
	
	public Voter() {}
	
	public Voter(String nombre, String nif, int cp, int mesa, String email){
		this.nombre = nombre;
		this.nif = nif;
		this.cp = cp;
		this.mesa = mesa;
		this.email = email;
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

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getNif() {
		return nif;
	}
	
	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	
	@Override
	public String toString() {
		return "Voter [id=" + id + ", nombre=" + nombre + ", nif=" + nif
				+ ", cp=" + cp + ", mesa=" + mesa + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		return true;
	}

	
	

}
