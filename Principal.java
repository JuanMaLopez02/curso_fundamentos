import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.util.Date;
public class Principal
{   
    public static void main (String [] args){
        Scanner entrada = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);        
        
        System.out.println("Ingrese el numero de pisos deseados: ");
        int pisos = entrada.nextInt();
        
        System.out.println("Ingrese el numero de espacios deseados: ");
        int espacios = entrada.nextInt();
        
        Vehiculo.vehiculos = new Vehiculo[pisos][espacios];
        Sensor.sensores = new Sensor[pisos][espacios];
        
         for(int i = 0; i < Sensor.sensores.length; i++){
           for(int j = 0; j < Sensor.sensores[0].length; j++){
               if(Sensor.sensores[i][j]==null){
                    Sensor.sensores[i][j] = new Sensor(0);
               }
           }
        }
        Vehiculo.tamano = pisos * espacios;
        System.out.println("Ingrese el costo por hora para parquear carros: ");
        int costoCarro = entrada.nextInt();
       
        System.out.println("Ingrese el costo por hora para parquear motos: ");
        int costoMoto = entrada.nextInt();
        
        System.out.println("Que desea hacer:");
        int accion = entrada.nextInt();
        while(accion >= 0){
            if(accion == 0){
                System.out.println("Saliendo");
                break;
            }
            switch(accion){
                case 1:
                    System.out.println(Sensor.sensorLibre());
                    break;
                case 2:
                    System.out.println("Ingrese el piso para estacionar: ");
                    int piso = entrada.nextInt();
                    System.out.println("Ingrese el espacio para estacionar: ");
                    int espacio = entrada.nextInt();
                    Sensor sensor = Sensor.sensores[piso-1][espacio-1];
                    if(sensor.getEstado()== 0){
                        System.out.println("Ingrese el tipo de Vehiculo");
                        String tipo = entrada2.nextLine().toLowerCase();
                        System.out.println("Ingrese la placa del vehiculo: ");
                        String placa = entrada2.nextLine();
                        System.out.println("Ingrese la marca del vehiculo: ");
                        String marca = entrada2.nextLine();
                        System.out.println("Ingrese el color del vehiculo: ");
                        String color = entrada2.nextLine();
                        Vehiculo vehiculo; 
                        Date firstDate;
                        if(tipo.equals("moto"))
                        {
                            firstDate = new Date();
                            vehiculo = new Moto(placa,marca,color,firstDate,tipo);
                        }else
                        {
                            firstDate = new Date();
                            vehiculo = new Carro(placa,marca,color,firstDate,tipo);
                        }
                        Vehiculo.vehiculos[piso-1][espacio-1] = vehiculo;
                        vehiculo.setCantidad(1);
                        sensor.setEstado(1);
                        System.out.println(vehiculo.toString());
                    }else{
                        System.out.println("El espacio esta ocupado, imposible parquear.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el piso para estacionar: ");
                    piso = entrada.nextInt();
                    System.out.println("Ingrese el espacio para estacionar: ");
                    espacio = entrada.nextInt();
                    sensor = Sensor.sensores[piso-1][espacio-1];
                    
                    if(sensor.getEstado()== 0){
                        System.out.println("Ingrese el tipo de Vehiculo");
                        String tipo = entrada2.nextLine().toLowerCase();
                        System.out.println("Ingrese la placa del vehiculo: ");
                        String placa = entrada2.nextLine();
                        System.out.println("Ingrese la marca del vehiculo: ");
                        String marca = entrada2.nextLine();
                        System.out.println("Ingrese el color del vehiculo: ");
                        String color = entrada2.nextLine();
                        System.out.println("Ingrese el valor comercial del vehiculo: ");
                        int valorComercial = entrada2.nextInt();
                        Vehiculo vehiculo;
                        Date firstDate;
                        if(tipo.equals("moto"))
                        {
                            firstDate = new Date();
                            vehiculo = new Moto(placa,marca,color,valorComercial,firstDate,tipo);
                        }else
                        {
                            firstDate = new Date();
                            vehiculo = new Carro(placa,marca,color,valorComercial,firstDate,tipo);
                        }
                        Vehiculo.vehiculos[piso-1][espacio-1] = vehiculo;
                        vehiculo.setCantidad(1);
                        sensor.setEstado(1);
                        System.out.println(vehiculo.toString());
                    }else{
                       System.out.println("El espacio esta ocupado, imposible parquear.");
                    }
                    break;
                case 4:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;
                case 5:
                    System.out.println("Se han creado un total de " + Vehiculo.cantidadVehiculos() + " vehiculos");
                    break;
                case 6:
                    System.out.println("Ingrese el piso: ");
                    piso = entrada.nextInt();
                    System.out.println("Ingrese el espacio: ");
                    espacio = entrada.nextInt();
                    sensor = Sensor.sensores[piso-1][espacio-1];
                    System.out.println(sensor.toString());
                    break;
                case 7:
                    System.out.println(Sensor.sensoresEstado());
                    break;
                case 8:
                    System.out.println("Ingrese el color del vehiculo: ");
                    String color = entrada2.nextLine();
                    for(int i = 0; i < Vehiculo.vehiculos.length; i++){
                       for(int j = 0; j < Vehiculo.vehiculos[0].length; j++){
                           if(Vehiculo.vehiculos[i][j]!=null && Vehiculo.vehiculos[i][j].getColor().equalsIgnoreCase(color)){
                               System.out.println(Vehiculo.vehiculos[i][j].toString());
                           }
                       }
                    }
                    break;
                case 10:
                    System.out.println("Ingrese el piso: ");
                    piso = entrada.nextInt();
                    System.out.println("Ingrese el espacio que desa vaciar: ");
                    espacio = entrada.nextInt();
                    sensor = Sensor.sensores[piso-1][espacio-1];
                    //Obtengo la hora en que sale el vehiculo
                    sensor.setEstado(0);
                    long horaSalida = new Date().getTime(); 
                    if(Vehiculo.vehiculos[piso-1][espacio-1].getTipo().equals("carro"))
                    {
                        //obtengo hora de entrada del vehiculo
                        long horaEntrada = Vehiculo.vehiculos[piso-1][espacio-1].getFirstDate().getTime();
                        long horasParqueadas = horaSalida - horaEntrada;
                        //Convierto el valor de ms a h
                        horasParqueadas = (((horasParqueadas/1000) / 60 ) / 60);
                        //Imprimo el precio
                        System.out.println("El costo de su estacionamiento es de: " + (horasParqueadas * costoCarro));
                    }else{
                        long horaEntrada = Vehiculo.vehiculos[piso-1][espacio-1].getFirstDate().getTime();
                        long horasParqueadas = horaSalida - horaEntrada;
                        horasParqueadas = (((horasParqueadas/1000) / 60 ) / 60);
                        System.out.println("El costo de su estacionamiento es de: " + (horasParqueadas * costoMoto));
                    }
                    break;
                case 11:
                    try {
                        File file = new File("C:/Users/HP/Documents/info.txt");
                        
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fw = new FileWriter(file);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(Vehiculo.toStringVehiculos());
                        bw.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Comando incorrecto");
                    break;
            }
            System.out.println("¿Qué desea hacer?: ");
            accion = entrada.nextInt();
        }
    }
}
