package com.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Expanses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expanseId;
	
	private String description;
	
	private int amount;
	


	public LocalDateTime getSpenton() {
		return spenton;
	}

	public void setSpenton(LocalDateTime spenton) {
		this.spenton = spenton;
	}

	private LocalDateTime spenton;
	
	@ManyToOne
	@JoinColumn(name ="userId")
	private AnotherUser user;

	public int getExpanseId() {
		return expanseId;
	}

	public void setExpanseId(int expanseId) {
		this.expanseId = expanseId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public AnotherUser getUser() {
		return user;
	}

	public void setUser(AnotherUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Expanses [expanseId=" + expanseId + ", description=" + description + ", amount=" + amount + "]";
	}
	
	

	public Expanses() {
		super();
	}

	public Expanses(int expanseId, String description, int amount) {
		super();
		this.expanseId = expanseId;
		this.description = description;
		this.amount = amount;
	}

	public Expanses(String description, int amount, AnotherUser user) {
		super();
		this.description = description;
		this.amount = amount;
		this.user = user;
	}

	public Expanses(String description, int amount, LocalDateTime spenton, AnotherUser user) {
		super();
		this.description = description;
		this.amount = amount;
		this.spenton = spenton;
		this.user = user;
	}
	
	

}
