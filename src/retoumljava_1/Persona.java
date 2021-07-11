/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoumljava_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ydhurtado
 */
public class Persona {

    private int id;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private char sexo;
    private double altura;
    private double peso;
    private String estado_civil;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the fecha_nacimiento
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the estado_civil
     */
    public String getEstado_civil() {
        return estado_civil;
    }

    /**
     * @param estado_civil the estado_civil to set
     */
    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }
    
    public void crear_persona() {
        System.out.println("Bienvenido. Ingresa los siguientes datos:");
        Scanner datos = new Scanner(System.in);
        
        // Identificación
        System.out.println("Identificación: ");
        int id = Integer.parseInt(datos.nextLine());
        // Nombre
        System.out.println("Nombre: ");
        String nombre = datos.nextLine();
        // Apellido
        System.out.println("Apellido: ");
        String apellido = datos.nextLine();
        // Fecha de nacimiento
        Date fecha_nacimiento = null;
        while(true) {
            System.out.println("Fecha de nacimiento: ");
            SimpleDateFormat formato_fecha = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = datos.nextLine();
            try {
                fecha_nacimiento = formato_fecha.parse(fecha);
                break;
            } catch (ParseException ex) {
                System.out.println("Formato incorrecto!");
            }
        }
        System.out.println("Sexo (M/F): ");
        char sexo = datos.nextLine().charAt(0);
        System.out.println("Estado civil: ");
        String estado_civil = datos.nextLine();
        
        System.out.println("Altura: ");
        double altura = Double.parseDouble(datos.nextLine());
        System.out.println("Peso: ");
        double peso = Double.parseDouble(datos.nextLine());
        
        setId(id);
        setNombre(nombre);
        setApellido(apellido);
        setFecha_nacimiento(fecha_nacimiento);
        setSexo(sexo);
        setAltura(altura);
        setPeso(peso);
        setEstado_civil(estado_civil);
    }
    
    public String consultar_persona(int identificacion) {
        SimpleDateFormat formato_fecha = new SimpleDateFormat("dd/MM/yyyy");
        if (getId() == id) {
            return "\nNombre: " + getNombre() + " " + getApellido()
                    + "\nFecha de nacimiento: " + formato_fecha.format(getFecha_nacimiento())
                    + "\nAltura: " + getAltura() + "mts."
                    + "\nPeso: " + getPeso() + "kg"
                    + "\nEstado civil: " + getEstado_civil();
        }
        
        return "No existe esta persona";
    }

    public String ejercitar(boolean ejercicio, boolean en_volumen){
        double peso_anterior = getPeso();
        if (ejercicio && en_volumen) {
            double peso_actual = getPeso() + 0.5;
            setPeso(peso_actual);
        } else if (ejercicio && !en_volumen) {
            double peso_actual = getPeso() - 0.5;
            setPeso(peso_actual);
        } else if (!ejercicio && en_volumen) {
            double peso_actual = getPeso() - 0.9;
            setPeso(peso_actual);
        }
        
        if (peso_anterior > getPeso()) {
            return getNombre() + " bajó de peso. Ahora pesa " + getPeso() + "kg.";
        } else if (peso_anterior < getPeso()) {
            return getNombre() + " subió de peso. Ahora pesa " + getPeso() + "kg.";
        } else {
            return getNombre() + " ha mantenido el mismo peso";
        }
    }
}
