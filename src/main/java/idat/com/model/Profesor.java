package idat.com.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;
	private String profesor;
	
	@ManyToMany(mappedBy = "profesor", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Curso> cursos = new ArrayList<Curso>();
	
	public Integer getIdProfesor() {
		return idProfesor;
	}
	
	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}
	
	public String getProfesor() {
		return profesor;
	}
	
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
}
