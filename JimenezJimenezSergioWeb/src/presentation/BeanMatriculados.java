package presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import conf.ServicesFactory;
import model.Matriculado;
import model.exceptions.BusinessException;

@ManagedBean(name = "matriculado_controller")
@SessionScoped
public class BeanMatriculados implements Serializable{


	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Long id;
	private Matriculado matriculado;
	private Matriculado[] matriculados;

	public Matriculado getMatriculado() {
		return matriculado;
	}

	public void setMatriculado(Matriculado matriculado) {
		this.matriculado = matriculado;
	}
	
	public String onload(Long id){
		try {
			this.id=id;
			matriculados = ServicesFactory.getMatriculadosService().findMatriculadosByAlumnoId(id).toArray(new Matriculado[0]);
			if(matriculados.length<=0){
				matriculados=null;
			}
			return "ok";
		} catch (BusinessException e) {
			return "error";
		}
	}
	


	public String delete(Matriculado m){
		try {
			ServicesFactory.getMatriculadosService().delete(m);
			return "/restricted/admin/index.xhtml";
		} catch (BusinessException e) {
			return "error";
		}
	}

	public Matriculado[] getMatriculados() {
		return matriculados;
	}

	public void setMatriculados(Matriculado[] matriculados) {
		this.matriculados = matriculados;
	}
	
	public void setMatriculadosToNull(){
		this.matriculados=null;
	}

}
