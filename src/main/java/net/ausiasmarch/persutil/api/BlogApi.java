package net.ausiasmarch.persutil.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.persutil.service.AleatorioService;
import net.ausiasmarch.persutil.service.BlogService;
import net.ausiasmarch.persutil.service.FraseService;

@RestController
@RequestMapping("/blog")
public class BlogApi {

    @Autowired
    AleatorioService oAleatorioService;

    @Autowired
    BlogService oBlogService;

    @Autowired
    FraseService oFraseService;
    String [] palabras = {
         "galaxia", "teclado", "búho", "laberinto", "escarcha",
    "murmullo", "destello", "brújula", "espejismo", "cristal",
    "misterio", "relámpago", "susurro", "océano", "fragmento",
    "eco", "vértigo", "tormenta", "horizonte", "cascada",
    "raíces", "cometa", "tempestad", "alborada", "melodía"
    };

    @GetMapping("/saludar")
    public ResponseEntity<String> saludar() {
        return new ResponseEntity<>("\"Hola desde el blog\"", HttpStatus.OK);
    }

    @GetMapping("/saludar/buenosdias")
    public ResponseEntity<String> saludarPorLaMañana() {
        return new ResponseEntity<>("\"Hola buenos dias desde el blog\"", HttpStatus.OK);
    }

    @GetMapping("/aleatorio") //endpoint
    public ResponseEntity<Integer> aleatorio() {
        int numeroAleatorio = (int) (Math.random() * 100) + 1;
        return ResponseEntity.ok(numeroAleatorio);
    }

    @GetMapping("/aleatorio/{min}/{max}") //endpoint
    public ResponseEntity<Integer> aleatorioEnRango(
            @PathVariable int min,
            @PathVariable int max) {
        int numeroAleatorio = (int) (Math.random() * (max - min + 1)) + min;
        return ResponseEntity.ok(numeroAleatorio);
    }

    @GetMapping("/aleatorio/service/{min}/{max}") //endpoint
    public ResponseEntity<Integer> aleatorioUsandoServiceEnRango(
            @PathVariable int min,
            @PathVariable int max) {
        return ResponseEntity.ok(oAleatorioService.GenerarNumeroAleatorioEnteroEnRango(min, max));
    }

    @GetMapping("/rellenauno")
    public ResponseEntity<Long> rellenaBlog() {
        return ResponseEntity.ok(oBlogService.rellenaBlog());
    }

    @GetMapping("/frase")
    public ResponseEntity<String> palabras(){
        return ResponseEntity.ok(oFraseService.FraseAleatoria(palabras));
    }

}
