/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cimav.rhglass.client;

import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

/**
 * Main entry point.
 *
 * @author juan.calderon
 */
public class MainEntryPoint implements EntryPoint {

    /**
     * Creates a new instance of MainEntryPoint
     */
    public MainEntryPoint() {
    }

    private boolean isCyan = true;
    
    /**
     * The entry point method, called automatically by loading a module that declares an implementing class as an entry-point
     */
    @Override
    public void onModuleLoad() {
        final Label label = new Label("Hello, GWT!!!");
        final Button button = new Button("Click me!");
        
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String str = " " + (Duration.currentTimeMillis() * 100000) + " <<<<<< ";
                label.setText(str);
                String color = (isCyan = !isCyan) ? "lightblue" : "lightsalmon";
                label.getElement().getStyle().setBackgroundColor(color);
            }
        });
        
        RootPanel.get().add(button);
        RootPanel.get().add(label);
    }
}
