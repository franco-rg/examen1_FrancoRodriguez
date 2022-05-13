package idat.com.model;

import javax.persistence.*;

@Entity
@Table(name="malla_curricular")
public class MallaCurricular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	private String anio;
	
	@JoinColumn(name = "id_curso", 
			nullable = false, 
			unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_curso) references curso(id_curso)"))
	
	@ManyToOne
	private Curso cursos;
	
	@OneToOne(mappedBy = "malla")
	private Universidad universidad;
	
	public Integer getIdMalla() {
		return idMalla;
	}
	
	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}
	
	public String getAnio() {
		return anio;
	}
	
	public void setAnio(String anio) {
		this.anio = anio;
	}
}