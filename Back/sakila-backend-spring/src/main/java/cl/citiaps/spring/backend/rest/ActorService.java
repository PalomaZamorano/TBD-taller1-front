package cl.citiaps.spring.backend.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import cl.citiaps.spring.backend.entities.Actor;
import cl.citiaps.spring.backend.repository.ActorRepository;
import cl.citiaps.spring.backend.repository.FilmRepository;
import cl.citiaps.spring.backend.entities.Film;

@RestController  
@RequestMapping("/actors")
public class ActorService {

	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private FilmRepository filmRepository;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Actor> getAllUsers() {
		return actorRepository.findAll();
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public  Actor findOne(@PathVariable("id") Integer id) {
		return actorRepository.findOne(id);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Actor create(@RequestBody Actor resource) {
	     return actorRepository.save(resource);
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}/films", method = RequestMethod.GET)
	@ResponseBody
	public Set<Film> getFilms(@PathVariable("id") Integer id) {
		return actorRepository.findOne(id).getFilms();
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}/films/{filmId}", method = RequestMethod.POST)
	@ResponseBody
	public Actor addFilm(@PathVariable("id") Integer id, @PathVariable("filmId") Integer filmId) {
		Film film = filmRepository.findOne(filmId);
		Actor actor = actorRepository.findOne(id);
		actor.getFilms().add(film);
		film.getActors().add(actor);
		
		return actorRepository.save(actor);
	}
	 
}