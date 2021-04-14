package ejerciciostate.logica;

public class Hora {
    private int horas;
    private int minutos;
    
    public Hora(int h, int m) {	
        this.horas = h;
        this.minutos = m;
    }
    
    public void incHoras() {
        if (this.horas==23)
            this.horas=0;
        else
            this.horas++;
    }
    
    public void incMinutos() {
        if (this.minutos==59)
            this.minutos=0;
        else
            this.minutos++;
    }
    
    public String toString() {
        return this.horas+":"+this.minutos;
    }
 
}
