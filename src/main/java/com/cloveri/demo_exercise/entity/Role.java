package com.cloveri.demo_exercise.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Entity
@Table(name = "ROLE_TABLE")
public class Role implements GrantedAuthority {

    @Id
    @Schema(description = "Идентификатор в БД")
    private Long id;
    @Size(min=2)
    @Schema (description = "Имя пользователя")
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    @Schema (description = "Номер пользователя в БД")
    private Set<User> users;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
