
package CuentaPackage;

import static junit.framework.Assert.assertEquals;
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
        double cantidad=100.0;
        
        try{
            Cuenta.ingresar(cantidad);
            System.out.println("Se ha ingresado corretamente");
        }
        catch(Exception e){
            System.out.println(e.getMessage()+"Error Indeterminado");   
        }
        double saldo=Cuenta.getSaldo();
        assertEquals(saldo,100.0);//comprobar que se añadio correctamente
    }
    
    @Test
    public void testIngresarCantidadNegativa(){
        System.out.println("Ingresar: ");
        double cantidad=-100.0;
        
        try{
            Cuenta.ingresar(cantidad);
            System.out.println("Error indeterminado");//No deberia haberse podido ingresar la cantidad
        }
        catch(Exception e){
            System.out.println(e.getMessage()+"No se puede ingresar una cantidad negativa");
        }
    }
    
    @Test
    public void testRetirar(){
        System.out.println("Retirar: ");
        Cuenta = new Cuenta();
        Cuenta.ingresar(900.0);
        double cantidad = 100.0;
        
        try{
            Cuenta.retirar(cantidad);
            System.out.println("Se ha retirado corretamente");
        }
        catch(Exception e){
            System.out.println(e.getMessage()+"Error indeterminado");
        }
        
    }
    
    @Test
    public void testRetirarCantidadNegatica(){
        System.out.println("Retirar: ");
        double cantidad=-100.0;
        
        try{
            Cuenta.retirar(cantidad);
            System.out.println("Error indeterminado");//No deberia haberse podido retirar efectivo negativo
        }
        catch(Exception e){
            System.out.println(e.getMessage()+"No se puede retirar una cantidad negativo de efectivo");
        }
        double saldo=Cuenta.getSaldo();
        assertEquals(saldo,100.0);
    }
    
    @Test
    public void testRetirarMasDinero(){
        System.out.println("Retirar:");
        Cuenta = new Cuenta();
        Cuenta.ingresar(100.0);
        double cantidad = 300.0;
        
        try{
            Cuenta.retirar(cantidad);
            System.out.println("Error indeterminado");
        }
        catch(Exception e){
            System.out.println(e.getMessage()+"Error! No hay suficiente efectivo");
        }
    }
    
}
