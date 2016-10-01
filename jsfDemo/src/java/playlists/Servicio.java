/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlists;

import entity.ListaReproduccion;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.PersistenceManager;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.primefaces.json.JSONObject;
/**
 *
 * @author Juleh
 */
@Path("/listas")
@Produces(MediaType.APPLICATION_JSON)
public class Servicio {
    
    @PersistenceContext(unitName = "CompetitorsPU")
    EntityManager entityManager; 
    
    @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
     @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from Competitor u order by u.surname ASC");
        List<ListaReproduccion> listas = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(listas).build();
    } 

    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCompetitor(ListaDTO list) {
        JSONObject rta = new JSONObject();
        ListaReproduccion listaTmp = new ListaReproduccion(list.nombre, list.canciones);
        
 
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(listaTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(listaTmp);
            rta.put("lista_id", listaTmp.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            listaTmp = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    } 
}
