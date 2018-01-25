package org.example.demo.ticket.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

import org.example.demo.ticket.model.exception.FunctionalException;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.model.exception.TechnicalException;


/**
 * Action de démo pour la gestion des exceptions
 */
public class DemoExceptionAction extends ActionSupport {


    public String doTechnicalException() throws TechnicalException {
        throw new TechnicalException("Une TechnicalException pour la démo...");
    }


    public String doNotFoundException() throws NotFoundException {
        throw new NotFoundException("Une NotFoundException pour la démo...");
    }


    public String doFunctionalException() throws FunctionalException {
        throw new FunctionalException("Une FunctionalException pour la démo...");
    }
}
