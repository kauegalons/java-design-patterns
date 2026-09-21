package strategy;


public class Main {
 public static void main(String[] args) {

	 //Exemplos onde os transportes atendem aos requisitos
	 
     // Transporte Terrestre
     TransporteStrategy transporteTerrestre = new TransporteTerrestre("Transportadora A");
     executarTransporte(transporteTerrestre);

     // Transporte Aéreo
     TransporteStrategy transporteAereo = new TransporteAereo(1000.0, 2.0); // Peso máximo 1000 kg, dimensões máximas 2m
     executarTransporte(transporteAereo);

     // Transporte Marítimo
     TransporteStrategy transporteMaritimo = new TransporteMaritimo(true); // Internacional
     executarTransporte(transporteMaritimo);

     // Entrega por Drones
     TransporteStrategy entregaPorDrones = new EntregaPorDrones(true, true); // Áreas metropolitanas e pequenos pacotes
     executarTransporte(entregaPorDrones);
 }

 public static void executarTransporte(TransporteStrategy transporte) {

     GestorTransporte gestor = new GestorTransporte();

     gestor.setEstrategia(transporte);

     gestor.executarTransporte();

     System.out.println(); 
 }
}


