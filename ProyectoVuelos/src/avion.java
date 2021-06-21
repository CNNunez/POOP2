public class avion {
    // atributos
    int Size;
    String Condition;

    //constructores
    avion(){
        Size = 0;
        Condition = "";
    }

    avion(int newSize, String newCondition){
        Size = newSize;
        Condition = newCondition;
    }

    // métodos
    int getSize(){
        return Size;
    }

    String getCondicion(){
        return Condition;
    }

    void setCondicion(String newCondition){
        Condition = newCondition;
    }

}
