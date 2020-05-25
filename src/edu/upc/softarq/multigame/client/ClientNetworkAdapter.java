/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.softarq.multigame.client;

import edu.upc.softarq.multigame.server.chess.network.ChessServerNetworkAdapter;


/**
 *
 * @author JuanCarlos
 */
public class ClientNetworkAdapter {
    
    private ChessServerNetworkAdapter servNetworkAd ;
    
    private ClientProtocolMngr clProtocolMngr ;
    
    public ClientNetworkAdapter(){
        
    }

    public void setClientProtocolMngr(ClientProtocolMngr clProtocolMngr){
        this.clProtocolMngr = clProtocolMngr ;
    }    
    
    public void setServerNetworkAd(ChessServerNetworkAdapter servNetworkAd){
        this.servNetworkAd = servNetworkAd ;
    }
    
    public void sendFromClientToServer(String fromClientToServer) {
        this.servNetworkAd.receiveFromClient(fromClientToServer);
    }
    
    public void receiveFromServer(String fromServerToClient){
        this.clProtocolMngr.receiveFromServer(fromServerToClient) ;
    }

}
