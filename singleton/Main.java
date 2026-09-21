package singleton;



public class Main {
    public static void main(String[] args) {
        GlobalConfig config = GlobalConfig.getInstance();

        System.out.println("Configurações iniciais:");
        config.printConfig();

        config.setApplicationName("MyIoTApp");
        config.setEnvironment("production");
        config.setMaxConnections(50);

        GlobalConfig updatedConfig = GlobalConfig.getInstance();
        System.out.println("\nConfigurações atualizadas:");
        updatedConfig.printConfig();

        System.out.println("\nAs duas instâncias são iguais? " + (config == updatedConfig));
    }
}
