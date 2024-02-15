package com.nttdatabc.msbootcoin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

@Document(value = "userBootcoin")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-14T15:31:56.641149800-05:00[America/Lima]")
public class UserBootcoin {

  private String id;

  private String typeIdentification;

  private String numberIdentification;

  private String numberPhone;

  private String email;

  private BigDecimal balanceBootcoin;

  public UserBootcoin id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */

  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UserBootcoin typeIdentification(String typeIdentification) {
    this.typeIdentification = typeIdentification;
    return this;
  }

  /**
   * Get typeIdentification
   * @return typeIdentification
   */

  @Schema(name = "typeIdentification", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("typeIdentification")
  public String getTypeIdentification() {
    return typeIdentification;
  }

  public void setTypeIdentification(String typeIdentification) {
    this.typeIdentification = typeIdentification;
  }

  public UserBootcoin numberIdentification(String numberIdentification) {
    this.numberIdentification = numberIdentification;
    return this;
  }

  /**
   * Get numberIdentification
   * @return numberIdentification
   */

  @Schema(name = "numberIdentification", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numberIdentification")
  public String getNumberIdentification() {
    return numberIdentification;
  }

  public void setNumberIdentification(String numberIdentification) {
    this.numberIdentification = numberIdentification;
  }

  public UserBootcoin numberPhone(String numberPhone) {
    this.numberPhone = numberPhone;
    return this;
  }

  /**
   * Get numberPhone
   * @return numberPhone
   */

  @Schema(name = "numberPhone", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numberPhone")
  public String getNumberPhone() {
    return numberPhone;
  }

  public void setNumberPhone(String numberPhone) {
    this.numberPhone = numberPhone;
  }

  public UserBootcoin email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */

  @Schema(name = "email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserBootcoin balanceBootcoin(BigDecimal balanceBootcoin) {
    this.balanceBootcoin = balanceBootcoin;
    return this;
  }

  /**
   * Get balanceBootcoin
   * @return balanceBootcoin
   */
  @Valid
  @Schema(name = "balanceBootcoin", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("balanceBootcoin")
  public BigDecimal getBalanceBootcoin() {
    return balanceBootcoin;
  }

  public void setBalanceBootcoin(BigDecimal balanceBootcoin) {
    this.balanceBootcoin = balanceBootcoin;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserBootcoin userBootcoin = (UserBootcoin) o;
    return Objects.equals(this.id, userBootcoin.id) &&
        Objects.equals(this.typeIdentification, userBootcoin.typeIdentification) &&
        Objects.equals(this.numberIdentification, userBootcoin.numberIdentification) &&
        Objects.equals(this.numberPhone, userBootcoin.numberPhone) &&
        Objects.equals(this.email, userBootcoin.email) &&
        Objects.equals(this.balanceBootcoin, userBootcoin.balanceBootcoin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, typeIdentification, numberIdentification, numberPhone, email, balanceBootcoin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserBootcoin {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    typeIdentification: ").append(toIndentedString(typeIdentification)).append("\n");
    sb.append("    numberIdentification: ").append(toIndentedString(numberIdentification)).append("\n");
    sb.append("    numberPhone: ").append(toIndentedString(numberPhone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    balanceBootcoin: ").append(toIndentedString(balanceBootcoin)).append("\n");
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

