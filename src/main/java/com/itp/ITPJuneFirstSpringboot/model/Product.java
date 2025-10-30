package com.itp.ITPJuneFirstSpringboot.model;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@NotNull(message = "Product Title cannot be null") 
	@Size(min = 3, max = 20, message = "Product Title must be between 3 and 20 characters") 
	private String productTitle;
	
	@NotNull(message = "Product Description cannot be null") 
	@Size(min = 3, max = 50, message = "Product Description must be between 3 and 50 characters") 
	private String productDesc;
	
	@NotNull(message = "Product Category cannot be null") 
	@Size(min = 3, max = 20, message = "Product Category must be between 3 and 20 characters") 
	private String productCategory;
	
	@NotNull(message = "Price cannot be null")
	@Min(value = 100, message = "Price must be at least 100")
	@Max(value = 10000, message = "Price must be less than or equal to 10000")
	private Double price;
	
	private LocalDateTime createdAt;
	
    private LocalDateTime modifiedAt;
	
	@PrePersist
	protected void atCreation()
	{
		LocalDateTime now=LocalDateTime.now();
		this.createdAt=now;
		this.modifiedAt=now;
	}
	
	@PreUpdate
	protected void atUpdation()
	{
		this.modifiedAt=LocalDateTime.now();
	}


}

