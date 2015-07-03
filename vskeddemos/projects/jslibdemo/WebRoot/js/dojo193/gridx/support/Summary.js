define([
	"dojo/_base/declare",
	"dojo/string",
	"dijit/_WidgetBase",
	"dijit/_TemplatedMixin"
], function(declare, string, _WidgetBase, _TemplatedMixin){

/*=====
	return declare([_WidgetBase, _TemplatedMixin], {
		// summary:
		//		Show total row count and selected row count.

		// gridx: [const] gridx/Grid
		grid: null,

		refresh: function(){
			// summary:
			//		Update the summary text.
		}
	});
=====*/

	return declare([_WidgetBase, _TemplatedMixin], {
		templateString: '<div class="gridxSummary"></div>',

		grid: null,

		//message: 'Total: ${0} Selected: ${1}',

		postCreate: function(){
			var t = this,
				m = t.grid.model;
			t.domNode.setAttribute('tabIndex', t.grid.domNode.getAttribute('tabIndex'));
			t.connect(m, 'onSizeChange', 'refresh');
			t.connect(m, 'onMarkChange', 'refresh');
			if(t.grid.pagination){
				t.connect(t.grid.pagination, 'onSwitchPage', 'refresh');
				t.connect(t.grid.pagination, 'onChangePageSize', 'refresh');
			}
			t.refresh();
		},

		refresh: function(){
			var g = this.grid,
				sr = g.select && g.select.row,
				pagination = g.pagination,
				size = g.model.size(),
				selected = sr ? sr.getSelected().length : 0,
				tpl = this.message;
			if(pagination){
				var cp = pagination.currentPage(),
					firstIdx = pagination.firstIndexInPage(cp) + 1,
					lastIdx = pagination.lastIndexInPage(cp) + 1;
			}
			if(g.getSummaryMessage){
				tpl = g.getSummaryMessage();
			}
			if(!tpl){
				tpl = [];
				if(pagination){
					tpl.push(string.substitute(g.nls.summaryRange, [firstIdx, lastIdx]));
				}
				tpl.push(string.substitute(g.nls.summaryTotal, [size >= 0 ? size : 0]));
				if(sr){
					tpl.push(string.substitute(g.nls.summarySelected, [selected]));
				}
				tpl = tpl.join(' ');
			}
			this.domNode.innerHTML = string.substitute(tpl, [size >= 0 ? size : 0, selected, firstIdx, lastIdx]);
		}
	});
});
