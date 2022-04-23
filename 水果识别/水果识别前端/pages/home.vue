<template>
	<view class="container">
		<view class="flex flex-wrap diygw-col-24 flex-direction-column flex-clz">
			<view class="diygw-col-24 text-clz diygw-text-lg"> 水果识别平台 </view>
			<view @tap="navigateTo" data-type="page" data-url="/pages/index" class="diygw-col-24 text2-clz diygw-text-md"> 登录 </view>
		</view>
	</view>
</template>

<script>

	export default {
		data() {
			return {};
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
			async init() {}
		}
	};
</script>

<style lang="scss" scoped>
	.flex-clz {
		padding-top: 10px;
		border-bottom-left-radius: 20px;
		z-index: 100;
		padding-left: 20px;
		padding-bottom: 10px;
		border-top-right-radius: 20px;
		margin-right: 20px;
		margin-left: 20px;
		box-shadow: 4px 8px 4px;
		overflow: hidden;
		width: calc(100% - 20px - 20px) !important;
		border-top-left-radius: 20px;
		margin-top: 100px;
		border-bottom-right-radius: 20px;
		margin-bottom: 20px;
		padding-right: 20px;
	}
	.text-clz {
		margin-left: 0px;
		color: rgba(239, 239, 239, 1);
		width: calc(100% - 0px - 0px) !important;
		margin-top: 10px;
		margin-bottom: 10px;
		text-align: center;
		margin-right: 0px;
	}
	.text2-clz {
		padding-top: 10px;
		border-bottom-left-radius: 20px;
		color: rgba(255, 255, 255, 1);
		padding-left: 0px;
		padding-bottom: 10px;
		border-top-right-radius: 20px;
		margin-right: 0px;
		margin-left: 0px;
		box-shadow: 4px 4px 8px, -4px -4px 8px;
		overflow: hidden;
		width: calc(100% - 0px - 0px) !important;
		border-top-left-radius: 20px;
		margin-top: 30px;
		border-bottom-right-radius: 20px;
		margin-bottom: 10px;
		text-align: center;
		padding-right: 0px;
	}
	.container {
		padding-left: 0px;
		padding-right: 0px;

		background-image: url(/static/u37975180821274876721fm26fmtauto.jpg);

		font-size: 12px;
	}
</style>
