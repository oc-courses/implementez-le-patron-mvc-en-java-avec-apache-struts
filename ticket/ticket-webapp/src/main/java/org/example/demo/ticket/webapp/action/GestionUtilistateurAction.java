package org.example.demo.ticket.webapp.action;

import java.util.Collections;

import javax.inject.Inject;

import com.opensymphony.xwork2.ActionSupport;

import org.example.demo.ticket.business.contract.ManagerFactory;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.example.demo.ticket.model.exception.NotFoundException;


/**
 * Action de gestion des {@link Utilisateur}
 */
public class GestionUtilistateurAction extends ActionSupport {


    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;

    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private Utilisateur utilisateur;


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }


    // ==================== Méthodes ====================
    /**
     * Action affichant les détails d'un {@link Utilisateur}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.user.missing.id"));
        } else {
            try {
                utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(id);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.user.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
