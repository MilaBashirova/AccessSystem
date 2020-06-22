package ru.accesssystem.model;


import lombok.*;

import javax.persistence.*;

/**
 * @author Bashirova Milyausha
 */

@Entity
@AllArgsConstructor
@Builder
@Data
@Table(name = "user_access")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean entrance;
    private String token;


    public User(Long id, String name, Boolean entrance,String token) {
        this.id=id;
        this.name=name;
        this.entrance=entrance;
        this.token=token;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getEntrance() {
        return entrance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEntrance(Boolean entrance) {
        this.entrance = entrance;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
