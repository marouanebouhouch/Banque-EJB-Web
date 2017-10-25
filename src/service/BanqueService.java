package service;

import metier.BanqueLocal;
import metier.entities.Compte;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class BanqueService {

    @EJB
    private BanqueLocal metier;

    @WebMethod
    public Compte addCompte(Compte compte) {
        return metier.addCompte(compte);
    }

    @WebMethod
    public Compte getCompte(Long aLong) {
        return metier.getCompte(aLong);
    }

    @WebMethod
    public List<Compte> listComptes() {
        return metier.listComptes();
    }

    @WebMethod
    public void verser(Long aLong, double v) {
        metier.verser(aLong, v);
    }

    @WebMethod
    public void retirer(Long aLong, double v) {
        metier.retirer(aLong, v);
    }

    @WebMethod
    public void virement(Long aLong, Long aLong1, double v) {
        metier.virement(aLong, aLong1, v);
    }
}
