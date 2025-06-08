package Particles;

import java.awt.*;

/**
 * Represents a muon.
 */
public class Muon extends Particle {
    /**
     * Constructs a new Muon particle with standard properties.
     */
    public Muon() {
        super(0.5, -1.602e-19, 1.883531627e-28, 2, Color.blue);
        setQuarkComposition(null);
    }
} 