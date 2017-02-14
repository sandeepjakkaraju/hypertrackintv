package org.springframework.samples.petclinic.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="movies")
public class Movie implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	private String title;
	
	@JsonProperty("value")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Hall> halls = new HashSet<Hall>();
	
	public Movie() {
		super();
	}
	public Movie(String title) {
		this.title = title;
	}
	public Set<Hall> getHalls() {
		return halls;
	}
	public void setHalls(Set<Hall> halls) {
		this.halls = halls;
	}
	
	@JsonProperty("label")
	public String getLabel() {
		return title;
	}
	
	}