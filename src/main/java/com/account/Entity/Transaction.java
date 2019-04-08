package com.account.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_table")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	Long client;
	Long account;
	Double amount;
	
	public Transaction() {
		
	}
	
	public Transaction(Long id, Long client, Long account, Double amount) {
		super();
		this.id = id;
		this.client = client;
		this.account = account;
		this.amount = amount;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClient() {
		return client;
	}
	public void setClient(Long client) {
		this.client = client;
	}
	public Long getAccount() {
		return account;
	}
	public void setAccount(Long account) {
		this.account = account;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Transaction [id=" + id + ", client=" + client + ", account=" + account + ", amount=" + amount
				+"]";
	}
}
