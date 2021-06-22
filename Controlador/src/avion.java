public class avion {
    // atributos
    String Size;
    String Condition;

    //constructores
    avion(){
        Size = "";
        Condition = "";
    }

    avion(String newSize, String newCondition){
        Size = newSize;
        Condition = newCondition;
    }

    // métodos
    String getSize(){
        return Size;
    }

    String getCondicion(){
        return Condition;
    }

    void setCondicion(String newCondition){
        Condition = newCondition;
    }

}