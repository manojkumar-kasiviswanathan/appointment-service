package uk.gov.nhs.appointment.service.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class Controller {

  @Value("${endpoints.translationService}")
  private String translationServiceUrl;

  @PostMapping("/registration/{GUID}")
  public Mono<String> registerUser(
      @PathVariable String GUID,
      @RequestHeader("correction-id") String CorrectionID,
      @RequestBody Map<String, Object> requestBody) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("correction-id", CorrectionID);
    WebClient webClient = WebClient.create(translationServiceUrl);
    System.out.println(requestBody);
    return webClient
        .get()
        .uri(GUID)
        .accept(MediaType.APPLICATION_JSON)
        .headers(httpHeaders -> httpHeaders.addAll(headers))
        .retrieve()
        .bodyToMono(String.class);
  }
}
