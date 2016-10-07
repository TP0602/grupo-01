package ar.fiuba.tdd.tp1.graph;

import ar.fiuba.tdd.tp1.cell.Cell;
import ar.fiuba.tdd.tp1.cell.InputCell;
import ar.fiuba.tdd.tp1.gameboard.GameBoard;
import ar.fiuba.tdd.tp1.graph.linkeable.OLDLinkeableSquare;
import ar.fiuba.tdd.tp1.graph.linkeable.OLDLinkedCell;
import ar.fiuba.tdd.tp1.graph.linker.OLDConcreteSquareLinker;
import ar.fiuba.tdd.tp1.graph.linker.OLDSquareLinker;
import ar.fiuba.tdd.tp1.graphSecondIt.linker.ConcreteSquareLinker;
import ar.fiuba.tdd.tp1.graphSecondIt.linker.SquareLinker;
import javafx.util.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by juanma on 06/10/16.
 */
public class LinkedGraphTests {

    @Test
    public void testLinkTwoLinkedCells(){
        OLDLinkeableSquare a1 = new OLDLinkedCell("");
        OLDLinkeableSquare a2 = new OLDLinkedCell("");

        a1.setRightLinked(a2);
        //up to here a1 can go to a2 BUT a2 CANT go to a1

        a2.setLeftLinked(a1);
        //now a1 can go to a2 and a2 can go to a1

        assertEquals(a2, a1.getRightLinked());
        assertEquals(a1, a2.getLeftLinked());
    }

/*
    ALL SACAR EL METODO PARA GETEAR Y SETEAR NEIGHBOURS ESTA TEST YA NO SIRVE
    @Test
    public void testLinker(){

        //////////////Se configura el Linker///////////////////////////
        OLDSquareLinker linker = new OLDConcreteSquareLinker();

        String rightOriginToken  = "";
        Set<String> rightDestinationTokens  = new HashSet<>();

        //Lo que esta en ESPANIOL se leeria de la configuracion
        //Los nombres de los Tokens se pueden llamar de cualquier forma, depende de la configuracion, los tokens solo sirven para poder indicar quien se puede linkear con quien
        //Lo seteo para la izquierda:
        rightOriginToken = "DERECHA";
        rightDestinationTokens.add("IZQUIERDA");
        linker.setRightLinkingInfo(rightOriginToken, rightDestinationTokens);
        //Si la celda origen tiene el Token "DERECHA" y la celda de la derecha a la origen tiene el token "IZQUIERDA"
        //entonces se puede establecer un link/arista de la celda origen a la celda destino


        String leftOriginToken = "IZQUIERDA";
        Set<String> leftDestinationTokens   = new HashSet<>();
        leftDestinationTokens.add("DERECHA");
        linker.setLeftLinkingInfo(leftOriginToken, leftDestinationTokens);
        /////////////////////////////////////////////////////



        ////////////////////////CONFIGURACION DEL BOARD////////////////////////
        OLDLinkeableSquare a1 = new OLDLinkedCell();
        OLDLinkeableSquare a2 = new OLDLinkedCell();
        //a1 y a2 se tienen mutuamente como NEIGHBOUR, pero no hay ningun LINK/ARISTA entre ellos
        //Todo: los neighbours podrian saberse del board
        a1.setRightNeighbour(a2);
        a2.setLeftNeighbour(a1);
        //|a1|a2|
        /////////////////////////////////////////////////////////////////////////

        ////////////////////////SIMULACION DEL INPUT DEL USUARIO////////////////////////
        //LOS TOKENS VALIDOS SERIAN LOS QUE SE INDIQUEN EN EL ARCHIVO DE CONFIGURACION, SE PUEDEN LLAMAR DE CUALQUIER FORMA
        //Esto simularia que el usuario ingresa en la celda a1 el dibujo "---" del country road
        Set<String> a1InputTokens  = new HashSet<>();
        Set<String> a2InputTokens  = new HashSet<>();

        a1InputTokens.add("DERECHA");
        a1InputTokens.add("IZQUIERDA");
        a1.setLinkingTokens(a1InputTokens);

        //Ahora el Linker chequea los nuevos links que puede hacer luego de que el usuario ingresara "---" en a1
        //Luego de haber ingresado un input a a1, antes de que el Linker updatee los Links de a1, a1 NO esta linkeada a a2
        assertEquals(null, a1.getLeftLinked());
        linker.updateLinkeablesLinks(a1);
        //Luego de updatear, a1 sigue SIN estar linkeada a a2 xq a2 no tiene cargado ningun Token,
        assertEquals(null, a1.getLeftLinked());



        //Esto simularia que el usuario ingresa en la celda a2 el dibujo "¬" del country road
        a2InputTokens.add("IZQUIERDA");
        a2InputTokens.add("ABAJO");

        ////Luego de haber ingresado un input a a2, antes de que el Linker updatee los Links de a2, a2 NO esta linkeada a a1
        assertEquals(null, a1.getLeftLinked());
        assertEquals(null, a2.getRightLinked());

        a2.setLinkingTokens(a2InputTokens);

        //Luego de updatear, a1 y a2 estan linkeados,
        //porque a1 tiene linking Tokens linkeables por DERECHA   con los linking Tokens de a2 y
        //porque a2 tiene linking Tokens linkeables por IZQUIERDA con los linking Tokens de a2
        linker.updateLinkeablesLinks(a1);
        linker.updateLinkeablesLinks(a2);

        assertEquals(a2, a1.getRightLinked());
        assertEquals(a1, a2.getLeftLinked());

        ////////////////////////////////////////////////////////////////////////////////
    }
*/

