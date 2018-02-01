package org.example.demo.ticket.webapp.action;

import java.util.List;
import javax.inject.Inject;

import com.opensymphony.xwork2.ActionSupport;

import org.example.demo.ticket.business.contract.ManagerFactory;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.projet.Version;


/**
 * Action de démo pour les appels AJAX
 */
public class DemoAjaxAction extends ActionSupport {


    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;

    // ----- Eléments en entrée
    private Projet projet;

    // ----- Eléments en sortie
    private List<Projet> listProjet;
    private List<Version> listVersion;


    // ==================== Getters/Setters ====================
    public Projet getProjet() {
        return projet;
    }
    public void setProjet(Projet pProjet) {
        projet = pProjet;
    }
    public List<Projet> getListProjet() {
        return listProjet;
    }
    public List<Version> getListVersion() {
        return listVersion;
    }


    // ==================== Méthodes ====================
    public String execute() {
        listProjet = managerFactory.getProjetManager().getListProjet();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action "AJAX" renvoyant la liste des projets
     * @return success
     */
    public String doAjaxGetListProjet() {
        listProjet = managerFactory.getProjetManager().getListProjet();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action "AJAX" renvoyant la liste des versions d'un projet
     * @return success / error
     */
    public String doAjaxGetListVersion() {
        if (projet == null) {
            addActionError("Le projet doit être précisé !");
        } else {
            listVersion = managerFactory.getProjetManager().getListVersion(projet);
        }

        return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
