
import tensorflow as tf
import cv2
import numpy as np
import re
import urllib.request
import requests, json

#发送get和put请求，用于返回前端的识别结果
# 预测图片，输入类名
def predict_img():
    # 图片类名，用于requests.put请求
    class_names = ['苹果', '香蕉', '柠檬']
    # 加载keras模型
    model = tf.keras.models.load_model("models/cnn_vgg.h5")
    # 读入图片
    img_init = cv2.imread("00000002.jpg")
    # 改变图片格式
    img_init = cv2.resize(img_init, (224, 224))
    # 将图片转化为numpy的数组
    img = np.asarray(img_init)
    # 将图片输入模型得到结果
    outputs = model(img.reshape(1, 224, 224, 3))
    result_index = int(np.argmax(outputs))
    # 获得对应的水果名称
    result = class_names[result_index]
    return result


# get请求，获取图片url下载和mark标记
def get():
    key = ''
    url = "http://localhost:81/dev-api/image/image/list"
    data = {
    }
    headers = {'Content-type': 'application/json'}
    response = requests.get(url, data, headers=headers)
    # 获取返回的请求响应，字符串格式
    data = response.text
    print(data)
    # 正则化表达式，用于获取mark
    patternStr = r'[\s\S]*%s(.+?)%s[\s\S]*' % ('mark":"', '"')
    middleStr = re.match(patternStr, data)
    if middleStr:
        key = (middleStr.group(1))
        print(key)
    # 正则化表达式，用于获取图片url链接
    data = re.search("(?P<url>https?://[^\s]+jpg)", data).group("url")
    print(data)
    # 下载图片
    urllib.request.urlretrieve(data, "00000002.jpg")
    print(key)
    # 返回mark，1表示要有新的图片需要识别，0表示无新的图片需要识别
    return key


# put请求，用于发送识别结果
def put(result):
    url = "http://localhost:81/dev-api/image/image/"
    data = {
        "id": "1",
        "name": result
    }
    headers = {'Content-type': 'application/json'}
    response = requests.put(url, json.dumps(data), headers=headers)
    # 返回响应结果
    print(response.content.decode())


# 循环执行函数
def run():
    key = get()
    # 1表示要有新的图片需要识别，0表示无新的图片需要识别
    if key != 1:
        result = predict_img()
        put(result)


if __name__ == '__main__':
    # 循环执行100000次
    for i in range(100000):
        run()
