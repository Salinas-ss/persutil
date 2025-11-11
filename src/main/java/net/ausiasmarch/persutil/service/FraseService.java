package net.ausiasmarch.persutil.service;

import java.util.Random;

public class FraseService {
    
    public String FraseAleatoria(String[] palabras) {
        Random random = new Random();

        StringBuilder frase = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int numeroPalabra = random.nextInt(palabras.length);
            frase.append(palabras[numeroPalabra]).append(" ");
        }

        return frase.toString().trim();
    }
}
