// creamos la clase Computadores
public class Computadores {
    // creamos las variables internas de la clase
    protected final static char CONSUMO_W = 'F';
    protected final static Double PRECIO_BASE = 100.0;
    protected final static Integer PESO_BASE = 5;
    // variables de instancia
    protected Integer peso;
    protected char consumoW;
    protected double precioBase;

    // constructor vacio de la clase
    public Computadores() {
        this.peso = PESO_BASE;
        this.consumoW = CONSUMO_W;
        this.precioBase = PRECIO_BASE;
    }
    // constructor con parametros peso y precio base
    public Computadores(Double precioBase, Integer peso) {
        this.precioBase = precioBase;
        this.consumoW = CONSUMO_W;
        this.peso = peso;
    } 

    // constructor con parametros de la clase
    public Computadores(double precioBase, Integer peso, char consumoW) {
        this.peso = peso;
        this.consumoW = consumoW;
        this.precioBase = precioBase;
    }

    // creamos la funcion pata obtener el precio
    public Double calcularPrecio() {
        double adicionar = 0.0;
    //    codigo para consumo 
        switch (consumoW) {
            case 'A':
                adicionar += 100.0;
                break;
            case 'B':
                adicionar += 80.5;
                break;
            case 'C':
                adicionar += 60.0;
                break;
            case 'D':
                adicionar += 50.0;
                break;
            case 'E':
                adicionar += 30.0;
                break;
            case 'F':
                adicionar += 10.0;
                break;
        }
        // codigo para peso
        if (peso >= 0 && peso < 19) {
            adicionar += 10.0;
        } else if (peso >= 20 && peso < 49) {
            adicionar += 50.0;
        } else if (peso >= 50 && peso < 79) {
            adicionar += 80.0;
        } else if (peso >= 80) {
            adicionar += 100.0;
        }
        // retorno el precio total
        return precioBase + adicionar;
    }
    // metodos get
    public int getPeso() {
        return peso;
    }
    public char getConsumoW() {
        return consumoW;
    }
    public double getPrecioBase() {
        return precioBase;
    }    
}
public class ComputadoresMesa extends Computadores {

    private final static Integer ALMACENAMIENTO_BASE = 50;
    // VARIABLES DE INSTANCIA
    private Integer almacenamiento;

    // CONSTRUCTOR VACIO DE LA CLASE
    public ComputadoresMesa() {
        // super();
        this.almacenamiento = ALMACENAMIENTO_BASE;
        this.precioBase = PRECIO_BASE;
        this.consumoW = CONSUMO_W;
        this.peso = PESO_BASE;
    }
    
    // CONSTRUCTOR CON parametros precio base y peso
    public ComputadoresMesa(Double precioBase, Integer peso) {
        super(precioBase, peso);
        this.almacenamiento = ALMACENAMIENTO_BASE;
    }

    // CONSTRUCTOR CON parametros de la clase
    public ComputadoresMesa(Double peso, Integer consumoW, char precioBase, Integer almacenamiento) {
        super(peso, consumoW, precioBase);
        this.almacenamiento = almacenamiento;
    }

    // CREAMOS LA FUNCION PATA OBTENER EL PRECIO
    public Double calcularPrecio() {
        Double adicion = super.calcularPrecio();
        //    codigo para consumo
        if (almacenamiento > 100.0){
            adicion += 50.0;
        }
        // retornamos el precio
        return adicion;
    }

    // metodos get y set de la clase
    public Integer getAlmacenamiento() {
        return almacenamiento;
    }

    
}
public class ComputadoresPortatiles extends Computadores {
    private final static Integer PULGADAS_BASE = 20;
    private Integer pulgadas;
    private boolean camaraITG;

    // CONSTRUCTOR VACIO DE LA CLASE
    public ComputadoresPortatiles() {
        this.peso = PESO_BASE;
        this.consumoW = CONSUMO_W;
        this.precioBase = PRECIO_BASE;
        this.pulgadas = PULGADAS_BASE;
        this.camaraITG = false;
    }
    // constructor con parametros precio base y peso
    public ComputadoresPortatiles(Double precioBase, Integer peso) {
        super(precioBase, peso);
        this.pulgadas = PULGADAS_BASE;
        this.camaraITG = false;
    }
    // constructor con parametros de la clase
    public ComputadoresPortatiles(Double peso, Integer consumoW, char precioBase, Integer pulgadas, boolean camaraITG) {
        super(peso, consumoW, precioBase);
        this.pulgadas = pulgadas;
        this.camaraITG = camaraITG;
    }

    // CREAMOS LA FUNCION PATA OBTENER EL PRECIO
    public Double calcularPrecio() {
        Double adicion = super.calcularPrecio();
        //    codigo para consumo
        if (pulgadas > 40){
            adicion += precioBase * 0.3;
        }
        if (camaraITG){
            adicion += 50.0;
        }
        // retornamos el precio
        return adicion;
    }
}

public class PrecioTotal {

    private Double totalComputadores = 0.0;
    private Double totalComputadoresPortatiles = 0.0;
    private Double totalComputadoresMesa = 0.0;
    private Computadores[] listaComputadores;

    // constructor
    public PrecioTotal(Computadores[] pComputadores) {
        this.listaComputadores = pComputadores;
    }

    public void mostrarTotales() {
        for (int i = 0; i < listaComputadores.length; i++) {
            if (listaComputadores[i] instanceof Computadores) {
                totalComputadores += listaComputadores[i].calcularPrecio();
            } if (listaComputadores[i] instanceof ComputadoresMesa) {
                totalComputadoresMesa += listaComputadores[i].calcularPrecio();
            } if (listaComputadores[i] instanceof ComputadoresPortatiles) {
                totalComputadoresPortatiles += listaComputadores[i].calcularPrecio();
            }
        }
        // Mostramos los resultados
        System.out.println("La suma del precio de los computadores es de " + totalComputadores);
        System.out.println("La suma del precio de los computadores de mesa es de " +
                totalComputadoresMesa);
        System.out.print("La suma del precio de los computadores portátiles es de " +
                totalComputadoresPortatiles);
    }

}

