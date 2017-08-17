package com.foxic.ranking.repository;

import com.foxic.ranking.dto.Rank;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Sem Babenko.
 */
@Repository
public class RankingRepository {

  private JdbcTemplate jdbcTemplate;

  public RankingRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Rank> loadAll() throws Exception {
    return jdbcTemplate.query("SELECT * FROM ranking", (row, index) -> populateRank(row));
  }

  private Rank populateRank(ResultSet row) throws SQLException {
    Rank rank = new Rank();
    rank.setId(row.getInt("id"));
    rank.setMoveId(row.getInt("moveId"));
    rank.setMark(row.getInt("mark"));
    rank.setDescription(row.getString("description"));
    return rank;
  }

}
