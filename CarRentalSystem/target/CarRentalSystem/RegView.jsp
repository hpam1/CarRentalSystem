<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <title>New_User_Page</title>
  <title></title>
  <style type="text/css">h2 {
text-align: center;
font-size: 30px;
color: green;
}
#SideHead {
color: blue;
padding-left: 1cm;
}
#B1 {
font-size: 15px;
}
#Left {
padding-left: 4cm;
}
  </style>
  <div align="center"><div id = "header">
<%@include file="header.jsp" %>
</div>
 <form action="CRSRegisterController" method="post">
  <h2>New User? Register Here!!</h2>
  <b><div style="color:#FF0000" id = "centerDiv">
						<% String messages;
						if(request.getAttribute("Messages") != null) {
							messages = request.getAttribute("Messages").toString();	
							if(messages!= null && messages.length() > 0) {
								System.out.println(messages);
						%>
							<div class="error"> <%=messages %> </div>
						<% } }%> </div></b>
  <p id="SideHead" style="text-align: left;"><b>&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;BASIC INFORMATION:</b></p>
  <p id="Left"><strong>&nbsp; &nbsp;
&nbsp;<label class="star"> * </label>First Name</strong>&nbsp;&nbsp;&nbsp; <input
 name="Firstname" required title="This is a Mandatory Field"><strong>&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<label class="star"> * </label>Last
Name</strong>&nbsp; &nbsp; &nbsp;&nbsp;<input
 name="Lastname" required title="This is a Mandatory Field" type="text"></p>
  <p id="Left"><strong>&nbsp; &nbsp;
&nbsp; &nbsp; <label class="star"> * </label>Password</strong>&nbsp; &nbsp;<input
 name="PWD" pattern=".{6,}" required title="This is a Mandatory Field and should contain minimum of 6 characters"
 type="password"><strong>&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <label class="star"> * </label>Re-enter
Password</strong> &nbsp; &nbsp; &nbsp;<input
 name="REPWD" pattern=".{6,}" required title="This is a Mandatory Field and should contain minimum of 6 characters" type="password"></p>
  <p id="Left"><strong>&nbsp;
&nbsp;&nbsp;Contact #</strong>&nbsp;&nbsp;&nbsp;
  <input name="CON" pattern="\d{1,10}" required title="This is a Mandatory Field and should only be charecter length of 10" type="text"><b>&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; <label class="star"> * </label>Date of Birth</b>&nbsp;
&nbsp; &nbsp;<input style="width:125px; id="DOB1" name="DOB"  placeholder="YYYY-MM-DD" required title="This is a Mandatory Field" type="date"></p>
  <p id="Left"><strong>&nbsp; &nbsp;
&nbsp; &nbsp;<label class="star"> * </label>E-mail ID</strong>&nbsp;&nbsp;&nbsp;
  <input name="EMID" placeholder="you@domain.com" required title="This is a Mandatory Field" type="email"><b>&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<label class="star"> * </label>Confirm E-mail ID</b>&nbsp; &nbsp;&nbsp;<input
 name="REEID" placeholder="you@domain.com" required title="This is a Mandatory Field" type="email"></p>
  <p id="Left" style="text-align: left;"><strong>&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<label class="star"> * </label>Address Line 1</strong>&nbsp;&nbsp;&nbsp; <input
 name="ADD1" required title="This is a Mandatory Field"
 type="text"><strong>&nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
