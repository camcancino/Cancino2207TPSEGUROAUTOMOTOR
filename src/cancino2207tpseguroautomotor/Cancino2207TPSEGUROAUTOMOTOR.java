package cancino2207tpseguroautomotor;

import java.util.Arrays;
import javax.swing.*;

public class Cancino2207TPSEGUROAUTOMOTOR {

    public static void main(String[] args) {
        
        // PARTE 1: BIENVENIDA
        ImageIcon icon = new ImageIcon("src/img/car-icon.png");
        JOptionPane.showMessageDialog(null, "¡Bienvenidx a CFP SEGUROS! "
                + "\nEl lugar más confiable para proteger su vehículo."
                + "\nACLARACION IMPORTANTE: Para aplicar, su vehículo no debe "
                + " \nllegar a los 20 años de antigüedad."
                + "\nPresione ACEPTAR para comenzar el trámite.",
                "BIENVENIDA", JOptionPane.INFORMATION_MESSAGE, icon);

        //PARTE 2: SOLICITAR DATOS DEL CLIENTE
        String nombre, telefono, email;
        
        //2.A) Nombre
        do {
            nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre completo: ", "Datos Personales", JOptionPane.QUESTION_MESSAGE);

            if (nombre == null) {
                salir();
                nombre = "";
            }

        } while (nombre.equals(""));

        //2.B) Telefono
        do {
            telefono = JOptionPane.showInputDialog(null, "Ingrese su número de teléfono: ", "Datos Personales", JOptionPane.QUESTION_MESSAGE);
            if (telefono == null) {
                salir();
                telefono = "";
            }
        } while (telefono.equals(""));

        //2.C) Email
        do {
            email = JOptionPane.showInputDialog(null, "Ingrese su dirección de e-mail: ", "Datos Personales", JOptionPane.QUESTION_MESSAGE);
            if (email == null) {
                salir();
                email = "";
            }
        } while (email.equals(""));
        
        //datos del cliente
        String datosCliente[] = {nombre,telefono,email};
        
        //PARTE 3: SOLICITAR DATOS DEL VEHÍCULO
        String marca, modelo, dominio, anio;
        String marcas[] = {" ", "La marca no se encuentra en la lista", "Citröen", "Chevrolet", "Fiat", "Ford", "Honda", "Hyundai", "Kia",
            "Mazda", "Mitsubishi", "Nissan", "Peugeot", "Renault", "Suzuki",
            "Toyota", "Volkswagen", "Alfa Romeo", "Aston Martin", "Audi",
            "Bentley", "BMW", "Bugatti", "Ferrari", "Jaguar", "Koenigsegg",
            "Lamborghini", "Maserati", "Porsche", "Rolls-Royce", "Lexus", "Volvo"};
        int antiguedad = 0;
        int agregadoCuota = 500;
        
        // 3.A) Marca
        do {
            marca = (String) JOptionPane.showInputDialog(null, "Indique la marca de su vehículo", "Características del Vehículo", JOptionPane.QUESTION_MESSAGE, null, marcas, marcas[0]);

            if (marca == null) {
                salir();
                marca = "";
            }

        } while (marca.equals(""));

        //Si no encuentra su marca
        if (marca.equals(marcas[1])) {
            do {
                marca = JOptionPane.showInputDialog(null, "Indique su marca:", "Características del Vehículo",
                        JOptionPane.QUESTION_MESSAGE);
                if (marca == null) {
                    salir();
                    marca = "";
                }
            } while (marca.equals(""));
        }

        //3.B) Modelo
        do {
            modelo = JOptionPane.showInputDialog(null, "Indique el modelo de su auto: ", "Características del Vehículo", JOptionPane.QUESTION_MESSAGE);
            if (modelo == null) {
                salir();
                modelo = "";
            }
        } while (modelo.equals(""));

        //3.C) Dominio
        do {
            dominio = JOptionPane.showInputDialog(null, "Indique el dominio de su auto: ", "Características del Vehículo", JOptionPane.QUESTION_MESSAGE);
            if (dominio == null) {
                salir();
                dominio = "";
            }
        } while (dominio.equals(""));

        //3.D) Antiguedad
        do {
            anio = JOptionPane.showInputDialog(null, "Ingrese el año de fabricación de su vehículo (XXXX): ",
                    "Año", JOptionPane.QUESTION_MESSAGE);
            if (anio == null) {
                salir();
                anio = "";
            } 
            if(!anio.equals("")){
                if (Integer.parseInt(anio)<1930 || Integer.parseInt(anio)>2020){
                JOptionPane.showMessageDialog(null, "Ingrese un año válido", null, JOptionPane.WARNING_MESSAGE);
                anio = "";
                } else{
                    antiguedad = 2020 - Integer.parseInt(anio);
                }
            } 
        } while (anio.equals(""));

        //cuota según antigüedad
        if (antiguedad >= 20) {
            JOptionPane.showMessageDialog(null, "No puede aplicar al seguro ya que su vehículo"
                    + " no cumple con los requisitos. Lo lamentamos.", null, JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        } else if (antiguedad != 5) {
            for (int i = 5; i <= antiguedad; i += 5) {
                agregadoCuota += 500;
            }
        }
        int totalAntiguedad = agregadoCuota;
        String datosVehiculo[] = {marca,modelo,dominio,(String)anio};
        
        
        //PARTE 4: SELECCION DE COBERTURA
        Object opcionesCobertura[] = {"Seguridad Civil", "Terceros Completos", "Todo Riesgo"};
        int costosCobertura[] = {1000, 2000, 3000};
        int totalCobertura = 0;
        Object seleccionCobertura;
        
        // elegir cobertura
        do {
            seleccionCobertura = JOptionPane.showInputDialog(null, "Indique la cobertura deseada", "Opciones de Cobertura", JOptionPane.QUESTION_MESSAGE, null, opcionesCobertura, opcionesCobertura[0]);
            if (seleccionCobertura == null) {
                salir();
                seleccionCobertura = "";
            }
            if (seleccionCobertura != "") {
                for (int i = 0; i < opcionesCobertura.length; i++) {
                    if (seleccionCobertura == opcionesCobertura[i]) {
                        totalCobertura = costosCobertura[i];
                    }
                }
            }

        } while (seleccionCobertura.equals(""));

        //PARTE 5: SELECCION DE ADICIONALES DE COBERTURA
        Object adicionales[] = {"Granizo", "Llantas Deportivas", "Asistencia Mecánica", "Localizador GPS"};
        Object adicionalesElegidos[] = new Object[adicionales.length];
        int cantidadAdicionales = 0;
        int totalAdicionales = 0;

        // A) seleccion de adicionales
        for (int i = 0; i < adicionales.length; i++) {
            adicionalesElegidos[i] = JOptionPane.showInputDialog(null, "Indique los adicionales que desea incluir en su seguro\n"
                    + "(presione CANCELAR si desea saltarse este paso): \n " + (i + 1) + "/4:", "Coberturas Adicionales",
                    JOptionPane.QUESTION_MESSAGE, null, adicionales, adicionales[0]);

            // A.1) ver si repitió opción
            // a partir de la segunda vez que elije
            if (i >= 1) {
                //necesito fijarme si la opción ingresada aparece en alguna de las posiciones anteriores
                for (int j = 0; j < i; j++) {
                    //j se repite hasta que alcance a i
                    //si i es 3, j pasa por 0,1,2 para comparar las respuestas
                    if (adicionalesElegidos[j] == adicionalesElegidos[i]) {
                        //si en algún momento j es igual a i, repitió opción
                        JOptionPane.showMessageDialog(null, "Ya eligió esa opción previamente", null, JOptionPane.WARNING_MESSAGE);
                        adicionalesElegidos[i] = "repite";
                        i --;
                    }
                }
            } 

            // A.2) Si no quiere ningún adicional
            if (adicionalesElegidos[i] == null) {
                //si no había ingresado nada
                if (i == 0) {
                    break;
                    //salgo del ciclo
                } else {
                    //si ya había ingresado algo 
                    int resp = JOptionPane.showConfirmDialog(null, "¿Desea salir del menú de coberturas adicionales?", null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    //si desea salir
                    if (resp == JOptionPane.YES_OPTION) {
                        int guardar = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios?", null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (guardar == JOptionPane.YES_OPTION) {
                            break;
                        } else {
                            for (int n = 0; n < adicionalesElegidos.length; n++) {
                                adicionalesElegidos[n] = null;
                            }
                            break;
                        }
                        //salgo del ciclo
                    } else {
                        //si no desea salir
                        i --;
                        continue;
                        //sigo en el ciclo
                    }
                }

            } //fin de A.2

            // A.3) Para que agregue opciones
            //Hasta que ya no pueda agregar más
            if ((i < 3) && (adicionalesElegidos[i + 1] != "repite")) {
                
                if (i != 3) {
                    int resp = JOptionPane.showConfirmDialog(null, "¿Desea agregar otra opción?", null, JOptionPane.YES_NO_OPTION);
                    if (resp == JOptionPane.NO_OPTION) {
                        break;
                        //salgo del ciclo
                    }
                } //fin de A.3
            }
        }//fin de A)selección de adicionales

        // B) Calcular total de adicionales elegidos
        //B.1) ver cuantos eligió
        

        for (Object adicional : adicionalesElegidos) {
            if (adicional != null) {
                cantidadAdicionales++;
            }
        }

        //B.2) sumar los valores
        //solo si eligió alguno
        
            //se repite tantas veces como adicionales haya elegido
            for (int i = 1; i <= cantidadAdicionales; i += 2) {
                //cada 2 suma 300
                totalAdicionales += 300;
            }
        
        
        // 6. TOTAL E IMPRESION DE DATOS
        int totalSeguro = totalAntiguedad + totalCobertura + totalAdicionales;
        imprimir(icon,datosCliente,datosVehiculo,totalAntiguedad,seleccionCobertura,totalCobertura,
                adicionalesElegidos,totalAdicionales,totalSeguro);
        //FIN
        
    }

    public static void salir() {
        
        int salir = JOptionPane.showConfirmDialog(null, "¿Desea salir del sistema de trámites?", null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        //si desea salir
        if (salir == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    public static void imprimir (ImageIcon icon, String[] cliente, String[] vehiculo, int totalAntiguedad, 
                                 Object seleccionCobertura, int totalCobertura, 
                                 Object adicionales[], int totalAdicionales, int totalSeguro){
        
        int nAdicionales = 0;
        for (Object adicional : adicionales) {
            if (!(adicional == null)) {
                nAdicionales++;
            }
        }
        
        Object adicionalesFinal[]= new Object [nAdicionales];
        System.arraycopy(adicionales, 0, adicionalesFinal, 0, nAdicionales);
        
        JOptionPane.showMessageDialog(null, 
                "Felicitaciones, ha completado el trámite.\n"
              +"A continuación podrá ver las características y costo de su seguro: "
              +"\nDATOS DEL CLIENTE"
              +"\nNombre: "+cliente[0]
              +"\nTeléfono: "+cliente[1]
              +"\nE-mail: "+cliente[2]
              +"\nDATOS DEL VEHÍCULO"
              +"\nMarca: "+vehiculo[0]
              +"\nModelo: "+vehiculo[1]
              +"\nDominio: "+vehiculo[2]
              +"\nAño de fabricación: "+vehiculo[3]
              +"\nTIPO DE COBERTURA"
              +"\n"+seleccionCobertura
              +"\nAdicionales: "+Arrays.toString(adicionalesFinal).replace("[","").replace("]","")
              +"\nVALOR DEL SEGURO"
              +"\nAntigüedad: $"+totalAntiguedad
              +"\nCobertura Principal: $"+totalCobertura
              +"\nAdicionales: $"+totalAdicionales
              +"\nTOTAL: $"+totalSeguro
              +"\nGRACIAS POR ELEGIR A CFP SEGUROS",
              "DATOS DE PÓLIZA",JOptionPane.INFORMATION_MESSAGE,icon);
        
    }
    
    
}

