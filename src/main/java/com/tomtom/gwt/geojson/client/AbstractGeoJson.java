package com.tomtom.gwt.geojson.client;

import static com.tomtom.gwt.geojson.client.util.Constants.JS_OBJECT_TYPE;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Base type for a GeoJson object.
 * @see http://geojson.org/
 * @see https://tools.ietf.org/html/rfc7946
 */
@JsType(isNative = true, name = JS_OBJECT_TYPE, namespace = JsPackage.GLOBAL)
public abstract class AbstractGeoJson {
    
    @JsProperty
    public native String getType();

    @JsProperty    
    protected native void setType(String value);
}