Address Line 2 &nbsp;&nbsp;</strong> <input
 name="ADD2" type="text"></p>
  <div style="text-align: left;"><span
 style="font-weight: bold;">&nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp;<label class="star"> * </label>City</span>&nbsp;&nbsp;&nbsp;
  <select name="City" style="width: 150px;">
  <option value="Abilene">Abilene</option>
  <option value="Akron">Akron</option>
  <option value="Albuquerque">Albuquerque</option>
  <option value="Alexandria">Alexandria</option>
  <option value="Allentown">Allentown</option>
  <option value="Amarillo">Amarillo</option>
  <option value="Anaheim">Anaheim</option>
  <option value="Anchorage">Anchorage</option>
  <option value="Ann Arbor">Ann Arbor</option>
  <option value="Antioch">Antioch</option>
  <option value="Arlington">Arlington</option>
  <option value="Arvada">Arvada</option>
  <option value="Athens">Athens</option>
  <option value="Atlanta">Atlanta</option>
  <option value="Augusta">Augusta</option>
  <option value="Aurora">Aurora</option>
  <option value="Aurora">Aurora</option>
  <option value="Austin">Austin</option>
  <option value="Bakersfield">Bakersfield</option>
  <option value="Baltimore">Baltimore</option>
  <option value="Baton Rouge">Baton Rouge</option>
  <option value="Beaumont">Beaumont</option>
  <option value="Bellevue">Bellevue</option>
  <option value="Berkeley">Berkeley</option>
  <option value="Billings">Billings</option>
  <option value="Birmingham">Birmingham</option>
  <option value="Boise">Boise</option>
  <option value="Boston">Boston</option>
  <option value="Boulder">Boulder</option>
  <option value="Bridgeport">Bridgeport</option>
  <option value="Broken Arrow">Broken Arrow</option>
  <option value="Brownsville">Brownsville</option>
  <option value="Buffalo">Buffalo</option>
  <option value="Burbank">Burbank</option>
  <option value="Cambridge">Cambridge</option>
  <option value="Cape Coral">Cape Coral</option>
  <option value="Carlsbad">Carlsbad</option>
  <option value="Carrollton">Carrollton</option>
  <option value="Cary">Cary</option>
  <option value="Cedar Rapids">Cedar Rapids</option>
  <option value="Centennial">Centennial</option>
  <option value="Chandler">Chandler</option>
  <option value="Charleston">Charleston</option>
  <option value="Charlotte">Charlotte</option>
  <option value="Chattanooga">Chattanooga</option>
  <option value="Chesapeake">Chesapeake</option>
  <option value="Chicago">Chicago</option>
  <option value="Chula Vista">Chula Vista</option>
  <option value="Cincinnati">Cincinnati</option>
  <option value="Clarksville">Clarksville</option>
  <option value="Clearwater">Clearwater</option>
  <option value="Cleveland">Cleveland</option>
  <option value="Colorado Springs">Colorado Springs</option>
  <option value="Columbia">Columbia</option>
  <option value="Columbia">Columbia</option>
  <option value="Columbus">Columbus</option>
  <option value="Columbus">Columbus</option>
  <option value="Concord">Concord</option>
  <option value="Coral Springs">Coral Springs</option>
  <option value="Corona">Corona</option>
  <option value="Corpus Christi">Corpus Christi</option>
  <option value="Costa Mesa">Costa Mesa</option>
  <option value="Dallas">Dallas</option>
  <option value="Daly City">Daly City</option>
  <option value="Davenport">Davenport</option>
  <option value="Dayton">Dayton</option>
  <option value="Denton">Denton</option>
  <option value="Denver">Denver</option>
  <option value="Des Moines">Des Moines</option>
  <option value="Detroit">Detroit</option>
  <option value="Downey">Downey</option>
  <option value="Durham">Durham</option>
  <option value="El Cajon">El Cajon</option>
  <option value="El Monte">El Monte</option>
  <option value="El Paso">El Paso</option>
  <option value="Elgin">Elgin</option>
  <option value="Elizabeth">Elizabeth</option>
  <option value="Elk Grove">Elk Grove</option>
  <option value="Erie">Erie</option>
  <option value="Escondido">Escondido</option>
  <option value="Eugene">Eugene</option>
  <option value="Evansville">Evansville</option>
  <option value="Everett">Everett</option>
  <option value="Fairfield">Fairfield</option>
  <option value="Fargo">Fargo</option>
  <option value="Fayetteville">Fayetteville</option>
  <option value="Flint">Flint</option>
  <option value="Fontana">Fontana</option>
  <option value="Fort Collins">Fort Collins</option>
  <option value="Fort Lauderdale">Fort Lauderdale</option>
  <option value="Fort Wayne">Fort Wayne</option>
  <option value="Fort Worth">Fort Worth</option>
  <option value="Fremont">Fremont</option>
  <option value="Fresno">Fresno</option>
  <option value="Frisco">Frisco</option>
  <option value="Fullerton">Fullerton</option>
  <option value="Gainesville">Gainesville</option>
  <option value="Garden Grove">Garden Grove</option>
  <option value="Garland">Garland</option>
  <option value="Gilbert">Gilbert</option>
  <option value="Glendale">Glendale</option>
  <option value="Glendale">Glendale</option>
  <option value="Grand Prairie">Grand Prairie</option>
  <option value="Grand Rapids">Grand Rapids</option>
  <option value="Green Bay">Green Bay</option>
  <option value="Greensboro">Greensboro</option>
  <option value="Gresham">Gresham</option>
  <option value="Hampton">Hampton</option>
  <option value="Hartford">Hartford</option>
  <option value="Hayward">Hayward</option>
  <option value="Henderson">Henderson</option>
  <option value="Hialeah">Hialeah</option>
  <option value="High Point">High Point</option>
  <option value="Hollywood">Hollywood</option>
  <option value="Honolulu">Honolulu</option>
  <option value="Houston">Houston</option>
  <option value="Huntington Beach">Huntington Beach</option>
  <option value="Huntsville">Huntsville</option>
  <option value="Independence">Independence</option>
  <option value="Indianapolis">Indianapolis</option>
  <option value="Inglewood">Inglewood</option>
  <option value="Irvine">Irvine</option>
  <option value="Irving">Irving</option>
  <option value="Jackson">Jackson</option>
  <option value="Jacksonville">Jacksonville</option>
  <option value="Jersey City">Jersey City</option>
  <option value="Joliet">Joliet</option>
  <option value="Kansas City">Kansas City</option>
  <option value="Kansas City">Kansas City</option>
  <option value="Kenosha">Kenosha</option>
  <option value="Kent">Kent</option>
  <option value="Killeen">Killeen</option>
  <option value="Knoxville">Knoxville</option>
  <option value="Lafayette">Lafayette</option>
  <option value="Lakewood">Lakewood</option>
  <option value="Lancaster">Lancaster</option>
  <option value="Lansing">Lansing</option>
  <option value="Laredo">Laredo</option>
  <option value="Las Cruces">Las Cruces</option>
  <option value="Las Vegas">Las Vegas</option>
  <option value="Lexington">Lexington</option>
  <option value="Lincoln">Lincoln</option>
  <option value="Little Rock">Little Rock</option>
  <option value="Long Beach">Long Beach</option>
  <option value="Los Angeles">Los Angeles</option>
  <option value="Louisville">Louisville</option>
  <option value="Lowell">Lowell</option>
  <option value="Lubbock">Lubbock</option>
  <option value="Madison">Madison</option>
  <option value="Manchester">Manchester</option>
  <option value="McAllen">McAllen</option>
  <option value="McKinney">McKinney</option>
  <option value="Memphis">Memphis</option>
  <option value="Mesa">Mesa</option>
  <option value="Mesquite">Mesquite</option>
  <option value="Miami">Miami</option>
  <option value="Miami Gardens">Miami Gardens</option>
  <option value="Midland">Midland</option>
  <option value="Milwaukee">Milwaukee</option>
  <option value="Minneapolis">Minneapolis</option>
  <option value="Miramar">Miramar</option>
  <option value="Mobile">Mobile</option>
  <option value="Modesto">Modesto</option>
  <option value="Montgomery">Montgomery</option>
  <option value="Moreno Valley">Moreno Valley</option>
  <option value="Murfreesboro">Murfreesboro</option>
  <option value="Murrieta">Murrieta</option>
  <option value="Naperville">Naperville</option>
  <option value="Nashville">Nashville</option>
  <option value="New Haven">New Haven</option>
  <option value="New Orleans">New Orleans</option>
  <option value="New York">New York</option>
  <option value="Newark">Newark</option>
  <option value="Newport News">Newport News</option>
  <option value="Norfolk">Norfolk</option>
  <option value="Norman">Norman</option>
  <option value="North Charleston">North Charleston</option>
  <option value="North Las Vegas">North Las Vegas</option>
  <option value="Norwalk">Norwalk</option>
  <option value="Oakland">Oakland</option>
  <option value="Oceanside">Oceanside</option>
  <option value="Odessa">Odessa</option>
  <option value="Oklahoma City">Oklahoma City</option>
  <option value="Olathe">Olathe</option>
  <option value="Omaha">Omaha</option>
  <option value="Ontario">Ontario</option>
  <option value="Orange">Orange</option>
  <option value="Orlando">Orlando</option>
  <option value="Overland Park">Overland Park</option>
  <option value="Oxnard">Oxnard</option>
  <option value="Palm Bay">Palm Bay</option>
  <option value="Palmdale">Palmdale</option>
  <option value="Pasadena">Pasadena</option>
  <option value="Pasadena">Pasadena</option>
  <option value="Paterson">Paterson</option>
  <option value="Pembroke Pines">Pembroke Pines</option>
  <option value="Peoria">Peoria</option>
  <option value="Peoria">Peoria</option>
  <option value="Philadelphia">Philadelphia</option>
  <option value="Phoenix">Phoenix</option>
  <option value="Pittsburgh">Pittsburgh</option>
  <option value="Plano">Plano</option>
  <option value="Pomona">Pomona</option>
  <option value="Pompano Beach">Pompano Beach</option>
  <option value="Port St. Lucie">Port St. Lucie</option>
  <option value="Portland">Portland</option>
  <option value="Providence">Providence</option>
  <option value="Provo">Provo</option>
  <option value="Pueblo">Pueblo</option>
  <option value="Raleigh">Raleigh</option>
  <option value="Rancho Cucamonga">Rancho Cucamonga</option>
  <option value="Reno">Reno</option>
  <option value="Rialto">Rialto</option>
  <option value="Richardson">Richardson</option>
  <option value="Richmond">Richmond</option>
  <option value="Richmond">Richmond</option>
  <option value="Riverside">Riverside</option>
  <option value="Rochester">Rochester</option>
  <option value="Rochester">Rochester</option>
  <option value="Rockford">Rockford</option>
  <option value="Roseville">Roseville</option>
  <option value="Round Rock">Round Rock</option>
  <option value="Sacramento">Sacramento</option>
  <option value="Saint Paul">Saint Paul</option>
  <option value="Salem">Salem</option>
  <option value="Salinas">Salinas</option>
  <option value="Salt Lake City">Salt Lake City</option>
  <option value="San Antonio">San Antonio</option>
  <option value="San Bernardino">San Bernardino</option>
  <option value="San Buenaventura (Ventura)">San
