package cl.citiaps.spring.backend.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.citiaps.spring.backend.entities.Actor;
import cl.citiaps.spring.backend.repository.FilmRepository;
import cl.citiaps.spring.backend.repository.ActorRepository;
import cl.citiaps.spring.backend.entities.Film;


@RestController  
@RequestMapping("/films")
public class FilmService {
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private ActorRepository actorRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Film> getAllFilms() {
		return filmRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Film findOne(@PathVariable("id") Integer id) {
		return filmRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Film create(@RequestBody Film resource) {
	     return filmRepository.save(resource);
	}
	
	@RequestMapping(value = "/{id}/actors", method = RequestMethod.GET)
	@ResponseBody
	public Set<Actor> getActors(@PathVariable("id") Integer id) {
		return filmRepository.findOne(id).getActors();
	}
	
	@RequestMapping(value = "/{id}/actors/{actorId}", method = RequestMethod.POST)
	@ResponseBody
	public Film addFilm(@PathVariable("id") Integer id, @PathVariable("actorId") Integer actorId) {
		Film film = filmRepository.findOne(id);
		Actor actor = actorRepository.findOne(actorId);
		actor.getFilms().add(film);
		film.getActors().add(actor);
		
		return filmRepository.save(film);
	}
}