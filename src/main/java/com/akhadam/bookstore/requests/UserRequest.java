package com.akhadam.bookstore.requests;

import javax.validation.constraints.*;

public class UserRequest {

    @NotBlank(message = "Le nom ne doit pas être null")
    @Size(min = 3, message = "Le nom doit contenir au moins 3 caracteres")
    private String firstName;

    @NotBlank(message = "Le nom ne doit pas être null")
    @Size(min = 3, message = "Le nom doit contenir au moins 3 caracteres")
    private String lastName;

    @NotNull(message = "L email ne doit pas être null")
    @Email(message = "Le format de l email est invalide")
    private String email;

    @NotNull(message = "Le mot de passe ne doit pas être null")
    @Size(min = 8, message = "le mot de passe doit dépasser 6 carcteeres")
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",
            message = "Le mot de passe doit avoir des lettres en minuscule et majuscule, des numéros ")
    private String password;

    private Boolean isAdmin= false;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
