package com.admin.resource.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Config {
    
    private Connection conecta = null;
    public static Config instance = null; 
    private String[] settings = DatabaseFile.read();
    private String driver = "com.mysql.jdbc.Driver";
    private String host = settings[0];
    private String port = settings[1];
    private String dbName = settings[2];
    private String userName = settings[3];
    private String password = settings[4];
    private String url = "jdbc:mysql://" + host +  ":" + port + "/";
    
    public synchronized static Config getInstance() { //patron Singleton, syncronized hace una lista de espera para el trafico de conexiones
        if (instance == null) {
            instance = new Config();
        }
        
        return instance;
    }
    
    private Config() {
        try {
            /*Class.forName("org.gjt.mm.mysql.Driver");
            conecta=DriverManager.getConnection("jdbc:mysql://sql40.hostinger.es:3306/u181402445_ferre","u181402445_admin","admin1234");*/
            /*Class.forName(driver);
            conecta=DriverManager.getConnection("jdbc:mysql://192.168.1.37:3306/ferreteriadino","cajero","1234");*/
            Class.forName(driver);
            conecta = DriverManager.getConnection(url + dbName, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            Messages.messageAlert("Conexión fallida a la base de datos."); 
            destruir();
            System.exit(1);
        }
    }
    
    public Connection getConnection() {
        return conecta;
    }
    
    public void destruir() {
        if (conecta != null) {
            try { 
                conecta.close(); 
            } catch(Exception e) {  
                Messages.messageError("Ocurrió un fallo al cerrar la conexión a la base de datos."); 
            }
        }
    }    
}