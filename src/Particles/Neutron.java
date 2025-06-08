package Particles;

import java.awt.*;

/**
 * Represents a neutron.
 */
public class Neutron extends Particle {
    /**
     * Constructs a new Neutron particle with standard properties.
     */
    public Neutron() {
        super(0.5, 0.0, 1.6749275e-27, 3, Color.gray);
        setQuarkComposition(new QuarkComposition(1, 2, 0, 0, 0, 0));
    }
} 