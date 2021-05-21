package com.talleres.guia7.model.dao;

import com.talleres.guia7.model.Conexion;
import com.talleres.guia7.model.dto.UsuarioDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioImpl implements IUsuario{

    @Override
    public void crear(UsuarioDto usuarioDto) throws Exception {
        int valores =1;
        Connection conn = null;
        PreparedStatement st = null;
        String sql = "INSERT INTO Usuario (tipoID, nroID, nombres, correo, celular)\n" +
                " VALUES (?,?,?,?,?);";

        try {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(valores++,usuarioDto.getTipoID());
            st.setString(valores++,usuarioDto.getNroID());
            st.setString(valores++,usuarioDto.getNombres().toUpperCase());
            st.setString(valores++,usuarioDto.getCorreo());
            st.setString(valores++,usuarioDto.getCelular());
            st.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(st);
        }
    }

    @Override
    public void actualizar(UsuarioDto usuarioDto) throws Exception {
        int valores =1;
        Connection conn = null;
        PreparedStatement st = null;
        String sql = "UPDATE Usuario SET tipoID=?,  nombres=?, correo=?, celular=? WHERE nroID='"+usuarioDto.getNroID()+"';";

        try {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(valores++,usuarioDto.getTipoID());
            st.setString(valores++,usuarioDto.getNombres().toUpperCase());
            st.setString(valores++,usuarioDto.getCorreo());
            st.setString(valores++,usuarioDto.getCelular());
            st.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(st);
        }
    }

    @Override
    public List<UsuarioDto> listar() throws Exception {
        List<UsuarioDto> usuarios = new ArrayList<>();
        UsuarioDto usuarioDto;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql ="SELECT tipoID, nroID, nombres, correo, celular FROM Usuario;";
        try {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                usuarioDto= new UsuarioDto(
                    rs.getString("nroID"),
                    rs.getString("tipoID"),
                    rs.getString("nombres"),
                    rs.getString("correo"),
                    rs.getString("celular")
                );
                usuarios.add(usuarioDto);
            }
        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(rs);
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
        return usuarios;
    }

    @Override
    public void eliminar(String id) throws Exception {

        Connection conn = null;
        PreparedStatement st = null;
        String sql = "DELETE FROM Usuario WHERE nroID='"+id+"';";

        try {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(st);
        }
    }

}
