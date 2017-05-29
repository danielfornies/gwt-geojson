package com.tomtom.gwt.geojson.client.geometry;

import com.tomtom.gwt.geojson.client.AbstractGeoJson;
import static com.tomtom.gwt.geojson.client.util.Constants.JS_OBJECT_TYPE;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A GeoJSON object with type "GeometryCollection" is a Geometry object. 
 * A GeometryCollection has a member with the name "geometries". The value of "geometries" is an array. Each element of this array is a GeoJSON Geometry object.
 * @see https://tools.ietf.org/html/rfc7946 Section 3.1.8
 */
@JsType(isNative = true, name = JS_OBJECT_TYPE, namespace = JsPackage.GLOBAL)
public class GeometryCollection extends AbstractGeoJson {
    
    @JsOverlay
    public static final GeometryCollection EMPTY = GeometryCollection.build(new Geometry[]{});
    
    private GeometryCollection() {
    }
    
    @JsOverlay
    public static GeometryCollection build(Geometry[] geometries) {
        GeometryCollection geometryCollection = new GeometryCollection();
        geometryCollection.setType("GeometryCollection");
        geometryCollection.setGeometries(geometries);
        return geometryCollection;
    }
    
    @JsProperty
    public native Geometry[] getGeometries();
    
    @JsProperty
    private native void setGeometries(Geometry[] geometries);
}
