import java.util.Date;
public class Vehiculo 
{
    public static Vehiculo[][] vehiculos;
    
    public static int tamano;
    
    public static int cantidad = 0;
    
    private String placa;
    
    private String marca;
    
    private String color;
    
    private int valorComercial;
    
    private Date firstDate;
    
    private String tipo;
    public Vehiculo()
    {
        
    }

    public Vehiculo(String placa, String marca, String color, Date firstDate, String tipo)
    {
        this(placa,marca,color,30000000, firstDate, tipo);
    }
    
    public Vehiculo(String placa, String marca, String color, int valorComercial, Date firstDate, String tipo)
    {
        this.placa = placa;
        this.marca = marca;
        this.color = color;
        this.valorComercial = valorComercial;
        this.cantidad = this.cantidad + 1;
        this.firstDate = firstDate;
        this.tipo = tipo;
    }
    
    public String getPlaca()
    {
        return placa;
    }
    
    public String getMarca()
    {
        return marca;
    }
    
    public String getColor()
    {
        return color;
    }
    
    public int getValorComercial()
    {
        return valorComercial;
    }
    
    public Date getFirstDate()
    {
        return firstDate;
    }
    
    public String getTipo()
    {
        return tipo;
    }
    
    public void setTamano(int tamano)
    {
        this.tamano = tamano;
    }
    
    public void setCantidad(int cantidad)
    {
        this.cantidad = this.cantidad;
    }
    
    public void setPlaca(String placa)
    {
        this.placa = placa;
    }
    
    public void setMarca(String marca)
    {
        this.marca = marca;
    }
    
    public void setColor(String color)
    {
        this.color = color;
    }
    
    public void setValorComercial(int valorComercial)
    {
        this.valorComercial = valorComercial;
    }
    
    public void setFirstDate(Date firstDate)
    {
        this.firstDate = firstDate;
    }
    
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
    
    public String toString()
    {
        return placa + " " + marca + " " + color + " " + valorComercial + " " + firstDate + " " + tipo + "\n";
    }
    
    public static String toStringVehiculos()
    {
        String vehiculosParqueados = "";
        for(int i = 0; i < vehiculos.length; i++){
           for(int j = 0; j < vehiculos[0].length; j++){
               if(vehiculos[i][j] != null){
                   vehiculosParqueados = vehiculosParqueados + vehiculos[i][j].toString();
               }
           }
        }
        return vehiculosParqueados;
    }
    
    public static int cantidadVehiculos()
    {
        return cantidad;
    }
    
}
