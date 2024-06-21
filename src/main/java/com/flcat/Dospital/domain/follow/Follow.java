package com.flcat.Dospital.domain.follow;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flcat.Dospital.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
            name="follow",
            uniqueConstraints = {
                @UniqueConstraint(
                    name = "follow_uk",
                    columnNames = {"fromUserId", "toUserId"}
                )
            }
        )   //중복 방지
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnoreProperties({"images"})
    @ManyToOne
    @JoinColumn(name = "fromUserId")
    private User fromUser;

    @CreationTimestamp
    private Timestamp createDate;
}
