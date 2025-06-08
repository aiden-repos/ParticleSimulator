package Particles;

import java.awt.*;

/**
 * Represents an electron.
 */
public class Electron extends Particle {
    /**
     * Constructs a new Electron particle with standard properties.
     */
    public Electron() {
        super(0.5, -1.602e-19, 9.109e-31, 2, Color.yellow);
        setQuarkComposition(null);
    }
}
