CurvedCornersCAD is a tiny, zero‑dependency Android Java library that lets you round the corners of any View in a single static call. It uses only Android’s built‑in GradientDrawable, so there’s no extra view wrapping, no reflection, and no impact on performance.

Add to Your Project

Add JitPack and Maven Central to your root build.gradle:

    allprojects {
        repositories {
            mavenCentral()
            maven { url 'https://jitpack.io' }
        }
    }

Then add the dependency:

    dependencies {
        implementation 'com.github.AdityaDarke97:CurvedCorners:1.0.0'
    }

Quick Usage

Import and call in one line:
```java
    
    
    // 1) Uniform 16dp radius, blue background
    CurvedCornersCAD.apply(myView, 16f, Color.BLUE);
    
    // 2) Uniform radius + 2dp red stroke
    CurvedCornersCAD.apply(myView, 16f, Color.WHITE, 2f, Color.RED);
    
    // 3) Individual radii: TL=8dp, TR=16dp, BR=24dp, BL=4dp; green bg; no stroke
    CurvedCornersCAD.apply(
        myView,
        8f,   // top-left
        16f,  // top-right
        24f,  // bottom-right
        4f,   // bottom-left
        Color.GREEN,
        0,    // stroke width = 0 (no stroke)
        0     // stroke color (ignored)
    );
```
