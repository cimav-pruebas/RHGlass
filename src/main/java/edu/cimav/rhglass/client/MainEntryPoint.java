/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cimav.rhglass.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.UmbrellaException;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import edu.cimav.rhglass.client.ui.main.MainUI;
import javax.validation.constraints.NotNull;
import org.fusesource.restygwt.client.Defaults;

/**
 * Main entry point.
 *
 * @author juan.calderon
 */
public class MainEntryPoint implements EntryPoint {

    static {
        /* Default initialize */
        Defaults.setServiceRoot(GWT.getHostPageBaseURL());
        Defaults.ignoreJsonNulls();
        String DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
        Defaults.setDateFormat(DATEFORMAT); //2015-01-14T00:00:00-0700
    }
    
    // Vistas UI
    private final MainUI mainUi;
    
    /**
     * Creates a new instance of MainEntryPoint
     */
    public MainEntryPoint() {
        
        mainUi = new MainUI();
        
        GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
            @Override
            public void onUncaughtException(@NotNull Throwable e) {
                ensureNotUmbrellaError(e);
            }
        });
        
    }

//    private boolean isCyan = true;
    
    /**
     * The entry point method, called automatically by loading a module that declares an implementing class as an entry-point
     */
    @Override
    public void onModuleLoad() {
        
        RootLayoutPanel.get().add(mainUi);

        mainUi.addOptionMenuChangeListener(new MainUI.OptionMenuChangeListener() {
            @Override
            public void onOptionMenuChange(String option) {
                switch (option) {
                    case MainUI.OPT_PERSONAL:
                        mainUi.setCenterPanel("Personal", "Consultas, altas, bajas y cambios", null);
                        break;
                    case MainUI.OPT_DEPARTAMENTOS:
                        mainUi.setCenterPanel("Departamentos", "Consultas, altas, bajas y cambios", null);
                        break;
                    default:
                        mainUi.setCenterPanel(option, "Not Yet Implemented...", null);
                        break;
                }
            }
        });
        
//        final Label label = new Label("Hello, GWT!!!");
//        final Button button = new Button("Click me!");
//        
//        button.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                String str = " " + (Duration.currentTimeMillis() * 100000) + " <<<<<< ";
//                label.setText(str);
//                String color = (isCyan = !isCyan) ? "lightblue" : "lightsalmon";
//                label.getElement().getStyle().setBackgroundColor(color);
//            }
//        });
//        
//        RootPanel.get().add(button);
//        RootPanel.get().add(label);
    }
    
    private static void ensureNotUmbrellaError(@NotNull Throwable e) {
        for (Throwable th : ((UmbrellaException) e).getCauses()) {
            if (th instanceof UmbrellaException) {
                ensureNotUmbrellaError(th);
            } else {
                System.err.println(th);
            }
        }
    }
    
}
