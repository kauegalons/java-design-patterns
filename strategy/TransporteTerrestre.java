package strategy;


public class TransporteTerrestre implements TransporteStrategy {
 private String transportadoraLocal;

 public TransporteTerrestre(String transportadoraLocal) {
     this.transportadoraLocal = transportadoraLocal;
 }

 @Override
 public void selecionarTransportadora() {
     System.out.println("Selecionando transportadora terrestre: " + transportadoraLocal);
 }

 @Override
 public boolean verificarDisponibilidade() {
     // Lógica simples para verificar disponibilidade de transporte terrestre
     return true; // Sempre disponível neste exemplo
 }
}

