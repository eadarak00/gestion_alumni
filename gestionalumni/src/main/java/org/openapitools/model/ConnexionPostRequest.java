package org.openapitools.model;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;


import io.swagger.v3.oas.annotations.media.Schema;



import jakarta.annotation.Generated;


/**
 * ConnexionPostRequest
 */

@JsonTypeName("_connexion_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-14T21:47:29.555388808Z[Africa/Dakar]", comments = "Generator version: 7.17.0")
public class ConnexionPostRequest {

  private @Nullable String email;

  private @Nullable String password;

  public ConnexionPostRequest email(@Nullable String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  
  @Schema(name = "email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public @Nullable String getEmail() {
    return email;
  }

  public void setEmail(@Nullable String email) {
    this.email = email;
  }

  public ConnexionPostRequest password(@Nullable String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   */
  
  @Schema(name = "password", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("password")
  public @Nullable String getPassword() {
    return password;
  }

  public void setPassword(@Nullable String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnexionPostRequest connexionPostRequest = (ConnexionPostRequest) o;
    return Objects.equals(this.email, connexionPostRequest.email) &&
        Objects.equals(this.password, connexionPostRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnexionPostRequest {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

