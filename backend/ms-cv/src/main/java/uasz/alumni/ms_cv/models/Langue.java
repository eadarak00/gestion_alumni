package uasz.alumni.ms_cv.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Langue
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-26T15:28:11.703869118Z[Africa/Dakar]", comments = "Generator version: 7.17.0")
public class Langue {

  private @Nullable Integer id;

  private @Nullable Integer cvId;

  private @Nullable String nom;

  /**
   * Gets or Sets niveau
   */
  public enum NiveauEnum {
    DEBUTANT("DEBUTANT"),
    
    INTERMEDIAIRE("INTERMEDIAIRE"),
    
    AVANCE("AVANCE"),
    
    COURANT("COURANT"),
    
    LANGUE_MATERNELLE("LANGUE_MATERNELLE");

    private final String value;

    NiveauEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NiveauEnum fromValue(String value) {
      for (NiveauEnum b : NiveauEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable NiveauEnum niveau;

  public Langue id(@Nullable Integer id) {
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

  public Langue cvId(@Nullable Integer cvId) {
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

  public Langue nom(@Nullable String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
   */
  
  @Schema(name = "nom", example = "Français", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nom")
  public @Nullable String getNom() {
    return nom;
  }

  public void setNom(@Nullable String nom) {
    this.nom = nom;
  }

  public Langue niveau(@Nullable NiveauEnum niveau) {
    this.niveau = niveau;
    return this;
  }

  /**
   * Get niveau
   * @return niveau
   */
  
  @Schema(name = "niveau", example = "LANGUE_MATERNELLE", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("niveau")
  public @Nullable NiveauEnum getNiveau() {
    return niveau;
  }

  public void setNiveau(@Nullable NiveauEnum niveau) {
    this.niveau = niveau;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Langue langue = (Langue) o;
    return Objects.equals(this.id, langue.id) &&
        Objects.equals(this.cvId, langue.cvId) &&
        Objects.equals(this.nom, langue.nom) &&
        Objects.equals(this.niveau, langue.niveau);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cvId, nom, niveau);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Langue {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    niveau: ").append(toIndentedString(niveau)).append("\n");
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

