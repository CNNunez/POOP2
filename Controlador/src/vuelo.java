public class vuelo{
    // atributos
    avion Avion;
    String Pista;
    String Puerta;

    //constructores
    vuelo(){
        Avion = new avion();
        Pista = "";
        Puerta = "";
    }

    vuelo(avion newAvion, String newPista, String newPuerta){
        Avion = newAvion;
        Pista = newPista;
        Puerta = newPuerta;
    }

    // métodos
    String getSize(){
        return Avion.getSize();
    }

    String getCondicion(){
        return Avion.getCondicion();
    }

    String getPista(){
        return Pista;
    }

    String getPuerta(){
        return Pista;
    }

    void setCondicion(String newCondition){
        Avion.setCondicion(newCondition);
    }

    void setPista(String newPista){
        Pista = newPista;
    }

    void setPuerta(String newPista){
        Pista = newPista;
    }

}