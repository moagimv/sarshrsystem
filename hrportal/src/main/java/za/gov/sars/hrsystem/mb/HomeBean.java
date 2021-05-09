/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author S2026987
 */
@ManagedBean
@RequestScoped
public class HomeBean extends BaseBean{
    public void login() {
        redirect("employee");
    }
}
