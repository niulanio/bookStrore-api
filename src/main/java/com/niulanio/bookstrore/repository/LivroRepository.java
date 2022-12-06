package com.niulanio.bookstrore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niulanio.bookstrore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
