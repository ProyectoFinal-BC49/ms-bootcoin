package com.nttdatabc.msbootcoin.controller.interfaces;

import com.nttdatabc.msbootcoin.model.Rate;
import com.nttdatabc.msbootcoin.utils.ApiUtil;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.codec.multipart.Part;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-14T15:31:56.641149800-05:00[America/Lima]")
@Validated
@Tag(name = "Rate", description = "the Rate API")
public interface RateControllerApi {

  /**
   * POST /rate : crear la tasa de compra y venta, si existe actualizar
   *
   * @param rate  (optional)
   * @return Rate creado (status code 201)
   *         or Error en parámetros (status code 400)
   */
  @Operation(
      operationId = "createRate",
      summary = "crear la tasa de compra y venta, si existe actualizar",
      tags = { "Rate" },
      responses = {
          @ApiResponse(responseCode = "201", description = "Rate creado"),
          @ApiResponse(responseCode = "400", description = "Error en parámetros")
      }
  )
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/rate",
      consumes = { "application/json" }
  )
  default ResponseEntity<Mono<Void>> createRate(
      @Parameter(name = "Rate", description = "") @Valid @RequestBody(required = false) Rate rate,
      @Parameter(hidden = true) final ServerWebExchange exchange
  ) {
    Mono<Void> result = Mono.empty();
    exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
    return ResponseEntity.ok().build();

  }


  /**
   * GET /rate : Obtener la tasa de compra y venta de soles a bootcoin
   *
   * @return Rate obtenido (status code 200)
   */
  @Operation(
      operationId = "getRate",
      summary = "Obtener la tasa de compra y venta de soles a bootcoin",
      tags = { "Rate" },
      responses = {
          @ApiResponse(responseCode = "200", description = "Rate obtenido", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = Rate.class))
          })
      }
  )
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/rate",
      produces = { "application/json" }
  )
  default ResponseEntity<Mono<Rate>> getRate(
      @Parameter(hidden = true) final ServerWebExchange exchange
  ) {
    Mono<Void> result = Mono.empty();
    exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
    for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
      if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
        String exampleString = "{ \"rateBootcoin\" : 0.8008281904610115 }";
        result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
        break;
      }
    }
    return ResponseEntity.ok().build();

  }

}

