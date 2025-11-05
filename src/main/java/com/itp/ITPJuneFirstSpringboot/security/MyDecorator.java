package com.itp.ITPJuneFirstSpringboot.security;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.itp.ITPJuneFirstSpringboot.model.Role;
import com.itp.ITPJuneFirstSpringboot.model.User;

public class MyDecorator implements UserDetails {

	User user;
	
	public MyDecorator(User user)
	{
		this.user=user;
	}
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        List<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
        }
         
        return authorities;
    }


	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		LocalDate accExpiryDate=this.user.getAccountExpiryDate();  //4 nov 2026
		LocalDate todaysDate=LocalDate.now();                           //5 nov 2025
		if(accExpiryDate.isAfter(todaysDate))
			return true;
		else
			return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		int accLockedStatus=this.user.getAccountLockedStatus();
		if(accLockedStatus==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		LocalDate credExpiryDate=this.user.getCredentialsExpiryDate();  //4 nov 2026
		LocalDate todaysDate=LocalDate.now();                           //5 nov 2025
		if(credExpiryDate.isAfter(todaysDate))
			return true;
		else
			return false;
	}

	@Override
	public boolean isEnabled() {
		int accEnabledStatus=this.user.getAccountEnabledStatus();
		if(accEnabledStatus==1)
			return true;
		else
			return false;
	}

}
