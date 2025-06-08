package Particles;

import java.awt.*;

/**
 * Represents a proton.
 */
public class Proton extends Particle {
    /**
     * Constructs a new Proton particle with standard properties.
     */
    public Proton() {
        super(0.5, 1.602e-19, 1.6726e-27, 3, Color.red);
        setQuarkComposition(new QuarkComposition(2, 1, 0, 0, 0, 0));
    }
}
