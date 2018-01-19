package org.example.demo.ticket.webapp.converter;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.Fraction;
import org.apache.struts2.util.StrutsTypeConverter;
import com.opensymphony.xwork2.conversion.TypeConversionException;


/**
 * Converter {@link org.apache.commons.lang3.math.Fraction} / {@link String}.
 */
public class FractionConverter extends StrutsTypeConverter {


    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;

        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour = StringUtils.isEmpty(vValue) ? null : Fraction.getFraction(vValue);
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format de fraction invalide", pEx);
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
        if (pObject instanceof Fraction) {
            Fraction vFraction = (Fraction) pObject;
            vString = String.format("%d/%d",
                                    vFraction.getNumerator(),
                                    vFraction.getDenominator());
        } else {
            vString = "";
        }
        return vString;
    }
}
