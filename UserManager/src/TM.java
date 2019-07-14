import javax.swing.table.DefaultTableModel;

public class TM extends DefaultTableModel {
	public TM (Object Mezonevek[], int rows){
		   super(Mezonevek, rows);
		}
	    	@Override
		public boolean isCellEditable(int row, int col) {
		    return false;
	    	}
	    	@Override
	    	public Class<?> getColumnClass(int index){
	       	   if(index > 9){return(Integer.class);}
	      	return(String.class);
	    	}
}
