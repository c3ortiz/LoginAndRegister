package com.codingdojo.LoginRegister.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo nombre es obligatorio")
    @Size(min = 2, max = 30, message = "Nombre debe tener entre 2 y 30 caractéres")
    private String name;

    @NotEmpty(message = "El campo email es obligatorio")
    @Email(message = "Ingrese un email aálido")
    private String email;

    @NotEmpty(message = "El campo password es obligatorio")
    @Size(min = 6, max = 128, message = "Password debe tener entre 6 y 20 caracteres")
    private String password;

    @Transient
    @NotEmpty(message = "El campo confirmacion es obligatorio")
    @Size(min = 6, max = 128, message = "Password debe tener entre 6 y 20 caracteres")
    private String confirmPassword;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
