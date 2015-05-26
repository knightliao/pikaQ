<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>campaign list</title>
</head>
<body>

<#list campaignList as campaign>
campaignId : ${campaign.id}<br/>
name : ${campaign.name}<br/>
price : ${campaign.price}<br/><br/>
</#list>

</body>
</html>