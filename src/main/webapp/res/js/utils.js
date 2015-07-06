$(document).ready(function() {
	$('#datetimepicker1').datepicker({
		format : "dd.mm.yyyy",
		clearBtn : true,
		language : "ru",
		calendarWeeks : true,
		autoclose : true,
		todayHighlight : true,
		toggleActive : true
	});
});

$(document).ready(function() {
	$('#datepicker').datepicker({
		clearBtn : true,
		language : "ru",
		calendarWeeks : true,
		autoclose : true,
		todayHighlight : true
	});
});
