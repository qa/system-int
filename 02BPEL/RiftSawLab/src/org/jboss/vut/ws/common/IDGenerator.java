package org.jboss.vut.ws.common;

/**
 *
 * @author mbaluch
 */
public class IDGenerator {

    protected volatile long current = 1;
    protected long initial          = current;
    protected long max              = Long.MAX_VALUE;

    public synchronized long next() {
        long id = current++;
        if (current > max || current < 0) {
            current = initial;
        }
        return id;
    }

}
