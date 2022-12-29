package com.niulanio.bookstrore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.niulanio.bookstrore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	@Query("Select obj From Livro obj Where obj.categoria.id = :id_cat Order By titulo")
	List<Livro> findAllByCategoria(@Param(value="id_cat") Long id_cat);

}
