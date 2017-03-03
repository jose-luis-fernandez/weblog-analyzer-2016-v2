public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    
    public Acceso(String fecha)
    {
        String[] elementosFecha = fecha.split(" ");
        this.ano = Integer.parseInt(elementosFecha[0]);
        this.mes = Integer.parseInt(elementosFecha[1]);
        this.dia = Integer.parseInt(elementosFecha[2]);
        this.hora = Integer.parseInt(elementosFecha[3]);
        this.minutos = Integer.parseInt(elementosFecha[4]);
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
}