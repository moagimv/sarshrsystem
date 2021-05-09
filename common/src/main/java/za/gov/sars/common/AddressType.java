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
public enum AddressType {
    RESIDENTIAL("Residential Address"),
    POSTAL("Postal Address");
    
    private final String name;
    
    AddressType(final String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
