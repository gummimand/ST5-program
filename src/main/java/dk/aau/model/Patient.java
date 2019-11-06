package dk.aau.model;




public class Patient {
    String navn;
    boolean skema;
    String tidspunkt;

    public Patient(String navn, boolean skema, String tidspunkt){
        this.navn = navn;
        this.skema = skema;
        this.tidspunkt = tidspunkt;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public boolean isSkema() {
        return skema;
    }

    public void setSkema(boolean skema) {
        this.skema = skema;
    }

    public String getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }
}