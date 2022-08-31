package fr.dawan.projet1.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String authority;

	public Authority() {
	}

	public Authority(String authority) {
		this.authority = authority;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}