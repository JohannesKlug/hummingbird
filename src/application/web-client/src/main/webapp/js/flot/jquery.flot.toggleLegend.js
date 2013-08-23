/**
 * Allows series to be toggled using their entries in the chart legend.
 * Supports series groups.
 *
 * TODO:
 *	Allow toggling to be disabled for individual series
 *	Disable visual feedback (usually so dev can implement their own)
 */
(function($) {

	var options = {
		series : {
			toggle : {
				enabled : true
			}
		}
	};

	/**
	 * State class which provides static functions to add or remove labels to a plot.
	 */
	var state = {
		add : function(plot, label) {
			var placeholder = $(plot.getPlaceholder());
			var data = placeholder.data("togglestates");

			if (!$.isArray(data)) {
				data = [];
			}

			if ($.inArray(label, data) === -1) {
				data.push(label);
			}

			placeholder.data("togglestates", data);
		},
		remove : function(plot, label) {
			var placeholder = $(plot.getPlaceholder());
			var data = placeholder.data("togglestates");

			if ($.isArray(data)) {
				if ($.inArray(label, data) > -1) {
					data.splice($.inArray(label, data), 1);
					placeholder.data("togglestates", data);
				}
			}
		}
	};

	var toggle = function(el, plot, datasets) {
		var cell, label, swatch, isCell = el.is("td");

		if (isCell || (el.parents("td").length)) {
			cell = (isCell ? el : el.parents("td"));

			// Acquire the label and colour swatch of whatever
			// legend item the user just clicked.
			if (cell.hasClass("legendLabel")) {
				label = cell;
				swatch = cell.prev(".legendColorBox");
			}
			else {
				label = cell.next(".legendLabel");
				swatch = cell;
			}

			var series = getSeries(label.text(), datasets);

			if (series.toggle.enabled) {
				if (label.hasClass("flotSeriesHidden")) {
					label.removeClass("flotSeriesHidden");
					toggleSwatch(swatch, true);
					showSeries(label.text(), plot, datasets);
				}
				else {
					label.addClass("flotSeriesHidden");
					toggleSwatch(swatch);
					hideSeries(label.text(), plot, datasets);
				}
			}
		}
	};

	var setupSwatch = function(swatch) {
		swatch.data("flotcolor", swatch.find("div div").css("border-top-color"));
	};

	var toggleSwatch = function(swatch, show) {
		if (show) {
			swatch.find("div div").css("border-color", swatch.data("flotcolor"));
		}
		else {
			swatch.find("div div").css("border-color", "transparent");
		}
	};

	var redraw = function(plot, datasets) {
		plot.setData(datasets.visible);
		plot.setupGrid();
		plot.draw();
	};

	var getSeries = function(label, datasets) {
		for ( var i = 0; i < datasets.all.length; i++) {
			if (datasets.all[i].label === label) {
				return datasets.all[i];
			}
		}
	};

	var hideSeries = function(label, plot, datasets) {
		for ( var i = 0; i < datasets.visible.length; i++) {
			if (datasets.visible[i].label === label) {
				// Hide this series
				datasets.visible.splice(i, 1);
				state.add(plot, label);
				break;
			}
		}
		redraw(plot, datasets);
	};

	var showAll = function() {
		plot.setData(datasets.all);
	};

	var showSeries = function(label, plot, datasets) {
		var i, j, outDataset = [];

		// Find the series we want to show
		for ( var i = 0; i < datasets.all.length; i++) {
			if (datasets.all[i].label === label) {
				datasets.visible.push(datasets.all[i]);
			}
		}

		// Sometimes the order of items in the datasets array is important
		// (especially when lines or areas overlap one another)
		for (i = 0; i < datasets.all.length; i++) {
			for (j = 0; j < datasets.visible.length; j++) {
				if (datasets.all[i].label === datasets.visible[j].label) {
					outDataset.push(datasets.all[i]);
					state.remove(plot, label);
					break;
				}
			}
		}

		datasets.visible = outDataset;

		redraw(plot, datasets);
	};

	var init = function(plot) {
		var datasets = {};
		var initDraw = false;
		var legend = null;

		plot.hooks.draw.push(function(originalPlot) {
			var placeholder, toggleStates, lenToggleStates, i;

			if (!initDraw) {
				placeholder = $(originalPlot.getPlaceholder());
				toggleStates = [];

				// This stops the calls to draw from creating an infinite loop
				initDraw = true;

				// Look for an existing toggleLegend config
				if ($.isArray(placeholder.data("togglestates"))) {
					toggleStates = placeholder.data("togglestates");

					lenToggleStates = toggleStates.length;

					// Initialise the line states
					for (i = 0; i < lenToggleStates; i++) {
						// hideSeries(toggleStates[i], plot, datasets);
						// Find the corresponding legend entry and click it!
						// (Yucky!)
						if (legend != null) {
							toggle(legend.find("td").filter(function() {
								return $(this).text() === toggleStates[i];
							}), originalPlot, datasets);
						}
						else {
							console.log("Error in toggleLegend, the legend was never created and drawn!");
						}
					}
				}
				else {
					placeholder.data("togglestates", toggleStates);

				}
			}
		});

		plot.hooks.legendInserted.push(function(originalPlot, originalLegend) {
			var plot = originalPlot;
			var toggleStates = [];
			var cells = originalLegend.find("td");
			var entries = [];

			datasets = {
				visible : plot.getData(),
				toggle : [],
				all : plot.getData().slice()
			};

			legend = originalLegend;

			// Split into objects containing each legend item's colour box and label.
			for (var i = 0; i < cells.length; i += 2) {
				entries.push({
					swatch : $(cells[i]),
					label : $(cells[i + 1])
				});
			}

			for (var e in entries) {
				if (entries.hasOwnProperty(e)) {
					setupSwatch(entries[e].swatch);
				}
			}

			legend.unbind("click.flot").bind("selectstart", function(e) {
				e.preventDefault();
				return false;
			});

			legend.bind("click.flot", function(e) {
				toggle($(e.target), plot, datasets);
			});

			legend.find("td").css("cursor", "pointer");
		});
	}; // end init

	$.plot.plugins.push({
		init : init,
		options : options,
		name : 'toggleLegend',
		version : '0.3'
	});

}(jQuery));