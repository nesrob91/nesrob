/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.beans;

/**
 *
 * @author nroblerol
 */
public class DOinfo {
    private String orderID;
    private String tcOrderID;
    private String extPurchaseOrder;
    private int doStatus;
    private int orderType;
    private String facilityAliasO;
    private String facilityAliasD;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getTcOrderID() {
        return tcOrderID;
    }

    public void setTcOrderID(String tcOrderID) {
        this.tcOrderID = tcOrderID;
    }

    public String getExtPurchaseOrder() {
        return extPurchaseOrder;
    }

    public void setExtPurchaseOrder(String extPurchaseOrder) {
        this.extPurchaseOrder = extPurchaseOrder;
    }

    public int getDoStatus() {
        return doStatus;
    }

    public void setDoStatus(int doStatus) {
        this.doStatus = doStatus;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public String getFacilityAliasO() {
        return facilityAliasO;
    }

    public void setFacilityAliasO(String facilityAliasO) {
        this.facilityAliasO = facilityAliasO;
    }

    public String getFacilityAliasD() {
        return facilityAliasD;
    }

    public void setFacilityAliasD(String facilityAliasD) {
        this.facilityAliasD = facilityAliasD;
    }
    
}
