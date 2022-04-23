
# cnn神经网络模型的搭建，模型的训练
import tensorflow as tf
import matplotlib.pyplot as plt
from time import *


# 1.数据集加载
# 参数:
# data_dir数据集的路径
# test_data_dir 验证集的路径
# img_height, img_width:图片的宽高, batch_size 分批喂入
def data_load(data_dir, test_data_dir, img_height, img_width, batch_size):
    #  加载训练集
    # 将文件夹中的数据加载到tf.data.Dataset中，且加载的同时会打乱数据。
    train_ds = tf.keras.preprocessing.image_dataset_from_directory(
        data_dir,  # 训练集的路径
        label_mode="categorical",  # 标签将被编码为分类向量（使用的损失函数应为：categorical_crossentropy loss）。
        batch_size=batch_size,  # 数据批次的大小。默认值：32
        image_size=(img_height, img_width),  # 从磁盘读取数据后将其重新调整大小。默认：（256，256）
        seed=123,  # 用于shuffle和转换的可选随机种子。
    )
    #   label_mode="categorical"
    #   返回的是将生成一个元组（images, labels），其中图像的shape为（batch_size, image_size[0], image_size(1), num_channels），
    #   labels是形状为（batch_size, num_classes）的float32张量，表示类索引的one-hot编码。
    # 加载测试集
    val_ds = tf.keras.preprocessing.image_dataset_from_directory(
        test_data_dir,
        label_mode='categorical',
        image_size=(img_height, img_width),
        batch_size=batch_size,
        seed=123,
    )
    class_names = train_ds.class_names
    # 返回处理之后的训练集、验证集和类名
    return train_ds, val_ds, class_names


# 2.构建cnn模型
# 构建CNN模型
def model_load(IMG_SHAPE=(224, 224, 3), class_num=3):
    # 搭建模型
    model = tf.keras.models.Sequential([
        # 对模型做归一化的处理，将0-255之间的数字统一处理到0到1之间
        tf.keras.layers.experimental.preprocessing.Rescaling(1. / 255, input_shape=IMG_SHAPE),

        tf.keras.layers.Conv2D(64, (3, 3), strides=1, activation='relu', padding='same'),
        tf.keras.layers.Conv2D(64, (3, 3), strides=1, activation='relu', padding='same'),
        tf.keras.layers.MaxPooling2D(pool_size=(2, 2), strides=2),

        tf.keras.layers.Conv2D(128, (3, 3), strides=1, activation='relu', padding='same'),
        tf.keras.layers.Conv2D(128, (3, 3), strides=1, activation='relu', padding='same'),
        tf.keras.layers.MaxPooling2D(pool_size=(2, 2), strides=2),

        tf.keras.layers.Conv2D(256, (3, 3), strides=1, activation='relu', padding='same'),
        tf.keras.layers.Conv2D(256, (3, 3), strides=1, activation='relu', padding='same'),
        tf.keras.layers.Conv2D(256, (1, 1), strides=1, activation='relu', padding='same'),
        tf.keras.layers.MaxPooling2D(pool_size=(2, 2), strides=2),

        tf.keras.layers.Conv2D(512, (3, 3), strides=1, activation='relu', padding='same'),
        tf.keras.layers.Conv2D(512, (3, 3), strides=1, activation='relu', padding='same'),
        tf.keras.layers.Conv2D(512, (1, 1), strides=1, activation='relu', padding='same'),
        tf.keras.layers.MaxPooling2D(pool_size=(2, 2), strides=2),

        tf.keras.layers.Conv2D(512, (3, 3), strides=1, activation='relu', padding='same'),
        tf.keras.layers.Conv2D(512, (3, 3), strides=1, activation='relu', padding='same'),
        tf.keras.layers.Conv2D(512, (1, 1), strides=1, activation='relu', padding='same'),
        tf.keras.layers.MaxPooling2D(pool_size=(2, 2), strides=2),

        # 将二维的输出转化为一维
        tf.keras.layers.Flatten(),
        # The same 128 dense layers, and 10 output layers as in the pre-convolution example:
        tf.keras.layers.Dense(2048),
        tf.keras.layers.Dense(2048),
        # 通过softmax函数将模型输出为类名长度的神经元上，激活函数采用softmax对应概率值
        tf.keras.layers.Dense(class_num, activation='softmax')
    ])
    # 输出模型信息
    model.summary()
    # 指明模型的训练参数，优化器为sgd优化器，损失函数为交叉熵损失函数
    model.compile(optimizer='sgd', loss='categorical_crossentropy', metrics=['accuracy'])
    # 返回模型
    return model


# 3.展示训练过程的曲线
def show_loss_acc(history):
    # 从history中提取模型训练集和验证集准确率信息和误差信息
    acc = history.history['accuracy']
    val_acc = history.history['val_accuracy']
    loss = history.history['loss']
    val_loss = history.history['val_loss']

    # 按照上下结构将图画输出
    plt.figure(figsize=(8, 8))
    plt.subplot(2, 1, 1)
    plt.plot(acc, label='Training Accuracy')
    plt.plot(val_acc, label='Validation Accuracy')
    plt.legend(loc='lower right')
    plt.ylabel('Accuracy')
    plt.ylim([min(plt.ylim()), 1])
    plt.title('Training and Validation Accuracy')

    plt.subplot(2, 1, 2)
    plt.plot(loss, label='Training Loss')
    plt.plot(val_loss, label='Validation Loss')
    plt.legend(loc='upper right')
    plt.ylabel('Cross Entropy')
    plt.title('Training and Validation Loss')
    plt.xlabel('epoch')
    plt.savefig('results/results_VGG.png', dpi=100)




# 4.显示训练过程
def train(epochs):
    # 开始训练，记录开始时间
    begin_time = time()
    # todo 加载数据集， 修改为你的数据集的路径
    train_ds, val_ds, class_names = data_load("D:/Git_warehouse/TensorFlow2.1笔记/水果识别/newdata/train",
                                              "D:/Git_warehouse/TensorFlow2.1笔记/水果识别/newdata/val", 224, 224, 3)
    print(class_names)
    # 加载模型
    model = model_load(class_num=len(class_names))
    # 指明训练的轮数epoch，开始训练
    history = model.fit(train_ds, validation_data=val_ds, epochs=epochs)
    # todo 保存模型， 修改为你要保存的模型的名称
    model.save("models/cnn_vgg.h5")
    # 记录结束时间
    end_time = time()
    run_time = end_time - begin_time
    print('该循环程序运行时间：', run_time, "s")  # 该循环程序运行时间： 1.4201874732
    # 绘制模型训练过程图
    show_loss_acc(history)


if __name__ == '__main__':
    train(epochs=30)