$(function() {

	var $table = $('#productTable');

	if ($table.length) 
	{
		var jsonUrl = '';
		if (window.categoryId == '') 
		{
			jsonUrl = window.contextRoot + '/json/show/all/products';
		} else 
		{
			jsonUrl = window.contextRoot + '/json/show/category/'
					+ window.categoryId + '/products';
		}
		console.log(jsonUrl);
		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ], [ '3', '5', '10', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
							},
					columns : [
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot
											+ '/rs/images/' + data
											+ '.jpg" class="dataTableImg"/>';

								}
							},

							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) 
								{
									return '&#8377; ' + data
								}
							},
							{
								data : 'quantity',
							},
							{
								data : 'id',
							}

					]
				});
	}
	});
	