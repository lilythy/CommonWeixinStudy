<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>江西省录取分数线</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>  
<style type="text/css">
.CELLSTYLE {
	background-color: #FFFFFF;
	font-size:12px;
	text-align: center;
	padding:2%;
}

</style>
<script language="javascript">
	function download(id){
		document.getElementById(id).style.visibility="visible";
		
	}
</script>
</HEAD>
<BODY>
<div align="center" style="text-align: left; margin:1%"> <h2>江西财经大学近五年各省录取分数线</h2> </div>
 

<div style="margin-left: 1%; font-size: 12px; color: #666;" >
2013-11-24&nbsp;&nbsp;校园小贴士
</div>

<div align="right" style="margin-right:2%;margin-top:5%;margin-bottom:2%">
  <select id="proselect" >
    <option selected >江西</option>
    <option >北京</option>
  </select>
  <select id="wlselect" >
    <option selected >文科</option>
    <option >理科</option>
  </select>
  <select id="numselect" >
    <option selected >一批</option>
    <option >二批</option>
  </select>
</div>
 
 
<table id="tableList"  width="95%" border="0"
		align="center" cellpadding="2" cellspacing="1" bgcolor="#B3CAE4">
  <tbody>
    <tr>
      <td class="CELLSTYLE"><strong>年份</strong></td>
      <td class="CELLSTYLE"><strong>最高分</strong></td>
      <td class="CELLSTYLE"><strong>平均分</strong></td>
      <td class="CELLSTYLE"><strong>省控线</strong></td>
      <td class="CELLSTYLE"><strong>考生类别</strong></td>
      <td class="CELLSTYLE"><strong>录取批次</strong></td>
    </tr>
    <tr>
      <td class="CELLSTYLE">2013</td>
      <td class="CELLSTYLE"></td>
      <td class="CELLSTYLE"></td>
      <td class="CELLSTYLE">532</td>
      <td class="CELLSTYLE">文科</td>
      <td class="CELLSTYLE">一批</td>
    </tr>
    <tr>
      <td class="CELLSTYLE">2012</td>
      <td class="CELLSTYLE">615</td>
      <td class="CELLSTYLE">591</td>
      <td class="CELLSTYLE">570</td>
      <td class="CELLSTYLE">文科</td>
      <td class="CELLSTYLE">一批</td>
    </tr>
    <tr>
      <td class="CELLSTYLE">2011</td>
      <td class="CELLSTYLE">576</td>
      <td class="CELLSTYLE">552</td>
      <td class="CELLSTYLE">532</td>
      <td class="CELLSTYLE">文科</td>
      <td class="CELLSTYLE">一批</td>
    </tr>
    <tr>
      <td class="CELLSTYLE">2010</td>
      <td class="CELLSTYLE">568</td>
      <td class="CELLSTYLE">540</td>
      <td class="CELLSTYLE">521</td>
      <td class="CELLSTYLE">文科</td>
      <td class="CELLSTYLE">一批</td>
    </tr>
    <tr>
      <td class="CELLSTYLE">2009</td>
      <td class="CELLSTYLE">553</td>
      <td class="CELLSTYLE">534</td>
      <td class="CELLSTYLE">515</td>
      <td class="CELLSTYLE">文科</td>
      <td class="CELLSTYLE">一批</td>
    </tr>
  </tbody>
</table>
<br>
<br>
<br>
<div align="center" style="font-family: '宋体';">

	<a href="#" onClick="download('toast')"><img src="<%=path %>/images/down3.png" name="dwonbtn" id="dwonbtn" /></a>
	
  <div style="font-size: 12px;">QQ交流群:276622758</div>
  <br>
  <div id="toast" style="visibility:hidden; font-size: 16px; color: #06F;">亲，我们正在努力研发!</div>
</div>
<!-- <div style="margin: 5%; text-align: justify; font-size:16px; font-family:'宋体';line-height:1.8">
<p>温馨提示：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>录取线差</strong>是院校当年平均录取分数与其在所在招生批次录取控制分数线的差值，所以应该逐年计算目标院校往年的录取线差：</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;某年录取线差＝当年平均录取分数-当年相应批次控制分数线</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;例如某重点大学（理工类）在北京2003—2008年录取情况简单线差法分析示例：
平均录取线差＝(62+70+69+69+64+58)/6＝65，根据往年的情况来看，报考此大学平均需要65分的线差，最高的年份需要70分的线差。为保险起见，建议考生至少要留10分以上的余地。</p>
</div> -->

</BODY>
</HTML>
