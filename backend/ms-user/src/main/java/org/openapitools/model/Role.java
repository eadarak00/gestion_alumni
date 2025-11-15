package org.openapitools.model;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.lang.Nullable;


import io.swagger.v3.oas.annotations.media.Schema;



import jakarta.annotation.Generated;


/**
 * Role
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-14T21:47:29.555388808Z[Africa/Dakar]", comments = "Generator version: 7.17.0")
public class Role {

  private @Nullable Integer id;

  private @Nullable String libelle;

  public Role id(@Nullable Integer id) {
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

  public Role libelle(@Nullable String libelle) {
    this.libelle = libelle;
    return this;
  }

  /**
   * Get libelle
   * @return libelle
   */
  
  @Schema(name = "libelle", example = "ALUMNI", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("libelle")
  public @Nullable String getLibelle() {
    return libelle;
  }

  public void setLibelle(@Nullable String libelle) {
    this.libelle = libelle;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Role role = (Role) o;
    return Objects.equals(this.id, role.id) &&
        Objects.equals(this.libelle, role.libelle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, libelle);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Role {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    libelle: ").append(toIndentedString(libelle)).append("\n");
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

