package Particles;

import java.awt.*;

public class Particle extends Rectangle {
    /*
     * Spin, Charge, and Mass are inherit properties of a Particle.
     *
     * Radius and Color are aesthetic, and will be used to be able to differentiate particles on the screen.
     *
     * The quark composition is a new property added to represent the internal structure of subatomic particles.
     *
     * The x and y coordinates are used to represent the position of the particle in a 2D space.
     * */
    private double spin, charge, mass, radius;
    private Color color;
    private QuarkComposition quarkComposition;

    private double x, y;
    private double vx, vy;

    /**
     * Default constructor for the Particle class. Initializes a particle with default values.
     *
     * <p>
     *     Can only be used by subclasses of Particle.
     * </p>
     */
    protected Particle() {
    }

    /**
     * Constructor for the Particle class with spin. Initializes a particle with a specified spin.
     *
     * <p>
     *     Can only be used by subclasses of Particle.
     * </p>
     *
     * @param spin The spin of the particle.
     */
    protected Particle(double spin) {
        this.spin = spin;
        this.charge = 0; // Default charge for a particle without specified charge
        this.mass = 0;   // Default mass for a particle without specified mass
        this.radius = 1; // Default radius for visualization purposes
        this.color = Color.WHITE; // Default color for visualization purposes
    }

    /**
     * Constructor for the Particle class with spin and charge. Initializes a particle with specified spin and charge.
     *
     * <p>
     *     Can only be used by subclasses of Particle.
     * </p>
     *
     * @param spin   The spin of the particle.
     * @param charge The charge of the particle.
     */
    protected Particle(double spin, double charge) {
        this.spin = spin;
        this.charge = charge;
        this.mass = 0;   // Default mass for a particle without specified mass
        this.radius = 1; // Default radius for visualization purposes
        this.color = Color.WHITE; // Default color for visualization purposes
    }

    /**
     * Constructor for the Particle class with spin, charge, and mass. Initializes a particle with specified spin, charge, and mass.
     *
     * <p>
     *     Can only be used by subclasses of Particle.
     * </p>
     *
     * @param spin   The spin of the particle.
     * @param charge The charge of the particle.
     * @param mass   The mass of the particle.
     */
    protected Particle(double spin, double charge, double mass) {
        this.spin = spin;
        this.charge = charge;
        this.mass = mass;
        this.radius = 1; // Default radius for visualization purposes
        this.color = Color.WHITE; // Default color for visualization purposes
    }

    /**
     * Constructor for the Particle class with spin, charge, mass, and radius. Initializes a particle with specified spin, charge, mass, and radius.
     *
     * <p>
     *     Can only be used by subclasses of Particle.
     * </p>
     *
     * @param spin   The spin of the particle.
     * @param charge The charge of the particle.
     * @param mass   The mass of the particle.
     * @param radius The radius of the particle.
     */
    protected Particle(double spin, double charge, double mass, double radius) {
        this.spin = spin;
        this.charge = charge;
        this.mass = mass;
        this.radius = radius;
        this.color = Color.WHITE; // Default color for visualization purposes
    }

    /**
     * Constructor for the Particle class with spin, charge, mass, radius, and color. Initializes a particle with specified spin, charge, mass, radius, and color.
     *
     * <p>
     *     Can only be used by subclasses of Particle.
     * </p>
     *
     * @param spin   The spin of the particle.
     * @param charge The charge of the particle.
     * @param mass   The mass of the particle.
     * @param radius The radius of the particle.
     * @param color  The color of the particle.
     */
    protected Particle(double spin, double charge, double mass, double radius, Color color) {
        this.spin = spin;
        this.charge = charge;
        this.mass = mass;
        this.radius = radius;
        this.color = color;
    }


    /**
     * Constructor for the Particle class with spin, charge, mass, radius, color, quark composition. Initializes a particle with specified spin, charge, mass, radius, color, and quark composition.
     *
     * <p>
     *     Can only be used by subclasses of Particle.
     * </p>
     *
     * @param spin              The spin of the particle.
     * @param charge            The charge of the particle.
     * @param mass              The mass of the particle.
     * @param radius            The radius of the particle.
     * @param color             The color of the particle.
     * @param quarkComposition The quark composition of the particle.
     */
    protected Particle(double spin, double charge, double mass, double radius, Color color, QuarkComposition quarkComposition) {
        this.spin = spin;
        this.charge = charge;
        this.mass = mass;
        this.radius = radius;
        this.color = color;
        this.quarkComposition = quarkComposition;
    }

