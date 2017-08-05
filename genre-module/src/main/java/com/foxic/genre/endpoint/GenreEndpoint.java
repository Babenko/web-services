package com.foxic.genre.endpoint;

import com.foxic.genre.dto.GetGenreRequest;
import com.foxic.genre.dto.GetGenreResponse;
import com.foxic.genre.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by Sem Babenko.
 */
@Endpoint
public class GenreEndpoint {
  private static final String NAMESPACE_URI = "http://temp.uri/genre";

  private GenreRepository genreRepository;

  @Autowired
  public GenreEndpoint(GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGenreRequest")
  @ResponsePayload
  public GetGenreResponse getCountry(@RequestPayload GetGenreRequest request) {
    GetGenreResponse response = new GetGenreResponse();
    response.getGenre().addAll(genreRepository.findAll());
    return response;
  }
}
