define([
	'dojo/_base/declare',
	'dojo/domReady',
	'dojo/store/Memory',
	'dojox/mobile/parser',
	'gridx/mobile/tests/support/data',
	'gridx/mobile/Grid',
	'gridx/mobile/Sort',
	'dojox/mobile/Heading',
	'dojox/mobile/View',
	'dojox/mobile/ScrollableView',
	'dojox/mobile/compat',
	'dojox/mobile/TabBar'
], function(declare, ready, MemoryStore, parser, data, Grid, Sort){
	var columns = [
		{field: 'name', width: '50%', title: 'Name'},
		{field: 'price', width: '20%', title: 'Price', template: '<font color="green">$${price}.00</font>'},
		{field: 'rating', width: '28%', title: 'Rating', template: '<font color="red">0.${rating}</font>'}
	];
	declare('gridx.mobile.tests.Grid', [Grid, Sort], {});
	ready(function(){
		parser.parse();
		grid.columns = columns;
		grid.setStore(new MemoryStore({data: data.products}));
	});
});