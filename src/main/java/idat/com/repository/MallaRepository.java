package idat.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.com.model.MallaCurricular;



@Repository
public interface MallaRepository extends JpaRepository<MallaCurricular, Integer>{

}
