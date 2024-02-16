package com.example.palworld;

import java.util.List;

public class Pokemon {
    String contador;
    String nombre;
    String altura;
    String Peso;
    List<String> habilidades;

    public Pokemon(String contador, String nombre) {
        this.contador = contador;
        this.nombre = nombre;
    }

    public Pokemon(String contador, String nombre, String altura, String peso, List<String> habilidades) {
        this.nombre = nombre;
        this.altura = altura;
        Peso = peso;
        this.habilidades = habilidades;
    }
    public String getContador() {
        return contador;
    }
    public void setContador(String contador) {
        this.contador = contador;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAltura() {
        return altura;
    }
    public void setAltura(String altura) {
        this.altura = altura;
    }
    public String getPeso() {
        return Peso;
    }
    public void setPeso(String peso) {
        Peso = peso;
    }
    public List<String> getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
