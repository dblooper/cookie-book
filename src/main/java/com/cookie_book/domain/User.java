package com.cookie_book.domain;

import com.cookie_book.domain.dto.CommentDto;
import com.cookie_book.domain.dto.CookBookDto;
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

    private User(String name, String email, byte status, Set<CookBook> cookBookSet, List<Comment> commentList) {
        this.name = name;
        this.email = email;
        this.status = status;
        this.cookBookSet = cookBookSet;
        this.commentList = commentList;
    }

    public static class Builder {
        private long userId;
        private String name;
        private String email;
        private byte status;
        private Set<CookBook> cookBookSet;
        private List<Comment> commentList;

        public Builder userId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder status(byte status) {
            this.status = status;
            return this;
        }

        public Builder cookBooks(Set<CookBook> cookBookSet) {
            this.cookBookSet = cookBookSet;
            return this;
        }

        public Builder commentList(List<Comment> commentList) {
            this.commentList = commentList;
            return this;
        }

        public User build() {
            return new User(name, email, status, cookBookSet, commentList);
        }
    }


}
