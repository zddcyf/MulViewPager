package com.mul.viewpager.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatTextView;

import com.mul.viewpager.bean.CustomPagerBean;

/**
 * @ProjectName: MulViewPager
 * @Package: com.mul.test.view
 * @ClassName: TextIndicator
 * @Author: zdd
 * @CreateDate: 2019/8/13 14:00
 * @Description: 轮播图样式的文字显示器
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/13 14:00
 * @UpdateRemark: 更新说明
 * @Version: v1.0.1
 */
public class TextIndicator extends AppCompatTextView {
    private CustomPagerBean bean;

    public TextIndicator(Context context) {
        this(context, null);
    }

    public TextIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextIndicator(CustomPagerBean bean, Context context) {
        super(context);
        this.bean = bean;
        initView(context);
    }

    public TextIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        if (bean.getTotalSize() != 0) {
            setText(String.format("%s/%s", bean.getDefaultTextIndex() == 0 ? 1 : bean.getDefaultTextIndex(), bean.getTotalSize()));
        }
        setGravity(Gravity.CENTER);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, bean.getDefaultTextSize() == -1 ? 12 : bean.getDefaultTextSize());
        setTextColor(context.getResources().getColor(bean.getDefaultTextColor() == -1 ? android.R.color.black : bean.getDefaultTextColor()));
        if (bean.getDefaultTextBg() != -1) {
            String resourceTypeName = context.getResources().getResourceTypeName(bean.getDefaultTextBg());
            if (resourceTypeName.contains("drawable")) {
                setBackground(context.getResources().getDrawable(bean.getDefaultTextBg()));
            } else if (resourceTypeName.contains("color")) {
                setBackgroundColor(context.getResources().getColor(bean.getDefaultTextBg()));
            }
        }
    }
}
