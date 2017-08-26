package com.foxic.ranking.endpoint;

import com.foxic.ranking.dto.Rank;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * Created by Sem Babenko.
 */
@WebService(targetNamespace = "http://url.temp/", name = "Rank")
public interface RankingEndpoint {

  @WebResult(name = "Rank", targetNamespace = "")
  @RequestWrapper(localName = "Rank",
      targetNamespace = "http://service.ws.sample/",
      className = "com.demo.cxf.service.SayHello")
  @WebMethod(action = "urn:SayHello")
  @ResponseWrapper(localName = "sayHelloResponse",
      targetNamespace = "http://url.temp/",
      className = "com.demo.cxf.service.SayHelloResponse")
  List<Rank> loadAll();
}
