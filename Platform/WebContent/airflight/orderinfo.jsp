<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<order>
<orderno><ww:property value='orderinfo.id'/></orderno>
<zratevalue><ww:property value='errManger'/></zratevalue>
<payprice><ww:property value='errManger'/></payprice>
<segs>
<ww:iterator value="listSegmentinfo">
<seg>
<scitycode><ww:property value='startairport'/></scitycode>
<endcitycode><ww:property value='endairport'/></endcitycode>
</seg>
</ww:iterator>
</segs>
<pass>
<ww:iterator value="listPassenger">
<pa>
<pname><ww:property value='name'/></pname>
<idtype><ww:property value='idtype'/></idtype>
<idno><ww:property value='idnumber'/></idno>
<Price><ww:property value='price'/></Price>
<Portfee><ww:property value='airportfee'/></Portfee>
<Fuelfee><ww:property value='fuelprice'/></Fuelfee>
</pa>
</ww:iterator>
</pass>
</order>
<descinfo><ww:property value='errManger'/></descinfo>


