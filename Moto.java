import java.util.Date;
public class Moto extends Vehiculo
{
    public Moto(String placa, String marca, String color, Date firstDate, String tipo)
    {
        super(placa, marca, color, firstDate, tipo);
    }
    
    public Moto(String placa, String marca, String color, int valorComercial, Date firstDate, String tipo)
    {
        super(placa, marca, color, valorComercial, firstDate, tipo);
    }
    
    @Override
    public String toString()
    {
        return super.toString();
    }
}
