<template>
	<view class="container">
		<view class="diygw-form-item diygw-col-24">
			<view class="title"> 标题 </view>
			<view class="input flex">
				<view class="upload" v-for="(item, index) in uploadDatas">
					<image class="image" @tap="previewUpload" :src="item" :data-url="item" mode="aspectFill"></image>
					<text class="diy-icon-close" :data-index="index" @tap="delUpload"></text>
				</view>
				<view class="upload" @tap="uploadUpload">
					<text class="diy-icon-cameraadd"></text>
				</view>
				<input hidden :value="upload" name="upload" maxlength="-1" />
			</view>
		</view>
		<view class="flex diygw-col-24" >
			<button @tap="navigateTo" data-type="loadimageApi" class="diygw-btn green flex1 margin-xs button-button-clz">按钮</button>
		</view>
		<!-- 加载窗口 -->
		<van-popup v-model="show">
		     <div class="myAppointment-content-popup">
		         <van-icon name="warning-o" color="#ee0a24" size="0.5rem" />
		     </div>
			 
		 </van-popup>
	
	</view>
</template>

<script>
	export default {
		data() {
			return {
			    show:"false",
				loadimage: {
					msg: "",
					code:''
				},
				uploadDatas: [],
				upload: '',
				form:{
				id:'5',
				image:'2315'
				},
			};
		},
		onShareAppMessage: function () {},
		onLoad(option) {
			this.setCurrentPage(this);
			if (option) {
				this.setData({
					globalOption: option
				});
			}
		},
		mounted() {
			this.init();
		},
		methods: {
			async init() {},
			// 水果图片上传 API请求方法
				// 水果图片上传 API请求方法
						async loadimageApi() {
							let loadimage = await this.$http.put(
								'http://localhost:81/dev-api/image/image/',
								{
									id: '1',
									image: this.upload,
									mark:'1'
								},
								{ },
								'json'
							);
							this.setData({ loadimage });
							setTimeout(()=>{
							    this.show = false
							},1000000)
							
						},
						
						
			uploadUpload(e) {
				this.uploadImage(this, 'upload', 'uploadDatas');
			},
			delUpload(evt) {
				let { index } = evt.currentTarget.dataset;
				let Datas = this.uploadDatas;
				Datas.splice(index, 1);
				let upload = uploadDatas.join(',');
				this.uploadDatas = uploadDatas;
				this.upload = upload;
			},
			previewUpload(e) {
				uni.previewImage({
					current: e.currentTarget.url, // 当前显示图片的http链接
					urls: this.uploadDatas // 需要预览的图片http链接列表
				});
			},
				toCancel(){
	        this.show = true
	        if(this.show){
	            console.log(this.show)
	            setTimeout(()=>{
	                this.show = false
	            },1000000)
	        }
	    },
	
		}
	};
</script>

<style lang="scss" scoped>
	.button-button-clz {
		margin: 3px !important;
	}
	.container {
		padding-left: 0px;
		padding-right: 0px;

		font-size: 12px;
	}
</style>
