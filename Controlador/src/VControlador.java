import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VControlador extends JFrame {// implements ActionListener

    private static final long serialVersionUID = -784964507977347415L;
    ControladorServer ControladorServer;

    // Labels
    JLabel titleControlador;

    // Panels
    JScrollPane panelControlador;

    // Text Areas
    JTextArea textAreaControlador;

    // textField
    JTextField textFielControlador;

    // Constructor
    public VControlador(){
        super("Ventana controlador");
        // Crear ventana
        int width = 455;
        int height = 400;
        this.setPreferredSize(new DimensionUIResource(width, height));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Llenar la ventana
        agregarComponentes();

        // Acomoda el tamano y ver la ventana
        this.pack();
        this.setVisible(true);
    }

    public void setControlador(ControladorServer newControladorServer){
        ControladorServer = newControladorServer;
    }

    private void agregarComponentes(){
        this.setLayout(null);

        //--------------------------------------------------------------------- text area Controlador
        titleControlador = new JLabel("Controlador: ");
        titleControlador.setBounds(20,20,400,25);//.setBounds(x, y, width, height)
        this.add(titleControlador);

        textAreaControlador = new JTextArea();
        panelControlador = new JScrollPane(textAreaControlador);
        panelControlador.setBounds(20,50,400,300);//.setBounds(x, y, width, height)
        this.add(panelControlador);

    }


}