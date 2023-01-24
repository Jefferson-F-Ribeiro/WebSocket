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

        //Precisa ser testada, provavelmente incorreta
        /*
        JsonProvider jp = JsonProvider.provider();
        JsonObject jo = jp.createObjectBuilder().add("acao", "comentarioAdicionado").add("descricao", c.getDescricao()).build();

        for(int i=0;i<comentarios.size();i++){
            System.out.println("Sessao " + i + ", novo comentario: " + comentario.get(i).getDescricao());

            try{
                comentarios.get(i).getBasicRemote().sendText(jo.toString());
            }
            catch(IOException e) {
                e.printStackTrace();
            }

        }*/
    }
    
    public void removerSessao(Session s){
        sessoes.remove(s);
    }
    
    public void adicionarComentario(Comentario c){
        comentarios.add(c);
        JsonProvider jp = JsonProvider.provider();
        JsonObject jo = jp.createObjectBuilder().add("acao", "comentarioAdicionado").add("descricao", c.getDescricao()).build();

        for(int i=0;i<sessoes.size();i++){
            System.out.println("Sessao " + i + ", novo comentario: " + c.getDescricao());

            try{
                sessoes.get(i).getBasicRemote().sendText(jo.toString());
            }
            catch(IOException e) {
                e.printStackTrace();
            }

        }
    }
    
    public void removerComentario(Comentario c){
        comentarios.remove(c);
    }
}
