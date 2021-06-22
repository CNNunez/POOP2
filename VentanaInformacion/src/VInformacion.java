import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class VInformacion extends JFrame {
    private static final long serialVersionUID = -784964507977347415L;

    // Labels
    JLabel titleATiempo;
    JLabel titleAterrizado;
    JLabel titleTaxi;
    JLabel titleLlegando;

    // Buttons
    JButton buttonActualizar;

    // Panels
    JScrollPane panelATiempo;
    JScrollPane panelAterrizado;
    JScrollPane panelTaxi;
    JScrollPane panelLlegando;

    // Text Areas
    JTextArea textAreaATiempo;
    JTextArea textAreaAterrizado;
    JTextArea textAreaTaxi;
    JTextArea textAreaLlegando;

    // textField
    JTextField textFielControlador;
    JTextField textFielATiempo;
    JTextField textFielAterrizado;
    JTextField textFielTaxi;
    JTextField textFielLlegando;

    // Constructor
    public VInformacion(){
        super("Ventana Informacion");
        // Crear ventana
        int width = 455;
        int height = 750;
        this.setPreferredSize(new DimensionUIResource(width, height));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Llenar la ventana
        agregarComponentes();

        // Acomoda el tamano y ver la ventana
        this.pack();
        this.setVisible(true);
    }

    
    private void agregarComponentes(){
        this.setLayout(null);

        //--------------------------------------------------------------------- text area Controlador
        titleATiempo = new JLabel("A tiempo: ");
        titleATiempo.setBounds(20,20,400,25);//.setBounds(x, y, width, height)
        this.add(titleATiempo);

        textAreaATiempo = new JTextArea();
        panelATiempo = new JScrollPane(textAreaATiempo);
        panelATiempo.setBounds(20,50,400,100);//.setBounds(x, y, width, height)
        this.add(panelATiempo);

        titleAterrizado = new JLabel("Aterrizando: ");
        titleAterrizado.setBounds(20,175,400,25);//.setBounds(x, y, width, height)
        this.add(titleAterrizado);

        textAreaAterrizado = new JTextArea();
        panelAterrizado = new JScrollPane(textAreaAterrizado);
        panelAterrizado.setBounds(20,205,400,100);//.setBounds(x, y, width, height)
        this.add(panelAterrizado);

        titleTaxi = new JLabel("Taxi: ");
        titleTaxi.setBounds(20,330,400,25);//.setBounds(x, y, width, height)
        this.add(titleTaxi);

        textAreaTaxi = new JTextArea();
        panelTaxi = new JScrollPane(textAreaTaxi);
        panelTaxi.setBounds(20,360,400,100);//.setBounds(x, y, width, height)
        this.add(panelTaxi);

        titleLlegando = new JLabel("Llegando: ");
        titleLlegando.setBounds(20,485,400,25);//.setBounds(x, y, width, height)
        this.add(titleLlegando);

        textAreaLlegando = new JTextArea();
        panelLlegando = new JScrollPane(textAreaLlegando);
        panelLlegando.setBounds(20,515,400,100);//.setBounds(x, y, width, height)
        this.add(panelLlegando);

        //--------------------------------------------------------------------- Button Controlador
        buttonActualizar = new JButton("Actualizar");
        buttonActualizar.setBounds(20,650,400,30);//.setBounds(x, y, width, height)
        this.add(buttonActualizar);

        buttonActualizar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                textAreaATiempo.append("Press Actualizar /n");;
            }
        });

    }
}
