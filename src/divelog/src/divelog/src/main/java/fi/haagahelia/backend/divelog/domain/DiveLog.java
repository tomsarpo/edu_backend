package fi.haagahelia.backend.divelog.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fi.haagahelia.backend.divelog.domain.User;

@Entity
public class DiveLog {
	/*
	divelog - taulu
	
	Name			Type		NULL	Comment
	----			----		----	----
	◆diveid			bigint		☐		IDENTITY (1,1)
	date			date		☒	
	place			varchar 	☒	
	diveplan		text		☒	
	comment			text 		☒	
	image			text		☒	
	diverid			bigint		☒		⇨ user.uid
	*/
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date date;
    private String place;
    private String diveplan;
    private String comment;
    private String image;
    
    @ManyToOne
    @JsonIgnore //many-to-one relaatio vaatii JSON lukemisen katkaisun
    @JoinColumn(name = "diverid")
    private User user;
	
    public DiveLog() {}
    
    public DiveLog(User user, Date date, String place, String diveplan, String comment, String image) {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDiveplan() {
		return diveplan;
	}

	public void setDiveplan(String diveplan) {
		this.diveplan = diveplan;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "DiveLog [id=" + id + ", date=" + date + ", place=" + place + ", diveplan=" + diveplan + ", comment="
				+ comment + ", image=" + image + ", user=" + user + "]";
	}
    
    
	
}
