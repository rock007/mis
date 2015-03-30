package com.sam.abcd.data.entity;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class User {

    @Id
    @NotNull
    @Size(max = 64)
    @Column(name = "userName", nullable = false, updatable = false)
    private String userName;
    
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@NotNull
    @Size(max = 64)
    @Column(name = "password", nullable = false)
    private String password;

    public User() {
    }

    public User(final String name, final String password) {
        this.userName = name;
        this.password = password;
    }


	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("userName", userName)
                .add("password", password)
                .toString();
    }
}
