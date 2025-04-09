package Particles;

import java.awt.*;

public class Proton extends Particle {
    public Proton() {
        super(0.5, 1.602e-19, 1.6726e-27, 3, Color.red); // Sets all the properties of the proton
        setQuarkComposition(new QuarkComposition(2, 1, 0, 0, 0, 0)); // Proton is made of two up quarks and one down quark
    }
}
