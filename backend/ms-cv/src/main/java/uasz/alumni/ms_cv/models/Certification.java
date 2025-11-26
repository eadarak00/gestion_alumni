package uasz.alumni.ms_cv.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Certification
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-26T15:28:11.703869118Z[Africa/Dakar]", comments = "Generator version: 7.17.0")
public class Certification {

  private @Nullable Integer id;

  private @Nullable Integer cvId;

  private @Nullable String nom;

  private @Nullable String organisme;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate dateObtention;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate dateExpiration;

  private @Nullable String lienCredential;

  public Certification id(@Nullable Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Integer getId() {
    return id;
  }

  public void setId(@Nullable Integer id) {
    this.id = id;
  }

  public Certification cvId(@Nullable Integer cvId) {
    this.cvId = cvId;
    return this;
  }

  /**
   * Get cvId
   * @return cvId
   */
  
  @Schema(name = "cvId", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cvId")
  public @Nullable Integer getCvId() {
    return cvId;
  }

  public void setCvId(@Nullable Integer cvId) {
    this.cvId = cvId;
  }

  public Certification nom(@Nullable String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
   */
  
  @Schema(name = "nom", example = "AWS Certified Developer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nom")
  public @Nullable String getNom() {
    return nom;
  }

  public void setNom(@Nullable String nom) {
    this.nom = nom;
  }

  public Certification organisme(@Nullable String organisme) {
    this.organisme = organisme;
    return this;
  }

  /**
   * Get organisme
   * @return organisme
   */
  
  @Schema(name = "organisme", example = "Amazon Web Services", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("organisme")
  public @Nullable String getOrganisme() {
    return organisme;
  }

  public void setOrganisme(@Nullable String organisme) {
    this.organisme = organisme;
  }

  public Certification dateObtention(@Nullable LocalDate dateObtention) {
    this.dateObtention = dateObtention;
    return this;
  }

  /**
   * Get dateObtention
   * @return dateObtention
   */
  @Valid 
  @Schema(name = "dateObtention", example = "2022-03-15", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateObtention")
  public @Nullable LocalDate getDateObtention() {
    return dateObtention;
  }

  public void setDateObtention(@Nullable LocalDate dateObtention) {
    this.dateObtention = dateObtention;
  }

  public Certification dateExpiration(@Nullable LocalDate dateExpiration) {
    this.dateExpiration = dateExpiration;
    return this;
  }

  /**
   * Get dateExpiration
   * @return dateExpiration
   */
  @Valid 
  @Schema(name = "dateExpiration", example = "2025-03-15", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateExpiration")
  public @Nullable LocalDate getDateExpiration() {
    return dateExpiration;
  }

  public void setDateExpiration(@Nullable LocalDate dateExpiration) {
    this.dateExpiration = dateExpiration;
  }

  public Certification lienCredential(@Nullable String lienCredential) {
    this.lienCredential = lienCredential;
    return this;
  }

  /**
   * Get lienCredential
   * @return lienCredential
   */
  
  @Schema(name = "lienCredential", example = "https://aws.amazon.com/verification/12345", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lienCredential")
  public @Nullable String getLienCredential() {
    return lienCredential;
  }

  public void setLienCredential(@Nullable String lienCredential) {
    this.lienCredential = lienCredential;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Certification certification = (Certification) o;
    return Objects.equals(this.id, certification.id) &&
        Objects.equals(this.cvId, certification.cvId) &&
        Objects.equals(this.nom, certification.nom) &&
        Objects.equals(this.organisme, certification.organisme) &&
        Objects.equals(this.dateObtention, certification.dateObtention) &&
        Objects.equals(this.dateExpiration, certification.dateExpiration) &&
        Objects.equals(this.lienCredential, certification.lienCredential);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cvId, nom, organisme, dateObtention, dateExpiration, lienCredential);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Certification {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    organisme: ").append(toIndentedString(organisme)).append("\n");
    sb.append("    dateObtention: ").append(toIndentedString(dateObtention)).append("\n");
    sb.append("    dateExpiration: ").append(toIndentedString(dateExpiration)).append("\n");
    sb.append("    lienCredential: ").append(toIndentedString(lienCredential)).append("\n");
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

