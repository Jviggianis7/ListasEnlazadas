/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasdobles;

import javax.swing.JOptionPane;

/**
 *
 * @author Jhon
 */
public class nodo {
    String civil;
    String nombre;
    float talla;
    int peso;
    int edad;
    String munici;
    String nom;
    int id;
    nodo sig,ant;

    public nodo(String civil, String nombre, float talla, int peso, int edad, String munici, String nom, int id) {
        this.civil = civil;
        this.nombre = nombre;
        this.talla = talla;
        this.peso = peso;
        this.edad = edad;
        this.munici = munici;
        this.nom = nom;
        this.id = id;
        sig = ant = null;
    }
    public void ShowInfo(){
         String info = "Información general: \n";
                info += "Registro civil: "+civil+"\n";
                info += "Nombre: "+nombre+"\n";
                info += "Talla: "+talla+"\n";
                info += "Peso: "+peso+"\n";
                info += "Edad: "+edad+"\n";
                info += "Municipio: "+munici+"\n";
                info += "Representante: "+nom+"\n";
                info += "Identificación: "+id+"\n";
        JOptionPane.showMessageDialog(null, info);        
    }
    public void Info(){
        String info = "Información del niño \n";
               info += "Nombre: "+nombre+"\n";
               info += "Talla: "+talla+"\n";
               info += "Peso: "+peso+"\n";
        JOptionPane.showMessageDialog(null, info);
    }
    
    
}
