package com.themyntt.dStock.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class UserModel {
    @Id
    @Column(name = "id_usuario")
    private int id;

    @Column(name = "nome_usuario")
    private String nome;

    @Column(name = "senha_usuario")
    private String password;
}
