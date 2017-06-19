/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facebook;

import facebook.Metodos;
import facebook4j.*;
import facebook4j.conf.ConfigurationBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Arasa
 */
public class Facebook{

  
    public static void main(String[] args) {

        Metodos face = new Metodos();

        /**
         * Application menu
         */
       
        face.Metodos();//applied permisions

        int select;

        do {
            select = Integer.parseInt(JOptionPane.showInputDialog("1. postear mensaje \n 2.publicar imagen \n 3.buscar tema \n 4. comentar en publicacion \n 5.Recoje comentarios\n 6.salir "));
            switch (select) {

                case 1:
                    face.postearMensaje(JOptionPane.showInputDialog("Introduce mensaje"));
                    break;
                case 2:
                    face.publicaImagen();
                    break;
                case 3:
                    face.buscar_Tema_Grupo(JOptionPane.showInputDialog("Introduce tema a buscar"));
                    break;
                case 4:
            {
                face.publicaComentario(JOptionPane.showInputDialog("Introduce comentario en una publicacion "));
            }
                    break;
                case 5:
                    face.RecojeComentarios();
                    break;
            }

        } while (select < 6);
    }

}
