package org.example.demo.ticket.webapp.converter.locator;

import java.util.Map;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import com.opensymphony.xwork2.conversion.TypeConversionException;

import org.example.demo.ticket.business.contract.ManagerFactory;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.exception.NotFoundException;


/**
 * Locator d'{@link Projet} via son identifiant.
 */
public class ProjetLocator extends StrutsTypeConverter {

    @Inject
    private ManagerFactory managerFactory;


    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;

        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour
                        = StringUtils.isEmpty(vValue)
                        ? null
                        : managerFactory.getProjetManager().getProjet(new Integer(vValue));
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format d'identifiant de projet invalide", pEx);
                } catch (NotFoundException pEx) {
                    throw new TypeConversionException("Projet introuvable", pEx);
                }
            } else {
                vRetour = performFallbackConversion(pContext, pValues, pToClass);
            }
        }

        return vRetour;
    }


    @Override
    public String convertToString(Map pContext, Object pObject) {
        String vString;
        if (pObject instanceof Projet) {
            Projet vProjet = (Projet) pObject;
            vString
                = vProjet.getId() != null
                ? vProjet.getId().toString()
                : "";
        } else {
            vString = "";
        }
        return vString;
    }
}
