package com.tomtom.gwt.geojson.client;

import com.tomtom.gwt.geojson.client.geometry.Geometry;
import static com.tomtom.gwt.geojson.client.util.Constants.JS_OBJECT_TYPE;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A Feature object represents a spatially bounded thing. 
 * Every Feature object is a GeoJSON object no matter where it occurs in a GeoJSON text.
 * @see https://tools.ietf.org/html/rfc7946 Section 3.2
 * @param <C> The sub-type of the geometry contents.
 * @param <P> The sub-type for the feature properties.
 */
@JsType(isNative = true, name = JS_OBJECT_TYPE, namespace = JsPackage.GLOBAL)
public final class Feature<C, P> extends AbstractGeoJson {
    
    @JsOverlay
    public static final String FEATURE_TYPE = "Feature";

    private Feature() {
    }

    @JsOverlay
    public static <C, P> Feature<C, P> build(Geometry<C> geometry, P properties) {
        Feature feature = new Feature();
        feature.setType(FEATURE_TYPE);
        if (geometry != null) {
            feature.setGeometry(geometry);
        }
        if (properties != null) {
            feature.setProperties(properties);
        }
        return feature;
    }
    
    @JsProperty
    public native Geometry<C> getGeometry();

    @JsProperty
    private native void setGeometry(Geometry<C> value);

    @JsProperty
    public native P getProperties();

    @JsProperty
    private native void setProperties(P properties);
}
