/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.UnidadMedidaDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DANNY VASQUEZ RAFAEL
 */
public class UnidadMedidaDTOIT {
    
    public UnidadMedidaDTOIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNombre method, of class UnidadMedidaDTO.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        UnidadMedidaDTO instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class UnidadMedidaDTO.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        UnidadMedidaDTO instance = null;
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValorReferencia method, of class UnidadMedidaDTO.
     */
    @Test
    public void testGetValorReferencia() {
        System.out.println("getValorReferencia");
        UnidadMedidaDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getValorReferencia();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValorReferencia method, of class UnidadMedidaDTO.
     */
    @Test
    public void testSetValorReferencia() {
        System.out.println("setValorReferencia");
        float valorReferencia = 0.0F;
        UnidadMedidaDTO instance = null;
        instance.setValorReferencia(valorReferencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcion method, of class UnidadMedidaDTO.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        UnidadMedidaDTO instance = null;
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class UnidadMedidaDTO.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        UnidadMedidaDTO instance = null;
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}