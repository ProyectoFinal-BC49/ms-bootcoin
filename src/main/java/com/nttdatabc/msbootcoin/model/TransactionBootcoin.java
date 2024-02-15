package com.nttdatabc.msbootcoin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

@Document(value = "transactionBootcoin")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-14T15:31:56.641149800-05:00[America/Lima]")
public class TransactionBootcoin {

  private String id;

  private String idUserBuy;

  private BigDecimal mountBuy;

  private BigDecimal mountSolesCalculated;

  private String modePayment;

  private String idUserSeller;

  private String modeCharged;

  private String numberTransaction;

  private String validateBank;

  private String reasonRejection;

  public TransactionBootcoin id(String id) {
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

  public TransactionBootcoin idUserBuy(String idUserBuy) {
    this.idUserBuy = idUserBuy;
    return this;
  }

  /**
   * Get idUserBuy
   * @return idUserBuy
   */

  @Schema(name = "idUserBuy", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("idUserBuy")
  public String getIdUserBuy() {
    return idUserBuy;
  }

  public void setIdUserBuy(String idUserBuy) {
    this.idUserBuy = idUserBuy;
  }

  public TransactionBootcoin mountBuy(BigDecimal mountBuy) {
    this.mountBuy = mountBuy;
    return this;
  }

  public String getModeCharged() {
    return modeCharged;
  }

  public void setModeCharged(String modeCharged) {
    this.modeCharged = modeCharged;
  }

  /**
   * Get mountBuy
   * @return mountBuy
   */
  @Valid
  @Schema(name = "mountBuy", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mountBuy")
  public BigDecimal getMountBuy() {
    return mountBuy;
  }

  public void setMountBuy(BigDecimal mountBuy) {
    this.mountBuy = mountBuy;
  }

  public TransactionBootcoin mountSolesCalculated(BigDecimal mountSolesCalculated) {
    this.mountSolesCalculated = mountSolesCalculated;
    return this;
  }

  /**
   * Get mountSolesCalculated
   * @return mountSolesCalculated
   */
  @Valid
  @Schema(name = "mountSolesCalculated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mountSolesCalculated")
  public BigDecimal getMountSolesCalculated() {
    return mountSolesCalculated;
  }

  public void setMountSolesCalculated(BigDecimal mountSolesCalculated) {
    this.mountSolesCalculated = mountSolesCalculated;
  }

  public TransactionBootcoin modePayment(String modePayment) {
    this.modePayment = modePayment;
    return this;
  }

  /**
   * Get modePayment
   * @return modePayment
   */

  @Schema(name = "modePayment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("modePayment")
  public String getModePayment() {
    return modePayment;
  }

  public void setModePayment(String modePayment) {
    this.modePayment = modePayment;
  }

  public TransactionBootcoin idUserSeller(String idUserSeller) {
    this.idUserSeller = idUserSeller;
    return this;
  }

  /**
   * Get idUserSeller
   * @return idUserSeller
   */

  @Schema(name = "idUserSeller", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("idUserSeller")
  public String getIdUserSeller() {
    return idUserSeller;
  }

  public void setIdUserSeller(String idUserSeller) {
    this.idUserSeller = idUserSeller;
  }

  public TransactionBootcoin numberTransaction(String numberTransaction) {
    this.numberTransaction = numberTransaction;
    return this;
  }

  /**
   * Get numberTransaction
   * @return numberTransaction
   */

  @Schema(name = "numberTransaction", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numberTransaction")
  public String getNumberTransaction() {
    return numberTransaction;
  }

  public void setNumberTransaction(String numberTransaction) {
    this.numberTransaction = numberTransaction;
  }

  public TransactionBootcoin validateBank(String validateBank) {
    this.validateBank = validateBank;
    return this;
  }

  /**
   * Get validateBank
   * @return validateBank
   */

  @Schema(name = "validateBank", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("validateBank")
  public String getValidateBank() {
    return validateBank;
  }

  public void setValidateBank(String validateBank) {
    this.validateBank = validateBank;
  }

  public TransactionBootcoin reasonRejection(String reasonRejection) {
    this.reasonRejection = reasonRejection;
    return this;
  }

  /**
   * Get reasonRejection
   * @return reasonRejection
   */

  @Schema(name = "reasonRejection", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reasonRejection")
  public String getReasonRejection() {
    return reasonRejection;
  }

  public void setReasonRejection(String reasonRejection) {
    this.reasonRejection = reasonRejection;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionBootcoin transactionBootcoin = (TransactionBootcoin) o;
    return Objects.equals(this.id, transactionBootcoin.id) &&
        Objects.equals(this.idUserBuy, transactionBootcoin.idUserBuy) &&
        Objects.equals(this.mountBuy, transactionBootcoin.mountBuy) &&
        Objects.equals(this.mountSolesCalculated, transactionBootcoin.mountSolesCalculated) &&
        Objects.equals(this.modePayment, transactionBootcoin.modePayment) &&
        Objects.equals(this.idUserSeller, transactionBootcoin.idUserSeller) &&
        Objects.equals(this.numberTransaction, transactionBootcoin.numberTransaction) &&
        Objects.equals(this.validateBank, transactionBootcoin.validateBank) &&
        Objects.equals(this.reasonRejection, transactionBootcoin.reasonRejection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idUserBuy, mountBuy, mountSolesCalculated, modePayment, idUserSeller, numberTransaction, validateBank, reasonRejection);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionBootcoin {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idUserBuy: ").append(toIndentedString(idUserBuy)).append("\n");
    sb.append("    mountBuy: ").append(toIndentedString(mountBuy)).append("\n");
    sb.append("    mountSolesCalculated: ").append(toIndentedString(mountSolesCalculated)).append("\n");
    sb.append("    modePayment: ").append(toIndentedString(modePayment)).append("\n");
    sb.append("    idUserSeller: ").append(toIndentedString(idUserSeller)).append("\n");
    sb.append("    modeCharged: ").append(toIndentedString(modeCharged)).append("\n");
    sb.append("    numberTransaction: ").append(toIndentedString(numberTransaction)).append("\n");
    sb.append("    validateBank: ").append(toIndentedString(validateBank)).append("\n");
    sb.append("    reasonRejection: ").append(toIndentedString(reasonRejection)).append("\n");
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
