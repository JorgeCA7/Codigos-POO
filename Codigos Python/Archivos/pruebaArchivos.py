from abc import ABCMeta


class Obra(ABCMeta):

    # Metodo de clase
    @staticmethod
    def calcularTiempoDemoradoJuntos(obrero1, obrero2, obrero3, obrero4):
        tiempoDemorado = 1 / ((1 / obrero1) + (1 / obrero2) + (1 / obrero3) + (1 / obrero4))
        tiempoDemorado = round(tiempoDemorado, 2)
        return tiempoDemorado


class pruebaArchivos:
    def leerArchivo(self, archivo):
        file = open(archivo, 'r')
        lineas = []
        lineas_archivo = []
        for linea in file.readlines():
            lineas.append(linea.replace('\n', '').split(";"))
        file.close()
        for f in range(0, len(lineas)):
            try:
                lineas_archivo.append([int(lineas[f][0]), int(lineas[f][1]), int(lineas[f][2]), int(lineas[f][3])])
            except ValueError:
                lineas_archivo.append([0, 0, 0, 0])
        return lineas_archivo

    def Obreros(self, lista):
        resultados = []
        for f in range(0, len(lista)):
            resultados.append(Obra.calcularTiempoDemoradoJuntos(lista[f][0], lista[f][1], lista[f][2], lista[f][3]))
        return resultados

    def guardarResultados(self, entrada, resultados):
        file = open("resultados.txt", 'w')
        file.write('Obrero1;Obrero2;Obrero3,Obrero4, tiempoQueTardaranEnRelaizarLaOBra\n')
        for f in range(0, len(entrada)):
            linea = str(entrada[f][0]) + ';' + str(entrada[f][1]) + ';' + str(entrada[f][2]) + ';' + str(
                entrada[f][3]) + ';' + str(resultados[f]) + '\n'
            file.write(linea)
        file.close()


if __name__ == "__main__":
    prueba = pruebaArchivos()
    archivo = []
    archivo = prueba.leerArchivo("datos.txt")
    resultado = prueba.Obreros(archivo)
    prueba.guardarResultados(archivo, resultado)
