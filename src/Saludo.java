import javax.swing.*; // Importamos componentes gráficos (ventanas, botones, etc.)
import java.awt.*;    // Importamos diseños (Layouts) y eventos
import java.awt.event.*; // Importamos la gestión de acciones (clics)

/**
 * Actividad de Autoaprendizaje 1: Pruebas prelanzamiento.
 * Aplicación sencilla para validar el ciclo de construcción y empaquetado.
 */
public class Saludo extends JFrame {

    // Declaramos los componentes como variables de clase para acceder a ellos desde los eventos
    private JTextField txtNombre;
    private JLabel lblResultado;

    public static void main(String[] args) {
        // Ejecutamos la interfaz en el hilo de despacho de eventos de Swing por seguridad
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Saludo frame = new Saludo();
                    frame.setVisible(true); // Hacemos visible la ventana
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructor: Configura la ventana y sus componentes.
     */
    public Saludo() {
        // 1. Configuración básica de la ventana
        setTitle("Prueba Prelanzamiento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la app al pulsar la X
        setBounds(100, 100, 400, 150); // Posición y tamaño

        // 2. Panel principal y diseño
        JPanel contentPane = new JPanel();
        // Usamos FlowLayout para que los elementos fluyan de izquierda a derecha sencillamente
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        setContentPane(contentPane);

        // 3. Creación y añadidura de componentes

        // Etiqueta de instrucción
        JLabel lblInstruccion = new JLabel("Introduce tu nombre:");
        contentPane.add(lblInstruccion);

        // Campo de texto (ancho de 15 columnas)
        txtNombre = new JTextField();
        txtNombre.setColumns(15);
        contentPane.add(txtNombre);

        // Botón de interacción
        JButton btnSaludar = new JButton("Saludar");
        // Añadimos el "escuchador" (listener) para gestionar el clic
        btnSaludar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saludarUsuario(); // Llamamos al método que hace la lógica
            }
        });
        contentPane.add(btnSaludar);

        // Etiqueta donde se mostrará el saludo final
        lblResultado = new JLabel(""); // Inicialmente vacía
        lblResultado.setFont(new Font("Tahoma", Font.BOLD, 12)); // Ponemos negrita para destacar
        contentPane.add(lblResultado);
    }

    /**
     * Método auxiliar que contiene la lógica del botón.
     * Recoge el texto y actualiza la etiqueta.
     */
    private void saludarUsuario() {
        String nombre = txtNombre.getText(); // Obtenemos lo que escribió el usuario

        if (nombre.isEmpty()) {
            // Validación simple: si está vacío, pedimos que escriba algo
            lblResultado.setText("Escribe tu nombre.");
            lblResultado.setForeground(Color.RED);
        } else {
            // Caso correcto: mostramos el saludo
            lblResultado.setText("Hola, " + nombre);
            lblResultado.setForeground(Color.BLUE);
        }
    }
}