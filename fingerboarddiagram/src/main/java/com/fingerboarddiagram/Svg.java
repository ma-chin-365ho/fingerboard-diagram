package com.fingerboarddiagram;

import java.awt.Dimension;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;

public class Svg {

    public SVGGraphics2D graphics;

    public Svg(int width, int height) {
        DOMImplementation domImpl = SVGDOMImplementation.getDOMImplementation();
        org.w3c.dom.Document doc = domImpl.createDocument(SVGDOMImplementation.SVG_NAMESPACE_URI, "svg", null);
        SVGGraphics2D g = new SVGGraphics2D(doc);
        g.setSVGCanvasSize(new Dimension(width, height));
        this.graphics = g;
    }

    public void save(String filePath) throws java.io.IOException {
        this.graphics.stream(filePath);
    }
}
