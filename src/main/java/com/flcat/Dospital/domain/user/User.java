package com.flcat.Dospital.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flcat.Dospital.domain.pet.Pet;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 30, unique = true)
    private String userName;

    @JsonIgnore
    private String password;

    private String name;
    private String phone;

    private String profileImageUrl;

    private String provider; // google, kakao
    private String role;

    @CreationTimestamp
    private Timestamp createDate;

    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user")
    private List<Pet> pets;

}
