package libreria;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
        private List<Libro> listaLibros;

        public Libreria() {
            listaLibros = new ArrayList<>();
        }

        public void addLibro(String autor, String titulo, double precioBase) {
            Libro nuevoLibro = new Libro(autor, titulo, precioBase);
            anyadirLibro(nuevoLibro);
        }

        public void remLibro(String autor, String titulo) {
            int indice = buscarLibro(autor, titulo);
            if (indice != -1) {
                listaLibros.remove(indice);
            } else {
                throw new RuntimeException("Libro no encontrado (autor: " + autor + ", título: " + titulo + ")");
            }
        }

        public double getPrecioFinal(String autor, String titulo) {
            int indice = buscarLibro(autor, titulo);
            if (indice != -1) {
                return listaLibros.get(indice).getPrecioFinal();
            } else {
                throw new RuntimeException("Libro no encontrado (autor: " + autor + ", título: " + titulo + ")");
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < listaLibros.size(); i++) {
                sb.append(listaLibros.get(i).toString());
                if (i < listaLibros.size() - 1) {
                    sb.append(",\n");
                }
            }
            sb.append("]");
            return sb.toString();
        }

        protected void anyadirLibro(Libro libro) {
            int indice = buscarLibro(libro.getAutor(), libro.getTitulo());
            if (indice != -1) {
                listaLibros.set(indice, libro);
            } else {
                listaLibros.add(libro);
            }
        }

        private int buscarLibro(String autor, String titulo) {
            for (int i = 0; i < listaLibros.size(); i++) {
                Libro libro = listaLibros.get(i);
                if (libro.getAutor().equalsIgnoreCase(autor) && libro.getTitulo().equalsIgnoreCase(titulo)) {
                    return i;
                }
            }
            return -1;
        }
    }

