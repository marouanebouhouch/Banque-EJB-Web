package service;

import metier.BanqueLocal;
import metier.entities.Compte;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("/comptes")
public class BanqueRestService {

    @EJB
    private BanqueLocal metier;

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Compte addCompte(Compte compte) {
        return metier.addCompte(compte);
    }

    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Compte getCompte(@PathParam("code") Long aLong) {
        return metier.getCompte(aLong);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Compte> listComptes() {
        return metier.listComptes();
    }

    @PUT
    @Path("/verser")
    @Produces(MediaType.APPLICATION_JSON)
    public void verser(@FormParam(value = "code") Long aLong,
                       @FormParam(value = "montant") double v) {
        metier.verser(aLong, v);
    }

    @PUT
    @Path("/retirer")
    @Produces(MediaType.APPLICATION_JSON)
    public void retirer(@FormParam(value = "code") Long aLong,
                        @FormParam(value = "montant") double v) {
        metier.retirer(aLong, v);
    }

    @PUT
    @Path("/virement")
    @Produces(MediaType.APPLICATION_JSON)
    public void virement(@FormParam(value = "code1") Long aLong,
                         @FormParam(value = "code2") Long aLong1,
                         @FormParam(value = "montant") double v) {
        metier.virement(aLong, aLong1, v);
    }
}
