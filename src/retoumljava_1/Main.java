/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoumljava_1;

/**
 *
 * @author ydhurtado
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona inst_persona = new Persona();
        inst_persona.crear_persona();
        int id = inst_persona.getId();
        System.out.println(inst_persona.consultar_persona(id));
        System.out.println(inst_persona.ejercitar(true, true));
    }
    
}
