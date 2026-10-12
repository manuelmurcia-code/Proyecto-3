/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juanj
 */
package Modelo;
 
public abstract class Cuenta {
    protected String numero;
    protected String titular;
    protected Fecha fechaApertura;
    protected double saldo;
 
    // Constructor sin saldo inicial
    public Cuenta(String numero, String titular, Fecha fechaApertura) {
        this.numero = numero;
        this.titular = titular;
        this.fechaApertura = fechaApertura;
        this.saldo = 0;
    }
 
    // Constructor sobrecargado con saldo inicial
    public Cuenta(String numero, String titular, Fecha fechaApertura, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }
 
    public void consignar(double valor) {
        saldo = saldo + valor;
    }
 
    // Cada tipo de cuenta lo implementa a su manera (polimorfismo)
    public abstract boolean retirar(double valor);
 
    public abstract String getTipo();
 
    public String getNumero() { return numero; }
    public double getSaldo() { return saldo; }
 
    // Imprimir todos los datos
    public String imprimir() {
        return "Tipo: " + getTipo() + "\n"
             + "Numero: " + numero + "\n"
             + "Titular: " + titular + "\n"
             + "Fecha de apertura: " + fechaApertura + "\n"
             + "Saldo: " + saldo;
    }
 
    // Imprimir solo el saldo (sobrecarga)
    public String imprimir(boolean soloSaldo) {
        if (soloSaldo) {
            return "Saldo de la cuenta " + numero + ": " + saldo;
        } else {
            return imprimir();
        }
    }
}