package idat.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.com.model.Profesor;



@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

}
