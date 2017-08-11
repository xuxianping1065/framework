var BaseURL="";
//var Admin_URL = "http://mgr.nongshangmall.com/admin";
var Admin_URL = "http://192.168.1.251:8081/admin";

//默认TOP菜单
var Top_Menu_Default="1";

//从URL取参数
function getQueryString(name){
	 var url=decodeURI(window.location.search);
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = url.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

var params;
function search(d){
	
	 if(params){
		  $.each(params, function(i, field){
	           d[field.name] = field.value; 
	      });
	 }
	
}

//页面刷新按钮
$('.btn-refresh').click(function(){
	location.reload(true);
})
//

function Ajax_Error(XMLHttpRequest){
	if(XMLHttpRequest && XMLHttpRequest.readyState==4){
		if(XMLHttpRequest.status==401){ //未授权：登录失败
			alert(XMLHttpRequest.responseText);
		}else if(XMLHttpRequest.status==403){ //禁止执行访问
			alert(XMLHttpRequest.responseText);
		}
	}
}

//
function form_valid_ajax_post_submit(url,form_id,successMsg,callback){
	$("#"+form_id).Validform({
		tiptype:2,
		ajaxPost:true,
		showAllError:true,
		beforeSubmit:function(curform){
			ajax_post(url,curform.serialize(),'json',successMsg,function(){
				callback();
			})
			return false;
		}
	});
}


	

//
function form_ajax_post_submit(url,formId,beforeCallback,callback){
	$(formId).ajaxForm({
		 dataType:'json',
		 url:BaseURL+url,
		 type:'post',
		 beforeSubmit: function() {
	    	 if(beforeCallback!=null && beforeCallback!="undefined"){
	    		 return beforeCallback();
	    	 }
	     },
	     success: function(data) {
	    	 if(callback!=null && callback!="undefined"){
    			 callback(data);
    		 }
	    	 /*
	    	 if(data.retCode=="0"){
	    		 if(callback!=null && callback!="undefined"){
	    			 callback(data);
	    		 }
	    		 parent.layer.alert(tipmes, {icon: 1},function(index){
						   parent.layer.close(index);
				 });
				}else{
					parent.layer.alert(data.retMsg, {icon: 2});
				}
				*/
	     }
	});
}

//post提交
function ajax_post(url,data,dataType,sucessMsg,callback){
	$.ajax({
		method: "POST",
		url: BaseURL+url,
		dataType: dataType||"json",
		data: data||{},
		success:function(data){
			if(data.retCode=="0"){
				layer.alert(sucessMsg, {icon: 1},function(index){
					 callback(index);
				});
			}else{
				layer.alert(data.retMsg, {icon: 2});
			}
		}
	});
}

//get提交
function ajax_get(url,data,before,successMsg,callback){
	$.ajax({
		method: "GET",
		url: BaseURL+url,
		dataType: "json",
		cache:false,
		data: data||{},
		beforeSend:function(){before()},
		success:function(data){
			if(data.retCode=="0"){
				layer.alert(successMsg, {icon: 1},function(index){
					// alert(index);
					 layer.close(index);
				});
				callback(data);
			}else{
				layer.alert(data.retMsg, {icon: 2});
			}
		}
	});
}

//删除 get请求删除 
function del_by_id(id,url,data,before,successMsg,callback){
	if(id==null||id==''||id=='undefined'){
		layer.alert('请选择一条数据', {icon: 1});
		return false;
	}else{
		layer.confirm('确定要删除吗？', {btn:['删除','取消']},function(){
			ajax_get(url,data,before,successMsg,function(){
				callback();
			})
			layer.close()
		},function(){
				layer.close()});
		}
		
}


function col_by_id(id,url,data,before,successMsg,callback){
	if(id==null||id==''||id=='undefined'){
		layer.alert('请选择一条数据', {icon: 1});
		return false;
	}else{
		layer.confirm('确定要更新吗？', {btn:['更新','取消']},function(){
			ajax_get(url,data,before,successMsg,function(){
				callback();
			})
			layer.close()
		},function(){
				layer.close()});
		}
		
}

function edit_Id(templateID ,tempparent,url ,callback){
	var formtemp=baidu.template(templateID);
	$.ajax({
		type:'GET',
		url:BaseURL+url,
		datatype:'json',
		success:function(data){
			$(tempparent).append(formtemp(data));
			if(callback!=null && callback!="undefined"){
    			 callback(data);
    		}
		}
	})
}




//根据id修改         先根据id get请求查询给表单input赋值，然后将末班引擎添加到tempparent里，然后添加表单验证，然后post请求提交，弹出successMsg，执行callback
function update_by_id(queryurl,tempid,tempparent,form_id,updateurl,successMsg,callback, loadCallback){
	//添加表单验证
	function valid(){
		$("#"+form_id).Validform({
			tiptype:2,
			ajaxPost:true,
			showAllError:true,
			beforeSubmit:function(curform){
				ajax_post(updateurl,curform.serialize(),'json',successMsg,function(){
					callback();
				})
				return false;
			}
		
		});
	}
	
	var formtemp=baidu.template(tempid);
	$.ajax({
		type:'GET',
		url:BaseURL+queryurl,
		datatype:'json',
		success:function(data){
			$(tempparent).append(formtemp(data));
			valid();
			
			loadCallback();
		}
	})
}


/**
 * 查看详情模块
 * @param url
 * @param tempid
 * @param containerId
 */
function detail(id){
	layer_show('查看详情', "detail.html?id="+id, 570, 540);
}

/**
 * 查看详情模块
 * @param url
 * @param tempid
 * @param containerId
 */
function detail_by_id(url, tempid, containerId, callback){
	var baiduTemplate = baidu.template(tempid);
	$.ajax({
		type:'GET',
		url:BaseURL+url,
		datatype:'json',
		success:function(data){
			$('#'+containerId).append(baiduTemplate(data));
			
			if(callbak){
				callback();
			}
		}
	})
}


//增加
function add(form_id,url,successMsg,callback){
	$("#"+form_id).Validform({
		tiptype:2,
		ajaxPost:true,
		showAllError:true,
		beforeSubmit:function(curform){
			ajax_post(url,curform.serialize(),'json',successMsg,callback);
			
			return false;
		}
	});
}


//==========================

function getTypeCode(type, selectId, val){
	var typecodes;
	var index="0";
	if( TypeCodeMap ){
		index="0";
		typecodes= TypeCodeMap.get(type);
	}else if( parent.TypeCodeMap ){
		index="1";
		typecodes= parent.TypeCodeMap.get(type);
	}else if( parent.parent.TypeCodeMap ){
		index="2";
		typecodes= parent.parent.TypeCodeMap.get(type);
	} else{
		return null;
	}
	if(typecodes==null){
		$.ajax({
			method: "GET",
			url: Admin_URL + '/bizcode/get2/'+type,
			async: false,
			dataType: "jsonp",
			jsonp: "jsonpCallback",
			success: function(data){
				typecodes=data.data;
				if("0"==index){
					TypeCodeMap.put(type,typecodes);
				}else if("1"==index){
					parent.TypeCodeMap.put(type,typecodes);
				}else if("2"==index){
					parent.parent.TypeCodeMap.put(type,typecodes);
				}
			},
		   error:function(){  
		   }  
		});
	}
	return typecodes;
}


function bizTypeHtml(type,val){
	var typecodes = getTypeCode(type);
	var text;
	if(typecodes!=null){
		 $.each(typecodes, function(idx,d){
			 if(d.val==val){
				 text= d.name;
				 return false;
			 }
		 });
	}
	return text;
}

//select下拉
function ajax_select(type, selectId, nullEnable, val){
	if( nullEnable ){
		$("#"+selectId).append("<option value=''>--请选择--</option>")
	}
	
	var typecodes;
	var index="0";
	if( TypeCodeMap ){
		index="0";
		typecodes= TypeCodeMap.get(type);
	}else if( parent.TypeCodeMap ){
		index="1";
		typecodes= parent.TypeCodeMap.get(type);
	}else if( parent.parent.TypeCodeMap ){
		index="2";
		typecodes= parent.parent.TypeCodeMap.get(type);
	} else{
		return null;
	}
	if(typecodes==null){
		$.ajax({
			method: "GET",
			url: Admin_URL + '/bizcode/get2/'+type,
			async: false,
			dataType: "jsonp",
			jsonp: "jsonpCallback",
			success: function(data){
				typecodes=data.data;
				if("0"==index){
					TypeCodeMap.put(type,typecodes);
				}else if("1"==index){
					parent.TypeCodeMap.put(type,typecodes);
				}else if("2"==index){
					parent.parent.TypeCodeMap.put(type,typecodes);
				}
			    $.each(typecodes, function(idx,d){
					 if( val!=undefined && val!=null && val !=""  && d.val==val){
						 $("#"+selectId).append("<option  value='"+d.val+"' selected>"+d.name+"</option>")
					  }else{
						 $("#"+selectId).append("<option  value='"+d.val+"'>"+d.name+"</option>")
					  }
				 });
			},
		   error:function(){  
		   }  
		});
	}else{
		 $.each(typecodes, function(idx,d){
			 if( val!=undefined && val!=null && val !=""  && d.val==val){
				 $("#"+selectId).append("<option  value='"+d.val+"' selected>"+d.name+"</option>")
			  }else{
				 $("#"+selectId).append("<option  value='"+d.val+"'>"+d.name+"</option>")
			  }
		 });
	}
}


/**
 * peter
 */
var Dictionary=function() {
    this.elements = new Array();
    //Length of Dictionary
    this.length = function () {
        return this.elements.length;
    };
    //Check whether the Dictionary is empty
    this.isEmpty = function () {
        return (this.length() < 1);
    };
    //remove all elements from the Dictionary
    this.removeAll = function () {
        this.elements = new Array();
    };
    //get specify element of the dictionary
    this.element = function (index) {
        var rlt = null;
        if (index >= 0 && index < this.elements.length) {
            rlt = this.elements[index];
        }
        return rlt;
    }
    //check whether the Dictionary contains this key
    this.Exists = function (key) {
        var rlt = false;
        try {
            for (var i = 0, iLen = this.length(); i < iLen; i++) {
                if (this.elements[i].key == key) {
                    rlt = true;
                    break;
                }
            }
        }
        catch (ex) {
        }
        return rlt;
    };
    //check whether the Dictionary contains this value
    this.containsValue = function (value) {
        var rlt = false;
        try {
            for (var i = 0, iLen = this.length(); i < iLen; i++) {
                if (this.elements[i].value == value) {
                    rlt = true;
                    break;
                }
            }
        }
        catch (ex) {
        }
        return rlt;
    };
    //remove this key from the Dictionary
    this.remove = function (key) {
        var rlt = false;
        try {
            for (var i = 0, iLen = this.length(); i < iLen; i++) {
                if (this.elements[i].key == key) {
                    this.elements.splice(i, 1);
                    rlt = true;
                    break;
                }
            }
        }
        catch (ex) {
        }
        return rlt;
    };
    //add this key/value to the Dictionary,if key is exists,replace the value
    this.add = function (key, value) {
        this.remove(key);
        this.elements.push({
            key: key,
            value: value
        });
    };
    //add this key/value to the Dictionary,if key is exists,append value
    this.set = function (key, value) {
        var arr = this.getItem(key);
        if (arr != null) {
            if (typeof(arr) == "object") {
                arr.unshift.apply(arr, value);
                value = arr;
            }
            else {
                var array = [];
                array.push(arr);
                array.unshift.apply(array, value);
                value = array;
            }
            this.remove(key);
        }
        this.elements.push({
            key: key,
            value: value
        });
    }
    //get value of the key
    this.getItem = function (key) {
        var rlt = null;
        try {
            for (var i = 0, iLen = this.length(); i < iLen; i++) {
                if (this.elements[i].key == key) {
                    rlt = this.elements[i].value;
                    break;
                }
            }
        }
        catch (ex) {
        }
        return rlt;
    };
    //get all keys of the dictionary
    this.keys = function () {
        var arr = [];
        for (var i = 0, iLen = this.length(); i < iLen; i++) {
            arr.push(this.elements[i].key);
        }
        return arr;
    }
    //get all values of the dictionary
    this.values = function () {
        var arr = [];
        for (var i = 0, iLen = this.length(); i < iLen; i++) {
            arr.push(this.elements[i].value);
        }
        return arr;
    }
}










