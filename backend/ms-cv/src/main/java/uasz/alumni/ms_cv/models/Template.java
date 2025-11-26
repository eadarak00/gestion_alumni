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
 * Template
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-26T15:28:11.703869118Z[Africa/Dakar]", comments = "Generator version: 7.17.0")
public class Template {

  /**
   * Gets or Sets id
   */
  public enum IdEnum {
    MODERNE("MODERNE"),
    
    CLASSIQUE("CLASSIQUE"),
    
    PROFESSIONNEL("PROFESSIONNEL");

    private final String value;

    IdEnum(String value) {
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
    public static IdEnum fromValue(String value) {
      for (IdEnum b : IdEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable IdEnum id;

  private @Nullable String nom;

  private @Nullable String description;

  private @Nullable String apercu;

  public Template id(@Nullable IdEnum id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", example = "MODERNE", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable IdEnum getId() {
    return id;
  }

  public void setId(@Nullable IdEnum id) {
    this.id = id;
  }

  public Template nom(@Nullable String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
   */
  
  @Schema(name = "nom", example = "Moderne", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nom")
  public @Nullable String getNom() {
    return nom;
  }

  public void setNom(@Nullable String nom) {
    this.nom = nom;
  }

  public Template description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  
  @Schema(name = "description", example = "Design moderne avec sections colorées", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  public Template apercu(@Nullable String apercu) {
    this.apercu = apercu;
    return this;
  }

  /**
   * URL de l'image d'aperçu
   * @return apercu
   */
  
  @Schema(name = "apercu", example = "https://storage.uasz.sn/templates/moderne-preview.png", description = "URL de l'image d'aperçu", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("apercu")
  public @Nullable String getApercu() {
    return apercu;
  }

  public void setApercu(@Nullable String apercu) {
    this.apercu = apercu;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Template template = (Template) o;
    return Objects.equals(this.id, template.id) &&
        Objects.equals(this.nom, template.nom) &&
        Objects.equals(this.description, template.description) &&
        Objects.equals(this.apercu, template.apercu);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nom, description, apercu);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Template {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    apercu: ").append(toIndentedString(apercu)).append("\n");
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

