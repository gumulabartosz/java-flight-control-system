package Airplane;

public class Seat {
    int number;
    char column;


    public String getId(){
        return  String.valueOf(this.number)+this.column;
    }
}
