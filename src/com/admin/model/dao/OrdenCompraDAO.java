package com.admin.model.dao;

import com.admin.model.dto.OrdenCompraDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class OrdenCompraDAO {

    OrdenCompraDTO getById(int id){ 
        
        OrdenCompraDTO ordenCompra = null;
        
        return ordenCompra;
    }
    
    ArrayList<OrdenCompraDTO> getByAll(){
        
        
        ArrayList<OrdenCompraDTO> ordenCompras = new ArrayList<>();
        
        
        return ordenCompras;
    }
    
    boolean updateOrdenCompra(){
        boolean estateOperation = true;
        
        return estateOperation;
        
    }
    
    boolean insertOrdenCompra(){
        boolean estateOperation = true;
        
        return estateOperation;
    }     
}
