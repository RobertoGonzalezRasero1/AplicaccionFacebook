/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Group;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arasa
 */
public class Metodos {
    /**
     * Configured access data 
     */
    static Facebook facebook ;
    public  void Metodos(){
    ConfigurationBuilder cb = new ConfigurationBuilder();
cb.setDebugEnabled(true)
  .setOAuthAppId("133552037181398")
  .setOAuthAppSecret("768fa7cd8fa76f05e8835e3bf686f758")
  .setOAuthAccessToken("EAAB5dwG8N9YBAHcB1vLZB3FPF5Xzw6Yv83xGHFxhCtcOjYZC4WWQZBXeUDiED1QdH8WkwMMnAjiw4FCRyMpfWoe6n00Dr8X5yp3ypOcnkv3IXMKrH4h9cPR8ilMXEC7OTDOyRxlNQZBwYdvxdGiHiRD5QFR6E2QLcu1WNPqFqDtTW8yeQhk63EHY65FMAbSvlbiktp9LOwZDZD")
  .setOAuthPermissions("email,publish_stream,status_update,...");
FacebookFactory ff = new FacebookFactory(cb.build());
 facebook = ff.getInstance(); 
    }
    /**
     * post a message using a 
     * @param mensaje
     */
 public void postearMensaje(String mensaje){
        
        try {
            facebook.postStatusMessage(mensaje);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
/**
 * publish image 
 */
public void publicaImagen(){
        try {
            PostUpdate post=null;
            try {
                post = new PostUpdate(new URL("http://facebook4j.org"))
                        .picture(new URL("http://cdn01.ib.infobae.com/adjuntos/162/imagenes/014/014/0014014674.jpg"))
                        .name("Facebook4J - A Java library for the Facebook Graph API")
                        .caption("facebook4j.org")
                        .description("Facebook4J is a Java library for the Facebook Graph API.");
            } catch (MalformedURLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
            facebook.postFeed(post);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
}
/**
 * Search theme on time line using a 
 * @param grupo 
 */
public void buscar_Tema_Grupo(String grupo){
        ResponseList<Group> results = null;
    try {
             results = facebook.searchGroups(grupo);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
for(int i=0;i<results.size();i++){
    System.out.println(results.get(i)); 
}
}
/**
 * Publish a comment passing as a 
 * @param comentario 
 */
public void publicaComentario(String comentario){
        try {
            facebook.commentPhoto("127157944496244", comentario);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public void RecojeComentarios(){
        try {
            ResponseList<Post> feed = facebook.getHome();
        
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}
