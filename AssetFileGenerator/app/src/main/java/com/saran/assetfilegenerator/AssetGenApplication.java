package com.saran.assetfilegenerator;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Saran on 22/12/15.
 */
public class AssetGenApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath(Asset.FONTS.FUTURA.getPath())
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
}
