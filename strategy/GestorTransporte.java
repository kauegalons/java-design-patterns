package strategy;

//GestorTransporte.java
public class GestorTransporte {
 private TransporteStrategy estrategia;

 public void setEstrategia(TransporteStrategy estrategia) {
     this.estrategia = estrategia;
 }

 public void executarTransporte() {
     if (estrategia != null) {
         estrategia.selecionarTransportadora();
         boolean disponivel = estrategia.verificarDisponibilidade();
         if (disponivel) {
             System.out.println("Transporte em andamento...");
         } else {
             System.out.println("Transporte não disponível no momento.");
         }
     } else {
         System.out.println("Por favor, selecione uma estratégia de transporte.");
     }
 }
}

