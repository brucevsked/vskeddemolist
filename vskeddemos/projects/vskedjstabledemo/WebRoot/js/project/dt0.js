  $(document).ready(function() {
	  var basePath=document.getElementsByTagName('base')[0].href;
	  $.extend( $.fn.dataTable.defaults, {
		    searching: false,
		    ordering:  false
		} );
	    $('#dt0').DataTable( {
	        "columnDefs": [{
	        	"targets": [0],
	            "visible": false,
	            "searchable": false
	        }],
	        "fnRowCallback":function(nRow,aData,iDataIndex){
	            var suId = aData[0];
	            $('td:eq(-1)',nRow).html('<button onclick=toEdit("'+suId+'")>编辑</button>');
	            return nRow;
	        },
	        "processing": true,
	        "serverSide": true,
	        "ajax": basePath+"demosproc/datatables/dt0proc.jsp"
	    } );
	} );
  
  function toEdit(suId){
	  console.log(suId)
  }

