import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

/**
 * Main application window containing the simulation panel and controls.
 */
public class MainWindow extends JFrame {
    private Panel panel;

    /**
     * Constructs the main window.
     */
    public MainWindow() {
        setTitle("Particle Simulator");
        setSize(900, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(Color.darkGray);

        panel = new Panel(this);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        controls.setBackground(Color.lightGray);
        
        controls.setPreferredSize(new java.awt.Dimension(getWidth(), 80));
        controls.setLayout(new FlowLayout());

        createControl(controls, "Electrons", panel::addElectrons);

        createControl(controls, "Protons", panel::addProtons);

        createControl(controls, "Neutrons", panel::addNeutrons);

        createControl(controls, "Positrons", panel::addPositrons);

        createControl(controls, "Antiprotons", panel::addAntiprotons);

        createControl(controls, "Muons", panel::addMuons);

        add(controls, BorderLayout.SOUTH);

        Timer timer = new Timer(8, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.updateParticles();
                repaint();
            }
        });
        timer.start();
    }

    /**
     * Adds a labeled spinner and button for a particle type.
     *
     * @param container panel to add controls to
     * @param label     particle type label
     * @param action    consumer accepting count to add particles
     */
    private void createControl(JPanel container, String label, Consumer<Integer> action) {
        container.add(new JLabel(label + ":"));
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        container.add(spinner);
        JButton button = new JButton("Add " + label);
        button.addActionListener(e -> action.accept((Integer) spinner.getValue()));
        container.add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
    }
}