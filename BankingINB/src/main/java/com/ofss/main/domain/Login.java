package com.ofss.main.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="login_id")
	private int loginId;
	@Column(name="password")
    private String password;
	@Column(name="attempts")
    private int attempts;
	@Column(name="login_status")
    private String loginStatus;
    
 // Default constructor
    public Login() {
        System.out.println("Default Constructor for Login");
    }

    // Parameterized constructor
    public Login(int loginId, String password, int attempts, String loginStatus) {
        this.loginId = loginId;
        this.password = password;
        this.attempts = attempts;
        this.loginStatus = loginStatus;
        System.out.println("Overloaded Constructor for Login");
    }

    public Login(int loginId, String password){
        this.loginId = loginId;
        this.password = password;
    }
    public Login(String password){
        this.password= password;
    }


	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", password=" + password + ", attempts=" + attempts + ", loginStatus="
				+ loginStatus + "]";
	}
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

}
