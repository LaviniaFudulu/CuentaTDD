
package CuentaPackage;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;




public class CuentaTest {
    private Cuenta Cuenta;
    
    public CuentaTest() {
    }
    
    @BeforeClass
    public static void setUp() {
      
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testIngresar() throws Exception{
        System.out.println("Ingresar: ");
        double cantidad=100.0;
        
        try{
            Cuenta.ingresar(cantidad);
            assertEquals(Cuenta.getSaldo(),100.0);//comprobar que se añadio correctamente
        }
        catch(Exception e){
            fail("No deberia haber fallado");   
        }
        
        
    }
    
    @Test
    public void testIngresarCantidadNegativa(){
        System.out.println("Ingresar: ");
        double cantidad=-100.0;
        
        try{
            Cuenta.ingresar(cantidad);
            fail("Error indeterminado");//No deberia haberse podido ingresar la cantidad
        }
        catch(Exception e){
            System.out.println(e.getMessage()+"No se puede ingresar una cantidad negativa");
        }
    }
    
    @Test
    public void testRetirar() throws Exception{
        System.out.println("Retirar: ");
        Cuenta=new Cuenta("0001.0002.12.1234567890", "Fulano de Tal");
        Cuenta.ingresar(500.0);
        double cantidad = 100.0;
        
        try{
            Cuenta.retirar(cantidad);
            System.out.println("Se ha retirado corretamente");
        }
        catch(Exception e){
            fail(e.getMessage()+"Error indeterminado");
        }
        
    }
    
    @Test
    public void testRetirarCantidadNegatica(){
        System.out.println("Retirar: ");
        double cantidad=-100.0;
        
        try{
            Cuenta.retirar(cantidad);
            fail("Error indeterminado");//No deberia haberse podido retirar efectivo negativo
        }
        catch(Exception e){
            System.out.println(e.getMessage()+"No se puede retirar una cantidad negativo de efectivo");
        }
        
    }
    
    @Test
    public void testRetirarMasDinero() throws Exception{
        System.out.println("TestRetirar_saldoInsuficiente:");
        Cuenta=new Cuenta("0001.0002.12.1234567890", "Fulano de Tal");
        Cuenta.ingresar(100.0);
        double cantidad = 300.0;
        
        try{
            Cuenta.retirar(cantidad);
            System.out.println("Error indeterminado");
        }
        catch(Exception e){
            fail(e.getMessage()+"Error! No hay suficiente efectivo");
        }
    }
    
}
