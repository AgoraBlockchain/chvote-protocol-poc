package ch.ge.ve.protopoc.service.model;

import com.google.common.base.Preconditions;

/**
 * This class defines the security parameters to be used
 */
public class SecurityParameters {
    /**
     * Minimal privacy security level &lambda;
     */
    public final int lambda;

    /**
     * Minimal integrity security level &mu;
     */
    public final int mu;

    /**
     * Output length of collision-resistant hash-function l (in bits)
     */
    public final int l;

    /**
     * Deterrence factor &epsilon; (with 0 &lt; &epsilon; &le; 1)
     */
    public final double epsilon;

    public SecurityParameters(int lambda, int mu, int l, double epsilon) {
        Preconditions.checkArgument(l % 8 == 0, "l should be a multiple of 8, so that l = 8L");
        Preconditions.checkArgument(l >= 2 * Math.max(lambda, mu));
        Preconditions.checkArgument(0.0 < epsilon && epsilon <= 1.0);
        this.lambda = lambda;
        this.mu = mu;
        this.l = l;
        this.epsilon = epsilon;
    }
}