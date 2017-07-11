package com.example.liuyuesen.twtnews.View;

import java.util.List;

/**
 * Created by liuyuesen on 2017/7/6.
 */

public class NewsBean {

    /**
     * error_code : -1
     * message :
     * data : [{"index":53700,"subject":"天大志 北洋情：2017年本科生毕业典礼顺利举行","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_07_06_02_16_49_cover_284.jpg","visitcount":202,"comments":0,"summary":"数载北洋情怀，一生天大志向。7月4日下午2时，天津大学2017年本科生毕业典礼暨学位授予..."},{"index":53699,"subject":"【图集】敢于担当 放飞理想：2017本科生毕业典礼","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_07_06_01_32_55_cover_284.jpg","visitcount":303,"comments":0,"summary":"7月4日下午2时，2017届本科生暨学位授予仪式在卫津路校区新体育馆隆重举行。天津大学2017..."},{"index":53697,"subject":"花开满盛夏 毕业致青春：天津大学2017届本科生毕业晚会","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_07_04_21_53_14_cover_353.jpg","visitcount":698,"comments":0,"summary":"7月2日晚7时，\u201c花开满盛夏 毕业致青春\u201d天津大学2017届本科生毕业晚会在卫津路校区体育..."},{"index":53690,"subject":"实事求是 砥砺前行：2017年研究生毕业典礼","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_06_30_21_35_24_cover_282.jpg","visitcount":449,"comments":1,"summary":"几番寒暑铸就天大品格，一生岁月践行家国情怀。6月30日上午9时，2017年研究生毕业典礼暨..."},{"index":53684,"subject":"天津大学2017届毕业生代表座谈会召开","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_06_25_01_08_16_cover_292.jpg","visitcount":255,"comments":0,"summary":"6月22日，2017届毕业生代表座谈会在天津大学北洋园校区行政楼第一会议室成功举办。天津..."},{"index":53677,"subject":"美国国家科学院院士Jef D.Boeke教授做客北洋大讲堂","pic":"/post/img/uploadFiles/2017_06_12_15_46_58_7.jpg","visitcount":444,"comments":0,"summary":"今年3月，中国科学家4篇研究长文登上了国际顶级学术期刊《科学》的封面，把Sc2.0计划推..."},{"index":53662,"subject":"【图集】谈判与外交的艺术：沙祖康先生莅临天津大学","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_06_06_21_25_31_cover_286.jpg","visitcount":652,"comments":0,"summary":"6月6日，前任联合国副秘书长沙祖康先生莅临天津大学。上午9时，沙祖康先生参观卫津路校..."},{"index":53657,"subject":"通信与技术的融合：邬贺铨做客北洋大讲堂","pic":"http://open.twtstudio.com/imgcache/633095635ae8534c018a69b591edb898.jpg","visitcount":231,"comments":0,"summary":"6月5日上午9时，由共青团天津大学委员会、电气自动化与信息工程学院、天津大学青年文化..."},{"index":53651,"subject":"玫瑰与海：北洋军乐团音乐沙龙","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_05_29_14_25_02_cover_280.jpg","visitcount":3065,"comments":0,"summary":"5月28日晚7时，北洋军乐团二队沙龙音乐专场\u201c玫瑰与海\u201d在卫津路校区大学生活动中心一..."},{"index":53648,"subject":"十佳社团颁奖晚会：年度盛典 众彩纷呈","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_05_27_18_16_20_cover_292.jpg","visitcount":3152,"comments":0,"summary":"5月25日晚上6时30分，天津大学社团庆典暨十佳社团标兵颁奖晚会于北洋园校区大通活动中心..."},{"index":53647,"subject":"她们 不只美而已","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_05_27_00_16_04_cover_298.jpg","visitcount":1358,"comments":1,"summary":"你是否发现北洋园里存在着这样一群人？她们在你回眸处可见，在你抬眼处可寻。你是否留..."},{"index":53643,"subject":"知学讲坛：《奇葩说》正能量男神艾力做客天大","pic":"http://open.twtstudio.com/imgcache/8235c0a7d6ed8cfffa079388d142c0a8.jpg","visitcount":396,"comments":0,"summary":"5月24日下午3时20分，郑东图书馆南区一层多功能厅传出了阵阵笑声。新东方集团讲师、《超..."}]
     */

    public int error_code;
    public String message;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * index : 53700
         * subject : 天大志 北洋情：2017年本科生毕业典礼顺利举行
         * pic : http://news.twt.edu.cn/public/news/wyynews/420_2017_07_06_02_16_49_cover_284.jpg
         * visitcount : 202
         * comments : 0
         * summary : 数载北洋情怀，一生天大志向。7月4日下午2时，天津大学2017年本科生毕业典礼暨学位授予...
         */

        public int index;
        public String subject;
        public String pic;
        public int visitcount;
        public int comments;
        public String summary;
    }

    public String show(){
        return this.data.get(1).subject + this.data.get(1).comments;
    }
}
