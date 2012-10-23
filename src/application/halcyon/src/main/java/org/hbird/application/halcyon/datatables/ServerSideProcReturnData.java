package org.hbird.application.halcyon.datatables;

import java.util.List;

// TODO i'd like this to be a plugin of some kind. Another OSGI bundle offering extensions to Halcyon. We can use reflection outside of OSGi to pick up extensions.
public class ServerSideProcReturnData {
	/**
	 * Total records, before filtering (i.e. the total number of records in the database)
	 */
	public int iTotalRecords;

	/**
	 * Total records, after filtering (i.e. the total number of records after filtering has been applied - not just the
	 * number of records being returned in this result set)
	 */
	public int iTotalDisplayRecords;

	/**
	 * An unaltered copy of sEcho sent from the client side. This parameter will change with each draw (it is basically
	 * a draw count) - so it is important that this is implemented. Note that it strongly recommended for security
	 * reasons that you 'cast' this parameter to an integer in order to prevent Cross Site Scripting (XSS) attacks.
	 */
	public String sEcho;

	/**
	 * Optional - this is a string of column names, comma separated (used in combination with sName) which will allow
	 * DataTables to reorder data on the client-side if required for display. Note that the number of column names
	 * returned must exactly match the number of columns in the table. For a more flexible JSON format, please consider
	 * using mDataProp.
	 */
	public String sColumns;

	/**
	 * The data in a 2D array. Note that you can change the name of this parameter with sAjaxDataProp.
	 */
	public List<?> aaData;
}
