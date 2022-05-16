/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.ws001.dao;

import java.util.List;
import pe.edu.upeu.ws001.model.Escuela;

/**
 *
 * @author USUARIO
 */
public interface EscuelaDao {
    int create(Escuela esc);
    int update(Escuela esc);
    int delete(int id);
    Escuela read(int id);
    List<Escuela> readAll();
}

