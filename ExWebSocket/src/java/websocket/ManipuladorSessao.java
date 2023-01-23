/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket;

import Modelos.Comentario;
import java.util.LinkedList;
import javax.websocket.Session;

public class ManipuladorSessao {
    public final LinkedList<Session> sessoes = new LinkedList<Session>();
    public final LinkedList<Comentario> comentarios = new LinkedList<Comentario>();
    
    public void adicionarSessao(Session e){
        sessoes.add(e);
    }
    
    public void removerSessao(Session s){
        sessoes.remove(s);
    }
    
    public void adicionarComentario(Comentario c){
        comentarios.add(c);
    }
    
    public void removerComentario(Comentario c){
        comentarios.remove(c);
    }
}
