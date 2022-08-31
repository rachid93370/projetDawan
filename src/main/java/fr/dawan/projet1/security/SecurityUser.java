package fr.dawan.projet1.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.dawan.projet1.entities.Utilisateur;

public class SecurityUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private List<? extends GrantedAuthority> authorities;

	private boolean enabled;

	public SecurityUser(Utilisateur user) {
		username = user.getEmail();
		password = user.getMotPasse();
		enabled = user.isEnabled();
		authorities = user.getAuthorities().stream().map(m -> new SimpleGrantedAuthority(m.getAuthority()))
				.collect(Collectors.toList());

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
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
		return enabled;
	}

}