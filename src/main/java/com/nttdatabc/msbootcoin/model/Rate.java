package com.nttdatabc.msbootcoin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Document(value = "rate")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-14T15:31:56.641149800-05:00[America/Lima]")
public class Rate {

  private BigDecimal rateBootcoin;
  private LocalDateTime localDateTime;

  public Rate rateBootcoin(BigDecimal rateBootcoin) {
    this.rateBootcoin = rateBootcoin;
    return this;
  }

  public Rate(BigDecimal rateBootcoin, LocalDateTime localDateTime) {
    this.rateBootcoin = rateBootcoin;
    this.localDateTime = localDateTime;
  }

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public void setLocalDateTime(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
  }

  /**
   * Get rateBootcoin
   * @return rateBootcoin
   */
  @Valid
  @Schema(name = "rateBootcoin", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("rateBootcoin")
  public BigDecimal getRateBootcoin() {
    return rateBootcoin;
  }

  public void setRateBootcoin(BigDecimal rateBootcoin) {
    this.rateBootcoin = rateBootcoin;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rate rate = (Rate) o;
    return Objects.equals(this.rateBootcoin, rate.rateBootcoin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rateBootcoin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rate {\n");
    sb.append("    rateBootcoin: ").append(toIndentedString(rateBootcoin)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}