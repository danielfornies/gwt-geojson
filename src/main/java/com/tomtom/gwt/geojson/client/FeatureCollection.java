package com.tomtom.gwt.geojson.client;

import static com.tomtom.gwt.geojson.client.util.Constants.JS_OBJECT_TYPE;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A GeoJSON object with the type "FeatureCollection" is a FeatureCollection object. 
 * A FeatureCollection object has a member with the name "features". 
 * The value of "features" is a JSON array. Each element of the array is a Feature object as defined above. It is possible for this array to be empty.
 * @see https://tools.ietf.org/html/rfc7946 Section 3.3
 */
@JsType(isNative = true, name = JS_OBJECT_TYPE, namespace = JsPackage.GLOBAL)
public class FeatureCollection extends AbstractGeoJson {

    @JsOverlay
    public static final FeatureCollection EMPTY = FeatureCollection.build(new Feature[]{});

    private FeatureCollection() {
    }

    @JsOverlay
    public static FeatureCollection build(Feature[] features) {
        FeatureCollection featureCollection = new FeatureCollection();
        featureCollection.setType("FeatureCollection");
        featureCollection.setFeatures(features);
        return featureCollection;
    }

    @JsProperty
    public native Feature[] getFeatures();

    @JsProperty
    private native void setFeatures(Feature[] features);
}
