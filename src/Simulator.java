import Particles.*;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static final double G = 6.67430e-11;
    private static final double K = 8.9875517873681764e9;
    private static final double GLOBAL_SPEED_SCALE = .05;

    /**
     * Creates a new instance of the Simulator class. The Simulator class is meant to provide utility, not act as a
     * standalone object, thus the private constructor.
     * */
    private Simulator() {
    }

    /** Calculates the distance/hypotenuse of a triangle or two points respectively.
     *
     * @param a The first side of the triangle, or the x distance between two points.
     * @param b The second side of the triangle, or the y distance between two points.
     * @return The length of distance between the two points, or the hypotenuse of the triangle.
     */
    public static double pythagoreanTheorem(double a, double b) {
        double c = (a*a) + (b*b);
        return Math.sqrt(c);
    }

    /**
     * Calculates the gravitational force experienced by two particles by each other.
     *
     * <p>
     *     Uses Newton's law of universal gravitation to calculate the force between two particles (fg = (G*m1*m2) / r^2).
     * </p>
     *
     * @param p1 The first particle.
     * @param p2 The second particle.
     * @return The gravitational force experienced between the two particles.
     */
    public static double calculateGF(Particle p1, Particle p2) {
        double distance = pythagoreanTheorem((p2.getX() - p1.getX()), (p2.getY() - p1.getY()));
        distance = Math.max(distance, 1e-10);
        double force = (G * p1.getMass() * p2.getMass()) / (distance * distance);
        return force;
    }

    /**
     * Calculates the electric force experienced by two particles by each other.
     *
     * @param p1 The first particle.
     * @param p2 The second particle.
     * @return The electric force experienced between the two particles.
     */
    public static double calculateEF(Particle p1, Particle p2) {
        double distance = pythagoreanTheorem((p2.getX() - p1.getX()), (p2.getY() - p1.getY()));
        distance = Math.max(distance, 1e-10);
        double force = (K * p1.getCharge() * p2.getCharge()) / (distance * distance);
        return force;
    }

    /**
     * Calculates the combined electric and gravitational force magnitude.
     *
     * @param p1       first particle
     * @param p2       second particle
     * @param distance distance between particles
     * @return combined force magnitude
     */
    private static double calculateCF(Particle p1, Particle p2, double distance) {
        double eForce = calculateEF(p1, p2);
        double gForce = calculateGF(p1, p2);
        double eMag = Math.abs(eForce);
        double eSign = eForce < 0 ? 1.0 : -1.0;
        double scaledE = eMag * 1e5 * eSign * Math.sqrt(distance);
        double scaledG = gForce * 1e41;
        return scaledE + scaledG;
    }

    /**
     * Updates all particles.
     *
     * @param particles list of particles
     * @param deltaTime simulation time step
     * @param width     width of simulation area
     * @param height    height of simulation area
     */
    public static void updateParticles(ArrayList<Particle> particles, double deltaTime, int width, int height) {
        int n = particles.size();
        double[] forcesX = new double[n];
        double[] forcesY = new double[n];
        boolean[] collided = new boolean[n];
        boolean[] toRemove = new boolean[n];

        computeForces(particles, forcesX, forcesY, collided, toRemove);
        updateStates(particles, forcesX, forcesY, collided, deltaTime, width, height);
        removeParticles(particles, toRemove);
    }

    /**
     * Computes inter-particle forces and processes collisions.
     *
     * @param particles list of particles
     * @param forcesX   array accumulating X-direction forces
     * @param forcesY   array accumulating Y-direction forces
     * @param collided  array marking collided particles
     * @param toRemove  array flagging particles for removal
     */
    private static void computeForces(List<Particle> particles, double[] forcesX, double[] forcesY, boolean[] collided, boolean[] toRemove) {
        int n = particles.size();
        for (int i = 0; i < n; i++) {
            Particle p1 = particles.get(i);
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                Particle p2 = particles.get(j);
                double dx = p2.getX() - p1.getX();
                double dy = p2.getY() - p1.getY();
                double distance = pythagoreanTheorem(dx, dy);
                if (processCollision(p1, p2, dx, dy, distance, i, j, collided, toRemove)) {
                    continue;
                }
                double force = calculateCF(p1, p2, distance);
                forcesX[i] += force * dx / distance;
                forcesY[i] += force * dy / distance;
            }
        }
    }

    /**
     * Processes a collision between two particles.
     *
     * @return true if a collision occurred, false otherwise
     */
    private static boolean processCollision(Particle p1, Particle p2, double dx, double dy, double distance, int i, int j, boolean[] collided, boolean[] toRemove) {
        double collisionDist = (p1.getRadius() + p2.getRadius()) * 5.0;
        if (distance <= collisionDist) {
            if ((p1 instanceof Electron && p2 instanceof Positron)
                || (p1 instanceof Positron && p2 instanceof Electron)
                || (p1 instanceof Proton && p2 instanceof Antiproton)
                || (p1 instanceof Antiproton && p2 instanceof Proton)) {
                toRemove[i] = true;
                toRemove[j] = true;
                return true;
            }
            double m1 = p1.getMass();
            double m2 = p2.getMass();
            double totalM = m1 + m2;
            double comX = (p1.getX() * m1 + p2.getX() * m2) / totalM;
            double comY = (p1.getY() * m1 + p2.getY() * m2) / totalM;
            double offset1 = (m2 / totalM) * collisionDist;
            double offset2 = (m1 / totalM) * collisionDist;
            int newX1 = (int) Math.round(comX - dx * offset1 / distance);
            int newY1 = (int) Math.round(comY - dy * offset1 / distance);
            int newX2 = (int) Math.round(comX + dx * offset2 / distance);
            int newY2 = (int) Math.round(comY + dy * offset2 / distance);
            p1.setX(newX1);
            p1.setY(newY1);
            p2.setX(newX2);
            p2.setY(newY2);
            double dvx = p1.getVx() - p2.getVx();
            double dvy = p1.getVy() - p2.getVy();
            double distSq = (distance == 0) ? 1e-10 : distance * distance;
            double dot = dvx * dx + dvy * dy;
            double coef1 = 2 * m2 / (m1 + m2) * dot / distSq;
            double coef2 = 2 * m1 / (m1 + m2) * dot / distSq;
            p1.setVx(p1.getVx() - coef1 * dx);
            p1.setVy(p1.getVy() - coef1 * dy);
            p2.setVx(p2.getVx() + coef2 * dx);
            p2.setVy(p2.getVy() + coef2 * dy);
            collided[i] = true;
            collided[j] = true;
            return true;
        }
        return false;
    }

    /**
     * Updates particle states and applies bounds.
     *
     * @param particles list of particles
     * @param forcesX   forces in X
     * @param forcesY   forces in Y
     * @param collided  collision flags
     * @param deltaTime timestep
     * @param width     area width
     * @param height    area height
     */
    private static void updateStates(List<Particle> particles, double[] forcesX, double[] forcesY, boolean[] collided, double deltaTime, int width, int height) {
        for (int i = 0; i < particles.size(); i++) {
            Particle p = particles.get(i);
            double speedMult = (p instanceof Proton || p instanceof Antiproton) ? 50.0 : 1.0;
            double fx = forcesX[i] * speedMult * GLOBAL_SPEED_SCALE;
            double fy = forcesY[i] * speedMult * GLOBAL_SPEED_SCALE;
            if (!collided[i]) {
                double damping = (p instanceof Proton) ? 0.99 : 0.999;
                p.setVx(p.getVx() * damping);
                p.setVy(p.getVy() * damping);
            }
            p.update(fx, fy, deltaTime);
            enforceBounds(p, width, height);
        }
    }

    /**
     * Keeps a particle within bounds, reflecting velocity on edge contact.
     */
    private static void enforceBounds(Particle p, int width, int height) {
        double r = p.getRadius() * 5.0;
        if (p.getX() - r < 0) {
            p.setX((int) r);
            p.setVx(-p.getVx() * 0.9);
        } else if (p.getX() + r > width) {
            p.setX((int) (width - r));
            p.setVx(-p.getVx() * 0.9);
        }
        if (p.getY() - r < 0) {
            p.setY((int) r);
            p.setVy(-p.getVy() * 0.9);
        } else if (p.getY() + r > height) {
            p.setY((int) (height - r));
            p.setVy(-p.getVy() * 0.9);
        }
    }

    /**
     * Removes particles flagged for removal.
     *
     * @param particles list of particles
     * @param toRemove  removal flags
     */
    private static void removeParticles(List<Particle> particles, boolean[] toRemove) {
        for (int i = particles.size() - 1; i >= 0; i--) {
            if (toRemove[i]) {
                particles.remove(i);
            }
        }
    }
}