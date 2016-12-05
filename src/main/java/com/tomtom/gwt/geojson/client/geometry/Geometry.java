package com.tomtom.gwt.geojson.client.geometry;

import com.tomtom.gwt.geojson.client.AbstractGeoJson;
import static com.tomtom.gwt.geojson.client.util.Constants.JS_OBJECT_TYPE;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 *
 * 
 * @param <C>
 */
@JsType(isNative = true, name = JS_OBJECT_TYPE, namespace = JsPackage.GLOBAL)
public class Geometry<C> extends AbstractGeoJson {
    
    public static enum GeometryType {
        Point,
        LineString,
        Polygon,
        MultiPoint,
        MultiLineString,
        MultiPolygon
    }
    
    @JsOverlay
    public static Geometry<double[]> buildPoint(double longitude, double latitude) {
        return build(GeometryType.Point, new double[]{longitude, latitude});
    }
    
    @JsOverlay
    public static Geometry<double[]> buildPoint(double[] coordinates) {
        return build(GeometryType.Point, coordinates);
    }
    
    @JsOverlay
    public static Geometry<double[][]> buildLineString(double[][] coordinates) {
        return build(GeometryType.LineString, coordinates);
    }
    
    @JsOverlay
    public static <C> Geometry<C> build(GeometryType type, C coordinates) {
        Geometry<C> geometry = new Geometry();
        geometry.setType(type.name());
        geometry.setCoordinates(coordinates);
        return geometry;
    }
    
    private Geometry() {
    }
    
    // TODO: a way to put the coordinates generic object in common? Seems to be either double[] or double[][] or double[][][] ?
    @JsProperty
    private native void setCoordinates(C coordinates);
    
    @JsProperty
    public native C getCoordinates();
}
