package Particles;

public class QuarkComposition {
    private int up;
    private int down;
    private int charm;
    private int strange;
    private int top;
    private int bottom;

    /**
     * Constructs a new QuarkComposition that holds the number of each type of quark for a particle.
     *
     * @param up      the number of up quarks
     * @param down    the number of down quarks
     * @param charm   the number of charm quarks
     * @param strange the number of strange quarks
     * @param top     the number of top quarks
     * @param bottom  the number of bottom quarks
     */
    public QuarkComposition(int up, int down, int charm, int strange, int top, int bottom) {
        this.up = up;
        this.down = down;
        this.charm = charm;
        this.strange = strange;
        this.top = top;
        this.bottom = bottom;
    }

    /**
     * Returns the number of up quarks.
     *
     * @return the up quark count
     */
    public int getUp() {
        return up;
    }

    /**
     * Sets the number of up quarks.
     *
     * @param up the new up quark count
     */
    public void setUp(int up) {
        this.up = up;
    }

    /**
     * Returns the number of down quarks.
     *
     * @return the down quark count
     */
    public int getDown() {
        return down;
    }

    /**
     * Sets the number of down quarks.
     *
     * @param down the new down quark count
     */
    public void setDown(int down) {
        this.down = down;
    }

    /**
     * Returns the number of charm quarks.
     *
     * @return the charm quark count
     */
    public int getCharm() {
        return charm;
    }

    /**
     * Sets the number of charm quarks.
     *
     * @param charm the new charm quark count
     */
    public void setCharm(int charm) {
        this.charm = charm;
    }

    /**
     * Returns the number of strange quarks.
     *
     * @return the strange quark count
     */
    public int getStrange() {
        return strange;
    }

    /**
     * Sets the number of strange quarks.
     *
     * @param strange the new strange quark count
     */
    public void setStrange(int strange) {
        this.strange = strange;
    }

    /**
     * Returns the number of top quarks.
     *
     * @return the top quark count
     */
    public int getTop() {
        return top;
    }

    /**
     * Sets the number of top quarks.
     *
     * @param top the new top quark count
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * Returns the number of bottom quarks.
     *
     * @return the bottom quark count
     */
    public int getBottom() {
        return bottom;
    }

    /**
     * Sets the number of bottom quarks.
     *
     * @param bottom the new bottom quark count
     */
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    /**
     * Returns a string representation of the quark composition.
     *
     * @return a string representing the quark makeup of a particle
     */
    @Override
    public String toString() {
        return "QuarkComposition [" +
                "up=" + up +
                ", down=" + down +
                ", charm=" + charm +
                ", strange=" + strange +
                ", top=" + top +
                ", bottom=" + bottom +
                ']';
    }
}
