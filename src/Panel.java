import Particles.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Panel responsible for rendering and updating particles in the simulation.
 */
public class Panel extends JPanel {
    private ArrayList<Particle> particles;
    private Random rand = new Random();

    /**
     * Constructs the simulation panel.
     *
     * @param mainWindow parent window reference
     */
    public Panel(MainWindow mainWindow) {
        setBackground(Color.darkGray);
        
        particles = new ArrayList<Particle>();
    }

    /**
     * Advances simulation particles by a fixed time step.
     */
    public void updateParticles() {
        Simulator.updateParticles(particles, 0.008, getWidth(), getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Particle p : particles) {
            p.paint(g);
        }
    }

    /**
     * Adds a specified number of particles using the provided supplier.
     *
     * @param supplier supplier for new Particle instances
     * @param count    number of particles to add
     */
    private void addParticles(Supplier<Particle> supplier, int count) {
        for (int i = 0; i < count; i++) {
            Particle p = supplier.get();
            int x = rand.nextInt(getWidth());
            int y = rand.nextInt(getHeight());
            p.setX(x);
            p.setY(y);
            p.setVx(0.0);
            p.setVy(0.0);
            particles.add(p);
        }
    }

    /**
     * Adds the specified number of Proton particles.
     *
     * @param count number of Protons to add
     */
    public void addProtons(int count) {
        addParticles(Proton::new, count);
    }

    /**
     * Adds the specified number of Electron particles.
     *
     * @param count number of Electrons to add
     */
    public void addElectrons(int count) {
        addParticles(Electron::new, count);
    }

    /**
     * Adds the specified number of Neutron particles.
     *
     * @param count number of Neutrons to add
     */
    public void addNeutrons(int count) {
        addParticles(Neutron::new, count);
    }

    /**
     * Adds the specified number of Positron particles.
     *
     * @param count number of Positrons to add
     */
    public void addPositrons(int count) {
        addParticles(Positron::new, count);
    }

    /**
     * Adds the specified number of Antiproton particles.
     *
     * @param count number of Antiprotons to add
     */
    public void addAntiprotons(int count) {
        addParticles(Antiproton::new, count);
    }

    /**
     * Adds the specified number of Muon particles.
     *
     * @param count number of Muons to add
     */
    public void addMuons(int count) {
        addParticles(Muon::new, count);
    }

    /**
     * Clears all particles from the simulation.
     */
    public void clearParticles() {
        particles.clear();
    }
}