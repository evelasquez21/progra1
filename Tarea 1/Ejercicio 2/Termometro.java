/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1prograe2;

/**
 *
 * @author eduar
 */
public class Termometro {
    private double celsius;
    private double fahrenheit;
    private double kelvin;
    
    
    public void setCelsius(double celsius) {
        if (celsius >= -273.15){
            this.celsius = celsius;
            this.fahrenheit = (celsius * (9 / 5)) + 32;
            this.kelvin = celsius + 273.15;
            
        }
    }

    public void setFahrenheit(int fahrenheit) {
        if (fahrenheit >= -459.67){
            this.celsius = (fahrenheit - 32) * (9/5);
            this.fahrenheit = fahrenheit;
            this.kelvin = ((fahrenheit - 32) * (9/5)) + 273.15;
            
        }
    }
    

    public void setKelvin(int kelvin) {
        if (fahrenheit >= 0){
            this.celsius = kelvin - 273.15;
            this.fahrenheit = ((kelvin - 273.15) * (9/5)) + 32;
            this.kelvin = kelvin;
        }
    }
    
    public void mostrarConversion(){
        System.out.format("%.2fC, %.2fF, %.2fK", this.celsius, this.fahrenheit, this.kelvin);
    }
    
    
}
