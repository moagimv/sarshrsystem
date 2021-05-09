/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import za.gov.sars.common.ContactType;

/**
 *
 * @author S2026987
 */
@Audited
@Entity
@Table(name = "contact")
public class Contact extends BaseEntity{
    
    @Enumerated(EnumType.STRING)
    private ContactType contactType;
    @Column(name = "contact_details")
    private String contactDetails;

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
    
}
