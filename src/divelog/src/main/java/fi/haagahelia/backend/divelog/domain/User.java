package fi.haagahelia.backend.divelog.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
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
    
    @NotNull
	@Size(min=1, max=60)
    private String firstName;
	
	@NotNull
	@Size(min=1, max=100)
    private String lastName;
	
	@NotNull
	@Size(min=1, max=54)
    private String loginpwd256; //convert to 64-char text by adding 10-char baseword & convert to SHA256
	
	@NotNull
    private boolean adminaccount;
    
    public User() {}
    
    public User(Long id, String firstName, String lastName, String loginpwd256, boolean adminaccount) {
    	//konstruktori jossa kaikki palautettavat arvot määritetty
    	super();
    	this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginpwd256 = loginpwd256;
		this.adminaccount = adminaccount;    	
    }
    
    public User(String firstName, String lastName, String loginpwd256, boolean adminaccount) {
    	//konstruktori jossa tietokantaa varten tarvittavat syötteet määritetty
    	super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginpwd256 = loginpwd256;
		this.adminaccount = adminaccount;    	
    }
    
    //get and set methods from Source -> Generate Getters and Setters
    //toString method from Source -> Generate toString
    //user repository from new -> interface + extends crudrepositiry
    
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
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", loginpwd256=" + loginpwd256
				+ ", adminaccount=" + adminaccount + "]";
	}
    
}
