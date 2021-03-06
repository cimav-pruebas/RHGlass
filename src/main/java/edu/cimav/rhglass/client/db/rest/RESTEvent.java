/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cimav.rhglass.client.db.rest;

/**
 *
 * @author juan.calderon
 */
public class RESTEvent {

    private ProviderMethod dbMethod;
    private TypeResult dbTypeResult;
    private String reason;

    private Object result;

    public RESTEvent(ProviderMethod dbMethod, TypeResult dBTypeResult, String reason) {
        this.dbMethod = dbMethod;
        this.dbTypeResult = dBTypeResult;
        this.reason = reason;
        this.result = null;
    }

    public ProviderMethod getDbMethod() {
        return dbMethod;
    }

    public void setDbMethod(ProviderMethod dbMethod) {
        this.dbMethod = dbMethod;
    }

    public TypeResult getDbTypeResult() {
        return dbTypeResult;
    }

    public void setDbTypeResult(TypeResult dbTypeResult) {
        this.dbTypeResult = dbTypeResult;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
