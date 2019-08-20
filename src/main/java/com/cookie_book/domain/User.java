package com.cookie_book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long userId;

    private String name;

    private String email;

    private byte status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
                    name = "join_users_cook_books",
                    joinColumns = {
                            @JoinColumn(
                                    name = "cook_book_id",
                                    referencedColumnName = "id"
                            )
                    },
                    inverseJoinColumns = {
                            @JoinColumn(
                                    name = "user_id",
                                    referencedColumnName = "id"
                            )
                    }
            )
    private Set<CookBook> cookBookSet = new HashSet<>();

    @OneToMany (
            targetEntity = Comment.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Comment> commentList = new ArrayList<>();

}
