package service;

import metier.BanqueLocal;
import metier.entities.Compte;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class BanqueService {

    @EJB
    private BanqueLocal metier;

    @WebMethod
    public Compte addCompte(@WebParam(name = "compte") Compte compte) {
        return metier.addCompte(compte);
    }

    @WebMethod
    public Compte getCompte(@WebParam(name = "code")Long aLong) {
        return metier.getCompte(aLong);
    }

    @WebMethod
    public List<Compte> listComptes() {
        return metier.listComptes();
    }

    @WebMethod
    public void verser(@WebParam(name = "code")Long aLong,@WebParam(name = "montant") double v) {
        metier.verser(aLong, v);
    }

    @WebMethod
    public void retirer(@WebParam(name = "code")Long aLong, double v) {
        metier.retirer(aLong, v);
    }

    @WebMethod
    public void virement(
            @WebParam(name = "code1")Long aLong,
            @WebParam(name = "code2")Long aLong1,
            @WebParam(name = "montant")double v) {
        metier.virement(aLong, aLong1, v);
    }
}
