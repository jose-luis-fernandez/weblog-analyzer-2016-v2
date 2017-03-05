import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> accesos;
    private ArrayList<String> paginasWeb = new ArrayList<String>();
    private ArrayList<Integer> numeroVecesPaginaWeb = new ArrayList<Integer>();
    
    public AnalizadorAccesosAServidor() 
    {
        accesos = new ArrayList<>();
    }
    
    
    public void analizarArchivoDeLog(String archivo)
    {
        accesos.clear();
        File archivoALeer = new File(archivo);
        try {
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                String lineaLeida = sc.nextLine();               
                Acceso accesoActual = new Acceso(lineaLeida);               
                accesos.add(accesoActual);
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrio algun error al leer el archivo.");
        }
    }
    
    
    public int obtenerHoraMasAccesos() 
    {
        int valorADevolver = -1;
        
        if (!accesos.isEmpty()) {
            int[] accesosPorHora = new int[24];
    
            for (Acceso accesoActual : accesos) {
                int horaAccesoActual = accesoActual.getHora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual] + 1;
            }
            
            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccesosMasAlto = 0;
            for (int i = 0; i < accesosPorHora.length; i++) {
                if (accesosPorHora[i] >= numeroDeAccesosMasAlto) {
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccesosMasAlto = i;
                }
            }
            
            valorADevolver = horaDeAccesosMasAlto;                      
        }
        
        return valorADevolver;
    }

    
    
    public String paginaWebMasSolicitada() 
    {
        String paginaADevolver = null;
        int posicionPaginaWebMasRepetida = -1;
        int mayor = 0;
        if (accesos.size() > 0){
            for (int i = 0; i < accesos.size(); i++){
                if (i > 0){
                    boolean encontrado = false;
                    int j = 0;
                    while (j < paginasWeb.size() && encontrado == false){
                        if (accesos.get(i).getpaginaWeb().equals(paginasWeb.get(j))){
                            numeroVecesPaginaWeb.set(j, (numeroVecesPaginaWeb.get(j) + 1));
                            encontrado = true;
                        }
                        j++;
                    }
                    if (encontrado == false){
                        paginasWeb.add(accesos.get(i).getpaginaWeb());
                        numeroVecesPaginaWeb.add(1);
                    }
                }
                else{
                    paginasWeb.add(accesos.get(i).getpaginaWeb());
                    numeroVecesPaginaWeb.add(1);
                }
            }
            
            for (int i = 0; i < numeroVecesPaginaWeb.size() - 1; i++){
                if (mayor < numeroVecesPaginaWeb.get(i)){
                    posicionPaginaWebMasRepetida = i;
                    mayor = numeroVecesPaginaWeb.get(i);
                }
            }
            paginaADevolver = paginasWeb.get(posicionPaginaWebMasRepetida);
            System.out.println("La pagina web m�s visitada es: " + paginasWeb.get(posicionPaginaWebMasRepetida));
        }
        else{
            System.out.println("Aun no se han registrado accesos.");
        }
        accesos.clear();
        paginasWeb.clear();
        numeroVecesPaginaWeb.clear();
        return paginaADevolver;
    }
    
    public String clienteConMasAccesosExitosos()
    {
        return "";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
