package com.tomtom.gwt.geojson.client;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 *
 * 
 */
@JsType(isNative = true)
public abstract class AbstractGeoJson {
    
    @JsProperty
    public native String getType();

    @JsProperty    
    protected native void setType(String value);
}
