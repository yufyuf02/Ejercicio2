
public class Reservacion {

    private String encargado;
    private String nombreEvento;
    private int tipoEvento;
    private String fecha;
    private int horaInicio;
    private int horaFinal;
    private String asignacion;

    public Reservacion (String encargado, String nombreEvento, int tipoEvento, String fecha, int horaInicio, int horaFinal, String asignacion) {
        this.encargado = encargado;
        this.nombreEvento = nombreEvento;
        this.tipoEvento = tipoEvento;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.asignacion = asignacion;
    }

    // Getters
        public String getEncargado() {
        return encargado;
    }
        public String getNombreEvento() {
        return nombreEvento;
    }
        public int getTipoEvento() {
        return tipoEvento;
    }
        public String getFecha() {
        return fecha;
    }
        public int getHoraInicio() {
        return horaInicio;
    }
        public int getHoraFinal() {
        return horaFinal;
    }
        public String getAsignacion() {
        return asignacion;
    }

    // Setters
    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }
}
