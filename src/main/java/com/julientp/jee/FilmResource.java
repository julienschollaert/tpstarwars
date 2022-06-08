package com.julientp.jee;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("film")
public class FilmResource {

    @Inject
    Request request;

    @EJB
    FilmBean fBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response listFilm() {
        // return Response.ok(request.getAll()).build();
        return Response.ok(fBean.getFilm()).build();
    }

    @POST
    @Path("/insert")
    public Response insertFilm(film films) {
        fBean.addFilms(films);
        return Response.ok("Success 200").build();
    }

    /*
     * if (test)
     * return Response.ok("Success 200").build();
     * else
     * return Response.status(405, "error").build();
     */

    /*
     * @PUT
     * 
     * @Path("/update/{id}")
     * public Response updateFilm()
     * {
     * 
     * }
     */
    @DELETE
    @Path("/delete/{id}")
    public Response deleteFilm(@PathParam("id") Integer id) {
        fBean.deleteFilms(id);
        return Response.ok("success delete").build();
    }
    /*
     * @DELETE
     * 
     * @Path("{name}")
     * public Response deleteCrewMember(@PathParam("name") String name) {
     * crewMembers.removeIf(crewMember ->
     * crewMember.getName().equalsIgnoreCase(name));
     * return Response.ok(crewMembers.size()).build();
     * }
     * 
     * 
     * 
     */

}
