package fi.haagahelia.backend.divelog.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AdminUser {
	/*
	user – taulu
	
	Name			Type		NULL	Comment
	----			----		----	----
	◆uid			bigint		☐		IDENTITY (1,1)
	firstname		varchar 	☐	
	lastname		varchar 	☐	
	loginpwd256		text 		☒	
	adminaccount	bit			☒		regular users FALSE, admin users TRUE
	*/
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String loginpwd256;
    private boolean adminaccount;
    
    public AdminUser() {}
    
    public AdminUser(Long id, String firstName, String lastName, String loginpwd256, boolean adminaccount) {
    	//konstruktori jossa kaikki palautettavat arvot määritetty
    	super();
    	this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginpwd256 = loginpwd256;
		this.adminaccount = true;  
    }
    
    public AdminUser(String firstName, String lastName, String loginpwd256, boolean adminaccount) {
    	//konstruktori jossa tietokannan tiedot määritetty
    	super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginpwd256 = loginpwd256;
		this.adminaccount = true;  
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginpwd256() {
		return loginpwd256;
	}

	public void setLoginpwd256(String loginpwd256) {
		this.loginpwd256 = loginpwd256;
	}

	public boolean isAdminaccount() {
		return adminaccount;
	}

	public void setAdminaccount(boolean adminaccount) {
		this.adminaccount = adminaccount;
	}

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", loginpwd256="
				+ loginpwd256 + ", adminaccount=" + adminaccount + "]";
	}
	
	
}
