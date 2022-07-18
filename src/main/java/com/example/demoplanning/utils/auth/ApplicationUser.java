package com.example.demoplanning.utils.auth;

import com.example.demoplanning.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Set;

public class ApplicationUser implements UserDetails {


    private final String username;
    private final String password;
    private final Set<? extends GrantedAuthority> grantedAuthorithies;
    private final boolean isAccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final boolean isEnabled;
    public ApplicationUser(User user) {
        this.username = user.getName();
        this.password = user.getPassword();
        this.grantedAuthorithies = user.getAccess(user.getRoleAccess()).getGrantedAuthorities();
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
    }

    @Override
    public Set<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorithies;
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
        return true;
    }
}
