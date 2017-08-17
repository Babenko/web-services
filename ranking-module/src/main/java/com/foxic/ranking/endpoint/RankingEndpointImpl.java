package com.foxic.ranking.endpoint;

import com.foxic.ranking.dto.Rank;
import com.foxic.ranking.repository.RankingRepository;
import java.util.List;

/**
 * Created by Sem Babenko.
 */
@javax.jws.WebService(serviceName = "RankingEndpointImpl", portName = "RankingEndpoint",
    targetNamespace = "http://service.ws.sample/",
    endpointInterface = "com.foxic.ranking.endpoint.RankingEndpoint")
public class RankingEndpointImpl implements RankingEndpoint {

  private RankingRepository rankingRepository;

  public RankingEndpointImpl(RankingRepository rankingRepository) {
    this.rankingRepository = rankingRepository;
  }

  public List<Rank> loadAll() {
      try {
        return rankingRepository.loadAll();
      } catch (java.lang.Exception ex) {
        throw new RuntimeException(ex);
      }
    }


}
