package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import resource.Joueur;

/**
 * Facade Joueur
 */
@Stateless
@Path("resource.joueur")
public class JoueurFacadeREST extends AbstractFacade<Joueur> {
    @PersistenceContext(unitName = "SysDist4PU")
    private EntityManager em;

    public JoueurFacadeREST() {
        super(Joueur.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Joueur entity) {
        super.create(entity);
    }
    
    /**
     *permet l'ajout d'un nouveau joueur
     * @param entity
     */
    @POST
    @Path("Joueur")
    @Consumes({"application/xml", "application/json", "text/xml"})
    public void createPlayer(Joueur entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Joueur entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Joueur find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Joueur> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Joueur> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}