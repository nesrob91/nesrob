/**
 * ServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public interface ServiceSoap extends java.rmi.Remote {
    public com.estafeta.www.QueryResult executeQuery(java.lang.String suscriberId, java.lang.String login, java.lang.String password, com.estafeta.www.SearchType searchType, com.estafeta.www.SearchConfiguration searchConfiguration) throws java.rmi.RemoteException;
}
