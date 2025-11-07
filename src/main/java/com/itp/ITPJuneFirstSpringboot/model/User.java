package com.itp.ITPJuneFirstSpringboot.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String username;
	private String password;
	
	private LocalDate accountExpiryDate;
	private LocalDate credentialsExpiryDate;
	private int accountLockedStatus;
	private int accountEnabledStatus;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
			name = "userroles",
			joinColumns = @JoinColumn(name="fkuserId"),
			inverseJoinColumns = @JoinColumn(name="fkroleId")
			)
	List<Role> roles;
}
