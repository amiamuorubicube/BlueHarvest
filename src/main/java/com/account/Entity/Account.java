package com.account.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_table")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	Double credit;
	Long client;
	
    public Account() {
		
	}
    public Account(Long id, Double credit, Long client) {
		super();
		this.id = id;
		this.credit = credit;
		this.client = client;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public Long getClient() {
		return client;
	}
	public void setClient(Long client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", credit=" + credit + ", client=" + client + "]";
	}
	
}
