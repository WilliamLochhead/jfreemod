package org.jfree.chart.axis;

import java.awt.geom.Rectangle2D;

import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.util.Args;

public class AxisSpaceOperations {
	
    /**
     * Adds space to the top, bottom, left or right edge of the plot area.
     *
     * @param space  the space (in Java2D units).
     * @param edge  the edge ({@code null} not permitted).
     */
    public static void add(double space, RectangleEdge edge, AxisSpace as) {
        Args.nullNotPermitted(edge, "edge");
        if (edge == RectangleEdge.TOP) {
            as.top += space;
        }
        else if (edge == RectangleEdge.BOTTOM) {
            as.bottom += space;
        }
        else if (edge == RectangleEdge.LEFT) {
            as.left += space;
        }
        else if (edge == RectangleEdge.RIGHT) {
            as.right += space;
        }
        else {
            throw new IllegalStateException("Unrecognised 'edge' argument.");
        }
    }

    /**
     * Ensures that this object reserves at least as much space as another.
     *
     * @param space  the other space.
     */
    public static void ensureAtLeast(AxisSpace space, AxisSpace as) {
        as.top = Math.max(as.top, space.top);
        as.bottom = Math.max(as.bottom, space.bottom);
        as.left = Math.max(as.left, space.left);
        as.right = Math.max(as.right, space.right);
    }

    /**
     * Ensures there is a minimum amount of space at the edge corresponding to
     * the specified axis location.
     *
     * @param space  the space.
     * @param edge  the location.
     */
    public static void ensureAtLeast(double space, RectangleEdge edge, AxisSpace as) {
        if (edge == RectangleEdge.TOP) {
            if (as.top < space) {
                as.top = space;
            }
        }
        else if (edge == RectangleEdge.BOTTOM) {
            if (as.bottom < space) {
                as.bottom = space;
            }
        }
        else if (edge == RectangleEdge.LEFT) {
            if (as.left < space) {
                as.left = space;
            }
        }
        else if (edge == RectangleEdge.RIGHT) {
            if (as.right < space) {
                as.right = space;
            }
        }
        else {
            throw new IllegalStateException(
                "AxisSpace.ensureAtLeast(): unrecognised AxisLocation."
            );
        }
    }
    
	/**
     * Shrinks an area by the space attributes.
     *
     * @param area  the area to shrink.
     * @param result  an optional carrier for the result.
     *
     * @return The result.
     */
    public static Rectangle2D shrink(Rectangle2D area, Rectangle2D result, AxisSpace as) {
        if (result == null) {
            result = new Rectangle2D.Double();
        }
        result.setRect(
            area.getX() + as.left,
            area.getY() + as.top,
            area.getWidth() - as.left - as.right,
            area.getHeight() - as.top - as.bottom
        );
        return result;
    }

    /**
     * Expands an area by the amount of space represented by this object.
     *
     * @param area  the area to expand.
     * @param result  an optional carrier for the result.
     *
     * @return The result.
     */
    public Rectangle2D expand(Rectangle2D area, Rectangle2D result, AxisSpace as) {
        if (result == null) {
            result = new Rectangle2D.Double();
        }
        result.setRect(
            area.getX() - as.left,
            area.getY() - as.top,
            area.getWidth() + as.left + as.right,
            area.getHeight() + as.top + as.bottom
        );
        return result;
    }

    /**
     * Calculates the reserved area.
     *
     * @param area  the area.
     * @param edge  the edge.
     *
     * @return The reserved area.
     */
    public Rectangle2D reserved(Rectangle2D area, RectangleEdge edge, AxisSpace as) {
        Rectangle2D result = null;
        if (edge == RectangleEdge.TOP) {
            result = new Rectangle2D.Double(
                area.getX(), area.getY(), area.getWidth(), as.top
            );
        }
        else if (edge == RectangleEdge.BOTTOM) {
            result = new Rectangle2D.Double(
                area.getX(), area.getMaxY() - as.top,
                area.getWidth(), as.bottom
            );
        }
        else if (edge == RectangleEdge.LEFT) {
            result = new Rectangle2D.Double(
                area.getX(), area.getY(), as.left, area.getHeight()
            );
        }
        else if (edge == RectangleEdge.RIGHT) {
            result = new Rectangle2D.Double(
                area.getMaxX() - as.right, area.getY(),
                as.right, area.getHeight()
            );
        }
        return result;
    }

}
