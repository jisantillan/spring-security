package org.javier.usuarios.infrastructure.adapters.rest.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/private")
@RestController
public class HolaController {
//    @GetMapping("/public/hola")
//    public String hola(){
//        return "hola mundo publico";
//    }
//
//    @GetMapping("/admin/hola")
//    public String holaPrivadoAdmin(){
//        return "hola mundo admin securizado";
//    }
//
//    @GetMapping("/user/hola")
//    public String holaPrivadoUser(){
//        return "hola mundo user securizado";
//    }

    @GetMapping("/hola")
    public String holaPrivado(){
        return "hola mundo privado securizado";
    }

}
