/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author hcadavid
 */
public interface ClienteDAO {
    
    public void save(Cliente c) throws PersistenceException;
    
    public Cliente load(int id) throws PersistenceException;
    
    public List<Cliente> consultarClientes() throws PersistenceException;
    
    public void registrarAlquiler(long docu, int id, Date fechainicio, Date fechafin) throws PersistenceException ;
    
    public TipoItem consultarTipoItem(int id) throws PersistenceException;
    
    public ItemRentado getItemRentado(int iditem) throws PersistenceException;
    
}