Buenaventura (Ventura)</option>
  <option value="San Diego">San Diego</option>
  <option value="San Francisco">San Francisco</option>
  <option value="San Jose">San Jose</option>
  <option value="Santa Ana">Santa Ana</option>
  <option value="Santa Clara">Santa Clara</option>
  <option value="Santa Clarita">Santa Clarita</option>
  <option value="Santa Maria">Santa Maria</option>
  <option value="Santa Rosa">Santa Rosa</option>
  <option value="Savannah">Savannah</option>
  <option value="Scottsdale">Scottsdale</option>
  <option value="Seattle">Seattle</option>
  <option value="Shreveport">Shreveport</option>
  <option value="Simi Valley">Simi Valley</option>
  <option value="Sioux Falls">Sioux Falls</option>
  <option value="South Bend">South Bend</option>
  <option value="Spokane">Spokane</option>
  <option value="Springfield">Springfield</option>
  <option value="Springfield">Springfield</option>
  <option value="Springfield">Springfield</option>
  <option value="St. Louis">St. Louis</option>
  <option value="St. Petersburg">St. Petersburg</option>
  <option value="Stamford">Stamford</option>
  <option value="Sterling Heights">Sterling Heights</option>
  <option value="Stockton">Stockton</option>
  <option value="Sunnyvale">Sunnyvale</option>
  <option value="Surprise">Surprise</option>
  <option value="Syracuse">Syracuse</option>
  <option value="Tacoma">Tacoma</option>
  <option value="Tallahassee">Tallahassee</option>
  <option value="Tampa">Tampa</option>
  <option value="Temecula">Temecula</option>
  <option value="Tempe">Tempe</option>
  <option value="Thornton">Thornton</option>
  <option value="Thousand Oaks">Thousand Oaks</option>
  <option value="Toledo">Toledo</option>
  <option value="Topeka">Topeka</option>
  <option value="Torrance">Torrance</option>
  <option value="Tucson">Tucson</option>
  <option value="Tulsa">Tulsa</option>
  <option value="Vallejo">Vallejo</option>
  <option value="Vancouver">Vancouver</option>
  <option value="Victorville">Victorville</option>
  <option value="Virginia Beach">Virginia Beach</option>
  <option value="Visalia">Visalia</option>
  <option value="Waco">Waco</option>
  <option value="Warren">Warren</option>
  <option value="Washington">Washington</option>
  <option value="Waterbury">Waterbury</option>
  <option value="West Covina">West Covina</option>
  <option value="West Jordan">West Jordan</option>
  <option value="West Palm Beach">West Palm Beach</option>
  <option value="West Valley City">West Valley City</option>
  <option value="Westminster">Westminster</option>
  <option value="Wichita">Wichita</option>
  <option value="Wichita Falls">Wichita Falls</option>
  <option value="Wilmington">Wilmington</option>
  <option value="Winston-Salem">Winston-Salem</option>
  <option value="Worcester">Worcester</option>
  <option value="Yonkers">Yonkers</option>
  </select>
  </div>
  <div style="text-align: left; margin-top: 19px; height: 22px;">&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong>&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp;<label class="star"> * </label>State</strong>&nbsp;&nbsp;&nbsp;
  <span style="font-weight: bold;">
  <select name="State" style="width: 150px;">
  <option value="Alabama">Alabama</option>
  <option value="Alaska">Alaska</option>
  <option value="Arizona">Arizona</option>
  <option value="Arkansas">Arkansas</option>
  <option value="California">California</option>
  <option value="Colorado">Colorado</option>
  <option value="Connecticut">Connecticut</option>
  <option value="Delaware">Delaware</option>
  <option value="Florida">Florida</option>
  <option value="Georgia">Georgia</option>
  <option value="Hawaii">Hawaii</option>
  <option value="Idaho">Idaho</option>
  <option value="Illinois">Illinois</option>
  <option value="Indiana">Indiana</option>
  <option value="Iowa">Iowa</option>
  <option value="Kansas">Kansas</option>
  <option value="Kentucky">Kentucky</option>
  <option value="Louisiana">Louisiana</option>
  <option value="Maine">Maine</option>
  <option value="Maryland">Maryland</option>
  <option value="Massachusetts">Massachusetts</option>
  <option value="Michigan">Michigan</option>
  <option value="Minnesota">Minnesota</option>
  <option value="Mississippi">Mississippi</option>
  <option value="Missouri">Missouri</option>
  <option value="Montana">Montana</option>
  <option value="Nebraska">Nebraska</option>
  <option value="Nevada">Nevada</option>
  <option value="New Hampshire">New Hampshire</option>
  <option value="New Jersey">New Jersey</option>
  <option value="New Mexico">New Mexico</option>
  <option value="New York">New York</option>
  <option value="North Carolina">North Carolina</option>
  <option value="North Dakota">North Dakota</option>
  <option value="Ohio">Ohio</option>
  <option value="Oklahoma">Oklahoma</option>
  <option value="Oregon">Oregon</option>
  <option value="Pennsylvania">Pennsylvania</option>
  <option value="Rhode Island">Rhode Island</option>
  <option value="South Carolina">South Carolina</option>
  <option value="South Dakota">South Dakota</option>
  <option value="Tennessee">Tennessee</option>
  <option value="Texas">Texas</option>
  <option value="Utah">Utah</option>
  <option value="Vermont">Vermont</option>
  <option value="Virginia">Virginia</option>
  <option value="Washington">Washington</option>
  <option value="West Virginia">West Virginia</option>
  <option value="Wisconsin">Wisconsin</option>
  <option value="Wyoming">Wyoming</option>
  </select>
  </span></div>
  <p id="Left" style="text-align: left;"><strong>&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp;<label class="star"> * </label>ZIP</strong>&nbsp;&nbsp;&nbsp;
  <input name="ZIP" pattern="\d{1,5}" required title="This is a Mandatory Field and should only be charecter length of 5"
 type="text"></p>
  <p id="SideHead" style="text-align: left;"><b>&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp;ADDITIONAL INFORMATION:</b></p>
  <p id="Left"><strong><label class="star"> * </label>License Number</strong>&nbsp;&nbsp;<input
 name="LIC" required title="This is a Mandatory Field"
 type="text"><strong>&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<label class="star"> * </label>Social Security #</strong>&nbsp;
