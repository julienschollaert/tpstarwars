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
        return Response.ok(fBean.getFilm()).build();
    }

    @POST
    @Path("/insert")
    public Response insertFilm(film films) {
        fBean.addFilms(films);
        return Response.ok("Success 200").build();
    }

    @PUT
    @Path("/update/{id}")
    public Response updateFilm(@PathParam("id") Integer id, film films) {
        fBean.updateFilm(id, films);
        return Response.ok("Success 200").build();

    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteFilm(@PathParam("id") Integer id) {
        fBean.deleteFilms(id);
        return Response.ok("success delete").build();
    }
}
