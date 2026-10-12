/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juanj
 */
public class CuentaCorriente extends Cuenta {
    private double cupoSobregiro;
 
    public CuentaCorriente(String numero, String titular, Fecha fecha, double cupoSobregiro) {
        super(numero, titular, fecha);
        this.cupoSobregiro = cupoSobregiro;
    }
 
    public CuentaCorriente(String numero, String titular, Fecha fecha, double saldo, double cupoSobregiro) {
        super(numero, titular, fecha, saldo);
        this.cupoSobregiro = cupoSobregiro;
    }
 
    // Retira si el valor no supera saldo + cupo de sobregiro (el saldo puede quedar negativo)
    public boolean retirar(double valor) {
        if (valor <= saldo + cupoSobregiro) {
            saldo = saldo - valor;
            return true;
        } else {
            return false;
        }
    }
 
    public String getTipo() {
        return "Cuenta Corriente";
    }
 
    public String imprimir() {
        return super.imprimir() + "\nCupo de sobregiro: " + cupoSobregiro;
    }
}