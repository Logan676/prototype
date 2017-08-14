package cn.com.proto.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.com.proto.R;

public class LTabTextView extends FrameLayout {

    private TextView mTextView;
    private TextView mTextViewBubble;
    // 宽高
    private int mWidth, mHeight;
    private float _density = 1;
    // 文本画笔
    private Paint tPaint = null;
    // 字体颜色
    private int textColor = Color.WHITE;
    // 字体大小
    private float textSize = 8f;
    // 画笔宽度
    private int strokeWidth = 2;

    private float mPointX = 0;
    private float mPointY = 0;
    private float mPointTextWidth = 0;
    private float mPointTextHeight = 0;
    private CharSequence mPointText = null;
    private RectF mRect = new RectF();
    private float circleY = 0;
    private float circleX = 0;
    private Paint circlePaint = null;
    // 圆圈颜色
    private int circleColor = Color.RED;
    // 圆圈画笔宽度
    private int circlestrokeWidth = 2;
    //数字在x轴的位移
    private float offsetX = 0;
    //数字在y轴的位移
    private float offsetY = 0;
    //数字的最大宽度
    private float maxWidth = 0;

    public LTabTextView(Context context) {
        super(context);
        init(context);
    }

    public LTabTextView(Context context, AttributeSet attrs,
                        int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

   /* @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int cCount = getChildCount();
        int cWidth = 0;
        int cHeight = 0;
        MarginLayoutParams cParams = null;
        *//**
     * 遍历所有childView根据其宽和高，以及margin进行布局
     *//*
        for (int i = 0; i < cCount; i++) {
            View childView = getChildAt(i);
            cWidth = childView.getMeasuredWidth();
            cHeight = childView.getMeasuredHeight();
            cParams = (MarginLayoutParams) childView.getLayoutParams();

            int cl = 0, ct = 0, cr = 0, cb = 0;

            switch (i) {
                case 0:
                    cl = cParams.leftMargin;
                    ct = cParams.topMargin;
                    break;
                case 1:
                    cl = getWidth() - cWidth - cParams.leftMargin
                            - cParams.rightMargin;
                    ct = cParams.topMargin;

                    break;
                case 2:
                    cl = cParams.leftMargin;
                    ct = getHeight() - cHeight - cParams.bottomMargin;
                    break;
                case 3:
                    cl = getWidth() - cWidth - cParams.leftMargin
                            - cParams.rightMargin;
                    ct = getHeight() - cHeight - cParams.bottomMargin;
                    break;

            }
            cr = cl + cWidth;
            cb = cHeight + ct;
            childView.layout(cl, ct, cr, cb);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        *//**
     * 获得此ViewGroup上级容器为其推荐的宽和高，以及计算模式
     *//*
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);


        // 计算出所有的childView的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        *//**
     * 记录如果是wrap_content是设置的宽和高
     *//*
        int width = 0;
        int height = 0;

        int cCount = getChildCount();

        int cWidth = 0;
        int cHeight = 0;
        MarginLayoutParams cParams = null;

        // 用于计算左边两个childView的高度
        int lHeight = 0;
        // 用于计算右边两个childView的高度，最终高度取二者之间大值
        int rHeight = 0;

        // 用于计算上边两个childView的宽度
        int tWidth = 0;
        // 用于计算下面两个childiew的宽度，最终宽度取二者之间大值
        int bWidth = 0;

        *//**
     * 根据childView计算的出的宽和高，以及设置的margin计算容器的宽和高，主要用于容器是warp_content时
     *//*
        for (int i = 0; i < cCount; i++) {
            View childView = getChildAt(i);
            cWidth = childView.getMeasuredWidth();
            cHeight = childView.getMeasuredHeight();
            cParams = (MarginLayoutParams) childView.getLayoutParams();

            // 上面两个childView
            if (i == 0 || i == 1) {
                tWidth += cWidth + cParams.leftMargin + cParams.rightMargin;
            }

            if (i == 2 || i == 3) {
                bWidth += cWidth + cParams.leftMargin + cParams.rightMargin;
            }

            if (i == 0 || i == 2) {
                lHeight += cHeight + cParams.topMargin + cParams.bottomMargin;
            }

            if (i == 1 || i == 3) {
                rHeight += cHeight + cParams.topMargin + cParams.bottomMargin;
            }

        }

        width = Math.max(tWidth, bWidth);
        height = Math.max(lHeight, rHeight);

        */

    /**
     * 如果是wrap_content设置为我们计算的值
     * 否则：直接设置为父容器计算的值
     *//*
        setMeasuredDimension(200, 100);

    }*/
    public LTabTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));
        /*


        setPadding(10, 10, 10, 10);*/

        setBackgroundColor(getResources().getColor(R.color.forestgreen));

        mTextView = new TextView(context);
        mTextView.setText("下载中");
        mTextView.setTextColor(getResources().getColor(R.color.black));

        final LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.topMargin = 17;
        params.leftMargin = 10;
        params.rightMargin = 17;
        params.bottomMargin = 10;
        params.gravity = Gravity.CENTER;
        addView(mTextView,params);

        mTextViewBubble = new TextView(context);
        mTextViewBubble.setText("26");
        mTextViewBubble.setTextSize(8);
        mTextViewBubble.setTextColor(getResources().getColor(R.color.white));


        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setShape(GradientDrawable.OVAL);
        mGradientDrawable.setCornerRadius(10);
        mGradientDrawable.setColor(getResources().getColor(R.color.red));
        mTextViewBubble.setBackgroundDrawable(mGradientDrawable);

        mTextViewBubble.setGravity(Gravity.CENTER);

        final LayoutParams params2 = new LayoutParams(50, 30);
        params2.gravity = Gravity.TOP | Gravity.RIGHT;
        mTextViewBubble.setLayoutParams(params2);

        addView(mTextViewBubble);

        _density = context.getResources().getDisplayMetrics().density;
        tPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        tPaint.setColor(textColor);
        tPaint.setStrokeWidth(strokeWidth);
        tPaint.setTextSize(textSize * _density);
        tPaint.setStyle(Style.FILL);

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(circleColor);
        circlePaint.setStrokeWidth(circlestrokeWidth);
        circlePaint.setStyle(Style.FILL);
    }


    private GradientDrawable mGradientDrawable;

    /*@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        //if (this.getText() != null) {
        if (mPointText != null && !mPointText.equals("")) {
            //计算出数字的可能的最大宽度，这里默认最大能显示数字是99，对于99用99+表示
            maxWidth = tPaint.measureText("99+");
            //当前数字的真正宽度
            mPointTextWidth = tPaint.measureText(String.valueOf(mPointText));
            //计算的是数字的x坐标
            //因为已经限定数字的最大宽度是"99+"字符串的宽度
//				mWidth-maxWidth/2就是圆心的位置，
//				如果我们要将数字画在园的中心，就要
//				获取当前数字的宽度的一半
//				mWidth-maxWidth/2-mPointTextWidth/2，
//				然后再减去自己设置的x轴位移量
            mPointX = mWidth - maxWidth / 2 - mPointTextWidth / 2 - offsetX;
            Paint.FontMetrics metrics = tPaint.getFontMetrics();
            //因为数字的外面要包一个圆，所以为了让圆能显示完全，就让数字的高也和宽相等，减去位移量，获取数字的高度
            float textH = maxWidth + offsetY;
            //如果看过http://www.jianshu.com/p/a3d15421a718我这篇文章，应该知道这是获取baseline，
            //获取到这个位置就能将文字在指定位置的y轴中心显示
            mPointTextHeight = (textH - (metrics.descent - metrics.ascent)) / 2 - metrics.ascent;
            //为了能让圆圈显示完整，所以+1*_density
            mPointY = mPointTextHeight + 1 * _density;
            //圆的x轴
            circleX = mWidth - (maxWidth) / 2 - offsetX;
            //圆的y轴
            circleY = textH / 2 + 1 * _density;
        }
    }*/
    //}

   /* @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPointText != null && !mPointText.equals("")) {
            mRect.set((float) (mPointX / 2 + maxWidth * 1.2),
                    0,
                    (float) (mPointX / 2 + 2.5 * maxWidth + 1 * _density-10),
                    circleY);
            canvas.drawOval(mRect, circlePaint);
            if (Integer.parseInt(mPointText.toString()) > 99) {
                canvas.drawText("99+", (float) (mPointX/ 2 + maxWidth * 0.6), mPointY/2, tPaint);
            } else
                canvas.drawText(mPointText.toString(),  (float) (mPointX/2+maxWidth*1.7), mPointY/2+6, tPaint);
        }

    }*/

    public void setmPointText(CharSequence mPointText) {
        this.mPointText = mPointText;
        invalidate();
    }

    public float getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }

    public float getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
    }


}