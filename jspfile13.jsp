<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		table{border:2px solid gray;}
		tr{border:1px solid silver;padding:3px;text-align:center;}
		td{border:1px solid silver;padding:3px;text-align:center;}
	</style>
</head>
<body>
	<table>
		<tr>
			<th>readDateTime</th>
			<th>ramUsed</th>
			<th>diskUsed</th>
			<th>cpuUsed</th>
		</tr>
		<tr>
			<td>${readDateTime}</td>
			<td>${ram}</td>
			<td>${disk}</td>
			<td>${cpu}$</td>
		</tr>
	</table>
	<br>
</body>
</html>