    @Test
    public void testLinkerSimulationWithGameBoard() {

        ////////////////////////////////CONFIGURACION DEL BOARD//////////////////////
        GameBoard board = new GameBoard(2, 1);
        board.addCell(0, 0, new InputCell());
        board.addCell(0, 1, new InputCell());
        //|a1|a2|
        ///////////////////////////////////////////////////////////////////////////


        ///////////////////////////////CONFIGURACION DEL LINKER/////////////////////////////////

        SquareLinker linker = new ConcreteSquareLinker(board);
        //Lo que esta en ESPANIOL y los OFFSETS se leerian de la configuracion
        //Los nombres de los Tokens se pueden llamar de cualquier forma, depende de la configuracion, los tokens solo sirven para poder indicar quien se puede linkear con quien
        //Lo seteo para la izquierda, esto :
        int rowOffset = 0;
        int columnOffset = 1;
        String rightOriginToken = "DERECHA";
        Set<String> rightDestinationTokens = new HashSet<>();
        rightDestinationTokens.add("IZQUIERDA");
        linker.setLinkingInfo(rowOffset, columnOffset, rightOriginToken, rightDestinationTokens);
        //Si la celda origen tiene el Token "DERECHA" y la celda de la derecha a la origen tiene el token "IZQUIERDA"
        //entonces se puede establecer un link/arista de la celda origen a la celda destino


        String leftOriginToken = "IZQUIERDA";
        Set<String> leftDestinationTokens = new HashSet<>();
        leftDestinationTokens.add("DERECHA");
        linker.setLinkingInfo(0, -1, leftOriginToken, leftDestinationTokens);
        //////////////////////////////////////////////////////////////////////////////////


        ////////////////////////SIMULACION DEL INPUT DEL USUARIO////////////////////////////////////////
        //LOS TOKENS VALIDOS SERIAN LOS QUE SE INDIQUEN EN EL ARCHIVO DE CONFIGURACION, SE PUEDEN LLAMAR DE CUALQUIER FORMA
        //Esto simularia que el usuario ingresa en la celda a1 el dibujo "---" del country road
        Cell a1 = board.getCell(0, 0);
        Cell a2 = board.getCell(0, 1);

        Set<String> a1InputTokens = new HashSet<>();
        Set<String> a2InputTokens = new HashSet<>();

        a1InputTokens.add("DERECHA");
        a1InputTokens.add("IZQUIERDA");

        a1.setLinkingTokens(a1InputTokens);
        //Ahora el Linker chequea los nuevos links que puede hacer luego de que el usuario ingresara "---" en a1
        //Luego de haber ingresado un input a a1, antes de que el Linker updatee los Links de a1, a1 NO esta linkeada a a2
        assertEquals(null, a1.getLeftLinked());
        linker.updateLinkeablesLinks(0, 0);
        //Luego de updatear, a1 sigue SIN estar linkeada a a2 xq a2 no tiene cargado ningun Token,
        assertEquals(null, a1.getLeftLinked());


        //Esto simularia que el usuario ingresa en la celda a2 el dibujo "¬" del country road
        a2InputTokens.add("IZQUIERDA");
        a2InputTokens.add("ABAJO");
        ////Luego de haber ingresado un input a a2, antes de que el Linker updatee los Links de a2, a2 NO esta linkeada a a1
        assertEquals(null, a1.getLeftLinked());
        assertEquals(null, a2.getRightLinked());

        a2.setLinkingTokens(a2InputTokens);
        //Luego de updatear, a1 y a2 estan linkeados,
        //porque a1 tiene linking Tokens linkeables por DERECHA   con los linking Tokens de a2 y
        //porque a2 tiene linking Tokens linkeables por IZQUIERDA con los linking Tokens de a2
        linker.updateLinkeablesLinks(0, 0);
        linker.updateLinkeablesLinks(0, 1);

        assertEquals(a2, a1.getRightLinked());
        assertEquals(a1, a2.getLeftLinked());

        ////////////////////////////////////////////////////////////////////////////////

    }
}