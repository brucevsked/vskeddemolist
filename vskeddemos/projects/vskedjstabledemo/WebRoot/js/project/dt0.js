  $(document).ready(function() {
	  var basePath=document.getElementsByTagName('base')[0].href;

	    $('#dt0').DataTable( {
	        "columnDefs": [{
	        	"targets": [0],
	            "visible": false,
	            "searchable": false
	        }],
	        dom: 'Bfrtip',
//	        searching: false, //隐藏搜索
	        buttons: [{ extend: 'colvis',
	        	        columns: ':not(:first-child)'
	        	       },
	        	        {
	        	        	extend:'excel' , 
	        	        	exportOptions: { columns: [ 1,2,3,4,5,6 ] } 
	        	        }], //[隐藏显示列时]不显示第一列
	        "fnRowCallback":function(nRow,aData,iDataIndex){
	            var suId = aData[0];
	            $('td:eq(-1)',nRow).html('<button onclick=toEdit("'+suId+'")>编辑</button>');
	            return nRow;
	        },
	        "processing": true,
	        "serverSide": true,
	        "ajax": basePath+"demosproc/datatables/dt0proc.jsp"
	    } );

	    //------------------------------
	    $('#dt0 tfoot th').each( function () {
	        var title = $(this).text();
	        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
	    } );
	    
	    var table = $('#dt0').DataTable();
	    
	    // Apply the search
	    table.columns().every( function () {
	        var that = this;
	 
	        $( 'input', this.footer() ).on( 'change', function () {
	            if ( that.search() !== this.value ) {
	                that
	                    .search( this.value )
	                    .draw();
	            }
	        } );
	    } );
	  //------------------------------
	    
	    
	} );
  
  function toEdit(suId){
	  console.log(suId)
  }

