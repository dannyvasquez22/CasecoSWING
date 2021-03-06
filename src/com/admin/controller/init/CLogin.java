package com.admin.controller.init;

// <editor-fold defaultstate="collapsed" desc="Importacion de clases">
import com.admin.model.bl.UsuarioBL;
import com.admin.model.dto.UsuarioDTO;
import com.admin.resource.utils.Config;
import com.admin.resource.utils.Constantes;
import com.admin.resource.utils.Encript;
import com.admin.resource.utils.GetIP;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.view.init.Login;
import com.admin.view.init.Menu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import org.apache.log4j.Logger;
// </editor-fold>

/** * @author DANNY VASQUEZ RAFAEL */

public class CLogin extends MouseAdapter implements ActionListener {
    private final Login view_login; 
    private Menu view_menu;
    private CMenu controller_menu;
    private UsuarioDTO usuario;
    private static final Config dbInstance = Config.getInstance();
    private String user, pass, fechaInicio, horaInicio;   
    final static Logger logger = Logger.getLogger(CLogin.class);
    
    public CLogin (Login view) {
        this.view_login = view;   
        this.view_login.btnSalir.addActionListener(this);
        this.view_login.btnIniciar.addActionListener(this);
        this.view_login.txtUsuario.addActionListener(this);
        this.view_login.btnIniciar.addMouseListener(this);
        this.view_login.btnSalir.addMouseListener(this);
        this.view_login.txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        this.view_login.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.view_login.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            @Override
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });        
    }

    public void iniciar() {
        view_login.setLocationRelativeTo(null);
        view_login.setResizable(false);
        view_login.setTitle(Constantes.S_TITLE_VIEW_LOGIN);
        view_login.setIconImage(Global.ICON_IMAGE);
        view_login.setCursor(Global.CURSOR);
        view_login.txtUsuario.requestFocus();
        view_login.progressBar.setVisible(false);
        view_login.lblMensaje.setVisible(false);
        view_login.lblIP.setText(Constantes.S_MESSAGE_IP + Constantes.S_SPACE + GetIP.getIP());
        view_login.setVisible(true);
    }
    
    public void errorLog(String message) {
        Messages.messageError(message);
        view_login.btnIniciar.setEnabled(true);
        view_login.btnSalir.setEnabled(true);
        view_login.txtPassword.setText(Constantes.S_EMPTY);
        view_login.txtUsuario.selectAll();
        view_login.txtUsuario.requestFocus();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Metodo de inicio de sesion">   
    public void Ingresar(String user, String pass) throws SQLException{
        String passwordEncrypt;
        Global.CALENDARY = Calendar.getInstance();
        view_login.btnIniciar.setEnabled(false);
        view_login.btnSalir.setEnabled(false);
        usuario = UsuarioBL.getInstance().authenticate(user);
        if (usuario == null) {
            errorLog(Constantes.S_MESSAGE_UNACCOUNT);
        } else {
            passwordEncrypt = Encript.Encriptar(pass);
            if (usuario.getContraseña().equals(passwordEncrypt)) {
                if (usuario.getDetalleCargo().getCargo().getNombre().equals(Constantes.S_DUEÑO) || (usuario.getDetalleCargo().getCargo().getNombre()).equals(Constantes.S_DUEÑO.toUpperCase())) {
                    UsuarioBL.getInstance().changeConnection(usuario, Constantes.I_NUM_UNO);
                    Global.TIMER.start();
                    view_login.lblMensaje.setVisible(true);
                    fechaInicio = Global.CALENDARY.get(Calendar.YEAR) + Constantes.S_GUION + (Global.CALENDARY.get(Calendar.MONTH) + Constantes.I_NUM_UNO) + Constantes.S_GUION + Global.CALENDARY.get(Calendar.DATE);
                    horaInicio = Global.CALENDARY.get(Calendar.HOUR_OF_DAY) + Constantes.S_DOS_PUNTOS + Global.CALENDARY.get(Calendar.MINUTE) + Constantes.S_DOS_PUNTOS + Global.CALENDARY.get(Calendar.SECOND);
                } else {
                    errorLog(Constantes.S_MESSAGE_UNADMIN);
                }                
            } else {
                errorLog(Constantes.S_MESSAGE_UNPASSWD);
            }
        }     
    }
    // </editor-fold>
    
    public class progreso implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
            int n = view_login.progressBar.getValue();
            if (n < Constantes.I_NUM_CIEN) {
                n++;
                view_login.progressBar.setValue(n);
                view_login.progressBar.setStringPainted(true);
                view_login.progressBar.setForeground(Color.GREEN);
                view_login.progressBar.setVisible(true);
            } else {
                Global.TIMER.stop();
                Global.TIMER.removeActionListener(this);
                Messages.messageOK(Constantes.S_MESSAGE_OK);
                view_login.dispose();
                view_menu = new Menu();
                controller_menu = new CMenu(view_menu, user, fechaInicio, horaInicio);
                controller_menu.iniciar();
                view_menu.setVisible(true);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_login.btnIniciar) {
            user = view_login.txtUsuario.getText().trim();
            pass = view_login.txtPassword.getText();
            if (!user.equals(Constantes.S_EMPTY) && !pass.equals(Constantes.S_EMPTY)) {
                try {
                    Ingresar(user, pass);
                } catch (SQLException ex) {
                    Messages.messageError(Constantes.S_ERROR + ex.getSQLState() + ex.toString() + Constantes.S_PUNTO + Constantes.S_SPACE + Constantes.S_BOTON + ae.getActionCommand());
                    logger.error(ex);
                }
            } else {   Messages.messageAlert();    }
        } else if (ae.getSource() == view_login.btnSalir) {
            dbInstance.destruir();
            System.exit(Constantes.I_NUM_UNO);        
        } else if (ae.getSource() == view_login.txtUsuario) {
            view_login.txtPassword.requestFocus();
        }
    }      
    
    public void entered(java.awt.event.MouseEvent me) {
        if (me.getSource() == view_login.btnIniciar) {
            view_login.btnIniciar.setForeground(Color.GREEN);
        } else if (me.getSource() == view_login.btnSalir) {
            view_login.btnSalir.setForeground(Color.RED);
        }
    }
    
    @Override
    public void mouseEntered(java.awt.event.MouseEvent me) {
        if (me.getSource() == view_login.btnIniciar) {
            view_login.btnIniciar.setForeground(Color.GREEN);
        } else if (me.getSource() == view_login.btnSalir) {
            view_login.btnSalir.setForeground(Color.RED);
        }
    }
    
    @Override
    public void mouseExited(java.awt.event.MouseEvent me) {
        view_login.btnIniciar.setForeground(Color.BLACK);
        view_login.btnSalir.setForeground(Color.BLACK);
    }
    
    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {                                       
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            view_login.btnIniciar.doClick();
        }
    } 
    
    public void formWindowOpened(WindowEvent we) {
        Global.TIMER = new Timer(Constantes.I_NUM_UNO, new progreso());
    }
    
    public void formWindowClosing(WindowEvent we) {                                   
        dbInstance.destruir();
        System.exit(Constantes.I_NUM_UNO);
    }        
}
