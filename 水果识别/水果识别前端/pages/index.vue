<template>
	<view class="container">
		<form @submit="submitForm" @reset="resetForm" class="flex diygw-form diygw-col-24">
			<image :src='image.rows[0].image' @tap="navigateTo" data-type="page" data-url="/pages/imgload" data-id="1" class="response diygw-col-24 image-clz" mode="widthFix"></image>
			<view class="diygw-form-item diygw-col-24">
				<view class="title">水果名称:{{image.rows[0].name }}</view>
				<view class="input">
					<input class="flex1" name="input" comfirm-type="done" type="text" v-model="input" placeholder=""  @click="toCancel"/>
				</view>
			</view>
			<view class="flex diygw-col-24">
				<button @tap="navigateTo" @click="toCancel" data-type="imageApi" class="diygw-btn green flex1 margin-xs button-button-clz">
					{{time}}</button>
					<!-- 加载窗口 -->
				
				
			</view>
			
		</form>
		
	
	</view>
	<van-popup v-model="show">
	     <div class="myAppointment-content-popup">
			
	         <van-icon name="warning-o" color="#ee0a24" size="0.5rem" />
			 
	     </div>
		 
	 </van-popup>
</template>

<script>
	//create by: 邓志锋 <280160522@qq.com> <https://www.diygw.com> DIYGW可视化设计一键生成源码
	export default {
	    data() {
			
	        return {
				time:"开始检测",
				show:"false",
				loadimage: {
					msg: "",
					code:''
				},
	            image:{
	    "total": 2,
	    "rows": [
	        {
	            "searchValue": null,
	            "createBy": null,
	            "createTime": null,
	            "updateBy": null,
	            "updateTime": null,
	            "remark": null,
	            "params": {},
	            "id": 1,
	            "name": "23",
	            "image": null
	        },
	        {
	            "searchValue": null,
	            "createBy": null,
	            "createTime": null,
	            "updateBy": null,
	            "updateTime": null,
	            "remark": null,
	            "params": {},
	            "id": 2,
	            "name": "24",
	            "image": "/profile/upload/2022/04/10/消息回复_20220410122954A005.png"
	        }
	    ],
	    "code": 200,
	    "msg": "查询成功"
	},
	            input:'',
	        }
	    },
	    onShareAppMessage: function () {
	    },
	    onLoad(option) {
			
	        this.setCurrentPage(this)
	        if (option) {
	            this.setData({
	                globalOption: option
	            })
	        }
			
	    },
	    mounted() {
	        this.init();
	    },
	    methods:{
			
			    
			
			
	        async init(){
				
						  
						  
				      
				  
	        },
			
			async imageApi(){

					  
			   let image = await this.$http.get('http://localhost:81/dev-api/image/image/list',
			   {
			        'id':'1'
			   },
			   {},
			   'json'
			   );
			    this.setData({image})
				// this.show=true
				
				
				let loadimage = await this.$http.put(
					'http://localhost:81/dev-api/image/image/',
					{
						id: '1',
						mark:'0'
					},
					{ },
					'json'
				);
				
				this.setData({ loadimage });
				
				
			
			},
			  
			
			
	     
	       
	        async getForm(){

	   if(this.globalOption && this.globalOption.id){
		   //调用数据
		   let param = {
			   tableName:'form'	   };
		   param = this.$tools.extend(param,this.globalOption);
		   //调用数据
		   let data = await this.$http.get('',param,{},'json')
		   if(data.code==200){
			   let values = {};
			   let formData = data.data
			   for (let key in formData) {
				   values[key] = formData[key];
			   }
			   this.setData(values);
		   }else{
			   this.showModal(data.message);
		   }
	   }
	},
	async submitForm(e) {
		this.validateForm = this.Validate({
	})
	;
		if (!this.validateForm.checkForm(e)) {
			let data = this.validateForm.errorList[0]
			this.showToast(data.msg,'none');
			return false
		}else{
			//保存数据
			let param = e.detail.value
			let url = ''
			if(!url){
	    		this.showToast('请先配置表单提交地址','none');
	    		return false
			}

			let data = await this.$http.post('',param,{},'json')
			if (data.code == 200) {
				this.showToast(data.msg, 'success');
	;
			}else{
				this.showModal(data.msg);
			}
		  }
	},
	resetForm() {
	    console.log('form发生了reset事件')
	},
	toCancel(){
	        this.show = true
	        if(this.show){
	            console.log(this.show)
	            setTimeout(()=>{
	                this.show = false
	            },8000)
	        }
	    },
	
	    },

	}
			
</script>

<style lang="scss" scoped>
	.image-clz {
		margin-left: 5px;
		border-bottom-left-radius: 20px;
		box-shadow: 10px 8px 4px 4px rgba(31, 31, 31, 0.16);
		overflow: hidden;
		width: calc(100% - 5px - 5px) !important;
		border-top-left-radius: 20px;
		margin-top: 5px;
		border-top-right-radius: 20px;
		border-bottom-right-radius: 20px;
		margin-bottom: 5px;
		margin-right: 5px;
	}
	.button-button-clz {
		margin: 3px !important;
	}
	.container {
		padding-left: 0px;
		padding-right: 0px;

		font-size: 12px;
	}
</style>
