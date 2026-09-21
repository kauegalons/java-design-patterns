package singleton;

public class GlobalConfig {
    private static volatile GlobalConfig instance;

    private String applicationName;
    private String environment;
    private int maxConnections;

    private GlobalConfig() {
        this.applicationName = "DefaultApp";
        this.environment = "development";
        this.maxConnections = 10;
    }

    public static GlobalConfig getInstance() {
        if (instance == null) {
            synchronized (GlobalConfig.class) {
                if (instance == null) {
                    instance = new GlobalConfig();
                }
            }
        }
        return instance;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public void printConfig() {
        System.out.println("Application Name: " + applicationName);
        System.out.println("Environment: " + environment);
        System.out.println("Max Connections: " + maxConnections);
    }
}
