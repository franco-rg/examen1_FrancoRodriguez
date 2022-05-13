package idat.com.model;

import javax.persistence.*;

@Entity
@Table(name="universidad")
public class Universidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUniversidad;
	private String Universidad;
	
	@OneToOne
	@JoinColumn(name="id_malla", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_malla) references malla_curricular (id_malla)"))
	
	private MallaCurricular malla;
	
	public Integer getIdUniversidad() {
		return idUniversidad;
	}
	
	public void setIdUniversidad(Integer idUniversidad) {
		this.idUniversidad = idUniversidad;
	}
	
	public String getUniversidad() {
		return Universidad;
	}
	
	public void setUniversidad(String universidad) {
		Universidad = universidad;
	}
}
