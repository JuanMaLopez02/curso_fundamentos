public class Sensor
{
    public static Sensor[][] sensores;

    private int estado;
    
    public Sensor()
    {
        
    }
    
    public Sensor(int estado)
    {
        this.estado = estado;
    }
    
    public int getEstado()
    {
        return estado;
    }
    
    public void setEstado(int estado)
    {
        this.estado = estado;
    }
    
    public String toString()
    {
        if(this.getEstado()==0){
            return "0-Libre";
        }else{
            return "1-Ocupado";
        }
    }
    
    public static String sensorLibre()
    {
        String espaciosLibres = "";
        for(int i = 0; i < sensores.length; i++){
           for(int j = 0; j < sensores[0].length; j++){
               if(sensores[i][j].getEstado()==0){
                    espaciosLibres= espaciosLibres + "Piso " + (i+1) + ", Espacio " + (j+1) + ", Libre\n";
               }
           }
       }
       return espaciosLibres;
    }
    
    public static String sensoresEstado()
    {
        String estadoParqueaderos = "";
        for(int i = 0; i < sensores.length; i++){
           for(int j = 0; j < sensores[0].length; j++){
               if(sensores[i][j].getEstado()!=0){
                   estadoParqueaderos = estadoParqueaderos + "Piso " + (i+1) + ", Espacio " + (j+1) + ", Ocupado\n";
               }else{
                   estadoParqueaderos = estadoParqueaderos + "Piso " + (i+1) + ", Espacio " + (j+1) + ", Libre\n ";
               }
           }
       }
       return estadoParqueaderos;
    }
}
