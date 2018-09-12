class BookYourShow {
    int size;
    Show[] showsArray;
	BookYourShow() {
	  showsArray = new Show[10];
      size = 0;
	}
	public void addAShow(Show item) {
		showsArray[size++] = item;
	}
	public Show getAShow(String movieName, String dateTime) {
		for(Show s : showsArray) {
			if (s != null) {
				if ((s.movieName .equals(movieName)) && (s.dateTime .equals(dateTime))) {
					return s;
				}
			}
		}
		return null;
	}
	public void bookAShow(String movieName, String dateTime, Patron pat, String[] seats) {
		if (size == 0) {
			System.out.println("No show");
			return;
		}
		if (getAShow(movieName, dateTime) == null) {
			System.out.println("No show");
			return;
		}
		for (Show s : showsArray) {
			if (s!= null) {
				if (s.movieName.equals(movieName) && s.dateTime.equals(dateTime)) {
					for (String sNum : seats) {
						for (int i = 0; i < s.sNum.length; i++) {
							if (s.sNum[i].equals(sNum)) {
								s.sNum[i] = "N/A";
								s.bookedSeats[i] = pat;
							}
						}
					}
				}
			}
		}
	}
	public void printTicket(String movieName, String dateTime, String phNum) {
		boolean bookedSeat = false;
		for (Show s : showsArray) {
			if (s != null) {
				if (s.movieName.equals(movieName) && s.dateTime.equals(dateTime)) {
					for (int i = 0; i < s.bookedSeats.length; i++) {
						if (s.bookedSeats[i] != null) {
							if (s.bookedSeats[i].phNum .equals(phNum)) {
								bookedSeat = true;
							}
						}
					}
				}
			}
		}
		if (bookedSeat) {
			System.out.println(phNum + " " + movieName + " " + dateTime);
		}
		else {
			System.out.println("Invalid");
		}
	}
	public void showAll() {
		for (Show item : showsArray) {
			if (item != null) {
				String str = item.movieName + ",";
				str += item.dateTime + ",[";
				for (int i = 0; i < item.sNum.length-1;i++) {
					str += item.sNum[i] + ",";
				}
				str += item.sNum[item.sNum.length-1] + "]";
				System.out.println(str);
			}
		}
	}
}