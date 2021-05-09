/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.common;

/**
 *
 * @author S2026987
 */
public enum ContactType {
    LANDLINE("Landline Number"),
    MOBILE("Mobile Number"),
    EMAIL("Email Address"),
    FACEBOOK("Facebook"),
    TWITTER("Twitter"),
    INSTAGRAM("Instagram");
    
    private final String name;
    
    ContactType(final String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
