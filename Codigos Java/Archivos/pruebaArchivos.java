package Archivos;
import java.io.*;
import java.util.ArrayList;

public class pruebaArchivos {
    private ArrayList<String> contenidoArchivo = new ArrayList<>();
    private ArrayList<Obra> listaEntrada = new ArrayList<>();
    private final String rutaWindows = "C:\\Users\\Erick\\Documents\\Programacion\\Nueva carpeta\\Jorge\\src\\Archivos\\datos.txt";

    public ArrayList<String> getContenidoArchivo() {
        return contenidoArchivo;
    }

    public ArrayList<Obra> getListaEntrada() {
        return listaEntrada;
    }

    public void leerArchivo() {
        LeerArchivo leer = new LeerArchivo();
        this.contenidoArchivo =
                leer.leerArchivo(this.rutaWindows);
        for (int i = 0; i < this.contenidoArchivo.size(); i++) {
            String linea = this.contenidoArchivo.get(i);
            String elementosLinea[] = linea.split(";");
            try {
                float obrero1 = Float.parseFloat(elementosLinea[0]);
                float obrero2 = Float.parseFloat(elementosLinea[1]);
                float obrero3 = Float.parseFloat(elementosLinea[2]);
                float obrero4 = Float.parseFloat(elementosLinea[3]);
                listaEntrada.add(new Obra(obrero1, obrero2, obrero3, obrero4));
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                listaEntrada.add(new Obra(0, 0, 0, 0));
            }
        }
    }
    public void escribirArchivo(ArrayList<Obra> lista){
        String archivo = "resultados.csv";
        File f = new File(archivo);
        try{
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write("");
            wr.append("obrero1, obrero2, obrero3, obrero4, tiempoDemoradoJuntos\n");
            for (int i=0; i < lista.size(); i++){
                wr.append(lista.get(i).getObrero1() + "," + lista.get(i).getObrero2() +"," + lista.get(i).getObrero3() +
                        "," + lista.get(i).getObrero4() + "," + lista.get(i).getTiempoDemoradoJuntos() + "\n");
            }
            wr.close();
            bw.close();
        }catch(IOException e){

        }
    }

    public static void main (String args[]){
        pruebaArchivos prueba = new pruebaArchivos();
        prueba.leerArchivo();
        for (int i=0; i < prueba.getListaEntrada().size(); i++){
            System.out.println(prueba.getListaEntrada().get(i).getObrero1() +
                    "\t" + prueba.getListaEntrada().get(i).getObrero2() +
                    "\t" + prueba.getListaEntrada().get(i).getObrero3() +
                    "\t" + prueba.getListaEntrada().get(i).getObrero4() +
                    "\t" + prueba.getListaEntrada().get(i).getTiempoDemoradoJuntos());
        }
        prueba.escribirArchivo(prueba.getListaEntrada());
    }
}
