package strategy;


public class EntregaPorDrones implements TransporteStrategy {
 private boolean areasMetropolitanas;
 private boolean pequenosPacotes;

 public EntregaPorDrones(boolean areasMetropolitanas, boolean pequenosPacotes) {
     this.areasMetropolitanas = areasMetropolitanas;
     this.pequenosPacotes = pequenosPacotes;
 }

 @Override
 public void selecionarTransportadora() {
     System.out.println("Organizando entrega por drones...");

     if (areasMetropolitanas && pequenosPacotes) {
         System.out.println("Para áreas metropolitanas e pacotes pequenos.");
     }
 }

 @Override
 public boolean verificarDisponibilidade() {
     // Lógica para verificar disponibilidade de entrega por drones
     // Exemplo simples: verificar se é para áreas metropolitanas e pacotes pequenos
     return areasMetropolitanas && pequenosPacotes; // Disponível se atender aos critérios
 }
}

