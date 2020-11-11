
package CuentaPackage;

import java.util.ArrayList;
import java.util.List;


public class Cuenta {
    protected String mNumero;
    protected String nTitular;
    protected List<Movimiento> mMovimientos;
    protected double saldo;

    public Cuenta(String numero, String titular)
    {
        this.mNumero=numero;
        this.nTitular=titular;
        mMovimientos=new ArrayList<>();
        
    }

     private static class Movimiento {
        private final double importe;
        private final String concepto;

        public Movimiento( double importe, String concepto) {
            this.concepto=concepto;
            this.importe=importe;
        }
        
        public double getImporte(){ return this.importe; }
        public String getConcepto(){ return this.concepto; }
        
    }
     
     
    void ingresar(double x) throws Exception {
        saldo=saldo+x;
        if(x<0){
           throw new Exception("No se puede ingresar una cantidad negativa"); 
        }
        Movimiento m=new Movimiento(x, "noseque");
        this.mMovimientos.add(m);
       
    }

    void retirar(double x) throws Exception {
        saldo=saldo-x;
        if(x<=0){
           throw new Exception("No se puede retirar una cantidad negativa"); 
        }
        if(getSaldo()<x){
            throw new Exception("Saldo insuficionte");
        }
        
        Movimiento m=new Movimiento(-x, "noseque");
        this.mMovimientos.add(m);
        
    }

     public double getSaldo() {
        return saldo;
    }
     
  
}
