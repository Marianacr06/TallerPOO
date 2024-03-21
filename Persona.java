/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.persona;

/**
 *
 * @author mac
 */
public class Persona {

    private String nombre;
    private int edad;
    private char sexo;
    private float peso;
    private float altura;
    private String cedula;

    public static final char SEXO_DEF = 'H';
    public static final int INFRAPESO = -1;
    public static final int PESO_IDEAL = 0;
    public static final int SOBREPESO = 1;

    public Persona() {
        this("", 0, SEXO_DEF, 0, 0);
    }

    public Persona(String _nombre, int _edad, char _sexo) {
        this(_nombre, _edad, _sexo, 0, 0);
    }

    public Persona(String _nombre, int _edad, char _sexo, float _peso, float _altura) {
        nombre = _nombre;
        edad = _edad;
        sexo = _sexo;
        altura = _altura;
        generarcdl();
        peso = _peso;
        comprobarSexo();
    }

    private void comprobarSexo() {
        if (sexo != 'H' && sexo != 'M') {
            sexo = 'H';
        }
    }

    private void generarcdl() {
        int divisor = 25;
        int numcdl = (int) (Math.random() * (899999999 - 100000000 + 1) + 100000000);
        int res = numcdl % divisor;
        char letraDNI = generaLetracdl(res);
        cedula = String.format("%010d", numcdl); // Asegurar que la cédula tenga 10 dígitos
    }

    private char generaLetracdl(int _res) {
        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'S', 'J', 'Z',
            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return letras[_res];
    }

    public void setNombre(String _nombre) {
        nombre = _nombre;
    }

    public void setEdad(int _edad) {
        edad = _edad;
    }

    public void setSexo(char _sexo) {
        sexo = _sexo;
    }

    public void setPeso(float _peso) {
        peso = _peso;
    }

    public void setAltura(float _altura) {
        altura = _altura;
    }

    public int calcularIMC() {
        float pesoActual = (float) (peso / Math.pow(altura, 2));
        if (pesoActual >= 20 && pesoActual <= 25) {
            return PESO_IDEAL;
        } else if (pesoActual < 20) {
            return INFRAPESO;
        } else {
            return SOBREPESO;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public void toStringPersona() {
        String _sexo = (sexo == 'H') ? "hombre" : "mujer";
        System.out.println("Informacion de la persona:\n"
                + "Nombre: " + nombre + "\n"
                + "Edad: " + edad + "\n"
                + "Sexo: " + _sexo + "\n"
                + "Cédula: " + cedula + "\n"
                + "Peso: " + peso + "\n"
                + "Altura: " + altura);
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona();

        persona1.setNombre("Michael");
        persona1.setEdad(19);
        persona1.setSexo('H');
        persona1.setPeso(80);
        persona1.setAltura((float) 1.88);

        System.out.println("Persona 1");
        MuestraMensajePeso(persona1);
        MuestraMayorEdad(persona1);
        persona1.toStringPersona();
    }

    public static void MuestraMensajePeso(Persona _persona) {
        int IMC = _persona.calcularIMC();
        switch (IMC) {
            case 0:
                System.out.println("La persona esta en su peso ideal");
                break;
            case -1:
                System.out.println("La persona esta por debajo de su peso ideal");
                break;
            case 1:
                System.out.println("La persona esta por encima de su peso ideal");
                break;
        }
    }

    public static void MuestraMayorEdad(Persona _persona) {
        if (_persona.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad");
        } else {
            System.out.println("La persona no es mayor de edad");
        }
    }
}
