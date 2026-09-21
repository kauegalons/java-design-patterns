package strategy;


public class TransporteMaritimo implements TransporteStrategy {
 private boolean internacional;

 public TransporteMaritimo(boolean internacional) {
     this.internacional = internacional;
 }

 @Override
 public void selecionarTransportadora() {
     System.out.println("Selecionando transportadora marítima para entrega internacional...");
 }

 @Override
 public boolean verificarDisponibilidade() {
     // Lógica para verificar disponibilidade de transporte marítimo
     // Exemplo simples: verificar se é internacional
     return internacional; // Disponível apenas se for internacional
 }
}

