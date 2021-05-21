package com.talleres.guia7.controller;

import com.talleres.guia7.model.dao.UsuarioImpl;
import com.talleres.guia7.model.dto.UsuarioDto;
import com.talleres.guia7.model.entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {
    @PostMapping
    public ResponseEntity crearUsuario(@RequestBody UsuarioDto usuarioDto) throws Exception {
        new UsuarioImpl().crear(usuarioDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity actualizarUsuario(@RequestBody UsuarioDto usuarioDto) throws Exception {
        new UsuarioImpl().actualizar(usuarioDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarUsuario(@PathVariable("id") String id) throws Exception {
        new UsuarioImpl().eliminar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() throws Exception {
        List<UsuarioDto> usuarios = new UsuarioImpl().listar();
        return new ResponseEntity<>(usuarios,HttpStatus.OK);
    }

}
