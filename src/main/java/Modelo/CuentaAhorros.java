/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juanj
 */

public class CuentaAhorros extends Cuenta {
 
    public CuentaAhorros(String numero, String titular, Fecha fecha) {
        super(numero, titular, fecha);
    }
 
    public CuentaAhorros(String numero, String titular, Fecha fecha, double saldo) {
        super(numero, titular, fecha, saldo);
    }
 
    // Solo retira si el valor no supera el saldo
    public boolean retirar(double valor) {
        if (valor <= saldo) {
            saldo = saldo - valor;
            return true;
        } else {
            return false;
        }
    }
 
    public String getTipo() {
        return "Cuenta de Ahorros";
    }
}
