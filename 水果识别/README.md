# 水果识别系统

#### 介绍
水果识别系统

#### 软件架构
前端：uniapp+diygwUI框架设计
后端: 若依前后端分离框架3.8.1版本
识别模块：tensorflow2.0,
         神经网络采用keras，
         采用requests向后端发送get和put请求，完成前端上传图片，识别图片，返回结果功能



#### 安装教程

1.  识别模块:根据requirements.txt完成
2.  后端：mysql-8.0.28和Redis

#### 使用说明

1.  文件说明
![image-20220414222726344](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220414222726344.png)
2.  安装mysql-8.0.28和Redis
    运行数据库文件
    打开Redis和mysql
    在IDEA打开运行后端文件，记得修改端口和数据库密码和端口号
    在py运行requests.py文件发送get和put请求（一定要有模型，没有就训练）
    在HBuilderX打开前端文件
    开始使用

#### 前端UI
![image-20220414222648951](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220414222648951.png)

![image-20220414222632486](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220414222632486.png)

![image-20220414222705000](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220414222705000.png)

#### 详情说明


1. 识别模块请看：https://blog.csdn.net/ECHOSON/article/details/117600329
2. PPT演示 /PPT
3. 效果视频演示 /PPT


#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
