/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import org.mybatis.guice.transactional.Transactional;



/**
 *
 * @author 2110540
 */
public class MyBATISClienteDAO implements ClienteDAO {

    @Inject
    private ClienteMapper clienteMapper;    
        
    @Override
    public void save(Cliente c) throws PersistenceException{
        try{
            clienteMapper.insertarCliente(c);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar el cliente "+c.toString(),e);
        }        
        
    }
    
    @Override
    public Cliente load(int id) throws PersistenceException {
        try{
            return clienteMapper.consultarCliente(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el cliente "+id,e);
        }   
    }

    @Override
    public List<Cliente> consultarClientes() throws PersistenceException{
        return clienteMapper.consultarClientes();
    }
    
    @Override
    public ItemRentado getItemRentado(int iditem) throws PersistenceException {
        return clienteMapper.getItemRentado(iditem);
    }
    
    @Transactional
    @Override
    public void registrarAlquiler(long docu, int id, Date fechainicio, Date fechafin) throws PersistenceException {
        int idit = clienteMapper.getNextValue();
        clienteMapper.agregarItemRentadoACliente(id,idit,fechainicio, fechafin);
    }
    
    @Override
    public TipoItem consultarTipoItem(int id) throws PersistenceException {
        return clienteMapper.consultarTipoItem(id);
    }
}