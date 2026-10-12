/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author juanj
 */
import java.util.ArrayList;
import Modelo.*;
 
public class ControladorBanco {
    private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
 
    public Cuenta buscar(String numero) {
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getNumero().equals(numero)) {
                return cuentas.get(i);
            }
        }
        return null;
    }
 
    public String crearCuentaAhorros(String numero, String titular, Fecha fecha, double saldo) {
        if (buscar(numero) != null) {
            return "Ya existe una cuenta con ese numero";
        }
        cuentas.add(new CuentaAhorros(numero, titular, fecha, saldo));
        return "Cuenta de ahorros creada";
    }
 
    public String crearCuentaCorriente(String numero, String titular, Fecha fecha, double saldo, double cupo) {
        if (buscar(numero) != null) {
            return "Ya existe una cuenta con ese numero";
        }
        cuentas.add(new CuentaCorriente(numero, titular, fecha, saldo, cupo));
        return "Cuenta corriente creada";
    }
 
    public String consignar(String numero, double valor) {
        Cuenta c = buscar(numero);
        if (c == null) {
            return "La cuenta no existe";
        }
        if (valor <= 0) {
            return "El valor debe ser mayor que cero";
        }
        c.consignar(valor);
        return "Consignacion exitosa";
    }
 
    public String retirar(String numero, double valor) {
        Cuenta c = buscar(numero);
        if (c == null) {
            return "La cuenta no existe";
        }
        if (valor <= 0) {
            return "El valor debe ser mayor que cero";
        }
        if (c.retirar(valor)) {
            return "Retiro exitoso";
        } else {
            return "Retiro rechazado: fondos insuficientes";
        }
    }
 
    public String consultarSaldo(String numero) {
        Cuenta c = buscar(numero);
        if (c == null) {
            return "La cuenta no existe";
        }
        return c.imprimir(true);
    }
 
    public String consultarDatos(String numero) {
        Cuenta c = buscar(numero);
        if (c == null) {
            return "La cuenta no existe";
        }
        return c.imprimir();
    }
}
