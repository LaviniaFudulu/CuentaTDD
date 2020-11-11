
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
    public void testIngresar(){
        
        System.out.println("Ingresar: ");
        Cuenta=new Cuenta("0001.0002.12.1234567890", "Fulano de Tal");
        double cantidad=100.0;
        
        try{
            Cuenta.ingresar(cantidad);
            System.out.println("Se ha ingresado correctamente");
        }
        catch(Exception e){
            System.out.println(e.getMessage() + "No se ha podido ingresar la cantidad");  
        }
        assertEquals(Cuenta.getSaldo(),100.0);
        
        //System.out.println("Dinero inicial: "+Cuenta.getSaldo());
        
    }
    
    @Test
    public void testIngresarCantidadNegativa(){
        System.out.println("Ingresar Cantidad Negativa: ");
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
        //System.out.println(Cuenta.getSaldo());
        
    }
    
    @Test
    public void testRetirarCantidadNegatica(){
        System.out.println("Retirar Cantidad Negativa: ");
        double cantidad=-100.0;
        
        try{
            Cuenta.retirar(cantidad);
            fail("Error indeterminado");//No deberia haberse podido retirar efectivo negativo
        }
        catch(Exception e){
            System.out.println(e.getMessage()+ "No se puede retirar una cantidad negativo de efectivo");
        }
        
    }
    
    @Test
    public void testRetirarMasDinero() throws Exception{
        System.out.println("Retirar mas de lo que hay en la cuenta:");
        Cuenta=new Cuenta("0001.0002.12.1234567890", "Fulano de Tal");
        Cuenta.ingresar(100.0);
        double cantidad = 5000.0;
        
        try{
            Cuenta.retirar(cantidad);
            System.out.println("Error indeterminado");
        }
        catch(Exception e){
            System.out.println(e.getMessage()+"No hay suficiente dinero");
            
        }
    }
    
}
