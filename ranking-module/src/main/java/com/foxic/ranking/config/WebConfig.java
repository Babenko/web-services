package com.foxic.ranking.config;

import com.foxic.ranking.endpoint.RankingEndpointImpl;
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

  @Bean
  public Endpoint endpoint() {
    Endpoint endpoint = new EndpointImpl(bus, new RankingEndpointImpl(rankingRepositorys));
    endpoint.publish("/rank");
    return endpoint;
  }
}
