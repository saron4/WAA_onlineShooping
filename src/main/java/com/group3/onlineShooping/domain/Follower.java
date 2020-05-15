package com.group3.onlineShooping.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class Follower {
    public enum FollowerStatus {
        follow,
        unfollow,
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="buyer_id")
    private Buyer buyer ;

    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller ;


    @Enumerated(EnumType.STRING)
    private FollowerStatus followerStatus = FollowerStatus.follow;

    @Override
    public String toString() {
        return "Follower{" +
                "id=" + id +
                ", followerStatus=" + followerStatus +
                '}';
    }
}
