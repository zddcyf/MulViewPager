package com.mul.viewpager.config;

/**
 * @ProjectName: MulViewPager
 * @Package: com.mul.test.config
 * @ClassName: ViewPagerEnum
 * @Author: zdd
 * @CreateDate: 2019/8/13 14:00
 * @Description: 轮播图样式的配置
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/13 14:00
 * @UpdateRemark: 更新说明
 * @Version: v1.0.1
 */
public enum ViewPagerEnum {
    ids(0), // 使用路径
    images(1), // 使用网络路径
    datas(18), // 使用数据源

    point(2), // 显示点
    number(3), // 显示数字

    wireBanner(4), // 是无线轮播
    startBanner(5), // 启动页
    firstBanner(6), // 轮播一次
    noBanner(7), // 不轮播
    selectBanner(8), // 设置了默认显示第几页

    bottomOrLeft(9), // 指示器所在位置 下左
    bottomOrCenter(10), // 指示器所在位置 下中
    bottomOrRight(11), // 指示器所在位置 下右
    topOrLeft(12), // 指示器所在位置 下右
    topOrCenter(13), // 指示器所在位置 下右
    topOrRight(14), // 指示器所在位置 下右

    noIndicator(15), // 不显示指示器

    childLeft(16), // 内部控件在显示数量的左边
    childRight(17); // 内部控件在显示数量的右边

    private int code;

    ViewPagerEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
