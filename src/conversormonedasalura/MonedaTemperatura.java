package conversormonedasalura;

import javax.swing.JOptionPane;

public class MonedaTemperatura {
    
    String opcion="";
    String cambio="";
    double conversion = 0;
    double ingresoMoneda = 0;
    double ingresoTemperatura = 0;
    
    String menuCambio="";
    double celsius = 0;
    double fahrenheit = 0;
    double kelvin = 0;

    
    //Cuadro de diálogo para escoger opciones de MonedaTemperatura o Temperatura
    public void menuMonedaTemperaura(){ 
        String [] opciones = {"Conversor de Moneda","Conversor de Temperatura"};        
        opcion = (String)JOptionPane.showInputDialog(null,"Seleccione una opción de conversión", "Menú",JOptionPane.PLAIN_MESSAGE,null,opciones, opciones[0]);        
        valorConvertir();          
    }
    
    
    //Cuadro de diálogo para ingresar el valor a convertir
    private void valorConvertir(){    
        try {
            if(opcion.equals("Conversor de Moneda")){
                ingresoMoneda = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa la cantidad de dinero que deseas convertir", "Input",JOptionPane.QUESTION_MESSAGE));                            
                menuOpcionesMoneda();                
            }else if(opcion.equals("Conversor de Temperatura")){
                ingresoTemperatura = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa el valor de la temperatura que deseas convertir", "Input",JOptionPane.QUESTION_MESSAGE));                     
                menuOpcionesTemperatura();                
            } 
        }        
        catch (NumberFormatException e) {            
            JOptionPane.showMessageDialog(null, "Valor no válido","Message",JOptionPane.INFORMATION_MESSAGE);
            valorConvertir();
        }        
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Programa terminado","Message",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);            
        }         
    }
    
    
    //Cuadro de diálogo para escoger la moneda a la que se convertirá el dinero
    private void menuOpcionesMoneda(){
        String [] cambioMoneda = {"De Pesos a Dólar", "De Pesos a Euro", "De Pesos a Libras", "De Pesos a Yen", "De Pesos a Won Coreano",
                                  "De Dólar a Pesos", "De Euro a Pesos", "De Libras a Pesos", "De Yen a Pesos", "De Won Coreano a Pesos"};        
        cambio = (String)JOptionPane.showInputDialog(null,"Elige la moneda a la que deseas convertir tu dinero", "Monedas",JOptionPane.PLAIN_MESSAGE,null,cambioMoneda, cambioMoneda[0]);                
        convertir();
        confirmacion();        
        if (cambio == null) {
            JOptionPane.showMessageDialog(null, "Programa terminado","Message",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);            
        }              
    }   
    
    
    //Método para enviar datos a el método calculoValorMoneda() según la moneda a convertir 
    private void convertir(){
        switch(cambio){            
            case "De Pesos a Dólar":                                
                calculoValorMoneda(ingresoMoneda, 0.00021, " Dólares");
                break;                
            case "De Pesos a Euro":                                
                calculoValorMoneda(ingresoMoneda, 0.00019, " Euros");
                break;                
            case "De Pesos a Libras":                                
                calculoValorMoneda(ingresoMoneda, 0.00017, " Libras");
                break;            
            case "De Pesos a Yen":                                
                calculoValorMoneda(ingresoMoneda, 0.027, " Yenes");
                break;                
            case "De Pesos a Won Coreano":                
                calculoValorMoneda(ingresoMoneda, 0.27, " Wones Coreanos");
                break;                
            case "De Dólar a Pesos":                
                calculoValorMoneda(ingresoMoneda, 4851, " COP");
                break;            
            case "De Euro a Pesos":                
                calculoValorMoneda(ingresoMoneda, 5148.80, " COP");
                break;                
            case "De Libras a Pesos":                
                calculoValorMoneda(ingresoMoneda, 5874.12, " COP");
                break;                
            case "De Yen a Pesos":                
                calculoValorMoneda(ingresoMoneda, 36.32, " COP");
                break;                
            case "De Won Coreano a Pesos":               
                calculoValorMoneda(ingresoMoneda, 3.73, " COP");
                break;
        }
    }    
    
    
    //Método que realiza el calculo para convertir de una moneda a otra
    //y muestra un cuadro de diálogo con el resultado de la conversión
    private void calculoValorMoneda(double ingresoMoneda, double operacionMoneda, String nombreMoneda){               
        conversion = ingresoMoneda * operacionMoneda;
        conversion = (double) Math.round(conversion * 100d) / 100;
        JOptionPane.showMessageDialog(null, "Tienes $" + conversion + nombreMoneda,"Message",JOptionPane.INFORMATION_MESSAGE);       
    } 
    
    
    //Cuadro de diálogo para escoger si se desea continuar o salir del programa
    private void confirmacion(){        
        int i = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Select an Option",JOptionPane.INFORMATION_MESSAGE);                    
        if(i == 0){
            menuMonedaTemperaura();
        }else if(i == 1){
            JOptionPane.showMessageDialog(null, "Gracias, hasta pronto!!!");  
        }else{
            JOptionPane.showMessageDialog(null, "Gracias, hasta pronto!!!");  
        }
    }
     
    //***************************************Temperatura*******************************************************************
    
    private void menuOpcionesTemperatura(){        
        String [] cambioTemperatura = {"Grados Celsius a Grados Fahrenheit", "Grados Celsius a Kelvin",
                                  "Grados Fahrenheit a Grados Celsius", "Grados Fahrenheit a kelvin",
                                  "Kelvin a Grados Celsius", "Kelvin a Grados Fahrenheit"};        
        menuCambio = (String)JOptionPane.showInputDialog(null,"Elige una temperatura para convertir", "Temperatura",JOptionPane.PLAIN_MESSAGE,null,cambioTemperatura, cambioTemperatura[0]);                
        convertirTemperatura();
        confirmacion();        
        if (menuCambio == null) {
            JOptionPane.showMessageDialog(null, "Programa terminado","Message",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);            
        }              
    }   
    
    
    private void convertirTemperatura(){
        switch(menuCambio){            
            case "Grados Celsius a Grados Fahrenheit":               
                fahrenheit = (ingresoTemperatura * 1.8) + 32; 
                calculoValorTemperatura(fahrenheit);
                break;                
            case "Grados Celsius a Kelvin":
                kelvin = ingresoTemperatura + 273;
                calculoValorTemperatura(kelvin);
                break;                
            case "Grados Fahrenheit a Grados Celsius":
                celsius = (ingresoTemperatura - 32) / 1.8;
                calculoValorTemperatura(celsius);
                break;            
            case "Grados Fahrenheit a kelvin":
                celsius = (ingresoTemperatura - 32) / 1.8;                
                kelvin = celsius + 273;
                calculoValorTemperatura(kelvin);
                break;                
            case "Kelvin a Grados Celsius":
                celsius = ingresoTemperatura - 273;
                calculoValorTemperatura(celsius);
                break;                
            case "Kelvin a Grados Fahrenheit":
                celsius = ingresoTemperatura - 273;
                fahrenheit = (celsius * 1.8) + 32;
                calculoValorTemperatura(fahrenheit);
                break;            
        }
    }
    
    
    //Método que realiza el redondeo del valor de temperatura
    //y muestra un cuadro de diálogo con el resultado de la conversión
    private void calculoValorTemperatura(double temperatura){                       
        temperatura = (double) Math.round(temperatura * 100d) / 100;
        JOptionPane.showMessageDialog(null, ingresoTemperatura + " " + menuCambio + " son: " + temperatura,"Message",JOptionPane.INFORMATION_MESSAGE);       
    }    
}