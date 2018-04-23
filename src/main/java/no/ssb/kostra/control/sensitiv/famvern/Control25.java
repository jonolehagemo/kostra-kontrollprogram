package no.ssb.kostra.control.sensitiv.famvern;

/*
 * $Log: Control25.java,v $
 * Revision 1.3  2008/12/13 10:40:26  pll
 * no message
 *
 * Revision 1.2  2007/10/25 11:37:03  pll
 * Implementerer getErrorType.
 *
 * Revision 1.1.1.1  2007/09/18 12:24:07  pll
 * Versjon: 2006-rapporteringen
 *
 * Revision 1.2  2006/09/22 09:13:47  lwe
 * Oppdatert årgang
 *
 * Revision 1.1  2006/09/22 08:18:26  lwe
 * Flyttet 2005-filene over i 2006-katalog - men ikke oppdatert årstallene
 *
 * Revision 1.6  2006/01/05 08:16:31  lwe
 * added logmessage
 * 
 */
 
import java.util.Vector;
import no.ssb.kostra.control.Constants;
import no.ssb.kostra.utils.CompatJdk13;

public final class Control25 extends no.ssb.kostra.control.Control
    implements no.ssb.kostra.control.SingleRecordErrorReport
    {
	  private final String ERROR_TEXT = "K25: Behandlingssamtaler for de involverte i saken i løpet av året";
	  private Vector<Integer> lineNumbers = new Vector<Integer>();

	  public boolean doControl(String line, int lineNumber, String region, String statistiskEnhet)
	  {
	    boolean lineHasError;
	    StringBuilder field_23_buffer = new StringBuilder();
	    StringBuilder field_23_empty = new StringBuilder();
	    
	    for (int i=1; i<=9; i++) {
	        field_23_buffer.append(RecordFields.getFieldValue(line, (i>9?2300+i:230+i)));
	        field_23_empty.append("  ");
	    }

	    String field_23 = field_23_buffer.toString();
	    field_23 = field_23.replace('0',' ');
	    
	    lineHasError = field_23.equalsIgnoreCase(field_23_empty.toString()) || 
	                   ! CompatJdk13.isNumericalWithSpace(field_23);
	        
	    if (lineHasError)
	      lineNumbers.add (new Integer (lineNumber));
	    
	    return lineHasError;
	  }

	  public String getErrorReport (int totalLineNumber)
	  {
	    String errorReport = ERROR_TEXT + ":" + lf + lf;
	    if (foundError())
	    {
	      int numOfRecords = lineNumbers.size();
	      errorReport += "\tFeil: i " + numOfRecords + 
	      " record" + (numOfRecords == 1 ? "" : "s") + 
	      " er det ikke ikke oppgitt hvor mange behandlingssamtaler de ulike " + lf +
	      "\tdeltakerne i saken har deltatt i gjennom året. Feltet er obligatorisk."; 
	      if (numOfRecords <= 10)
	      {
	        errorReport += lf + "\t\t(Gjelder record nr.";
	        for (int i=0; i<numOfRecords; i++)
	        {
	          errorReport += " " + lineNumbers.elementAt(i);
	        }
	        errorReport += ").";
	      }
	    }
	    errorReport += lf + lf;
	    return errorReport;
	  }

	  public boolean foundError()
	  {
	    return lineNumbers.size() > 0;
	  }  

	  public String getErrorText()
	  {
	    return  ERROR_TEXT;
	  }

	  public int getErrorType() {
	    return Constants.NORMAL_ERROR;
	  }
	}