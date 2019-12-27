package com.eco.authservice.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import static java.util.Collections.*;

@Document
public class User implements UserDetails {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String password;

    private boolean activated;

    private String activationKey;

    private String resetPasswordKey;

    private Set<Authorities> authorities = new HashSet<>();

    private User() {
    }

    private User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private User(String username, String password, boolean activated, Set<Authorities> authorities) {
        this(username,password);
        this.activated = activated;
        this.authorities = authorities;
    }

    public static User newUser(String username, String password){
        return new User(username, password, Boolean.TRUE, new HashSet<>(singletonList(Authorities.ROLE_USER)));
    }

    public static User tempUser(String username, String password){
        return new User(username, password);
    }

    public String getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return new ArrayList<>(authorities);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activated;
    }

    public boolean isActivated() {
        return activated;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public String getResetPasswordKey() {
        return resetPasswordKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}