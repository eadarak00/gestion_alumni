package org.openapitools.model;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;


import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

/**
 * Utilisateur
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-14T21:47:29.555388808Z[Africa/Dakar]", comments = "Generator version: 7.17.0")
public class Utilisateur {

  private @Nullable Integer id;

  private String nom;

  private String prenom;

  private String email;

  private String telephone;

  private String password;

  private String username;

  /**
   * Gets or Sets sexe
   */
  public enum SexeEnum {
    M("M"),
    
    F("F");

    private final String value;

    SexeEnum(String value) {
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
    public static SexeEnum fromValue(String value) {
      for (SexeEnum b : SexeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private SexeEnum sexe;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateNaissance;

  private Role role;

  private @Nullable Boolean actif;

  private @Nullable String codeValidation;

  private @Nullable Boolean codeExpiration;

  public Utilisateur() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Utilisateur(String nom, String prenom, String email, String telephone, String password, String username, SexeEnum sexe, LocalDate dateNaissance, Role role) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.telephone = telephone;
    this.password = password;
    this.username = username;
    this.sexe = sexe;
    this.dateNaissance = dateNaissance;
    this.role = role;
  }

  public Utilisateur id(@Nullable Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Integer getId() {
    return id;
  }

  public void setId(@Nullable Integer id) {
    this.id = id;
  }

  public Utilisateur nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
   */
  @NotNull 
  @Schema(name = "nom", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Utilisateur prenom(String prenom) {
    this.prenom = prenom;
    return this;
  }

  /**
   * Get prenom
   * @return prenom
   */
  @NotNull 
  @Schema(name = "prenom", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("prenom")
  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Utilisateur email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  @NotNull 
  @Schema(name = "email", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Utilisateur telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * Get telephone
   * @return telephone
   */
  @NotNull 
  @Schema(name = "telephone", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("telephone")
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public Utilisateur password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   */
  @NotNull 
  @Schema(name = "password", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Utilisateur username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   */
  @NotNull 
  @Schema(name = "username", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Utilisateur sexe(SexeEnum sexe) {
    this.sexe = sexe;
    return this;
  }

  /**
   * Get sexe
   * @return sexe
   */
  @NotNull 
  @Schema(name = "sexe", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sexe")
  public SexeEnum getSexe() {
    return sexe;
  }

  public void setSexe(SexeEnum sexe) {
    this.sexe = sexe;
  }

  public Utilisateur dateNaissance(LocalDate dateNaissance) {
    this.dateNaissance = dateNaissance;
    return this;
  }

  /**
   * Get dateNaissance
   * @return dateNaissance
   */
  @NotNull @Valid 
  @Schema(name = "dateNaissance", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dateNaissance")
  public LocalDate getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(LocalDate dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public Utilisateur role(Role role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
   */
  @NotNull @Valid 
  @Schema(name = "role", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("role")
  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Utilisateur actif(@Nullable Boolean actif) {
    this.actif = actif;
    return this;
  }

  /**
   * Get actif
   * @return actif
   */
  
  @Schema(name = "actif", example = "false", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("actif")
  public @Nullable Boolean getActif() {
    return actif;
  }

  public void setActif(@Nullable Boolean actif) {
    this.actif = actif;
  }

  public Utilisateur codeValidation(@Nullable String codeValidation) {
    this.codeValidation = codeValidation;
    return this;
  }

  /**
   * Get codeValidation
   * @return codeValidation
   */
  
  @Schema(name = "codeValidation", example = "482915", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("codeValidation")
  public @Nullable String getCodeValidation() {
    return codeValidation;
  }

  public void setCodeValidation(@Nullable String codeValidation) {
    this.codeValidation = codeValidation;
  }

  public Utilisateur codeExpiration(@Nullable Boolean codeExpiration) {
    this.codeExpiration = codeExpiration;
    return this;
  }

  /**
   * Get codeExpiration
   * @return codeExpiration
   */
  
  @Schema(name = "codeExpiration", example = "true", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("codeExpiration")
  public @Nullable Boolean getCodeExpiration() {
    return codeExpiration;
  }

  public void setCodeExpiration(@Nullable Boolean codeExpiration) {
    this.codeExpiration = codeExpiration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Utilisateur utilisateur = (Utilisateur) o;
    return Objects.equals(this.id, utilisateur.id) &&
        Objects.equals(this.nom, utilisateur.nom) &&
        Objects.equals(this.prenom, utilisateur.prenom) &&
        Objects.equals(this.email, utilisateur.email) &&
        Objects.equals(this.telephone, utilisateur.telephone) &&
        Objects.equals(this.password, utilisateur.password) &&
        Objects.equals(this.username, utilisateur.username) &&
        Objects.equals(this.sexe, utilisateur.sexe) &&
        Objects.equals(this.dateNaissance, utilisateur.dateNaissance) &&
        Objects.equals(this.role, utilisateur.role) &&
        Objects.equals(this.actif, utilisateur.actif) &&
        Objects.equals(this.codeValidation, utilisateur.codeValidation) &&
        Objects.equals(this.codeExpiration, utilisateur.codeExpiration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nom, prenom, email, telephone, password, username, sexe, dateNaissance, role, actif, codeValidation, codeExpiration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Utilisateur {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    sexe: ").append(toIndentedString(sexe)).append("\n");
    sb.append("    dateNaissance: ").append(toIndentedString(dateNaissance)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    actif: ").append(toIndentedString(actif)).append("\n");
    sb.append("    codeValidation: ").append(toIndentedString(codeValidation)).append("\n");
    sb.append("    codeExpiration: ").append(toIndentedString(codeExpiration)).append("\n");
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

