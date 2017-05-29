package com.tomtom.gwt.geojson.client.geometry;

import com.tomtom.gwt.geojson.client.AbstractGeoJson;
import static com.tomtom.gwt.geojson.client.util.Constants.JS_OBJECT_TYPE;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A Geometry object represents points, curves, and surfaces in coordinate space. 
 * Every Geometry object is a GeoJSON object no matter where it occurs in a GeoJSON text.
 * 
 * @see https://tools.ietf.org/html/rfc7946 Section 3.1
 * @param <C> The type of contained geometry, be it a point, or a line string.
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

    @JsProperty
    private native void setCoordinates(C coordinates);

    @JsProperty
    public native C getCoordinates();
}
