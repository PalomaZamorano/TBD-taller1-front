package cl.citiaps.spring.backend.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import net.minidev.json.annotate.JsonIgnore;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="film_id", unique=true, nullable=false)
	private int filmId;

	@Column(name="title", nullable=false, length=255)
	private String title;

	@Column(name="description", nullable=false)
	private String description;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;
	
	@JsonIgnore
	@JsonBackReference
	@ManyToMany(mappedBy = "films")
	private Set<Actor> actors = new HashSet<>();
	
	public Film() {
	}
	

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}
	
}