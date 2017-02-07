/*
 * Copyright (C) 2017 The AndroidCoreText Project
 */

package com.hyena.coretext;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.hyena.framework.utils.UIUtils;

/**
 * Created by yangzc on 17/1/20.
 */
public class TextEnv {

    private Context mContext;
    private int mVerticalSpacing;
    private int mPageWidth, mPageHeight;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private boolean mEditable = true;

    private TextEnv(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Paint getPaint() {
        return paint;
    }

    public int getVerticalSpacing() {
        return mVerticalSpacing;
    }

    private void setVerticalSpacing(int spacing) {
        this.mVerticalSpacing = spacing;
    }

    private void setPageWidth(int width) {
        this.mPageWidth = width;
    }

    private void setPageHeight(int height) {
        this.mPageHeight = height;
    }

    public int getPageWidth() {
        return mPageWidth;
    }

    public int getPageHeight() {
        return mPageHeight;
    }

    private void setEditable(boolean editable) {
        this.mEditable = editable;
    }

    public boolean isEditable() {
        return mEditable;
    }

    public static class Builder {

        private Context context;
        private int fontSize = 50;
        private int textColor = Color.BLACK;
        private Typeface typeface;
        private int verticalSpacing = 0;
        private int pageWidth = 0;
        private int pageHeight = 0;
        private boolean editable = true;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setFontSize(int fontSize) {
            this.fontSize = fontSize;
            return this;
        }

        public Builder setTextColor(int color) {
            this.textColor = color;
            return this;
        }

        public Builder setTypeFace(Typeface typeface) {
            this.typeface = typeface;
            return this;
        }

        public Builder setVerticalSpacing(int spacing) {
            this.verticalSpacing = spacing;
            return this;
        }

        public Builder setPageWidth(int width) {
            this.pageWidth = width;
            return this;
        }

        public Builder setPageHeight(int height) {
            this.pageHeight = height;
            return this;
        }

        public Builder setEditable(boolean editable) {
            this.editable = editable;
            return this;
        }

        public TextEnv build() {
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setColor(textColor);
            if (fontSize <= 0) {
                fontSize = UIUtils.dip2px(18);
            }
            paint.setTextSize(fontSize);
            if (typeface != null)
                paint.setTypeface(typeface);

            TextEnv textEnv = new TextEnv(context);
            textEnv.setPaint(paint);
            textEnv.setVerticalSpacing(verticalSpacing);
            textEnv.setPageWidth(pageWidth);
            textEnv.setPageHeight(pageHeight);
            textEnv.setEditable(editable);
            return textEnv;
        }
    }
}
