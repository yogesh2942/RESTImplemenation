package com.cts.demoRestJersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cts.model.Alien;

@Path("aliens")
public class AlienResource {

	AlienRepository repo = new AlienRepository();

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Alien> getAlienList() {
		System.out.println("Returning Resource from getAlienList:");
		return repo.getAlienList();
	}

	@GET
	@Path("alien/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Alien getAlienById(@PathParam("id") int id) {
		System.out.println("Returning Resource from getAlienById:");
		return repo.getAlienById(id);
	}

	@POST
	@Path("alien")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String createAlien(Alien a1) {
		return repo.createAlien(a1);

	}

	@PUT
	@Path("alien")
	public String updateAlien(Alien a1) {
		if (repo.getAlienById(a1.getId()) == null) {
			return repo.createAlien(a1);
		} else {
			return repo.updateAlien(a1);
		}

	}

	@DELETE
	@Path("alien/{id}")
	public Alien deleteAlien(@PathParam("id") int id) {
		Alien a = repo.getAlienById(id);
		if (a != null)
			repo.deleteAlien(id);
		return a;

	}
}
