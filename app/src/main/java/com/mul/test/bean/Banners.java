package com.mul.test.bean;

import com.mul.viewpager.bean.ConfigBean;

/**
 * @ProjectName: MulViewPager
 * @Package: com.mul.test.bean
 * @ClassName: Banners
 * @Author: zdd
 * @CreateDate: 2019/8/13 14:00
 * @Description: 测试轮播的数据源
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/13 14:00
 * @UpdateRemark: 更新说明
 * @Version: v1.0.1
 */
public class Banners implements ConfigBean {
    private Object pictures;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPictures(Object pictures) {
        this.pictures = pictures;
    }

    @Override
    public Object getPictures() {
        return pictures;
    }

    public Banners(Object pictures, String type) {
        this.pictures = pictures;
        this.type = type;
    }
}
