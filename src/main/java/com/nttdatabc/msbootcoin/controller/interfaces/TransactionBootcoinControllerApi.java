package com.nttdatabc.msbootcoin.controller.interfaces;

import com.nttdatabc.msbootcoin.model.TransactionBootcoin;
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
@Tag(name = "Transacciones", description = "the Transacciones API")
public interface TransactionBootcoinControllerApi {

  /**
   * PUT /transaction/accept_exchange : Vendedor acepta transacción
   *
   * @param transactionBootcoin  (optional)
   * @return se actualizó correctamente (status code 200)
   *         or Error en Request (status code 400)
   */
  @Operation(
      operationId = "accepetExchangeTransaction",
      summary = "Vendedor acepta transacción",
      tags = { "Transacciones" },
      responses = {
          @ApiResponse(responseCode = "200", description = "se actualizó correctamente"),
          @ApiResponse(responseCode = "400", description = "Error en Request")
      }
  )
  @RequestMapping(
      method = RequestMethod.PUT,
      value = "/transaction/accept_exchange",
      consumes = { "application/json" }
  )
  default ResponseEntity<Mono<Void>> accepetExchangeTransaction(
      @Parameter(name = "TransactionBootcoin", description = "") @Valid @RequestBody(required = false) TransactionBootcoin transactionBootcoin,
      @Parameter(hidden = true) final ServerWebExchange exchange
  ) {
    Mono<Void> result = Mono.empty();
    exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
    return ResponseEntity.ok().build();

  }


  /**
   * POST /transaction : Agregar transaction
   *
   * @param transactionBootcoin  (optional)
   * @return Transaction creada exitosamente (status code 201)
   *         or Error en Request (status code 400)
   */
  @Operation(
      operationId = "createTransaction",
      summary = "Agregar transaction",
      tags = { "Transacciones" },
      responses = {
          @ApiResponse(responseCode = "201", description = "Transaction creada exitosamente"),
          @ApiResponse(responseCode = "400", description = "Error en Request")
      }
  )
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/transaction",
      consumes = { "application/json" }
  )
  default ResponseEntity<Mono<Void>> createTransaction(
      @Parameter(name = "TransactionBootcoin", description = "") @Valid @RequestBody(required = false) TransactionBootcoin transactionBootcoin,
      @Parameter(hidden = true) final ServerWebExchange exchange
  ) {
    Mono<Void> result = Mono.empty();
    exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
    return ResponseEntity.ok().build();

  }


  /**
   * GET /transaction : Obtener todos las transacciones realizadas.
   *
   * @return Lista de transacciones obtenida correctamente (status code 200)
   */
  @Operation(
      operationId = "getAllTransaction",
      summary = "Obtener todos las transacciones realizadas.",
      tags = { "Transacciones" },
      responses = {
          @ApiResponse(responseCode = "200", description = "Lista de transacciones obtenida correctamente", content = {
              @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TransactionBootcoin.class)))
          })
      }
  )
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/transaction",
      produces = { "application/json" }
  )
  default ResponseEntity<Flux<TransactionBootcoin>> getAllTransaction(
      @Parameter(hidden = true) final ServerWebExchange exchange
  ) {
    Mono<Void> result = Mono.empty();
    exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
    for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
      if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
        String exampleString = "[ { \"idUserSeller\" : \"idUserSeller\", \"mountBuy\" : 0.8008281904610115, \"mountSolesCalculated\" : 6.027456183070403, \"numberTransaction\" : \"numberTransaction\", \"validateBank\" : \"validateBank\", \"idUserBuy\" : \"idUserBuy\", \"id\" : \"id\", \"modePayment\" : \"modePayment\", \"reasonRejection\" : \"reasonRejection\" }, { \"idUserSeller\" : \"idUserSeller\", \"mountBuy\" : 0.8008281904610115, \"mountSolesCalculated\" : 6.027456183070403, \"numberTransaction\" : \"numberTransaction\", \"validateBank\" : \"validateBank\", \"idUserBuy\" : \"idUserBuy\", \"id\" : \"id\", \"modePayment\" : \"modePayment\", \"reasonRejection\" : \"reasonRejection\" } ]";
        result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
        break;
      }
    }
    return ResponseEntity.ok().build();

  }

}