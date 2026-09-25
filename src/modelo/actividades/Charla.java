package modelo.actividades;

public class Charla extends Actividad {
    private String disertante;

    public Charla ( int id1, String titulo1, int cupoMaximo1, String disertante1){
        super (id1, titulo1, cupoMaximo1);
        this.disertante = disertante1;
    }
    @Override
    public String getTipo (){
        return "Charla";
    }
    @Override
    public double calcularCostoMateriales (){

        return 0;
    }
}
