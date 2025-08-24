
public class Salon {

    private int num;
    private String tipo;                // Pequeño, mediano y grande
    private int horaInicio;
    private int horaFinal;
    private String limites;

    public Salon (int num, String tipo, int horasInicio, int horasFinal, String limites) {
        this.num = num;
        this.tipo = tipo;
        this.horaInicio = horasInicio;
        this.horaFinal = horasFinal;
        this.limites = limites;
    }
        public int getNum() {
        return num;
    }
        public String getTipo() {
        return tipo;
    }
        public int getHorasInicio() {
        return horaInicio;
    }
        public int getHorasFinal() {
        return horaFinal;
    }
        public String getLimites() {
        return limites;
    }
}