    /**
     * Gets the spin of the particle.
     *
     * @return The spin of the particle.
     *
     * */
    public double getSpin() {
        return spin;
    }

    /**
     * Sets the spin of the particle.
     *
     * @param spin The spin of the particle.
     * */
    public void setSpin(double spin) {
        this.spin = spin;
    }

    /**
     * Gets the charge of the particle.
     *
     * @return The charge of the particle.
     * */
    public double getCharge() {
        return charge;
    }

    /**
     * Sets the charge of the particle.
     *
     * @param charge The charge of the particle.
     * */
    public void setCharge(double charge) {
        this.charge = charge;
    }

    /**
     * Gets the mass of the particle.
     *
     * @return The mass of the particle.
     * */
    public double getMass() {
        return mass;
    }

    /**
     * Sets the mass of the particle.
     *
     * @param mass The mass of the particle.
     * */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * Gets the radius of the particle.
     *
     * @return The radius of the particle.
     * */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the particle.
     *
     * @param radius The radius of the particle.
     * */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Gets the color of the particle.
     *
     * @return The color of the particle.
     * */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the particle.
     *
     * @param color The color of the particle.
     * */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets the quark composition of the particle.
     *
     * @return The quark composition of the particle.
     * */
    public QuarkComposition getQuarkComposition() {
        return quarkComposition;
    }

    /**
     * Sets the quark composition of the particle.
     *
     * @param quarkComposition The quark composition of the particle.
     * */
    public void setQuarkComposition(QuarkComposition quarkComposition) {
        this.quarkComposition = quarkComposition;
    }

    /**
     * Gets the x coordinate of the particle.
     *
     * @return The x coordinate of the particle.
     * */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Sets the x coordinate of the particle.
     *
     * @param x The x coordinate of the particle.
     * */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the y coordinate of the particle.
     *
     * @return The y coordinate of the particle.
     * */
    public double getY() {
        return y;
    }

    /**
     * Sets the y coordinate of the particle.
     *
     * @param y The y coordinate of the particle.
     * */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the x velocity of the particle.
     *
     * @return The x velocity of the particle.
     * */
    public double getVx() {
        return vx;
    }

    /**
     * Sets the x velocity of the particle.
     *
     * @param vx The x velocity of the particle.
     * */
    public void setVx(double vx) {
        this.vx = vx;
    }

    /**
     * Gets the y velocity of the particle.
     *
     * @return The y velocity of the particle.
     * */
    public double getVy() {
        return vy;
    }

    /**
     * Sets the y velocity of the particle.
     *
     * @param vy The y velocity of the particle.
     * */
    public void setVy(double vy) {
        this.vy = vy;
    }

    /**
     * Updates the position and velocity of the particle through the application of forces.
     *
     * <p>
     * Updates the particle's position by utilizing Newton's second law of motion (F = ma).
     * </p>
     *
     * <p>
     * Acceleration is force divided by mass according to F = ma.
     * Velocity is updated using this kinematic: vf = vi + a * deltaTime.
     * Position is updated using this kinematic: xf = xi + vi * deltaTime.
     * </p>
     *
     * @param forceX    The force applied in the x-direction.
     * @param forceY    The force applied in the y-direction.
     * @param deltaTime The change in time over which the update occurs.
     */
    public void update(double forceX, double forceY, double deltaTime) {
        // Since F = ma, then F/m = a, in which vf = vi + a*t
        vx += (forceX / mass) * deltaTime;
        vy += (forceY / mass) * deltaTime;

        // xf = xi + vi*t
        x += vx * deltaTime;
        y += vy * deltaTime;

        System.out.println("Particle position: (" + x + ", " + y + ")");
    }

    /**
     * Paints the particle on the screen.
     *
     * <p>
     *     This method should only be used in the context of a GUI application, as it requires Graphics.
     * </p>
     *
     * @param g The Graphics object to paint on.
     * */
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval((int) x, (int) y, (int) radius * 10, (int) radius * 10);
    }
}