<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<DataList Airlines="<ww:property value='AirCompanyCode'/>" Arr="<ww:property value='EndAirportCode'/>"  Date="<ww:property value='depDate'/>" Direct="true" Dpt="<ww:property value='StartAirportCode'/>" >
<ww:iterator value="listFlightInfoAll">
<Flight ArrAirport="<ww:property value='EndAirport' />" ArrAirportName="<ww:property value='getAirportbySZM(EndAirport)'/>" ArrTime="<ww:property value='formatTimestampHHmm(ArriveTime)' />" Carrier="<ww:property value='Airline.substring(0, 2)' />" CarrierName="<ww:property value='getAircomapnycodeByEZM(Airline.substring(0, 2))' />" Code="<ww:property value='Airline' />" CodeShare="false"  DptAirport="<ww:property value='StartAirport' />" DptAirportName="<ww:property value='getAirportbySZM(StartAirport)' />" DptTime="<ww:property value='formatTimestampHHmm(DepartTime)' />" Fuel="<ww:property value='AirportFee' />" Price="<ww:property value='YPrice' />" Meal="true" Plantype="<ww:property value='AirplaneType' />" Stops="<ww:property value='isStopInfo' />" Tax="<ww:property value='FuelFee' />" DptTerminal="" ArrTerminal="">

<Cabins>
<ww:iterator value="Carbins">
<Cabin Code="<ww:property value='cabin'/>" CabinName="<ww:property value='GetCabinType(Discount,cabin)'/>" Price="<ww:property value='Price'/>" ZrateValue="<ww:property value='ratevalue'/>"  Status="<ww:property value='SeatNum'/>" Discount="<ww:property value='(Discount/10)'/>" />
</ww:iterator>
</Cabins>
</Flight>
</ww:iterator>
</DataList>