package com.ftninformatika.jwd.modul3.test.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.test.model.Vino;

@Repository
public interface VinoRepository extends JpaRepository<Vino, Long> {
	
	Vino findOneById(Long id);
	
	List<Vino>findByIdIn(List<Long>ids);
	
	@Query
	("SELECT v from Vino v WHERE"
			+ "(:vinarija IS NULL OR v.vinarija.ime LIKE %:vinarija%)AND"
			+ "(:vino IS NULL OR v.ime LIKE %:vino%)")
	Page<Vino>search(
			@Param("vinarija")String vinarija,
			@Param("vino")String vino,
			Pageable pageable);
	List<Vino>findAll();

}
