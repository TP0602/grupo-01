package ar.fiuba.tdd.tp1.cell;

/*  */
public class InputCell extends Cell {

    public InputCell(String data) {
        super(data);
    }

    public InputCell() {
        super(null);
    }


    public boolean isEmpty(){
        return (data == "0");
    }

    public void setData(String data) {
        this.data = data;
    }

}
