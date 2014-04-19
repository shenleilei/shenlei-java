<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	request.setAttribute("base", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HTML>
<HEAD>
<TITLE>在线订餐</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
<script type="text/javascript" src="${base}/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript">
	function checkName(){
		var menuname = document.managerForm.name.value;
		//获得用户层对象：
		var uDiv = document.getElementById("nameDiv");
		if(menuname.length == 0){
			uDiv.innerHTML ="<font size='3' color = 'red'> 菜名不能为空！</font>";
			return false;    //函数有返回值
		}
		uDiv.innerHTML = "";	
		return true;
	}
	

$(document).ready(		
		function(){
	$("#registerBT").click(
						function(){		
							var name=$("#name").val();						
							var pic=$("#pic").val();
							var price=$("#price").val();
							var remark=$("#remark").val();						
							$.ajax(
									{
										url:"${base}/MenuServlet",
										type:"post",
										data:"name="+name+"&pic="+pic+"&price="+price+"&remark="+remark,
										dataType:"json",
										success:successInfo
									}
								);		
						}		
							
					);
			});	
	
	function successInfo(json){
		var success=json.success;//tipDiv
		if(success!=null){
			alert("操作成功");
			window.location.href = "manager.jsp";
		}
	}
	
</script>

</HEAD>
<BODY leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
<table cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<tr>
		<td width="220" rowspan="3"><img src="images/jb_logo.jpg"
			width="200"></td>
		<td width="556" height="36">&nbsp;</td>
	</tr>
	<tr>
		<TD
			style="FONT-SIZE: 24pt; FILTER: blur(add=1, direction=120, strength=5); WIDTH: 100%; COLOR: #000000; FONT-FAMILY: arial; POSITION: relative"
			noWrap><B><span class="STYLE1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		网上订餐系统</B></TD>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>
<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<TBODY>
		<TR>
			<TD background="images/001.gif" height=42>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD width=0 height=20></TD>
						<TD align=middle><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="show.jsp" target="_self"><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">网站首页</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="locate.html" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">地理信息</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="#" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">定餐帮助</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="show.jsp" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">网上订餐</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="contactUs.jsp" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">客服中心</FONT></A>
							<FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;<A
							href="manager.jsp" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">管理页面</FONT></A></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<TBODY>
		<TR vAlign=top>
			<TD width=181 background="images/002.gif">
			<TABLE cellSpacing=0 cellPadding=0 width=181 border=0>
				<TBODY>
					<TR>
						<TD><IMG height=234 src="images/left_top.jpg" width=181></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD align=middle height=30><FONT color=#000000> <SCRIPT
							language=javascript src="images/DateTime2.js"></SCRIPT> <SCRIPT
							language=javascript>tick('cn');</SCRIPT> </FONT></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD>&nbsp;</TD>
					</TR>
					<TR>
						<TD background="images/003.gif" height=4></TD>
					</TR>
					<TR>
						<TD>&nbsp;</TD>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD>&nbsp;</TD>
					</TR>
					<TR>
						<TD background="images/003.gif" height=4></TD>
					</TR>
					<TR>
						<TD align=middle>
						<TABLE cellSpacing=0 cellPadding=0 width="94%" border=0>
							<TBODY>
								<TR>
									<TD>&nbsp;</TD>
								</TR>
							</TBODY>
						</TABLE>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
			<TD>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD><IMG height=72 src="images/001.jpg" width=595></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD width="90%">
						<div class='cnt'><marquee
							style="FONT-SIZE: 13px; COLOR: #0000FF" scrollamount='5'
							direction='left'><IMG height=15 src="images/tp009.gif"
							width=15>欢迎使用网上订餐系统，祝您用餐愉快!</marquee></div>
						&nbsp;&nbsp;</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD align=right background="images/004.gif" height=19></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="96%" align=center border=0>
				<TBODY>
					<TR>
						<TD>

						<H2>                管理员加入新的菜品</H2>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<form method="post" name="managerForm" action="/showServlet">
			<div id="tipDiv"></div>
			<table width="100%" border="0">
				<tr>
					<td width="25%">&nbsp;</td>
					<td width="45%">&nbsp;</td>
				</tr>
				<tr>
					<td valign="middle" align="right">菜    品：</td>
					<td valign="top"><input type="text" id="name" name="name" size="20"
						class="input" onblur="javascript:checkName()">
						<div style="display:inline;" id="nameDiv"></div>
						</td>
					<input type="hidden" name="flag" value="login"/>
				</tr>
				<tr>
					
					<td valign="middle" align="right">&nbsp;图片位置：</td>
					<td valign="top">
						<input type="text" name="pic" id="pic" size="20" class="input" value="/wireless_web/images/"/>
					
					</td>
					
				</tr>
					<tr>
					
					<td valign="middle" align="right">&nbsp;价格：</td>
					<td valign="top">
						<input type="text" name="price" id="price" size="20" class="input" />
					
					</td>
					
				</tr>
		
		
					<tr>
					
					<td valign="middle" align="right">&nbsp;简介：</td>
					<td valign="top">
						<input type="text" name="remark" id="remark" size="20" class="input" />
						
					</td>
					
				</tr>
				<tr>
					<td colspan="3" align="center">
						<input type="button" id="registerBT" name="register" value="提交">&nbsp;&nbsp;
						<input type="reset"	name="reset" value="重置">&nbsp;&nbsp;
				</tr>
				<tr>
					<td height="33">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>
			</form>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<TBODY>
		<TR>
			<TD background="images/005.gif" height=8></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<TBODY>
		<TR>
			<TD bgColor=#eeeeee>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD align=middle><BR>
						<P align=center><FONT color=#000000>Copyright &copy;
						2014&nbsp;&nbsp;&nbsp;华中师范大学 沈磊 陶诗蕾</P>
						<P align=center>&nbsp;</P>
						<BR>
						<BR>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</BODY>
</HTML>
