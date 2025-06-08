package Particles;

import java.awt.*;

/**
 * Represents an antiproton.
 */
public class Antiproton extends Particle {
    /**
     * Constructs a new Antiproton particle with standard properties.
     */
    public Antiproton() {
        super(0.5, -1.602e-19, 1.6726e-27, 3, Color.cyan);
        setQuarkComposition(new QuarkComposition(0, 0, 2, 1, 0, 0));
    }

    /**
     * Returns the label for display, overriding default to show antiproton symbol.
     *
     * @return display label "p̅"
     */
    @Override
    public String getLabel() {
        return "p̅";
    }
} 