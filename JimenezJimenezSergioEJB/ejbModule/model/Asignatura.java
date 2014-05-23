package model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Asignatura {
	@Id
	@GeneratedValue
	private Long id;
	@Transient
	private boolean canBeDeleted;
	
	private String nombre;
	private Integer curso;
	private Double numerocreditos;

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "asignatura")
	protected Set<Matriculado> matriculados = new HashSet<Matriculado>();

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "asignatura")
	protected Set<Imparte> imparte = new HashSet<Imparte>();

	public Set<Matriculado> getMatriculados() {
		return Collections.unmodifiableSet(matriculados);
	}

	public boolean isCanBeDeleted() {
		return !(matriculados.isEmpty()&&imparte.isEmpty());
	}

	public void setCanBeDeleted(boolean canBeDeleted) {
		this.canBeDeleted = canBeDeleted;
	}

	protected Set<Matriculado> _getMatriculados() {
		return matriculados;
	}

	public Set<Imparte> getImparte() {
		return Collections.unmodifiableSet(imparte);
	}

	protected Set<Imparte> _getImparte() {
		return imparte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public void setCurso(String curso) {
		try {
			this.curso = Integer.parseInt(curso);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Double getNumerocreditos() {
		return numerocreditos;
	}

	public void setNumerocreditos(Double numerocreditos) {
		this.numerocreditos = numerocreditos;
	}

	public void setNumerocreditos(String numerocreditos) {
		try {
			this.numerocreditos = Double.parseDouble(numerocreditos);
		} catch (Exception e) {
		}
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Asignatura other = (Asignatura) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Asignatura() {
		super();
		// TODO Auto-generated constructor stub
	}

}
