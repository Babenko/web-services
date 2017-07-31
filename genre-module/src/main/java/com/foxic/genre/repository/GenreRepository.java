package com.foxic.genre.repository;

import com.foxic.genre.dto.Genre;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Sem Babenko.
 */
@Repository
public class GenreRepository {

  private JdbcTemplate jdbcTemplate;

  public GenreRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Genre> findAll() {
    return jdbcTemplate.query("select * from genre", (rs, rowNum) -> new Genre());
  }
}
