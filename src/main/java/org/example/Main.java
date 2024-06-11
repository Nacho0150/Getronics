package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


    abstract class Producto implements Comparable<Producto> {
        private String nombre;
        private int precio;

        public Producto(String nombre, int precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public int getPrecio() {
            return precio;
        }

        @Override
        public int compareTo(Producto otroProducto) {
            return Double.compare(this.precio, otroProducto.precio);
        }

        @Override
        public abstract String toString();
    }

    class Bebida extends Producto {
        private double litros;

        public Bebida(String nombre, double litros, int precio) {
            super(nombre, precio);
            this.litros = litros;
        }

        @Override
        public String toString() {
            return "Nombre: " + getNombre() + " /// Litros: " + litros + " /// Precio: $" + getPrecio();
        }
    }

    class Higiene extends Producto {
        private int contenido;

        public Higiene(String nombre, int contenido, int precio) {
            super(nombre, precio);
            this.contenido = contenido;
        }

        @Override
        public String toString() {
            return "Nombre: " + getNombre() + " /// Contenido: " + contenido + "ml /// Precio: $" + getPrecio();
        }
    }

    class Frutas extends Producto {
        private String unidadVenta;

        public Frutas(String nombre, int precio, String unidadVenta) {
            super(nombre, precio);
            this.unidadVenta = unidadVenta;
        }

        @Override
        public String toString() {
            return "Nombre: " + getNombre() + " /// Precio: $" + getPrecio() + " /// Unidad de venta: " + unidadVenta;
        }
    }

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Bebida("Coca-Cola Zero", 1.5, 20));
        productos.add(new Bebida("Coca-Cola", 1.5, 18));
        productos.add(new Higiene("Shampoo Sedal", 500, 19));
        productos.add(new Frutas("Frutillas", 64, "kilo"));

        for (Producto producto : productos) {
            System.out.println(producto);
        }

        System.out.println("=============================");

        Producto productoMasCaro = Collections.max(productos);
        Producto productoMasBarato = Collections.min(productos);

        System.out.println("Producto más caro: " + productoMasCaro.getNombre());
        System.out.println("Producto más barato: " + productoMasBarato.getNombre());
    }
}