window.onload = function(){
    var rightiframeHeight= document.body.scrollHeight;
    var file = document.getElementById('ecFileUpload_fujian');
    var fileHeight = 0;
    var isRefue = 0;
    var isRefueObject = null;
    if(parent.document.getElementById("isRefue")!=null){
    	isRefueObject = parent.document.getElementById("isRefue");
    }else if(parent.parent.document.getElementById("isRefue")!=null){
    	isRefueObject = parent.parent.document.getElementById("isRefue");
    }else if(document.getElementById("isRefue")!=null){
    	isRefueObject = document.getElementById("isRefue");
    }
    if(isRefueObject!=null){
    	isRefue=isRefueObject.value;
    }
    
    if(file!=null&&file!=undefined){
    	fileHeight = 270;
    }
    
	if(parent.document.getElementById("bottomframe")){
		if(isRefue==0&&fileHeight!=0){
			parent.document.getElementById("bottomframe").style.height=rightiframeHeight+fileHeight;
		}else{
			parent.document.getElementById("bottomframe").style.height=rightiframeHeight;
		}
	}
	if(parent.parent.document.getElementById("rightiframe")){
		if(rightiframeHeight+fileHeight>771){
			if(isRefue==0&&fileHeight!=0){
				parent.parent.document.getElementById("rightiframe").height=rightiframeHeight+fileHeight;
				if(isRefueObject!=null){
			    	isRefueObject.value=fileHeight;
			    }
			}else{
				parent.parent.document.getElementById("rightiframe").height=rightiframeHeight+27;
			}
		}else{
			if(isRefueObject!=null){
		    	isRefueObject.value=0;
		    }
			parent.parent.document.getElementById("rightiframe").height=771;
		}
	}
}
