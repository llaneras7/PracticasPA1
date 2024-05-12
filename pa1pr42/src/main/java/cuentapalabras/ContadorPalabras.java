package cuentapalabras;

import java.util.ArrayList;
import java.util.List;

public class ContadorPalabras {
    private List<PalabraEnTexto> palabras;

    public ContadorPalabras() {
        palabras = new ArrayList<>();
    }
    private int esta(String pal){
        PalabraEnTexto p = new PalabraEnTexto(pal);
        for(int i : palabras){
            if(palabras.get(i).equals(p)){
                return i;
            }
        }
        return -1;
    }
    protected void incluye(String pal){
        if(pal != null){
            int pos = esta(pal);
            if(pos < 0){
                if(!pal.isEmpty()){
                    palabra.add(new PalabraEnTexto(pal));
                }
            }else{
                palabras.get(pos).incrementa();
            }
        }

    }
}
