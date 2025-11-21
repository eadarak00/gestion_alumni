package com.gestional.msuser.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "is_email_verified")
    private boolean emailVerified = false;

    @Column(name = "validation_code")
    private String validationCode;

    @Column(name = "validation_code_expiry")
    private Instant validationCodeExpiry;

    // Constructors
    public User() {}

    public User(String email) { this.email = email; }

    // Getters / Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public boolean isEmailVerified() { return emailVerified; }
    public void setEmailVerified(boolean emailVerified) { this.emailVerified = emailVerified; }
    public String getValidationCode() { return validationCode; }
    public void setValidationCode(String validationCode) { this.validationCode = validationCode; }
    public Instant getValidationCodeExpiry() { return validationCodeExpiry; }
    public void setValidationCodeExpiry(Instant validationCodeExpiry) { this.validationCodeExpiry = validationCodeExpiry; }
}
