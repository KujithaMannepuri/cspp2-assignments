public class Show {
		String movieName;
		String dateTime;
		String[] sNum;
		Patron[] bookedSeats;
		
	public Show(String movieName, String dateTime, String[] seats) {
		this.movieName = movieName;
		this.dateTime = dateTime;
		this.sNum = seats;
		this.bookedSeats = new Patron[seats.length];
	}

	public String toString() {
		return movieName+ "," + dateTime;
	}
}
	
