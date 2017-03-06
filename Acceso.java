public class Acceso
{
    private String ip;
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    private String paginaWeb;
    private String respuestaHTTP;
    
    public Acceso(String linea)
    {
        String[] elementosLinea = linea.split(" ");
        this.ip = elementosLinea[0];
        String anio = elementosLinea[1].replace("[", "");
        String minuto = elementosLinea[5].replace("]", "");
        this.ano = Integer.parseInt(anio);
        this.mes = Integer.parseInt(elementosLinea[2]);
        this.dia = Integer.parseInt(elementosLinea[3]);
        this.hora = Integer.parseInt(elementosLinea[4]);
        this.minutos = Integer.parseInt(minuto);
        this.paginaWeb = elementosLinea[6];
        respuestaHTTP = elementosLinea[7];
    }
    
    public int getAno() 
    {
        return ano;
    }
    
    public int getMes()
    {
        return mes;
    }
    
    public int getDia()
    {
        return dia;
    }
    
    public int getHora()
    {
        return hora;
    }
    
    public int getMinutos()
    {
        return minutos;
    }
    
    public String getpaginaWeb()
    {
        return paginaWeb;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public String getRespuestaHTTP()
    {
        return respuestaHTTP;
    }
}