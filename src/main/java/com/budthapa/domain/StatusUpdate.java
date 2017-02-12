package com.budthapa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name="status_update")
public class StatusUpdate {
	@Id
	@Column(name="status_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Size(min=5, max=255, message="{addstatus.text.size}")
	@Column(name="status")
	private String text;
	
	@Column(name="added_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date added;
	
	public StatusUpdate(){}
	
	@PrePersist
	private void onCreate(){
		if(added==null){
			added=new Date();
		}
	}

	public StatusUpdate(String text){
		this.text=text;
	}
	
	public StatusUpdate(String text, Date added){
		this.text=text;
		this.added=added;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getAdded() {
		return added;
	}
	public void setAdded(Date added) {
		this.added = added;
	}

	@Override
	public String toString() {
		return "StatusUpdate [id=" + id + ", text=" + text + ", added=" + added + "]";
	}
	
	
}
