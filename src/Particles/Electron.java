package Particles;

import java.awt.*;

public class Electron extends Particle {
    public Electron() {
        super(0.5, -1.602e-19, 9.109e-31, 2, Color.yellow); // Sets all the properties of the electron
        setQuarkComposition(null); // Electrons are not made of quarks
    }
}
