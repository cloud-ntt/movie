package com.ntt.movie.controller;

import com.ntt.movie.entity.Movie;
import com.ntt.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/movie")
public class MovieController {

    @Value("${ruta.servicio.externo1}")
    private String propiedad1;

    @Value("${ruta.servicio.externo2}")
    private String propiedad2;

    @Autowired
    private MovieService movieService;

    @GetMapping("/listar")
    public List<Movie> listarTodos(){
        return movieService.listarTodos();
    }

    @PostMapping("/crear")
    public Movie crearMovie(@RequestBody Movie movie){
        return movieService.crearMovie(movie);
    }

    @GetMapping("/buscar/{id}")
    public Movie buscarPorId(@PathVariable(name="id") Long id) throws IllegalAccessException {
        System.out.println("Propiedad 1: "+propiedad1);
        System.out.println("Propiedad 2: "+propiedad2);

        if(id==10){
            throw new IllegalAccessException("Error por id 10");
        }
        return movieService.buscarPorId(id);
    }

    @GetMapping("/buscarpor")
    public List<Movie> buscarMoviesPorName(@RequestParam(name="name") String name){
        return movieService.buscarMoviesPorName(name);
    }

    @PutMapping("/actualizar/{id}")
    public Movie actualizarMovie(@RequestParam Map<String,String> parametros, @RequestHeader HttpHeaders headers, @PathVariable("id") Long id,
                                 @RequestBody Movie movie){
        System.out.println("Cabeceras: "+headers.toString());
        System.out.println("Parametros: "+parametros.toString());//enviado desde ms gateway AddRequestParameter=color, rojo (yml)
        return movieService.actualizarMovie(id, movie);
    }
}
