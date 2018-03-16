package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.guice.transactional.Transactional;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    public Cliente consultarCliente(@Param("idcli")int id); 
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("idrent")int id, 
            @Param("iditem") int idit,
            @Param("finicio") Date fechainicio,
            @Param("ffin") Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();
   
    public void insertarCliente(Cliente c);
    
    public TipoItem consultarTipoItem(int id) throws PersistenceException ;
    
    public ItemRentado getItemRentado(int iditem) throws PersistenceException;
    
    int getNextValue();
    
}
