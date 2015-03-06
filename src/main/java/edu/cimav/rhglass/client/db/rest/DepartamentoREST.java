/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cimav.rhglass.client.db.rest;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import edu.cimav.rhglass.client.db.domain.Departamento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.JsonCallback;
import org.fusesource.restygwt.client.JsonEncoderDecoder;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.Resource;

/**
 *
 * @author juan.calderon
 */
public class DepartamentoREST extends BaseREST {
    
    public interface JsonCodec extends JsonEncoderDecoder<Departamento> {
    }
    
    public JsonEncoderDecoder jsonCodec = GWT.create(JsonCodec.class);
    
    private static final String URL_REST = Defaults.getServiceRoot() + "api/departamento";
    
    public void findAllBase() {

        org.fusesource.restygwt.client.Defaults.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"); 
         
        HashMap<String, String> headers = new HashMap<>();
        headers.put(Resource.HEADER_CONTENT_TYPE, "application/json; charset=utf-8");

        Resource rb = new Resource(URL_REST + "/base", headers);
        rb.get().send(Ajax.jsonCall(new JsonCallback() {

            @Override
            public void onFailure(Method method, Throwable exception) {
                Window.alert(exception.getLocalizedMessage());

                RESTEvent dbEvent = new RESTEvent(ProviderMethod.FIND_ALL_BASE, TypeResult.FAILURE, exception.getMessage());
                onRESTExecuted(dbEvent);
            }

            @Override
            public void onSuccess(Method method, JSONValue response) {
                List<Departamento> deptos = new ArrayList<>();
                try {
                    JSONArray array = response.isArray();
                    for (int i = 0; i < array.size(); i++) {
                        JSONValue val = array.get(i);
                        
                        Departamento depto  = (Departamento) jsonCodec.decode(val);
                        deptos.add(depto);
                    }
                    RESTEvent dbEvent = new RESTEvent(ProviderMethod.FIND_ALL_BASE, TypeResult.SUCCESS, "");
                    dbEvent.setResult(deptos);
                    onRESTExecuted(dbEvent);
                } catch (Exception e) {
                    RESTEvent dbEvent = new RESTEvent(ProviderMethod.FIND_ALL_BASE, TypeResult.FAILURE, e.getMessage());
                    onRESTExecuted(dbEvent);
                }
            }

        }));

    }
    
}
