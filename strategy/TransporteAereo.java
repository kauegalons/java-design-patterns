package strategy;


public class TransporteAereo implements TransporteStrategy {
 private double pesoMaximo;
 private double dimensoesMaximas;

 public TransporteAereo(double pesoMaximo, double dimensoesMaximas) {
     this.pesoMaximo = pesoMaximo;
     this.dimensoesMaximas = dimensoesMaximas;
 }

 @Override
 public void selecionarTransportadora() {
     System.out.println("Selecionando transportadora aérea...");
 }

 @Override
 public boolean verificarDisponibilidade() {
     // Lógica para verificar disponibilidade de transporte aéreo
     // Exemplo simples: verificação de peso e dimensões
     if (pesoMaximo <= 1000 && dimensoesMaximas <= 2) {
         System.out.println("Verificando peso máximo e dimensões...");
         return true; // Disponível se o peso e as dimensões estiverem dentro dos limites
     } else {
         return false; // Não disponível se os limites não forem válidos
     }
 }
}

