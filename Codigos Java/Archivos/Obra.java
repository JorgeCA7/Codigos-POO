package Archivos;

public class Obra {
    private float obrero1;
    private float obrero2;
    private float obrero3;
    private float obrero4;
    private double tiempoDemoradoJuntos;

    public Obra(float obrero1, float obrero2, float obrero3, float obrero4) {
        this.obrero1 = obrero1;
        this.obrero2 = obrero2;
        this.obrero3 = obrero3;
        this.obrero4 = obrero4;
        this.calcularTiempoDemoradoJuntos();
    }

    public double getObrero1(){
        return obrero1;
    }
    public void setObrero1(int obrero1) {
        this.obrero1 = obrero1;
    }

    public double getObrero2(){
        return obrero2;
    }
    public void setObrero2(int obrero2) {
        this.obrero2 = obrero2;
    }

    public double getObrero3(){
        return obrero3;
    }
    public void setObrero3(int obrero3){
        this.obrero3 = obrero3;
    }

    public double getObrero4(){
        return obrero4;
    }
    public void setObrero4(int obrero4) {
        this.obrero4 = obrero4;
    }
    public double getTiempoDemoradoJuntos(){
        return tiempoDemoradoJuntos;
    }

    public void calcularTiempoDemoradoJuntos(){
        this.tiempoDemoradoJuntos = 1 / ((1 / this.obrero1) + (1 / this.obrero2) + (1 / this.obrero3) + (1 / this.obrero4));
    }

    public static void main(String[] args) {
        Obra obra = new Obra(3, 6, 12, 24);
        System.out.println(obra.getTiempoDemoradoJuntos());

    }
}
