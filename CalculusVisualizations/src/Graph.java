import java.awt.*;

/**
 * A class of static methods designed to handle the necessary conversions between the worlds of pixels and \
 * the worlds of coordinates
 * @author Bay Foley-Cox
 */
public class Graph {

    /**
     * Takes a point in coordinate space and finds the corresponding location in pixel space
     * @param x the x-value of the coordinate
     * @param y the y-value of the coordinate
     * @return an length 2 array of integers representing the points coordinates in pixel space. The 0 index represents
     * X, the 1 index represents Y.
     */
    public static double[] getPixelSpace(double x, double y) {
        double[] pixelSpace = new double[2];
        double maxX = TaylorSeries.getMax_X();
        double maxY = TaylorSeries.getMAX_Y();
        double minX = TaylorSeries.getMin_X();
        double minY = TaylorSeries.getMIN_Y();
        int xRes = TaylorSeries.getXRES();
        int yRes = TaylorSeries.getYRES();
        //get relative positions between max and min
        double relativeX = (x - minX) / Math.abs(maxX - minX);
        double relativeY = (y - minY) / Math.abs(maxY - minY);
        //transform
        pixelSpace[0] = (TaylorSeries.getWidth() * relativeX);
        int pixHeight = (int) (TaylorSeries.getHeight());
        double yValue = (pixHeight * relativeY);
        pixelSpace[1] = pixHeight - yValue;
        return pixelSpace;
    }

    /**@param x coordinate that corresponds to a column in pixel space
     * @return that column as an x coordinate in coordinate space
     */
    public static double getCoordinateSpace(int x) {
        double minX = TaylorSeries.getMin_X();
        double maxY = TaylorSeries.getMAX_Y();
        int xRes = TaylorSeries.getXRES();
        double graphWidth = Math.abs(maxY - minX);
        int numPixColumns = (int) (graphWidth * xRes);
        double relativeX = (double) x / (double) numPixColumns;
        return minX + graphWidth * relativeX;
    }
}
