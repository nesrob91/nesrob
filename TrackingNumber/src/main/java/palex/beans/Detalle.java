/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palex.beans;

/**
 *
 * @author DPARRA
 */
public class Detalle {
    
    private String Identificador;
    private String Contenido;
    private double ValorDeclarado;
    private Dimensiones dimensiones;

    public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    public double getValorDeclarado() {
        return ValorDeclarado;
    }

    public void setValorDeclarado(double ValorDeclarado) {
        this.ValorDeclarado = ValorDeclarado;
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(Dimensiones dimensiones) {
        this.dimensiones = dimensiones;
    }
    
        
}
