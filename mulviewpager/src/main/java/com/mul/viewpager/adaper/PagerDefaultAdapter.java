package com.mul.viewpager.adaper;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;

import com.mul.viewpager.bean.ConfigBean;
import com.mul.viewpager.click.IVpAllClick;
import com.mul.viewpager.click.IVpItemClick;
import com.mul.viewpager.utils.GlideUtil;

/**
 * @ProjectName: MulViewPager
 * @Package: com.mul.test.adaper
 * @ClassName: MainActivity
 * @Author: zdd
 * @CreateDate: 2019/8/13 14:00
 * @Description: 轮播图的实现类的适配器
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/13 14:00
 * @UpdateRemark: 更新说明
 * @Version: v1.0.1
 */
public class PagerDefaultAdapter extends BaseAdapter {

    /**
     * 传入的是一堆id的时候调用
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantIds(ViewGroup container, int position) {
        Context context = container.getContext();
        PagerHolder holder = null;
        if (null == holder) {
            holder = new PagerHolder();
            holder.imageView = new AppCompatImageView(context);
            holder.imageView.setTag(holder);
        } else {
            holder = (PagerHolder) holder.imageView.getTag();
        }
        if (null != bean) {
            int integer = (int) bean.getIds().get(position % bean.getIds().size());
            setImageBg(context, holder.imageView, integer);
            setImageAttr(holder.imageView);
            setClick(holder.imageView, position);
        }
        container.addView(holder.imageView);
        return holder.imageView;
    }

    /**
     * 传入的是网络路径的时候调用
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantImages(ViewGroup container, int position) {
        Context context = container.getContext();
        AppCompatImageView imageView = new AppCompatImageView(context);
        String url = (String) bean.getImages().get(position % bean.getImages().size());
        GlideUtil.load(context, bean.getImageHeadUrl() + url, imageView, bean.getDefaultImage());
        setImageAttr(imageView);
        setClick(imageView, position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public Object instantDatas(ViewGroup container, int position) {
        Context context = container.getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        AppCompatImageView imageView = new AppCompatImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        Object data = bean.getDatas().get(position % bean.getDatas().size());
        if (data instanceof ConfigBean) {
            Object pictures = ((ConfigBean) data).getPictures();
            if (pictures instanceof String && null != pictures && !"".equals(pictures)) {
                GlideUtil.load(context, bean.getImageHeadUrl() + pictures, imageView, bean.getDefaultImage());
            } else if (pictures instanceof Integer) {
                setImageBg(context, imageView, (Integer) pictures);
            } else {
                setImageBg(context, imageView, -1);
            }
        }
        linearLayout.setTag(data);
        setImageAttr(imageView);
        setClick(linearLayout, position);
        linearLayout.addView(imageView);
        container.addView(linearLayout);
        return linearLayout;
    }

    /**
     * 传入的是默认图的时候调用
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantDefault(ViewGroup container, int position) {
        Context context = container.getContext();
        AppCompatImageView imageView = new AppCompatImageView(context);
        setImageAttr(imageView);
        setImageBg(context, imageView, bean.getDefaultImage());
        setClick(imageView, position);
        container.addView(imageView);
        return imageView;
    }

    private void setClick(View imageView, final int position) {
        if (null != bean.getiVpClick()) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (bean.getiVpClick() instanceof IVpItemClick) {
                        ((IVpItemClick) bean.getiVpClick()).itemClick(v, position);
                    } else if (bean.getiVpClick() instanceof IVpAllClick) {
                        ((IVpAllClick) bean.getiVpClick()).itemClick(v, position);
                    }
                }
            });
        }
    }

    private void setImageAttr(AppCompatImageView imageView) {
        ImageView.ScaleType scaleType = bean.getScaleType();
        if (null != scaleType) {
            imageView.setScaleType(scaleType);
        }
    }

    private void setImageBg(Context context, AppCompatImageView imageView, int backgroundBg) {
        if (backgroundBg != -1) {
            String resourceTypeName = context.getResources().getResourceTypeName(backgroundBg);
            if (resourceTypeName.contains("drawable")) {
                imageView.setBackground(context.getResources().getDrawable(backgroundBg));
            } else if (resourceTypeName.contains("color")) {
                imageView.setBackgroundColor(context.getResources().getColor(backgroundBg));
            }
        } else {
            if (bean.getDefaultImage() != -1) {
                imageView.setBackgroundResource(bean.getDefaultImage());
            } else {
                imageView.setBackgroundColor(Color.parseColor("000000"));
            }
        }
    }

    public class PagerHolder {
        private AppCompatImageView imageView;
    }
}
