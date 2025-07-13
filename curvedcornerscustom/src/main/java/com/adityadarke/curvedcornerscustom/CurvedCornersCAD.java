package com.adityadarke.curvedcornerscustom;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

public class CurvedCornersCAD {

    private CurvedCornersCAD() { /* no instances */ }

    /**
     * Apply a uniform corner radius + background color.
     * @param view         the target View
     * @param radiusDp     corner radius in dp
     * @param bgColor      background color (e.g. Color.RED)
     */
    public static void apply(View view, float radiusDp, int bgColor) {
        apply(view, radiusDp, radiusDp, radiusDp, radiusDp, bgColor, 0, 0);
    }

    /**
     * Apply uniform radius + bg color + stroke.
     * @param view         the target View
     * @param radiusDp     corner radius in dp
     * @param bgColor      background color
     * @param strokeDp     stroke width in dp
     * @param strokeColor  stroke color
     */
    public static void apply(View view,
                             float radiusDp,
                             int bgColor,
                             float strokeDp,
                             int strokeColor) {
        apply(view, radiusDp, radiusDp, radiusDp, radiusDp, bgColor, strokeDp, strokeColor);
    }

    /**
     * Apply individual corner radii + bg color + optional stroke.
     * @param view         the target View
     * @param topLeftRadius
     * @param topRightRadius
     * @param bottomRightRadius
     * @param bottomLeftRadius
     * @param bgColor
     * @param strokeDp     pass 0 for no stroke
     * @param strokeColor  ignored if strokeDp==0
     */
    public static void apply(View view,
                             float topLeftRadius,
                             float topRightRadius,
                             float bottomRightRadius,
                             float bottomLeftRadius,
                             int bgColor,
                             float strokeDp,
                             int strokeColor) {
        float scale = view.getResources().getDisplayMetrics().density;
        GradientDrawable gd = new GradientDrawable();
        // rectangle + color
        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setColor(bgColor);
        // corner radii: {tl,tl, tr,tr, br,br, bl,bl}
        gd.setCornerRadii(new float[] {
                topLeftRadius * scale, topLeftRadius * scale,
                topRightRadius * scale, topRightRadius * scale,
                bottomRightRadius * scale, bottomRightRadius * scale,
                bottomLeftRadius * scale, bottomLeftRadius * scale
        });
        // optional stroke
        if (strokeDp > 0) {
            gd.setStroke((int)(strokeDp * scale), strokeColor);
        }
        // apply
        view.setBackground(gd);
    }
}
