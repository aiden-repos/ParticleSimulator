package Particles;

import java.awt.*;

/**
 * Represents a positron.
 */
public class Positron extends Particle {
    /**
     * Constructs a new Positron particle with standard properties.
     */
    public Positron() {
        super(0.5, 1.602e-19, 9.109e-31, 2, Color.magenta);
        setQuarkComposition(null);
    }

    /**
     * Returns the label for display, overriding default to show positron symbol.
     *
     * @return display label "E+"
     */
    @Override
    public String getLabel() {
        return "E+";
    }
} 