&nbsp;&nbsp;<input name="SSNUM"
 pattern=".{9,}" 
 required title="This is a Mandatory Field and should only be charecter length of 9"
 type="text"></p>
  <p><strong>&nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp;<label class="star"> * </label>License Expiry</strong>&nbsp;
&nbsp;&nbsp;<input style="width:125px; id="LE1" name="LicExp"
 placeholder="YYYY-MM-DD" required title="This is a Mandatory Field" type="date">&nbsp;
&nbsp; &nbsp; &nbsp;<b><label class="star"> * </label>License Issued State</b><span
 style="font-weight: bold;">&nbsp; &nbsp; &nbsp;
  <select name="State1" style="width: 150px;">
  <option value="Alabama">Alabama</option>
  <option value="Alaska">Alaska</option>
  <option value="Arizona">Arizona</option>
  <option value="Arkansas">Arkansas</option>
  <option value="California">California</option>
  <option value="Colorado">Colorado</option>
  <option value="Connecticut">Connecticut</option>
  <option value="Delaware">Delaware</option>
  <option value="Florida">Florida</option>
  <option value="Georgia">Georgia</option>
  <option value="Hawaii">Hawaii</option>
  <option value="Idaho">Idaho</option>
  <option value="Illinois">Illinois</option>
  <option value="Indiana">Indiana</option>
  <option value="Iowa">Iowa</option>
  <option value="Kansas">Kansas</option>
  <option value="Kentucky">Kentucky</option>
  <option value="Louisiana">Louisiana</option>
  <option value="Maine">Maine</option>
  <option value="Maryland">Maryland</option>
  <option value="Massachusetts">Massachusetts</option>
  <option value="Michigan">Michigan</option>
  <option value="Minnesota">Minnesota</option>
  <option value="Mississippi">Mississippi</option>
  <option value="Missouri">Missouri</option>
  <option value="Montana">Montana</option>
  <option value="Nebraska">Nebraska</option>
  <option value="Nevada">Nevada</option>
  <option value="New Hampshire">New Hampshire</option>
  <option value="New Jersey">New Jersey</option>
  <option value="New Mexico">New Mexico</option>
  <option value="New York">New York</option>
  <option value="North Carolina">North Carolina</option>
  <option value="North Dakota">North Dakota</option>
  <option value="Ohio">Ohio</option>
  <option value="Oklahoma">Oklahoma</option>
  <option value="Oregon">Oregon</option>
  <option value="Pennsylvania">Pennsylvania</option>
  <option value="Rhode Island">Rhode Island</option>
  <option value="South Carolina">South Carolina</option>
  <option value="South Dakota">South Dakota</option>
  <option value="Tennessee">Tennessee</option>
  <option value="Texas">Texas</option>
  <option value="Utah">Utah</option>
  <option value="Vermont">Vermont</option>
  <option value="Virginia">Virginia</option>
  <option value="Washington">Washington</option>
  <option value="West Virginia">West Virginia</option>
  <option value="Wisconsin">Wisconsin</option>
  <option value="Wyoming">Wyoming</option>
  </select>
  </span></p>
  <p id="B1"><span style="line-height: 1.6em;">
 <p align:center> <span>
 <p style="color:red"><b>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
 &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;*indicates mandatory field</b></p>
</span><p> 
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp;</span></p>
  <div style="text-align: center;"><span
 style="font-weight: bold;">
&nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp;<input value="Submit"
 type="submit">&nbsp; &nbsp; <input type="reset" value="Reset!"><br></form> </span></div>
  <p>&nbsp;</p>
   </div>
  <div id="footer">
				<%@include file="footer.jsp" %>
			</div>
</head>
<body style="width: 1444px;">
</body>
</html>
    