package com.foxic.ranking.config;

import com.foxic.ranking.endpoint.RankingEndpointImpl;
import com.foxic.ranking.repository.RankingRepository;
import javax.sql.DataSource;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sem Babenko.
 */
@Configuration
public class WebConfig {

  @Autowired
  private Bus bus;

  @Autowired
  private RankingRepository rankingRepository;

  @Bean
  public Endpoint endpoint() {
    Endpoint endpoint = new EndpointImpl(bus, new RankingEndpointImpl(rankingRepository));
    endpoint.publish("/rank");
    return endpoint;
  }

  public DataSource dataSource() {
    return null;
  }
}
