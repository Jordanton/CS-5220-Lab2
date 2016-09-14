package mytodolist.model;

public class MyToDoList {

	private Integer id;
	private String chore;
	private String date;
	private String compDate;
	private boolean check;
	
	public MyToDoList() {
	
	}

	public MyToDoList( Integer id, String chore, String date ) {
		
		this.id = id;
		this.chore = chore;
		this.date = date;
		check = true;
		compDate = "-";
	}

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public String getChore() {
		return chore;
	}

	public void setChore( String chore ) {
		this.chore = chore;
	}

	public String getDate() {
		return date;
	}

	public void setDate( String date ) {
		this.date = date;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck( boolean check ) {
		this.check = check;
	}

	public String getCompDate() {
		return compDate;
	}

	public void setCompDate( String compDate ) {
		this.compDate = compDate;
	}
	
}
