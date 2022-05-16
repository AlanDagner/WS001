/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.ws001.daolmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.ws001.config.Conexion;
import pe.edu.upeu.ws001.dao.EscuelaDao;
import pe.edu.upeu.ws001.model.Escuela;

/**
 *
 * @author USUARIO
 */
public class EscuelaDaoIMpl implements EscuelaDao{
   private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Escuela esc) {
        String SQL = "INSERT INTO escuela(nombre) VALUES(?)";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, esc.getNombre());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;       
    }

    @Override
    public int update(Escuela esc) {
        String SQL = "UPDATE escuela SET nombre=? WHERE idescuela=?";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, esc.getNombre());
            ps.setInt(2, esc.getIdescuela());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM escuela WHERE idescuela=?";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }
    @Override
    public Escuela read(int id) {
        String SQL = "SELECT *FROM escuela WHERE idescuela=?";
        Escuela esc = new Escuela();
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                esc.setIdescuela(rs.getInt("idescuela"));
                esc.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return esc;
    }

    @Override
    public List<Escuela> readAll() {
        String SQL = "SELECT *FROM escuela";
        List<Escuela> lista = new ArrayList<Escuela>();
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Escuela esc = new Escuela();
                esc.setIdescuela(rs.getInt("idescuela"));
                esc.setNombre(rs.getString("nombre"));
                lista.add(esc);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
    
}
