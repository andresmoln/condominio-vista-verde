package com.umg.vistaverde;

import com.umg.vistaverde.model.Condominio;
import com.umg.vistaverde.service.CondominioService;
import com.umg.vistaverde.ui.LoginFrame;

public class CondominioVistaVerde {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            CondominioService service = new CondominioService(new Condominio());
            new LoginFrame(service).setVisible(true);
        });
    }
}