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
 * Experience
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-26T19:36:29.996620853Z[Africa/Dakar]", comments = "Generator version: 7.17.0")
public class Experience {

  private @Nullable Integer id;

  private @Nullable Integer cvId;

  private @Nullable String poste;

  private @Nullable String entreprise;

  private @Nullable String localisation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate dateDebut;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate dateFin;

  private @Nullable Boolean enCours;

  private @Nullable String description;

  public Experience id(@Nullable Integer id) {
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

  public Experience cvId(@Nullable Integer cvId) {
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

  public Experience poste(@Nullable String poste) {
    this.poste = poste;
    return this;
  }

  /**
   * Get poste
   * @return poste
   */
  
  @Schema(name = "poste", example = "Développeur Full Stack", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("poste")
  public @Nullable String getPoste() {
    return poste;
  }

  public void setPoste(@Nullable String poste) {
    this.poste = poste;
  }

  public Experience entreprise(@Nullable String entreprise) {
    this.entreprise = entreprise;
    return this;
  }

  /**
   * Get entreprise
   * @return entreprise
   */
  
  @Schema(name = "entreprise", example = "Tech Company", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("entreprise")
  public @Nullable String getEntreprise() {
    return entreprise;
  }

  public void setEntreprise(@Nullable String entreprise) {
    this.entreprise = entreprise;
  }

  public Experience localisation(@Nullable String localisation) {
    this.localisation = localisation;
    return this;
  }

  /**
   * Get localisation
   * @return localisation
   */
  
  @Schema(name = "localisation", example = "Dakar, Sénégal", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("localisation")
  public @Nullable String getLocalisation() {
    return localisation;
  }

  public void setLocalisation(@Nullable String localisation) {
    this.localisation = localisation;
  }

  public Experience dateDebut(@Nullable LocalDate dateDebut) {
    this.dateDebut = dateDebut;
    return this;
  }

  /**
   * Get dateDebut
   * @return dateDebut
   */
  @Valid 
  @Schema(name = "dateDebut", example = "2020-01-15", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateDebut")
  public @Nullable LocalDate getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(@Nullable LocalDate dateDebut) {
    this.dateDebut = dateDebut;
  }

  public Experience dateFin(@Nullable LocalDate dateFin) {
    this.dateFin = dateFin;
    return this;
  }

  /**
   * Get dateFin
   * @return dateFin
   */
  @Valid 
  @Schema(name = "dateFin", example = "2023-06-30", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateFin")
  public @Nullable LocalDate getDateFin() {
    return dateFin;
  }

  public void setDateFin(@Nullable LocalDate dateFin) {
    this.dateFin = dateFin;
  }

  public Experience enCours(@Nullable Boolean enCours) {
    this.enCours = enCours;
    return this;
  }

  /**
   * Get enCours
   * @return enCours
   */
  
  @Schema(name = "enCours", example = "false", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("enCours")
  public @Nullable Boolean getEnCours() {
    return enCours;
  }

  public void setEnCours(@Nullable Boolean enCours) {
    this.enCours = enCours;
  }

  public Experience description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  
  @Schema(name = "description", example = "- Développement d'applications web - Gestion de bases de données", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Experience experience = (Experience) o;
    return Objects.equals(this.id, experience.id) &&
        Objects.equals(this.cvId, experience.cvId) &&
        Objects.equals(this.poste, experience.poste) &&
        Objects.equals(this.entreprise, experience.entreprise) &&
        Objects.equals(this.localisation, experience.localisation) &&
        Objects.equals(this.dateDebut, experience.dateDebut) &&
        Objects.equals(this.dateFin, experience.dateFin) &&
        Objects.equals(this.enCours, experience.enCours) &&
        Objects.equals(this.description, experience.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cvId, poste, entreprise, localisation, dateDebut, dateFin, enCours, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Experience {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    poste: ").append(toIndentedString(poste)).append("\n");
    sb.append("    entreprise: ").append(toIndentedString(entreprise)).append("\n");
    sb.append("    localisation: ").append(toIndentedString(localisation)).append("\n");
    sb.append("    dateDebut: ").append(toIndentedString(dateDebut)).append("\n");
    sb.append("    dateFin: ").append(toIndentedString(dateFin)).append("\n");
    sb.append("    enCours: ").append(toIndentedString(enCours)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

