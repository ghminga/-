app.service("uploadService",function($http){
	
	this.uploadFile = function(){
		// 向后台传递数据:
		var formData = new FormData();
		// 向formData中添加数据:
		formData.append("file",file.files[0]);

		/**
		 * 因为是通过anjularjs的http请求来上传文件的，所以要让当前的request成为Multpart/form-data请求
		*/


		return $http({
			method:'post',
			url:'http://localhost:8989/shopping-content/uploadFile',
			data:formData,
			headers:{'Content-Type':undefined} ,// Content-Type : text/html  text/plain
			transformRequest: angular.identity
		});
	}
	
});