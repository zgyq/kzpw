<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<ww:iterator value="listCarbin">
<Cabin Code="<ww:property value='Cabin'/>"  ZrateValue="<ww:property value='ratevalue'/>"  zrateid="<ww:property value='zrateid'/>"  />
</ww:iterator>

