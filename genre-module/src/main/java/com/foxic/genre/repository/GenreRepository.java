package com.foxic.genre.repository;

import com.foxic.genre.dto.Genre;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    return jdbcTemplate.query("select * from genre", (rs, rowNum) -> populateGenre(rs));
  }

  private Genre populateGenre(ResultSet resultSet) throws SQLException {
    Genre genre = new Genre();
    genre.setId(BigInteger.valueOf(resultSet.getLong("id")));
    genre.setMovieId(BigInteger.valueOf(resultSet.getLong("movieId")));
    genre.setDescription(resultSet.getString("description"));
    genre.setName(resultSet.getString("name"));
    return genre;
  }
}
