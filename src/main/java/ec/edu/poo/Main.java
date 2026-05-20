package ec.edu.poo;

public class Main {

    public static void main(String[] args) {

        GestorActivos gestor = new GestorActivos();

        Servidor s1 = new Servidor("S001", "Servidor Web", 9, false, "Linux");
        Servidor s2 = new Servidor("S002", "Servidor BD", 8, false, "Linux");

        Firewall fw1 = new Firewall("FW001", "Firewall Perimetral", 7, false, 150);
        Firewall fw2 = new Firewall("FW002", "Firewall Interno", 3, true, 40);

        ActivoDigital ad1 = new ActivoDigital("AD001", "Laptop Analista", 5, false);

        System.out.println("=== REGISTRO ===");

        System.out.println("Registrar S001:  " + gestor.registrarActivo(s1));
        System.out.println("Registrar S002:  " + gestor.registrarActivo(s2));
        System.out.println("Registrar FW001: " + gestor.registrarActivo(fw1));
        System.out.println("Registrar FW002: " + gestor.registrarActivo(fw2));
        System.out.println("Registrar AD001: " + gestor.registrarActivo(ad1));

        System.out.println("Duplicado S001:  " + gestor.registrarActivo(s1));

        System.out.println("\n=== CANTIDAD ===");
        System.out.println("Activos registrados: " + gestor.obtenerCantidadActivos());

        System.out.println("\n=== BUSQUEDA ===");

        ActivoDigital encontrado = gestor.buscarPorCodigo("FW001");

        System.out.println("Buscar FW001: " +
                (encontrado != null ? encontrado.getNombre() : "No encontrado"));

        System.out.println("Buscar XXXX:  " +
                (gestor.buscarPorCodigo("XXXX") != null ? "Encontrado" : "No encontrado"));

        System.out.println("\n=== CRITICOS ===");
        System.out.println("Activos críticos: " + gestor.contarActivosCriticos());

        System.out.println("\n=== PROMEDIO ===");
        System.out.println("Promedio riesgo: " + gestor.calcularPromedioRiesgo());

        System.out.println("\n=== PARCHE ===");

        System.out.println("Parchear S001:  " + gestor.aplicarParcheActivo("S001"));
        System.out.println("Parche aplicado: " + s1.isParcheAplicado());

        System.out.println("Parchear XXXX:  " + gestor.aplicarParcheActivo("XXXX"));

        System.out.println("\n=== REINICIO ===");

        gestor.reiniciar();

        System.out.println("Activos tras reinicio: " + gestor.obtenerCantidadActivos());
        System.out.println("Promedio tras reinicio: " + gestor.calcularPromedioRiesgo());
    }
}