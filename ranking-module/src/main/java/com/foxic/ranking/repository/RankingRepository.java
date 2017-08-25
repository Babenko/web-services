package com.foxic.ranking.repository;

import com.foxic.ranking.dto.Rank;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Sem Babenko.
 */
@Repository
public class RankingRepository {

  private DataSource dataSource;

  @Autowired
  public RankingRepository(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public List<Rank> loadAll() throws Exception {
    List<Rank> list = new ArrayList<>();
    try (Connection conn = dataSource.getConnection();
          Statement statement = conn.createStatement()) {
      ResultSet rs = statement.executeQuery("SELECT * FROM ranking");
      while(rs.next()) {
        list.add(populateRank(rs));
      }
    }
    return list;
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
