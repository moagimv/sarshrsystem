/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.mb;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author S2026987
 */
public class BaseBean<T> extends SpringBeanAutowiringSupport implements Serializable{
    
    private List<String> errorCollectionMsg = new ArrayList<>();
    private boolean list;
    private boolean add;
    private boolean visible;//field
    private List<T> collections = new ArrayList<>();
    private T entity;
    
    public BaseBean() {
    }

    public void initialize() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Cache-Control", "must-revalidate");
        response.setHeader("Expires", "Mon, 8 Aug 2000 10:00:00 GMT");
    }

    public void redirect(String page) {
        try {
            StringBuilder builder = new StringBuilder(page);
            builder.append(".xhtml");
            FacesContext.getCurrentInstance().getExternalContext().redirect(builder.toString());
        } catch (IOException ex) {
            Logger.getLogger(HomeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addInformationMessage(String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "", detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addInformationMessage(String... detail) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String message : detail) {
            stringBuilder.append(message);
            stringBuilder.append(" ");
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "", stringBuilder.toString().trim());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addErrorMessage(String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addErrorMessage(String... detail) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String message : detail) {
            stringBuilder.append(message);
            stringBuilder.append(" ");
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", stringBuilder.toString().trim());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addWarningMessage(String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "", detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addWarningMessage(String... detail) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String message : detail) {
            stringBuilder.append(message);
            stringBuilder.append(" ");
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "", stringBuilder.toString().trim());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public void addError(String... message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String error : message) {
            stringBuilder.append(error);
            stringBuilder.append(" ");
        }
        this.getErrorCollectionMsg().add(stringBuilder.toString());
    }

    public void addInfomation(String... message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String information : message) {
            stringBuilder.append(information);
            stringBuilder.append(" ");
        }
        this.getErrorCollectionMsg().add(stringBuilder.toString());
    }

    public void addWarning(String... message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String warning : message) {
            stringBuilder.append(warning);
            stringBuilder.append(" ");
        }
        this.getErrorCollectionMsg().add(stringBuilder.toString());
    }

    public String defaultRouter(String page) {
        StringBuilder builder = new StringBuilder(page);
        builder.append(".xhtml");
        return builder.toString();
    }

    /**
     * @return the errorCollectionMsg
     */
    public List<String> getErrorCollectionMsg() {
        return errorCollectionMsg;
    }

    /**
     * @param errorCollectionMsg the errorCollectionMsg to set
     */
    public void setErrorCollectionMsg(List<String> errorCollectionMsg) {
        this.errorCollectionMsg = errorCollectionMsg;
    }

    public BaseBean reset() {
        setList(false);
        setAdd(false);
        return this;
    }

    public boolean isList() {
        return list;
    }

    public void setList(boolean list) {
        this.list = list;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public List<T> getCollections() {
        return collections;
    }

    public void setCollections(List<T> collections) {
        this.collections = collections;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public void addEntity(T entity) {
        this.entity = entity;
    }

    public void addCollections(List<T> list) {
        collections.clear();
        collections.addAll(list);
    }

    public void addCollection(T entity) {
        collections.add(entity);
    }

    public void addCollections(Set<T> list) {
        collections.clear();
        collections.addAll(list);
    }

    public void refreshTable(T entity) {
        collections.add(0, entity);
    }

    public void remove(T entity) {
        collections.remove(entity);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public Date formattedDate(String dateString) {
        SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder builder = new StringBuilder(dateString.substring(0, 4));
        builder.append("-");
        builder.append(dateString.substring(4, 6));
        builder.append("-");
        builder.append(dateString.substring(6, 8));
        try {
            return sdfSource.parse(builder.toString());
        } catch (ParseException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
