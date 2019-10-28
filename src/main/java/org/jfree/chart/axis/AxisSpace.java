/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2016, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * --------------
 * AxisSpace.java
 * --------------
 * (C) Copyright 2003-2016, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * Changes
 * -------
 * 03-Jul-2003 : Version 1 (DG);
 * 14-Aug-2003 : Implemented Cloneable (DG);
 * 18-Aug-2003 : Implemented Serializable (DG);
 * 17-Mar-2004 : Added a toString() method for debugging (DG);
 * 07-Jan-2005 : Updated equals() method (DG);
 * 11-Jan-2005 : Removed deprecated methods in preparation for 1.0.0
 *               release (DG);
 * 02-Jul-2013 : Use ParamChecks (DG);
 *
 */

package org.jfree.chart.axis;

import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.util.Args;
import org.jfree.chart.util.PublicCloneable;

/**
 * A record that contains the space required at each edge of a plot.
 */
public class AxisSpace implements Cloneable, PublicCloneable, Serializable {

    /** For serialization. */
    private static final long serialVersionUID = -2490732595134766305L;

    /** The top space. */
    double top;

    /** The bottom space. */
    double bottom;

    /** The left space. */
    double left;

    /** The right space. */
    double right;

    /**
     * Creates a new axis space record.
     */
    public AxisSpace() {
        this.top = 0.0;
        this.bottom = 0.0;
        this.left = 0.0;
        this.right = 0.0;
    }

    /**
     * Returns the space reserved for axes at the top of the plot area.
     *
     * @return The space (in Java2D units).
     */
    public double getTop() {
        return this.top;
    }

    /**
     * Sets the space reserved for axes at the top of the plot area.
     *
     * @param space  the space (in Java2D units).
     */
    public void setTop(double space) {
        this.top = space;
    }

    /**
     * Returns the space reserved for axes at the bottom of the plot area.
     *
     * @return The space (in Java2D units).
     */
    public double getBottom() {
        return this.bottom;
    }

    /**
     * Sets the space reserved for axes at the bottom of the plot area.
     *
     * @param space  the space (in Java2D units).
     */
    public void setBottom(double space) {
        this.bottom = space;
    }

    /**
     * Returns the space reserved for axes at the left of the plot area.
     *
     * @return The space (in Java2D units).
     */
    public double getLeft() {
        return this.left;
    }

    /**
     * Sets the space reserved for axes at the left of the plot area.
     *
     * @param space  the space (in Java2D units).
     */
    public void setLeft(double space) {
        this.left = space;
    }

    /**
     * Returns the space reserved for axes at the right of the plot area.
     *
     * @return The space (in Java2D units).
     */
    public double getRight() {
        return this.right;
    }

    /**
     * Sets the space reserved for axes at the right of the plot area.
     *
     * @param space  the space (in Java2D units).
     */
    public void setRight(double space) {
        this.right = space;
    }    

    /**
     * Returns a clone of the object.
     *
     * @return A clone.
     *
     * @throws CloneNotSupportedException This class won't throw this exception,
     *         but subclasses (if any) might.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Tests this object for equality with another object.
     *
     * @param obj  the object to compare against.
     *
     * @return {@code true} or {@code false}.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AxisSpace)) {
            return false;
        }
        AxisSpace that = (AxisSpace) obj;
        if (this.top != that.top) {
            return false;
        }
        if (this.bottom != that.bottom) {
            return false;
        }
        if (this.left != that.left) {
            return false;
        }
        if (this.right != that.right) {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code for this object.
     *
     * @return A hash code.
     */
    @Override
    public int hashCode() {
        int result = 23;
        long l = Double.doubleToLongBits(this.top);
        result = 37 * result + (int) (l ^ (l >>> 32));
        l = Double.doubleToLongBits(this.bottom);
        result = 37 * result + (int) (l ^ (l >>> 32));
        l = Double.doubleToLongBits(this.left);
        result = 37 * result + (int) (l ^ (l >>> 32));
        l = Double.doubleToLongBits(this.right);
        result = 37 * result + (int) (l ^ (l >>> 32));
        return result;
    }

    /**
     * Returns a string representing the object (for debugging purposes).
     *
     * @return A string.
     */
    @Override
    public String toString() {
        return super.toString() + "[left=" + this.left + ",right=" + this.right
                    + ",top=" + this.top + ",bottom=" + this.bottom + "]";
    }

}
