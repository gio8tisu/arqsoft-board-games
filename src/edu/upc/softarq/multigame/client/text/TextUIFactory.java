/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.softarq.multigame.client.text;

import edu.upc.softarq.multigame.client.Client;
import edu.upc.softarq.multigame.client.Color;
import edu.upc.softarq.multigame.client.UIBoard;
import edu.upc.softarq.multigame.client.UIFactory;
import edu.upc.softarq.multigame.client.UIPiece;
import edu.upc.softarq.multigame.client.UIRenderer;



/**
 *
 * @author JuanCarlos
 */
public class TextUIFactory extends UIFactory {

    @Override
    public Client createUIClient() {
        return new TUIClient() ;
    }
    @Override
    public UIBoard createUIBoard() {
        return new TUIBoard() ;
    }

    @Override
    public UIPiece createUIPiece(String type, Color color) {
        return new TUIPiece(type,color) ;
    }

    @Override
    public UIRenderer createRenderer() {
        return new TUIRenderer() ;
    }

    
}
