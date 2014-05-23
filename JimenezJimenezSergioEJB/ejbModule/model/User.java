package model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	protected Long id;
	@Transient
	protected boolean canBeDeleted;



	protected String user;
	protected String name;
	protected String surname;
	protected String mail;
	protected String pass;
	protected boolean active;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "profesor")
	protected Set<Imparte> imparte = new HashSet<Imparte>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "alumno",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	protected Set<Matriculado> matriculados = new HashSet<Matriculado>();

	/**
	 * si el usuario no esta ni matriculado ni impartiendo asignaturas, podrá ser borrado
	 * @return
	 */
	public boolean isCanBeDeleted() {

		return (this.matriculados.isEmpty() && this.imparte.isEmpty());
	}

	public void setCanBeDeleted(boolean canBeDeleted) {

		this.canBeDeleted = canBeDeleted;
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	protected Set<Matriculado> _getMatriculados() {
		return matriculados;
	}

	public Set<Matriculado> getMatriculados() {
		return matriculados;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setMatriculados(Set<Matriculado> matriculados) {
		this.matriculados = matriculados;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "User [user=" + user + ", name=" + name + ", surname=" + surname
				+ ", mail=" + mail + ", pass=" + pass + ", active=" + active
				+ ", matriculados=" + matriculados + ", imparte=" + imparte
				+ "]";
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setImparte(Set<Imparte> imparte) {
		this.imparte = imparte;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Imparte> getImparte() {
		return Collections.unmodifiableSet(imparte);
	}

	protected Set<Imparte> _getImparte() {
		return imparte;
	}

	public String getUser() {
		return user;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getMail() {
		return mail;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
