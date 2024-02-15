package com.nttdatabc.msbootcoin.controller.interfaces;

import com.nttdatabc.msbootcoin.model.UserBootcoin;
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
@Tag(name = "User Bootcoin", description = "the User Bootcoin API")
public interface UserBootcoinControllerApi {

  /**
   * POST /user_bootcoin : Agregar UserBootcoin
   *
   * @param userBootcoin  (optional)
   * @return UserBootcoin creada exitosamente (status code 201)
   *         or Error en Request (status code 400)
   */
  @Operation(
      operationId = "createUserBootcoin",
      summary = "Agregar UserBootcoin",
      tags = { "User Bootcoin" },
      responses = {
          @ApiResponse(responseCode = "201", description = "UserBootcoin creada exitosamente"),
          @ApiResponse(responseCode = "400", description = "Error en Request")
      }
  )
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/user_bootcoin",
      consumes = { "application/json" }
  )
  default ResponseEntity<Mono<Void>> createUserBootcoin(
      @Parameter(name = "UserBootcoin", description = "") @Valid @RequestBody(required = false) UserBootcoin userBootcoin,
      @Parameter(hidden = true) final ServerWebExchange exchange
  ) {
    Mono<Void> result = Mono.empty();
    exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
    return ResponseEntity.ok().build();

  }


  /**
   * GET /user_bootcoin : Obtener todos los users bootcoin
   *
   * @return Lista de usersBootcoin obtenida correctamente (status code 200)
   */
  @Operation(
      operationId = "getAllUserBootcoin",
      summary = "Obtener todos los users bootcoin",
      tags = { "User Bootcoin" },
      responses = {
          @ApiResponse(responseCode = "200", description = "Lista de usersBootcoin obtenida correctamente", content = {
              @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserBootcoin.class)))
          })
      }
  )
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/user_bootcoin",
      produces = { "application/json" }
  )
  default ResponseEntity<Flux<UserBootcoin>> getAllUserBootcoin(
      @Parameter(hidden = true) final ServerWebExchange exchange
  ) {
    Mono<Void> result = Mono.empty();
    exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
    for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
      if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
        String exampleString = "[ { \"typeIdentification\" : \"typeIdentification\", \"numberIdentification\" : \"numberIdentification\", \"numberPhone\" : \"numberPhone\", \"balanceBootcoin\" : 0.8008281904610115, \"id\" : \"id\", \"email\" : \"email\" }, { \"typeIdentification\" : \"typeIdentification\", \"numberIdentification\" : \"numberIdentification\", \"numberPhone\" : \"numberPhone\", \"balanceBootcoin\" : 0.8008281904610115, \"id\" : \"id\", \"email\" : \"email\" } ]";
        result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
        break;
      }
    }
    return ResponseEntity.ok().build();

  }


  /**
   * GET /user_bootcoin/{user_id} : Obtener detalle de UserBootcoin
   *
   * @param userId ID del user (required)
   * @return Detalle de Wallet obtenido exitosamente (status code 200)
   *         or Error en request (status code 400)
   *         or Recurso no encontrado (status code 404)
   */
  @Operation(
      operationId = "getUserBootcoinById",
      summary = "Obtener detalle de UserBootcoin",
      tags = { "User Bootcoin" },
      responses = {
          @ApiResponse(responseCode = "200", description = "Detalle de Wallet obtenido exitosamente", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserBootcoin.class))
          }),
          @ApiResponse(responseCode = "400", description = "Error en request"),
          @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
      }
  )
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/user_bootcoin/{user_id}",
      produces = { "application/json" }
  )
  default ResponseEntity<Mono<UserBootcoin>> getUserBootcoinById(
      @Parameter(name = "user_id", description = "ID del user", required = true, in = ParameterIn.PATH) @PathVariable("user_id") String userId,
      @Parameter(hidden = true) final ServerWebExchange exchange
  ) {
    Mono<Void> result = Mono.empty();
    exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
    for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
      if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
        String exampleString = "{ \"typeIdentification\" : \"typeIdentification\", \"numberIdentification\" : \"numberIdentification\", \"numberPhone\" : \"numberPhone\", \"balanceBootcoin\" : 0.8008281904610115, \"id\" : \"id\", \"email\" : \"email\" }";
        result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
        break;
      }
    }
    return ResponseEntity.ok().build();

  }


  /**
   * PUT /user_bootcoin : update balance Bootcoin
   *
   * @param userBootcoin  (optional)
   * @return UserBootcoin actualizado exitosamente (status code 200)
   *         or Error en Request (status code 400)
   */
  @Operation(
      operationId = "updateUserBootcoin",
      summary = "update balance Bootcoin",
      tags = { "User Bootcoin" },
      responses = {
          @ApiResponse(responseCode = "200", description = "UserBootcoin actualizado exitosamente"),
          @ApiResponse(responseCode = "400", description = "Error en Request")
      }
  )
  @RequestMapping(
      method = RequestMethod.PUT,
      value = "/user_bootcoin",
      consumes = { "application/json" }
  )
  default ResponseEntity<Mono<Void>> updateUserBootcoin(
      @Parameter(name = "UserBootcoin", description = "") @Valid @RequestBody(required = false) UserBootcoin userBootcoin,
      @Parameter(hidden = true) final ServerWebExchange exchange
  ) {
    Mono<Void> result = Mono.empty();
    exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
    return ResponseEntity.ok().build();

  }

}