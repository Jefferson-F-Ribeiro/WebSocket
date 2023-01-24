/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ApplicationScoped
@ServerEndpoint("/acoes")
public class ServidorWebSocket {
    
    @Inject
    private ManipuladorSessao ms;
    
    @OnOpen
    public void abrir(Session s){
        ms.adicionarSessao(s);
    }
    
    @OnClose
    public void fechar(Session s){
        ms.removerSessao(s);
    }
    
    @OnError
    public void erro(Throwable t){
        Logger.getLogger(ServidorWebSocket.class.getName()).log(Level.SEVERE, null, t);
    }
    
    @OnMessage
    public void mensagem(String m, Session s){
        System.out.println("Nova mensagem");
        try(JsonReader jr = Json.createReader(new StringReader(m))){
            JsonObject jo = jr.readObject();
            if(jo.getString("acao").equals("adicionar")){
                Comentario c = new Comentario();
                c.setDescricao(jo.getString("descricao"));
                ms.adicionarComentario();
            }
        }
    }
}
