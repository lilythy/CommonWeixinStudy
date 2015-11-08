<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.wxcommon.utils.SmallUtils" %>
<%
String path = request.getContextPath();

String username = (String)session.getAttribute("username");
String insertState = (String)request.getAttribute("insertState");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>分数线管理</title>

<script type="text/javascript">
	function insertData() {
		var th = document.scoreForm
		if(th.province.value == "") {
			alert("请填写省份");
			th.province.focus();
			return;
		}else if(th.year.value == "") {
			alert("请填写年份");
			th.year.focus();
			return;
		}else if(th.type_student.value == "") {
			alert("请填写考生类别");
			th.type_student.focus();
			return;
		}else if(th.batch.value == "") {
			alert("请填写录取批次");
			th.batch.focus();
			return;
		}else { 
			th.action="<%=path%>/servlet/AdminDataAction?flag=insertData";
			th.submit;
		}
	}
	
	function getLastData() {
		var sc = document.scoreForm
		sc.action="<%=path%>/servlet/AdminDataAction?flag=lastData";
		sc.submit;
	}

</script>

<style type="text/css">
.CELLSTYLE {
	width:30%;
	font-size:12px;
	text-align: center;
}
.INPUTSTYLE1 {
	width:60%;	
}
.INPUTSTYLE2 {
	width:58%;	
}

.sidebar1 {
	float: left;
	width: 180px;
	background-color: #EADCAE;
}
.content {
	background-color: #CCC49F;
	width: 80%;
	float: left;
}

ul.nav a, ul.nav a:visited { /* 对这些选择器进行分组可确保链接即使在访问之后也能保持其按钮外观 */
	padding: 5px 5px 5px 15px;
	display: block; /* 这将为链接赋予块属性，使其填满包含它的整个 LI。这样，整个区域都可以响应鼠标单击操作。 */
	width: 160px;  /*此宽度使整个按钮在 IE6 中可单击。如果您不需要支持 IE6，可以删除它。请用侧栏容器的宽度减去此链接的填充来计算正确的宽度。 */
	text-decoration: none;
}

</style>

</head>
<body>
	<% 
		if(username == null) {
%>
<script type="text/javascript">
	alert("请先登录");
	window.location.href = "<%=path%>/index.jsp";
</script>
		
<% 
		}
%>

  <div class="header"><a href="#"><img src="<%=path%>/images/godata.jpg" alt="校园小贴士" name="Insert_logo" width="180" height="90" id="Insert_logo" style="background-color: #C6D580; display:block;" /></a> 
    <!-- end .header --></div>
<div class="sidebar1">
    <ul class="nav">
       <li><a href="<%=path%>/sqldata/scoreProvince.jsp">省分数线管理</a></li>
      <li><a href="<%=path%>/sqldata/scoreSpecialty.jsp">专业分数线管理</a></li>
    </ul>
  </div>
        
   <form method="post" id="scoreForm" name="scoreForm">
   <table width="80%" align="center" >
   	<tbody>
    
    <tr>
        <td class="CELLSTYLE">
         	<span>所在省</span>:&nbsp;&nbsp;&nbsp;&nbsp;<input name="province" class="INPUTSTYLE1" />
        </td>
        <td class="CELLSTYLE">
            <span>年份</span>:&nbsp;&nbsp;&nbsp;&nbsp;<input onkeyup="value=value.replace(/[^\d]/g,'')" name="year" class="INPUTSTYLE1" />
        </td>
        <td class="CELLSTYLE">
            <span>最高分</span>:&nbsp;&nbsp;&nbsp;&nbsp;<input onkeyup="value=value.replace(/[^\d]/g,'')" name="score_high" class="INPUTSTYLE1" />
        </td>
        
     </tr>
      <tr>
      <td class="CELLSTYLE">
            <span>平均分</span>:&nbsp;&nbsp;&nbsp;&nbsp;<input onkeyup="value=value.replace(/[^\d]/g,'')" name="score_average" class="INPUTSTYLE1" />   
        </td>
      	<td class="CELLSTYLE">
        	<span>省控线</span>:&nbsp;&nbsp;<input onkeyup="value=value.replace(/[^\d]/g,'') " name="score_control" class="INPUTSTYLE2"/>
        </td>
        <td class="CELLSTYLE">
            <span>考生类别</span>:&nbsp;&nbsp;<input name="type_student" class="INPUTSTYLE2"/>
        </td>
       
      </tr>
      <tr>
     
       <td  class="CELLSTYLE">
            <span>录取批次</span>:&nbsp;&nbsp;<input name="batch" class="INPUTSTYLE2"/>
        </td>
         <td>
      </td>
        <td align="right" class="CELLSTYLE" >
        <% 
        	String date = SmallUtils.getSendDate();
        %>
            <span>更新时间</span>:&nbsp;&nbsp;<input readonly="readonly" name="time_update" class="INPUTSTYLE2" value=<%=date%> />
        </td>
      </tr>
       <tr align="center">
       <td></td>  
      	<td>
     	 <input name="insert" type="submit" value="插入"  onclick="insertData()" />
         <input name="get" type="submit" value="上条记录" onclick="getLastData()" />
     	</td>
      </tr>
      
      <%
   		String state_text = "";
      	if(insertState == null) {
      		state_text = "请插入数据！";
      		
      	}else if(insertState.equals("success")) {
      		state_text = "插入成功！";
      		
      	}else if(insertState.equals("error")) {
      		state_text = "插入失败！如果多次失败请联系制作人员！";
      	}
      %>
    </tbody> 
   </table>
   </form>
    <br></br>
    <div align="center">
      <div><%=state_text %></div> 
     
      <br></br>
      <%
     	 List<Object> insertList = (List)request.getAttribute("insertData");
      		if(insertList == null) {
      %>
      		<div align="center">无操作记录！</div>				
      	<%	}else {
      	%>		
			      上条数据记录：
		<%      
     			 List<Object> nameList = (List)request.getAttribute("nameList");
      	 		for(int i=0; i < nameList.size(); i++) {	
     	 %>
      		 <%=nameList.get(i) + ": " %> <%=insertList.get(i) %>
      <% 			}
      	 }
      		
      		String count = (String)request.getAttribute("count");
      		if(count != null)  {
      %>
      <div>数据库中已经有<%=count %>条数据了哦！</div>
      <%
      		}
      %>
      </div>
     
</body>
</html>
