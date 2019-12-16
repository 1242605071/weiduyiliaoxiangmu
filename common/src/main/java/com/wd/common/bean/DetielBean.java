package com.wd.common.bean;

import java.util.List;

/**
 * @Description: 作用描述
 * @CreateDate: 2019/12/16 15:24
 * @Author: 作者名
 * @Version: 1.0
 */
public class DetielBean {


        /**
         * badNum : 0
         * commentList : [{"commentTime":1564985498000,"content":"啦M8听哦肯德基","headPic":"http://172.17.8.100/images/health/user/head_pic/2019-07-29/20190729113034.jpeg","nickName":"别逼逼"},{"commentTime":1561447840000,"content":"很好","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_6.jpg","nickName":"hw_LLLYN"}]
         * commentNum : 2
         * doctorId : 2
         * doctorName : 安安
         * doctorReceiveGiftList : [{"giftName":"奖杯","giftPic":"http://172.17.8.100/images/health/gift/gift3.jpg","meaning":"奖杯是一种荣誉","receiveNum":38,"worth":100}]
         * followFlag : 2
         * goodField : 啊啊啊啊
         * imagePic : http://172.17.8.100/images/health/doctor/system_image_pic/system_image3.jpg
         * inauguralHospital : 三甲
         * jobTitle : 主治医师
         * personalProfile : 啊啊啊啊啊啊啊啊
         * praise : 50.00%
         * praiseNum : 2
         * serverNum : 33
         * servicePrice : 500
         */

        public int badNum;
        public int commentNum;
        public int doctorId;
        public String doctorName;
        public int followFlag;
        public String goodField;
        public String imagePic;
        public String inauguralHospital;
        public String jobTitle;
        public String personalProfile;
        public String praise;
        public int praiseNum;
        public int serverNum;
        public int servicePrice;
        public List<CommentListBean> commentList;
        public List<DoctorReceiveGiftListBean> doctorReceiveGiftList;

        public static class CommentListBean {
            /**
             * commentTime : 1564985498000
             * content : 啦M8听哦肯德基
             * headPic : http://172.17.8.100/images/health/user/head_pic/2019-07-29/20190729113034.jpeg
             * nickName : 别逼逼
             */

            public long commentTime;
            public String content;
            public String headPic;
            public String nickName;
        }

        public static class DoctorReceiveGiftListBean {
            /**
             * giftName : 奖杯
             * giftPic : http://172.17.8.100/images/health/gift/gift3.jpg
             * meaning : 奖杯是一种荣誉
             * receiveNum : 38
             * worth : 100
             */

            public String giftName;
            public String giftPic;
            public String meaning;
            public int receiveNum;
            public int worth;
        }

}
