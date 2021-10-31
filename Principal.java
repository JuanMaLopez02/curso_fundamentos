import java.util.Scanner;

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
                        System.out.println("Ingrese la placa del vehiculo: ");
                        String placa = entrada2.nextLine();
                        System.out.println("Ingrese la marca del vehiculo: ");
                        String marca = entrada2.nextLine();
                        System.out.println("Ingrese el color del vehiculo: ");
                        String color = entrada2.nextLine();
                        Vehiculo vehiculo = new Vehiculo(placa,marca,color);
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
                        System.out.println("Ingrese la placa del vehiculo: ");
                        String placa = entrada2.nextLine();
                        System.out.println("Ingrese la marca del vehiculo: ");
                        String marca = entrada2.nextLine();
                        System.out.println("Ingrese el color del vehiculo: ");
                        String color = entrada2.nextLine();
                        System.out.println("Ingrese el valor comercial del vehiculo: ");
                        int valorComercial = entrada2.nextInt();
                        Vehiculo vehiculo = new Vehiculo(placa,marca,color,valorComercial);
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
                default:
                    System.out.println("Comando incorrecto");
                    break;
            }
            System.out.println("¿Qué desea hacer?: ");
            accion = entrada.nextInt();
        }
    }
}
