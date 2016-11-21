package com.tomtom.gwt.geojson.client;

import com.tomtom.gwt.geojson.client.geometry.Geometry;
import static com.tomtom.gwt.geojson.client.util.Constants.JS_OBJECT_TYPE;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 *
 * 
 * @param <C>
 * @param <P>
 */
@JsType(isNative = true, name = JS_OBJECT_TYPE, namespace = JsPackage.GLOBAL)
public class Feature<C, P> extends AbstractGeoJson {
    
    private Feature() {
    }
    
    @JsOverlay
    public static <C, P> Feature<C, P> build(Geometry<C> geometry, P properties) {
        Feature feature = new Feature();
        feature.setType("Feature");
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
