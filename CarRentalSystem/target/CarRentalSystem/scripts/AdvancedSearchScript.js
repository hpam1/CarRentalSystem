/**
 * @ Author Arun Sriram 
 * 
 * This script file contains all jquery and javascript functions that are needed to be executed on advanced search page
 */

$(document).ready(function(){	   
	         /* removing duplicates on dropdown boxes at the time of page load */
	           removeduplicates();
	           
           	 /* jquery for apply filter button */
               $("#ApplyFilterBtn").click(function(){
            	    var srchstringmodel = $("#selectcarmodel option:selected").text();
            	    var srchstringmake = $("#selectcarmake option:selected").text();
            	    var srchstringtype = $("#selectcartype option:selected").text();
            	    var srchstringcapacity = $("#selectcarcapacity option:selected").text();
            	    var srchstringcolor = $("#selectcarcolor option:selected").text();
            	    if((!srchstringmodel) && (!srchstringmake) && (!srchstringtype) && (!srchstringcapacity) && (srchstringcolor)){
            	      //alert("advanced srch for car model:");
            	    	srchstringcolor="Car color: "+srchstringcolor;
            	    	var srchflag = "1";
            	    }
            	    if((srchstringmodel) && (!srchstringmake) && (srchstringtype) && (srchstringcapacity) && (srchstringcolor)){
            	      //alert("advanced srch for car make:");
            	    	srchstringmodel="Car Model: "+srchstringmodel;srchstringtype="Car type: "+srchstringtype;srchstringcapacity="Car Capacity: "+srchstringcapacity;
            	    	srchstringcolor="Car color: "+srchstringcolor;
            	    	var srchflag = "2";
            	    }	
            	    if((srchstringmodel) && (srchstringmake) && (!srchstringtype) && (srchstringcapacity) && (srchstringcolor)){
            	      //alert("advanced srch for car type:");
            	    	srchstringmodel="Car Model: "+srchstringmodel;srchstringmake="Car Manufacturer: "+srchstringmake;srchstringcapacity="Car Capacity: "+srchstringcapacity;
            	    	srchstringcolor="Car color: "+srchstringcolor;
            	    	var srchflag = "3";
            	    }
            	  //alert("displaying srchflag:"+srchflag);
            	  //alert("srchstringmodel="+srchstringmodel+" srchstringmake="+srchstringmake+" srchstringtype="+srchstringtype+" srchstringcapacity="+srchstringcapacity+" srchstringcolor="+srchstringcolor);
            	    searchcartable(srchstringmodel,srchstringmake,srchstringtype,srchstringcapacity,srchstringcolor,srchflag);
               });
               
        	 /* jquery for reset filter button */
               $("#ResetFilterBtn").click(function(){
            	   $("#tbldata tr").each(function(){
            		   $(this).show();
            	   });
               });
               
               
             /* jquery for rent a car button */  
               $(".rentacar").click(function(){
          			var id=$(this).attr("id");
        	  		var value=$("#hid"+id).val();
        	  		$("#finalcarid").val(value);
          		});               
 }); 
 
 function searchcartable(srchstringmodel,srchstringmake,srchstringtype,srchstringcapacity,srchstringcolor,srchflag)
 {
	   if(srchflag == "1")
	   {   
        	   $("#tbldata tr").each(function(index){
        		   var tabletext = $(this).find("td").eq(1).text(); 
        			   if(tabletext.indexOf(srchstringcolor)!=-1)
            			   //alert("Data found in this row:"+index);
                           $(this).show(); 
            		   else
            			   //alert(srchcolorstring+" not found in this row:"+index);
                           $(this).hide();
        	   });
       }
	   if(srchflag == "2")
	   {   
        	   $("#tbldata tr").each(function(index){
        		   var tabletext = $(this).find("td").eq(1).text(); 
        			   if((tabletext.indexOf(srchstringmodel)!=-1)    && 
        				  (tabletext.indexOf(srchstringtype)!=-1)     && 
        				  (tabletext.indexOf(srchstringcapacity)!=-1) && 
        				  (tabletext.indexOf(srchstringcolor)!=-1))
            			   //alert("Data found in this row:"+index);
                           $(this).show(); 
            		   else
            			   //alert(srchcolorstring+" not found in this row:"+index);
                           $(this).hide();
        	   });
       }
	   if(srchflag == "3")
	   {   
        	   $("#tbldata tr").each(function(index){
        		   var tabletext = $(this).find("td").eq(1).text(); 
        			   if((tabletext.indexOf(srchstringmodel)!=-1)    && 
        				  (tabletext.indexOf(srchstringmake)!=-1)     && 
        				  (tabletext.indexOf(srchstringcapacity)!=-1) && 
        				  (tabletext.indexOf(srchstringcolor)!=-1))
            			   //alert("Data found in this row:"+index);
                           $(this).show(); 
            		   else
            			   //alert(srchcolorstring+" not found in this row:"+index);
                           $(this).hide();
        	   });
       }
 }
           
 function removeduplicates()
 {
	    var dropdownfilter = $("#selectcarmodel");
	    removedup(dropdownfilter);
	    dropdownfilter = $("#selectcarmake");
	    removedup(dropdownfilter);
	    dropdownfilter = $("#selectcartype");
	    removedup(dropdownfilter);
	    dropdownfilter = $("#selectcarcapacity");
	    removedup(dropdownfilter);
	    dropdownfilter = $("#selectcarcolor");
	    removedup(dropdownfilter);
 }	    
 
 function removedup(dropdownfilter)
 {
        	   var a = new Array();
        	   $(dropdownfilter).children("option").each(function(x){
        	       test = false;
        		   b = a[x] = $(this).text();
            	   for (i=0;i<a.length-1;i++){
            	      if (b ==a[i]) test =true;
            	    }
            	    if (test) $(this).remove();
               });   
  }  