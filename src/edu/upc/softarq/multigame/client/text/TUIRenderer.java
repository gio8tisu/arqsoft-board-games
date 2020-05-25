/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.softarq.multigame.client.text;

import edu.upc.softarq.multigame.client.UIBoard;
import edu.upc.softarq.multigame.client.UIRenderer;


/**
 *
 * @author JuanCarlos
 */
public class TUIRenderer implements UIRenderer {

    @Override
    public void render(UIBoard b) {
        StringBuilder builder = new StringBuilder();
        for (int i=1; i < 9; i++) {
            System.out.println();
            for (int j=1 ;j < 9; j++) {
                builder.delete(0, builder.length());
                builder.append(i).append(",").append(j);
                TUIPiece p = (TUIPiece)b.getPiece(i, j);
                if (p != null) {
                    builder.delete(0,builder.length());
                    builder.append("[").append(p.getFigure()).append("]");
                    System.out.print(builder.toString());
                } else {
                    System.out.print("[  ]");
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }

//        StringBuilder grid = new StringBuilder("    ");
//        for (int i = 0; i < 8; i++) {
//            grid.append("(").append(i).append(") ");
//        }
//        grid.append("\n");
//        for (int y = 0; y <= 2 * 8; y++) {
//            grid.append((y % 2 == 0) ? "    " : ("(" + y / 2 + ")" + "|"));
//            for (int x = 0; x < 8; x++) {
//                if (y % 2 == 0) {
//                    grid.append("- - ");
//                } else {
//                    grid.append(this.cells[y / 2][x]).append("|");
//                }
//            }
//            if (y != 2 * 8) {
//                grid.append("\n");
//            }
//        }
//        return grid.toString();

}
