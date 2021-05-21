package com.talleres.guia7.model.dao;

import com.talleres.guia7.model.dto.UsuarioDto;

import java.util.List;

public interface IUsuario {
    void crear(UsuarioDto usuarioDto) throws Exception;
    void actualizar(UsuarioDto usuarioDto) throws Exception;
    List<UsuarioDto> listar() throws Exception;
    void eliminar(String id) throws Exception;

}
